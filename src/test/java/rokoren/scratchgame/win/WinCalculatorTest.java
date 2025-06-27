/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package rokoren.scratchgame.win;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import rokoren.scratchgame.config.Config;
import rokoren.scratchgame.probabilities.ProbabilitiesSymbol;
import rokoren.scratchgame.probabilities.ProbabilitiesSymbolBuilder;
import rokoren.scratchgame.probabilities.ProbabilitiesSymbolCellBuilder;
import rokoren.scratchgame.symbol.Symbol;
import rokoren.scratchgame.symbol.SymbolExtraBonus;
import rokoren.scratchgame.symbol.SymbolMiss;
import rokoren.scratchgame.symbol.SymbolMultiplyReward;

/**
 *
 * @author Rok Koren
 */
public class WinCalculatorTest 
{  
    private Config config;
    
    @Before
    public void setUp() 
    {
        Symbol symbolA = new SymbolMultiplyReward(5);
        Symbol symbolB = new SymbolMultiplyReward(3);
        Symbol symbolC = new SymbolMultiplyReward(2.5F);
        Symbol symbolD = new SymbolMultiplyReward(2);
        Symbol symbolE = new SymbolMultiplyReward(1.2F);
        Symbol symbolF = new SymbolMultiplyReward(1);

        Symbol symbol10x = new SymbolMultiplyReward(10);
        Symbol symbol5x = new SymbolMultiplyReward(5);
        
        Symbol symbol1000 = new SymbolExtraBonus(1000);
        Symbol symbol500 = new SymbolExtraBonus(500);
        Symbol symbolMiss = new SymbolMiss();        
        
        ProbabilitiesSymbolCellBuilder standardBuilder = new ProbabilitiesSymbolCellBuilder();
        ProbabilitiesSymbolBuilder bounusBuilder = new ProbabilitiesSymbolBuilder();
        
        ProbabilitiesSymbol standard00 = standardBuilder
                .row(0)
                .column(0)
                .withSymbol("A", 1)
                .withSymbol("B", 2)
                .withSymbol("C", 3)
                .withSymbol("D", 4)  
                .withSymbol("E", 5)
                .withSymbol("F", 6)
                .build();
        
        ProbabilitiesSymbol standard10 = standardBuilder
                .row(1)
                .column(0)
                .build();   
        
        ProbabilitiesSymbol standard20 = standardBuilder
                .row(2)
                .column(0)
                .build();   
        
        ProbabilitiesSymbol standard01 = standardBuilder
                .row(0)
                .column(1)
                .build();  

        ProbabilitiesSymbol standard11 = standardBuilder
                .row(1)
                .column(1)
                .build();    
        
        ProbabilitiesSymbol standard21 = standardBuilder
                .row(2)
                .column(1)
                .build();         
        
        ProbabilitiesSymbol standard02 = standardBuilder
                .row(0)
                .column(2)
                .build();  
        
        ProbabilitiesSymbol standard12 = standardBuilder
                .row(1)
                .column(2)
                .build();    
        
        ProbabilitiesSymbol standard22 = standardBuilder
                .row(2)
                .column(2)
                .build(); 
        
        ProbabilitiesSymbol bonus = bounusBuilder
                .withSymbol("10x", 1)
                .withSymbol("5x", 2)
                .withSymbol("+1000", 3)
                .withSymbol("+500", 4)                
                .withSymbol("MISS", 5)
                .build();
        
        AbstractWinCombination sameSymbol3Times = new WinCombinationSameSymbols(3, 1);
        AbstractWinCombination sameSymbol4Times = new WinCombinationSameSymbols(4, 1.5F);
        AbstractWinCombination sameSymbol5Times = new WinCombinationSameSymbols(5, 2);        
        AbstractWinCombination sameSymbol6Times = new WinCombinationSameSymbols(6, 3);
        AbstractWinCombination sameSymbol7Times = new WinCombinationSameSymbols(7, 5);          
        AbstractWinCombination sameSymbol8Times = new WinCombinationSameSymbols(8, 10);
        AbstractWinCombination sameSymbol9Times = new WinCombinationSameSymbols(9, 20);   
        
        WinCombinationLinearSymbols sameSymbolsHorizontally = WinCombinationLinearSymbols.builder()
                .rewardMultiplier(2)
                .withCoveredArea(Arrays.asList("0:0", "0:1", "0:2"))
                .withCoveredArea(Arrays.asList("1:0", "1:1", "1:2"))
                .withCoveredArea(Arrays.asList("2:0", "2:1", "2:2"))
                .build();
        
        WinCombinationLinearSymbols sameSymbolsVertically = WinCombinationLinearSymbols.builder()
                .rewardMultiplier(2)
                .withCoveredArea(Arrays.asList("0:0", "1:0", "2:0"))
                .withCoveredArea(Arrays.asList("0:1", "1:1", "2:1"))
                .withCoveredArea(Arrays.asList("0:2", "1:2", "2:2"))
                .build();   
        
        WinCombinationLinearSymbols sameSymbolsDiagonallyLeftToRight = WinCombinationLinearSymbols.builder()
                .rewardMultiplier(5)
                .withCoveredArea(Arrays.asList("0:0", "1:1", "2:2"))
                .build();  
        
        WinCombinationLinearSymbols sameSymbolsDiagonallyRightToLeft = WinCombinationLinearSymbols.builder()
                .rewardMultiplier(5)
                .withCoveredArea(Arrays.asList("0:2", "1:1", "2:0"))
                .build();          
        
        config = Config.builder()
                .rows(3)
                .columns(3)
                .withSymbol("A", symbolA)
                .withSymbol("B", symbolB)
                .withSymbol("C", symbolC)
                .withSymbol("D", symbolD) 
                .withSymbol("E", symbolE)
                .withSymbol("F", symbolF)  
                .withSymbol("10x", symbol10x)
                .withSymbol("5x", symbol5x)
                .withSymbol("+1000", symbol1000)
                .withSymbol("+500", symbol500) 
                .withSymbol("MISS", symbolMiss)  
                .withProbabilities(standard00)
                .withProbabilities(standard10)
                .withProbabilities(standard20)
                .withProbabilities(standard01)  
                .withProbabilities(standard11)
                .withProbabilities(standard21)
                .withProbabilities(standard02)
                .withProbabilities(standard12)                  
                .withProbabilities(standard22)                  
                .withProbabilities(bonus)  
                .withWinCombination("same_symbol_3_times", sameSymbol3Times)
                .withWinCombination("same_symbol_4_times", sameSymbol4Times)                
                .withWinCombination("same_symbol_5_times", sameSymbol5Times)
                .withWinCombination("same_symbol_6_times", sameSymbol6Times)                
                .withWinCombination("same_symbol_7_times", sameSymbol7Times)
                .withWinCombination("same_symbol_8_times", sameSymbol8Times)                
                .withWinCombination("same_symbol_9_times", sameSymbol9Times)                
                .withWinCombination("same_symbols_horizontally", sameSymbolsHorizontally)
                .withWinCombination("same_symbols_vertically", sameSymbolsVertically)                
                .withWinCombination("same_symbols_diagonally_left_to_right", sameSymbolsDiagonallyLeftToRight)
                .withWinCombination("same_symbols_diagonally_right_to_left", sameSymbolsDiagonallyRightToLeft)                                
                .build();        
    }
    
    @Test
    public void testWinRewardInRow() 
    {
        System.out.println("testWinRewardInRow");
        
        Symbol symbolA = config.getSymbols().get("A");
        WinCombination sameSymbol3Times = config.getWinCombinations().get("same_symbol_3_times");           
        WinCombination sameSymbolsHorizontally = config.getWinCombinations().get("same_symbols_horizontally"); 
        Symbol bonus = config.getSymbols().get("+500");
        
        String[][] grid = new String[][] {
            {"A", "A", "A"},
            {"B", "C", "D"},
            {"E", "F", "G"}
        };        
        
        WinChecker checker = new WinChecker();   
        Map<Symbol, List<WinCombination>> wins = checker.checkWins(grid, config);                
        List<WinCombination> winCombinations = wins.get(symbolA);  
        
        WinCalculator calculator = new WinCalculator();        
        int reward = calculator.calculateReward(100, wins, bonus);
         
        assertTrue(wins.containsKey(symbolA));
        assertEquals(1, wins.size());        
        assertTrue(winCombinations.contains(sameSymbol3Times));
        assertTrue(winCombinations.contains(sameSymbolsHorizontally));
        assertEquals(2, winCombinations.size());    
        
        assertEquals(1500, reward);    
    } 
    
    @Test
    public void testWinReward3Symbols() 
    {
        System.out.println("testWinReward3Symbols");
        
        Symbol symbolA = config.getSymbols().get("A");
        Symbol symbolB = config.getSymbols().get("B");
        Symbol symbolC = config.getSymbols().get("C");
        WinCombination sameSymbol3Times = config.getWinCombinations().get("same_symbol_3_times");           
        WinCombination sameSymbolsHorizontally = config.getWinCombinations().get("same_symbols_horizontally"); 
        
        Symbol bonus = config.getSymbols().get("MISS");
        
        String[][] grid = new String[][] {
            {"A", "A", "A"},
            {"B", "B", "B"},
            {"C", "C", "C"}
        };        
        
        WinChecker checker = new WinChecker();   
        Map<Symbol, List<WinCombination>> wins = checker.checkWins(grid, config);                
        List<WinCombination> winCombinationsA = wins.get(symbolA);        
        List<WinCombination> winCombinationsB = wins.get(symbolB);        
        List<WinCombination> winCombinationsC = wins.get(symbolC); 
        
        WinCalculator calculator = new WinCalculator();        
        int reward = calculator.calculateReward(100, wins, bonus);        
         
        assertTrue(wins.containsKey(symbolA));
        assertTrue(wins.containsKey(symbolB));
        assertTrue(wins.containsKey(symbolC));
        assertEquals(3, wins.size());   
        
        assertTrue(winCombinationsA.contains(sameSymbol3Times));
        assertTrue(winCombinationsA.contains(sameSymbolsHorizontally));
        assertEquals(2, winCombinationsA.size());  
        
        assertTrue(winCombinationsB.contains(sameSymbol3Times));
        assertTrue(winCombinationsB.contains(sameSymbolsHorizontally));
        assertEquals(2, winCombinationsB.size());         
        
        assertTrue(winCombinationsC.contains(sameSymbol3Times));
        assertTrue(winCombinationsC.contains(sameSymbolsHorizontally));
        assertEquals(2, winCombinationsC.size());   
        
        assertEquals(2100, reward);    
    }      
}
