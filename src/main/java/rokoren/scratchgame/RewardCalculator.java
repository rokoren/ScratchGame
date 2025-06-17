/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame;

import java.util.List;
import java.util.Map;
import rokoren.scratchgame.model.AppliedSymbol;
import rokoren.scratchgame.model.AppliedWinCombination;

/**
 *
 * @author Rok Koren
 */
public class RewardCalculator 
{
    public int calculateReward(int bettingAmount, Map<AppliedSymbol, List<AppliedWinCombination>> winCombinations, AppliedSymbol bonus)
    {
        float reward = 0;
        for(AppliedSymbol symbol : winCombinations.keySet())
        {
            float symbolReward = symbol.getReward(bettingAmount);
            for(AppliedWinCombination winCombination : winCombinations.get(symbol))
            {
                symbolReward *= winCombination.getWinCombination().getRewardMultiplier();
            }
            reward += symbolReward;
        }
        return Math.round(bonus.getReward(reward));
    }
}
