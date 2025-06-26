/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.generator;

import java.util.Map;
import java.util.Random;
import rokoren.scratchgame.config.Config;

/**
 *
 * @author Rok Koren
 */
public class MatrixGenerator
{
    private final Random random = new Random();    
    
    public String[][] generateGrid(Config config) 
    {
        int rows = config.getRows();
        int cols = config.getColumns();
        String[][] grid = new String[rows][cols];

        for (int row = 0; row < rows; row++) 
        {
            for (int col = 0; col < cols; col++) 
            {
                Map<String, Integer> probabilities = config.getProbabilities().getStandardSymbols(row, col);
                grid[row][col] = getRandomSymbol(probabilities);
            }
        }

        return grid;
    }

    private String getRandomSymbol(Map<String, Integer> probabilities) 
    {
        int totalWeight = probabilities.values().stream().mapToInt(Integer::intValue).sum();
        int rand = random.nextInt(totalWeight);
        int cumulative = 0;

        for (String symbol : probabilities.keySet()) 
        {
            cumulative += probabilities.get(symbol);
            if (rand < cumulative) {
                return symbol;
            }
        }

        // fallback (ne bi se smelo zgoditi)
        return null;
    }   
}
