/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.symbol;

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
    public Impact getImpact() 
    {
        return Impact.MULTIPLY_REWARD;
    }    
    
    public float getRewardMultiplier() 
    {
        return rewardMultiplier;
    }      
}
