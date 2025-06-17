/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.model;

/**
 *
 * @author Rok Koren
 */
public class SymbolExtraBonus implements Symbol 
{
    private final int extraBonus;

    public SymbolExtraBonus(int extraBonus)
    {
        this.extraBonus = extraBonus;
    }   
    
    @Override
    public Impact getImpact() 
    {
        return Impact.EXTRA_BONUS;
    }  

    public int getExtraBonus()
    {
        return extraBonus;
    }
}
