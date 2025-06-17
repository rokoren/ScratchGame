/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.model;

import java.util.Set;

/**
 *
 * @author Rok Koren
 */
public abstract class WinCombination 
{  
    public static final String WHEN_SAME_SYMBOLS   = "same_symbols";
    public static final String WHEN_LINEAR_SYMBOLS = "linear_symbols";
    
    public static final String GROUP_SAME_SYMBOLS = "same_symbols";
    
    private final float rewardMultiplier;
    
    public WinCombination(float rewardMultiplier) 
    {
        this.rewardMultiplier = rewardMultiplier;
    } 
    
    public float getRewardMultiplier()
    {
        return rewardMultiplier;
    }
    
    public abstract Set<String> checkWins(String[][] grid);
}
