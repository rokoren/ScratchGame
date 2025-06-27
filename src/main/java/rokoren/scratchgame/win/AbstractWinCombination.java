/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.win;

import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Rok Koren
 */
public abstract class AbstractWinCombination implements WinCombination
{
    private final float rewardMultiplier;
    
    public AbstractWinCombination(float rewardMultiplier) 
    {
        this.rewardMultiplier = rewardMultiplier;
    } 
    
    public abstract Set<String> checkWins(String[][] grid);    
    
    @Override
    public float getRewardMultiplier()
    {
        return rewardMultiplier;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;    
        return Objects.equals(obj, this);
    }     
}
