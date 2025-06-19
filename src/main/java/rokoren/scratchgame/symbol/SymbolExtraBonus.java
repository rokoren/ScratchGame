/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.symbol;

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
    public int getReward(int bettingAmount) 
    {
        return bettingAmount + extraBonus;
    }
}
