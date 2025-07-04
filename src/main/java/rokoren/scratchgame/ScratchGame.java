/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rokoren.scratchgame;

import rokoren.scratchgame.config.Config;
import rokoren.scratchgame.win.WinCalculator;
import rokoren.scratchgame.generator.MatrixGenerator;
import rokoren.scratchgame.generator.BonusGenerator;
import rokoren.scratchgame.applied.AppliedSerializer;
import rokoren.scratchgame.win.WinCombinationDeserializer;
import rokoren.scratchgame.symbol.SymbolDeserializer;
import rokoren.scratchgame.win.WinChecker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import rokoren.scratchgame.applied.AppliedSymbol;
import rokoren.scratchgame.symbol.Symbol;
import rokoren.scratchgame.win.WinCombination;
import rokoren.scratchgame.applied.AppliedWinCombination;
import rokoren.scratchgame.applied.AppliedOutput;
import rokoren.scratchgame.win.AbstractWinCombination;

/**
 *
 * @author Rok Koren
 */
public class ScratchGame
{
    private static final Logger LOG = Logger.getLogger(ScratchGame.class.getName());  
     
    private final MatrixGenerator matrixGenerator = new MatrixGenerator();
    private final BonusGenerator bonusGenerator = new BonusGenerator();
    private final WinChecker checker = new WinChecker();
    private final WinCalculator calculator = new WinCalculator();
    
    private final Config config;

    public ScratchGame(Config config) 
    {
        assert config != null;        
        this.config = config;
    }    
    
    public AppliedOutput play(int bettingAmount)
    {
        LOG.info("Play with betting amount: " + bettingAmount);
        String[][] grid = matrixGenerator.generateGrid(config);  
        Map<Symbol, List<WinCombination>> winCombinations = checker.checkWins(grid, config);
        List<List<String>> matrix = Arrays.stream(grid).map(Arrays::asList).collect(Collectors.toList());  
        AppliedSymbol bonus = bonusGenerator.generateBonus(config);
        int reward = calculator.calculateReward(bettingAmount, winCombinations, bonus);
        return new AppliedOutput(matrix, winCombinations, bonus, reward);
    }
    
    public static void main(String[] args) 
    {
        Map<String, String> arguments = parseArgs(args);        
        
        if (!arguments.containsKey("config") || !arguments.containsKey("betting-amount")) 
        {
            LOG.warning("Usage: java -jar game.jar --config=path/to/config.json --betting-amount=100");
            System.exit(1);
        } 
        

        String configPath = arguments.get("config");
        int bettingAmount;

        try {
            bettingAmount = Integer.parseInt(arguments.get("betting-amount"));
        } catch (NumberFormatException e) {
            LOG.warning("Invalid betting amount: " + arguments.get("betting-amount"));
            System.exit(1);
            return;
        }

        String configContent;
        try {
            configContent = Files.readString(Path.of(configPath));
        } catch (IOException e) {
            LOG.warning("Could not read config file: " + e.getMessage());
            System.exit(1);
            return;
        } 
        
        JsonProvider gson = new JsonProviderImpl();

        Config config = gson.getConfig(configContent);
        ScratchGame game = new ScratchGame(config);
        AppliedOutput output = game.play(bettingAmount);
        String json = gson.toJson(output);
        LOG.info(json);  
    }
    
    private static Map<String, String> parseArgs(String[] args) 
    {
        return Arrays.stream(args)
                .filter(arg -> arg.startsWith("--") && arg.contains("="))
                .map(arg -> arg.substring(2).split("=", 2))
                .collect(java.util.stream.Collectors.toMap(a -> a[0], a -> a[1]));
    } 
    
    public static final class JsonProviderImpl implements JsonProvider
    {
        private final Gson gson;

        public JsonProviderImpl() 
        {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            builder.registerTypeAdapter(Symbol.class, new SymbolDeserializer());   
            builder.registerTypeAdapter(AbstractWinCombination.class, new WinCombinationDeserializer()); 
            builder.registerTypeAdapter(AppliedWinCombination.class, new AppliedSerializer()); 
            builder.registerTypeAdapter(AppliedSymbol.class, new AppliedSerializer()); 
            gson = builder.create();
        }                
        
        @Override
        public Config getConfig(String json) 
        {
            return gson.fromJson(json, Config.class);     
        }

        @Override
        public String toJson(AppliedOutput output)
        {
            return gson.toJson(output);
        }      
    }
}
