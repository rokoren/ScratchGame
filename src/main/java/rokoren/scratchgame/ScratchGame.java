/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rokoren.scratchgame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import rokoren.scratchgame.model.AppliedSymbol;
import rokoren.scratchgame.model.Symbol;
import rokoren.scratchgame.model.WinCombination;
import rokoren.scratchgame.model.AppliedWinCombination;
import rokoren.scratchgame.model.ScratchGameOutput;

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
    private final RewardCalculator calculator = new RewardCalculator();
    
    private final Config config;

    public ScratchGame(Config config) 
    {
        assert config != null;        
        this.config = config;
    }    
    
    public ScratchGameOutput play(int bettingAmount)
    {
        LOG.info("Play with betting amount: " + bettingAmount);
        String[][] grid = matrixGenerator.generateGrid(config);  
        Map<AppliedSymbol, List<AppliedWinCombination>> appliedWinCombinations = checker.checkWins(grid, config);
        List<List<String>> matrix = Arrays.stream(grid).map(Arrays::asList).collect(Collectors.toList());  
        AppliedSymbol bonus = bonusGenerator.generateBonus(config);
        int reward = calculator.calculateReward(bettingAmount, appliedWinCombinations, bonus);
        return new ScratchGameOutput(matrix, appliedWinCombinations, bonus, reward);
    }
    
    public static void main(String[] args) 
    {
        /*
        Map<String, String> arguments = parseArgs(args);        
        
        if (!arguments.containsKey("config") || !arguments.containsKey("betting-amount")) 
        {
            LOG.warning("Usage: java -jar game.jar --config=path/to/config.json --betting-amount=100");
            System.exit(1);
        } 
        

        String configPath = arguments.get("config");
        double bettingAmount;

        try {
            bettingAmount = Double.parseDouble(arguments.get("betting-amount"));
        } catch (NumberFormatException e) {
            System.err.println("Invalid betting amount: " + arguments.get("betting-amount"));
            System.exit(1);
            return;
        }

        String configContent;
        try {
            configContent = Files.readString(Path.of(configPath));
        } catch (IOException e) {
            System.err.println("Could not read config file: " + e.getMessage());
            System.exit(1);
            return;
        } 
        */
        
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapter(Symbol.class, new SymbolDeserializer());   
        builder.registerTypeAdapter(WinCombination.class, new WinCombinationDeserializer()); 
        builder.registerTypeAdapter(AppliedWinCombination.class, new AppliedSerializer()); 
        builder.registerTypeAdapter(AppliedSymbol.class, new AppliedSerializer()); 
        Gson gson = builder.create();

        try
        {
            //String url = getClass().getResource("resources/config.json").toExternalForm();          
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Rok Koren\\NetBeansProjects\\ScratchGame\\src\\main\\java\\rokoren\\scratchgame\\resources\\config.json")));
            Config config = gson.fromJson(reader, Config.class);     
            ScratchGame game = new ScratchGame(config);
            ScratchGameOutput output = game.play(100);
            String json = gson.toJson(output);
            LOG.info(json);
            //System.out.println("Hello World!");            
        }
        catch(IOException e)
        {
            LOG.warning(e.getMessage());
        }
    }
    
    private static Map<String, String> parseArgs(String[] args) 
    {
        return Arrays.stream(args)
                .filter(arg -> arg.startsWith("--") && arg.contains("="))
                .map(arg -> arg.substring(2).split("=", 2))
                .collect(java.util.stream.Collectors.toMap(a -> a[0], a -> a[1]));
    }  
}
