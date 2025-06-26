/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package rokoren.scratchgame.win;

import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rokoren.scratchgame.config.Config;
import rokoren.scratchgame.applied.AppliedSymbol;
import rokoren.scratchgame.applied.AppliedWinCombination;

/**
 *
 * @author Rok Koren
 */
public class WinCheckerTest {
    
    public WinCheckerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }

    /**
     * Test of checkWins method, of class WinChecker.
     */
    //@Test
    public void testCheckWins() 
    {
        System.out.println("checkWins");
        String[][] grid = null;
        Config config = null;
        WinChecker instance = new WinChecker();
        Map<AppliedSymbol, List<AppliedWinCombination>> expResult = null;
        Map<AppliedSymbol, List<AppliedWinCombination>> result = instance.checkWins(grid, config);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
