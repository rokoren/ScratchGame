/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.probabilities;

/**
 *
 * @author Rok Koren
 */
public class ProbabilitiesSymbolCell extends ProbabilitiesSymbol
{
    private final int row;
    private final int column; 

    public ProbabilitiesSymbolCell(int row, int column) 
    {
        this.row = row;
        this.column = column;
    }     
    
    public int getRow()
    {
        return row;
    }
    
    public int getColumn()
    {
        return column;
    }
}
