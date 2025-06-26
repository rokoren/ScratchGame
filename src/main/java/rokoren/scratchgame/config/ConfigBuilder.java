/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.config;

import java.util.HashMap;
import java.util.Map;
import rokoren.scratchgame.probabilities.Probabilities;
import rokoren.scratchgame.probabilities.ProbabilitiesSymbol;
import rokoren.scratchgame.probabilities.ProbabilitiesSymbolCell;
import rokoren.scratchgame.symbol.Symbol;
import rokoren.scratchgame.win.WinCombination;

/**
 *
 * @author Rok Koren
 */
public class ConfigBuilder 
{    
    private Map<String, Symbol> symbols = new HashMap<>();
    private Probabilities probabilities = new Probabilities();
    private Map<String, WinCombination> winCombinations = new HashMap<>();
    
    private int rows    = 3;
    private int columns = 3;    
    
    ConfigBuilder() {}
    
    public ConfigBuilder rows(int rows)
    {
        this.rows = rows;
        return this;
    }
    
    public ConfigBuilder columns(int columns)
    {
        this.columns = columns;
        return this;
    }  
    
    public ConfigBuilder withSymbol(String name, Symbol symbol)
    {
        symbols.put(name, symbol);
        return this;
    }
    
    public ConfigBuilder withProbabilities(ProbabilitiesSymbol symbols)
    {
        if(symbols instanceof ProbabilitiesSymbolCell standard)
        {
            probabilities.getStandardSymbols().add(standard);
        }
        else
        {
            probabilities.setBonusSymbols(symbols);
        }
        return this;
    }   
    
    public ConfigBuilder withWinCombination(String name, WinCombination combination)
    {
        winCombinations.put(name, combination);
        return this;
    }    
    
    public Config build()
    {
        Config config = new Config();
        config.setRows(rows);
        config.setColumns(columns);
        config.getSymbols().putAll(symbols);
        config.setProbabilities(probabilities);
        config.getWinCombinations().putAll(winCombinations);
        return config;
    }
}
