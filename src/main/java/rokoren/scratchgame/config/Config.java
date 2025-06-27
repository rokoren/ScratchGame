/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.config;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import rokoren.scratchgame.probabilities.Probabilities;
import rokoren.scratchgame.symbol.Symbol;
import rokoren.scratchgame.win.AbstractWinCombination;

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
    private Map<String, AbstractWinCombination> winCombinations;
    
    public int getRows()
    {
        return rows;
    }
    
    public void setRows(int rows)
    {
        this.rows = rows;
    }
    
    public int getColumns()
    {
        return columns;
    }
    
    public void setColumns(int columns)
    {
        this.columns = columns;
    }    
    
    public Map<String, Symbol> getSymbols()
    {
        if(symbols == null)
        {
            symbols = new HashMap<>();
        }
        return symbols;
    }
    
    public Probabilities getProbabilities()
    {
        return probabilities;
    }
    
    public void setProbabilities(Probabilities probabilities)
    {
        this.probabilities = probabilities;
    }
    
    public Map<String, AbstractWinCombination> getWinCombinations()
    {
        if(winCombinations == null)
        {
            winCombinations = new HashMap<>();
        }
        return winCombinations;
    }
    
    public static ConfigBuilder builder()
    {
        return new ConfigBuilder();
    }
}
