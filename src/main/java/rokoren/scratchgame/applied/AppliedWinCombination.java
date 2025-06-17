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
public class AppliedWinCombination extends AbstractApplied
{
    private final WinCombination winCombination;

    public AppliedWinCombination(String name, WinCombination winCombination) 
    {
        super(name);
        this.winCombination = winCombination;
    }  
    
    public WinCombination getWinCombination()
    {
        return winCombination;
    }
}
