/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package rokoren.scratchgame.generator;

import java.util.Arrays;
import java.util.HashMap;
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
import rokoren.scratchgame.win.AbstractWinCombination;
import rokoren.scratchgame.win.WinCombinationLinearSymbols;
import rokoren.scratchgame.win.WinCombinationSameSymbols;

/**
 *
 * @author Rok Koren
 */
public class MatrixGeneratorTest 
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
                .rows(4)
                .columns(4)
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

    /**
     * Test of generateGrid method, of class MatrixGenerator.
     */
    @Test
    public void testGridGenerationDimensions() 
    {
        System.out.println("testGridGenerationDimensions");
        MatrixGenerator generator = new MatrixGenerator();
        String[][] grid = generator.generateGrid(config);
        
        assertEquals(4, grid.length);
        assertEquals(4, grid[0].length);        
    }
 
    /**
     * Test of generateGrid method, of class MatrixGenerator.
     */
    @Test
    public void testGridGenerationSymbolDistribution() 
    {
        System.out.println("testGridGenerationSymbolDistribution");        
        MatrixGenerator generator = new MatrixGenerator(); 
        
        Map<String, Integer> symbolCounts = new HashMap<>();
        int totalRuns = 100_000;
        for (int i = 0; i < totalRuns; i++)
        {
            String[][] grid = generator.generateGrid(config);
            String symbol = grid[0][0];
            symbolCounts.merge(symbol, 1, Integer::sum);
        } 
        
        // Pretvori v odstotke
        double percentA = 100.0 * symbolCounts.getOrDefault("A", 0) / totalRuns;
        double percentB = 100.0 * symbolCounts.getOrDefault("B", 0) / totalRuns;
        double percentC = 100.0 * symbolCounts.getOrDefault("C", 0) / totalRuns;
        double percentD = 100.0 * symbolCounts.getOrDefault("D", 0) / totalRuns;
        double percentE = 100.0 * symbolCounts.getOrDefault("E", 0) / totalRuns;
        double percentF = 100.0 * symbolCounts.getOrDefault("F", 0) / totalRuns;        

        System.out.printf("A: %.2f%%, B: %.2f%%, C: %.2f, D: %.2f%%, E: %.2f%%, F: %.2f%%%n", percentA, percentB, percentC, percentD, percentE, percentF);

        assertTrue(percentB > percentA);
        assertTrue(percentC > percentB);
        assertTrue(percentD > percentC);        
        assertTrue(percentE > percentD); 
        assertTrue(percentF > percentE); 
    }    
}
