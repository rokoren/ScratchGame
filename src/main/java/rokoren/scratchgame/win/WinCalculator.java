/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.win;

import java.util.List;
import java.util.Map;
import rokoren.scratchgame.symbol.Symbol;

/**
 *
 * @author Rok Koren
 */
public class WinCalculator 
{
    public int calculateReward(int bettingAmount, Map<Symbol, List<WinCombination>> winCombinations, Symbol bonus)
    {
        int reward = 0;
        for(Symbol standard : winCombinations.keySet())
        {
            int symbolReward = standard.getReward(bettingAmount);
            for(WinCombination winCombination : winCombinations.get(standard))
            {
                symbolReward *= winCombination.getRewardMultiplier();
            }
            reward += symbolReward;
        }
        return bonus.getReward(reward);
    }
}
