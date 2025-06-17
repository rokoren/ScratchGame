/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import rokoren.scratchgame.model.Probabilities;
import rokoren.scratchgame.model.Symbol;
import rokoren.scratchgame.model.WinCombination;

/**
 *
 * @author Rok Koren
 */
public class Config 
{
    private int rows;
    private int columns;
    private Map<String, Symbol> symbols;
    private Probabilities probabilities;   
    
    @SerializedName("win_combinations")
    private Map<String, WinCombination> winCombinations;
    
    public int getRows()
    {
        return rows;
    }
    
    public int getColumns()
    {
        return columns;
    }
    
    public Map<String, Symbol> getSymbols()
    {
        return symbols;
    }
    
    public Probabilities getProbabilities()
    {
        return probabilities;
    }
    
    public Map<String, WinCombination> getWinCombinations()
    {
        return winCombinations;
    }
}
