/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rokoren.scratchgame.model.AppliedSymbol;
import rokoren.scratchgame.model.Symbol;
import rokoren.scratchgame.model.WinCombination;
import rokoren.scratchgame.model.AppliedWinCombination;

/**
 *
 * @author Rok Koren
 */
public class WinChecker 
{
    public Map<AppliedSymbol, List<AppliedWinCombination>> checkWins(String[][] grid, Config config)
    {
        Map<AppliedSymbol, List<AppliedWinCombination>> map = new HashMap<>();
        for(String combinationName : config.getWinCombinations().keySet())
        {
            WinCombination winCombination = config.getWinCombinations().get(combinationName);
            Set<String> symbols = winCombination.checkWins(grid);
            if(!symbols.isEmpty())
            {
                for(String symbolName : symbols)
                {
                    Symbol symbol = config.getSymbols().get(symbolName);
                    List<AppliedWinCombination> results = map.get(symbolName);
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
