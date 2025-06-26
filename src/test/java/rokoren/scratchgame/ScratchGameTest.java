/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package rokoren.scratchgame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rokoren.scratchgame.ScratchGame.JsonProviderImpl;
import rokoren.scratchgame.applied.AppliedOutput;

/**
 *
 * @author Rok Koren
 */
public class ScratchGameTest 
{
    private static final String CONFIG_PATH = "src/main/java/rokoren/scratchgame/resources/config.json";
    
    public ScratchGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }

    @Test
    public void testLoadValidConfig() throws IOException
    {
        String configContent = Files.readString(Path.of(CONFIG_PATH));       
        
        JsonProvider provider = new JsonProviderImpl();
        Config config = provider.getConfig(configContent);

        assertTrue(config.getRows() > 1);
        assertTrue(config.getColumns() > 1);
        assertFalse(config.getSymbols().isEmpty());
        assertNotNull(config.getProbabilities());
        assertFalse(config.getProbabilities().getStandardSymbols(0, 0).isEmpty());
        assertFalse(config.getProbabilities().getStandardSymbols(1, 1).isEmpty());
        assertFalse(config.getProbabilities().getStandardSymbols(2, 2).isEmpty());
        assertFalse(config.getProbabilities().getBonusSymbols().isEmpty());
        assertFalse(config.getWinCombinations().isEmpty());
    } 
    
    @Test
    public void loadingMissingConfigShouldThrow() 
    {
        assertThrows(IOException.class, () -> {
            Files.readString(Path.of("nonexistent.json"));
        });
    }
    
    /**
     * Test of play method, of class ScratchGame.
     */
    @Test
    public void testPlay() throws IOException
    {
        String configContent = Files.readString(Path.of(CONFIG_PATH));       
        
        JsonProvider provider = new JsonProviderImpl();
        Config config = provider.getConfig(configContent);  
        
        ScratchGame game = new ScratchGame(config);
        AppliedOutput output = game.play(100);
              
        assertNotNull(output);
        assertFalse(output.getMatrix().isEmpty());  
        assertNotNull(output.getBonus());        
    }

    /**
     * Test of main method, of class ScratchGame.
     */
    @Test
    public void testMain() 
    {
        Logger logger = Logger.getLogger(ScratchGame.class.getName());

        TestLogHandler handler = new TestLogHandler();
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);      
        
        String[] args = {
            "--config=" + CONFIG_PATH,
            "--betting-amount=" + 100
        };

        ScratchGame.main(args);

        boolean matrix = handler.containsMessage("matrix");
        boolean reward = handler.containsMessage("reward");
        boolean applied_bonus_symbol = handler.containsMessage("applied_bonus_symbol");
        assertTrue("Expected a log message containing 'matrix'", matrix);
        assertTrue("Expected a log message containing 'reward'", reward);
        assertTrue("Expected a log message containing 'applied_bonus_symbol'", applied_bonus_symbol);

        logger.removeHandler(handler);       
    }
 
    private static class TestLogHandler extends Handler 
    {
        private final StringBuilder logMessages = new StringBuilder();

        @Override
        public void publish(LogRecord record) 
        {
            logMessages.append(record.getMessage()).append("\n");
        }

        @Override
        public void flush() {}

        @Override
        public void close() throws SecurityException {}

        public boolean containsMessage(String substring) 
        {
            return logMessages.toString().contains(substring);
        }
    }
}
