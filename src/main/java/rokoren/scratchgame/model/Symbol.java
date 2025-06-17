/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.model;

/**
 *
 * @author Rok Koren
 */
public abstract class Symbol 
{
    public static final String TYPE_STANDARD = "standard";
    public static final String TYPE_BONUS    = "bonus";
    
    public static final String IMPACT_MULTIPLY_REWARD = "multiply_reward";
    public static final String IMPACT_EXTRA_BONUS     = "extra_bonus";
    public static final String IMPACT_MISS            = "miss";
    
    private final String name;

    public Symbol(String name) 
    {
        this.name = name;
    }        
    
    @Override
    public String toString()
    {
        return name;
    }
}
