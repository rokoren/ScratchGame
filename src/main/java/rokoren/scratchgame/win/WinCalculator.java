/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.win;

import java.util.List;
import java.util.Map;
import rokoren.scratchgame.applied.AppliedSymbol;
import rokoren.scratchgame.applied.AppliedWinCombination;

/**
 *
 * @author Rok Koren
 */
public class WinCalculator 
{
    public int calculateReward(int bettingAmount, Map<AppliedSymbol, List<AppliedWinCombination>> winCombinations, AppliedSymbol bonus)
    {
        int reward = 0;
        for(AppliedSymbol standard : winCombinations.keySet())
        {
            int symbolReward = standard.getSymbol().getReward(bettingAmount);
            for(AppliedWinCombination winCombination : winCombinations.get(standard))
            {
                symbolReward *= winCombination.getWinCombination().getRewardMultiplier();
            }
            reward += symbolReward;
        }
        return bonus.getSymbol().getReward(reward);
    }
}
