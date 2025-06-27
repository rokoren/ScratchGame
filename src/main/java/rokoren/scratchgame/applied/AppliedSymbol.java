/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.applied;

import rokoren.scratchgame.symbol.Symbol;

/**
 *
 * @author Rok Koren
 */
public class AppliedSymbol extends AbstractApplied implements Symbol
{
    private final Symbol symbol;

    public AppliedSymbol(String name, Symbol symbol) 
    {
        super(name);
        this.symbol = symbol;
    }
    
    @Override
    public int getReward(int bettingAmount) 
    {
        return symbol.getReward(bettingAmount);
    }    
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof AppliedSymbol applied)
        {
            return applied == this;
        }
        else if(obj instanceof Symbol symbol)
        {
            return symbol == this.symbol;
        }      
        return false;
    }

    @Override
    public int hashCode() 
    {
        return symbol.hashCode();
    }     
}
