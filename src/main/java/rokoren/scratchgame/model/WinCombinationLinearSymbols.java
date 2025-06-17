/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author Rok Koren
 */
public class WinCombinationLinearSymbols extends WinCombination
{
    private final List<List<String>> coveredAreas;

    public WinCombinationLinearSymbols(float rewardMultiplier, List<List<String>> coveredAreas) 
    {
        super(rewardMultiplier);
        this.coveredAreas = coveredAreas;
    }            

    private String getSymbol(String[][] grid, List<String> coveredArea) throws NumberFormatException
    {
        String symbol = null;
        for(String cell : coveredArea)
        {            
            StringTokenizer st = new StringTokenizer(cell, ":");
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            if(symbol == null)
            {
                symbol = grid[row][column];
            }
            else if(!symbol.equals(grid[row][column]))
            {
                return null;
            }
        }
        return symbol;
    }
    
    @Override
    public Set<String> checkWins(String[][] grid) 
    {
        Set<String> symbols = new HashSet<>();
        for(List<String> coveredArea : coveredAreas)
        {
            String symbol = getSymbol(grid, coveredArea);
            if(symbol != null)
            {
                symbols.add(symbol);
            }
        }
        return symbols;
    }
}
