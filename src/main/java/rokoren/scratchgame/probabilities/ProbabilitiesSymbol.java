/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.probabilities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rok Koren
 */
public class ProbabilitiesSymbol 
{    
    protected Map<String, Integer> symbols;  

    public Map<String, Integer> getSymbols()
    {
        if(symbols == null)
        {
            symbols = new HashMap<>();
        }
        return symbols;
    }
}
