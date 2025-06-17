/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.model;

/**
 *
 * @author Rok Koren
 */
public interface Symbol 
{
    String TYPE_STANDARD = "standard";
    String TYPE_BONUS    = "bonus";
    
    String IMPACT_MULTIPLY_REWARD = "multiply_reward";
    String IMPACT_EXTRA_BONUS     = "extra_bonus";
    String IMPACT_MISS            = "miss";
    
    public enum Impact 
    {
        MULTIPLY_REWARD,
        EXTRA_BONUS,        
        MISS;   
    }     

    Impact getImpact();
}
