/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.probabilities;

/**
 *
 * @author Rok Koren
 */
public class ProbabilitiesSymbolCellBuilder extends ProbabilitiesSymbolBuilder
{    
    private int row    = 0;
    private int column = 0;     
    
    public ProbabilitiesSymbolCellBuilder row(int row)
    {
        this.row = row;
        return this;
    }    
    
    public ProbabilitiesSymbolCellBuilder column(int column)
    {
        this.column = column;
        return this;
    }     
    
    @Override
    public ProbabilitiesSymbol build()
    {
        ProbabilitiesSymbolCell probabilities = new ProbabilitiesSymbolCell(row, column);
        probabilities.getSymbols().putAll(symbols);
        return probabilities;
    }      
}
