/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.win;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rokoren.scratchgame.config.Config;
import rokoren.scratchgame.applied.AppliedSymbol;
import rokoren.scratchgame.symbol.Symbol;
import rokoren.scratchgame.applied.AppliedWinCombination;

/**
 *
 * @author Rok Koren
 */
public class WinChecker 
{
    public Map<Symbol, List<WinCombination>> checkWins(String[][] grid, Config config)
    {
        Map<Symbol, List<WinCombination>> map = new HashMap<>();                
        for(String combinationName : config.getWinCombinations().keySet())
        {
            AbstractWinCombination winCombination = config.getWinCombinations().get(combinationName);
            Set<String> symbols = winCombination.checkWins(grid);
            if(!symbols.isEmpty())
            {
                for(String symbolName : symbols)
                {
                    Symbol symbol = config.getSymbols().get(symbolName);                                         
                    List<WinCombination> results = map.get(symbol);
                    if(results == null)
                    {
                        results = new ArrayList<>();                       
                        map.put(new AppliedSymbol(symbolName, symbol), results);
                    }
                    AppliedWinCombination result = new AppliedWinCombination(combinationName, winCombination);
                    results.add(result);
                }
            }
        }        
        return map;
    }    
}
