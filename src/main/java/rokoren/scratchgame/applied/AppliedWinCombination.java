/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.applied;

import rokoren.scratchgame.win.WinCombination;

/**
 *
 * @author Rok Koren
 */
public class AppliedWinCombination extends AbstractApplied implements WinCombination
{
    private final WinCombination winCombination;

    public AppliedWinCombination(String name, WinCombination winCombination) 
    {
        super(name);
        this.winCombination = winCombination;
    }  
    
    @Override
    public float getRewardMultiplier() 
    {
        return winCombination.getRewardMultiplier();
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof AppliedWinCombination applied)
        {
            return applied == this;
        }
        else if(obj instanceof WinCombination winCombination)
        {
            return winCombination == this.winCombination;
        }      
        return false;
    }  
    
    @Override
    public int hashCode() 
    {
        return winCombination.hashCode();
    }      
}
