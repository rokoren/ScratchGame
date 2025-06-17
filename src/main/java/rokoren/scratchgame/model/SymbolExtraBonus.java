/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.model;

/**
 *
 * @author Rok Koren
 */
public class SymbolExtraBonus extends Symbol 
{
    private final int extra;

    public SymbolExtraBonus(int extra, String name)
    {
        super(name);
        this.extra = extra;
    }        
}
