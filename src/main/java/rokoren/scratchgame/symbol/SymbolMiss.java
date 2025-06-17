/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.symbol;

/**
 *
 * @author Rok Koren
 */
public class SymbolMiss implements Symbol
{
    @Override
    public Impact getImpact() 
    {
        return Impact.MISS;
    }
}
