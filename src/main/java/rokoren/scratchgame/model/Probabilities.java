/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rok Koren
 */
public class Probabilities 
{    
    @SerializedName("standard_symbols")
    private List<ProbabilitiesSymbolCell> standardSymbols;
    
    @SerializedName("bonus_symbols")
    private ProbabilitiesSymbol bonusSymbols;
    
    private Map<String, Integer> defaultSymbols;
    
    private Map<String, Integer> getDeafultSymbols()
    {
        if(defaultSymbols == null)
        {
            for(ProbabilitiesSymbolCell cell : standardSymbols)
            {
                if(cell.getRow() == 0 && cell.getColumn() == 0)
                {
                    defaultSymbols = cell.getSymbols();
                    break;
                }
            }
        }
        return defaultSymbols;
    }
    
    public Map<String, Integer> getStandardSymbols(int row, int column)
    {
        for(ProbabilitiesSymbolCell cell : standardSymbols)
        {
            if(cell.getRow() == row && cell.getColumn() == column)
            {
                return cell.getSymbols();
            }
        }        
        return getDeafultSymbols();
    } 
    
    public Map<String, Integer> getBonusSymbols()
    {
        return bonusSymbols.getSymbols();
    }
}
