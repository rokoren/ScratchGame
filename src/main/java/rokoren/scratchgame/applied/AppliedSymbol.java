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
public class AppliedSymbol extends AbstractApplied
{
    private final Symbol symbol;

    public AppliedSymbol(String name, Symbol symbol) 
    {
        super(name);
        this.symbol = symbol;
    }
    
    public Symbol getSymbol()
    {
        return symbol;
    }
}
