/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.symbol;

import java.util.Objects;

/**
 *
 * @author Rok Koren
 */
public class SymbolMultiplyReward implements Symbol
{
    private final float rewardMultiplier;    
    
    public SymbolMultiplyReward(float rewardMultiplier) 
    {
        this.rewardMultiplier = rewardMultiplier;        
    }  

    @Override
    public int getReward(int bettingAmount) 
    { 
        float reward = bettingAmount * rewardMultiplier;
        return Math.round(reward);
    } 
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;    
        return Objects.equals(obj, this);
    }    
}
