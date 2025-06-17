/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.win;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Rok Koren
 */
public class WinCombinationSameSymbols extends WinCombination
{
    private final int count;

    public WinCombinationSameSymbols(int count, float rewardMultiplier)
    {
        super(rewardMultiplier);
        this.count = count;
    }    

    @Override
    public Set<String> checkWins(String[][] grid) 
    {
        List<String> symbols = Arrays.stream(grid).flatMap(Arrays::stream).collect(Collectors.toList());         
        return symbols.stream().filter(i -> Collections.frequency(symbols, i) >= count).collect(Collectors.toSet());        
    }
}
