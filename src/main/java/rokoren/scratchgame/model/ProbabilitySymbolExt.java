/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.model;

/**
 *
 * @author Rok Koren
 */
public class ProbabilitySymbolExt extends ProbabilitySymbol
{
    private final int row;
    private final int column; 

    public ProbabilitySymbolExt(int row, int column) 
    {
        this.row = row;
        this.column = column;
    }     
}
