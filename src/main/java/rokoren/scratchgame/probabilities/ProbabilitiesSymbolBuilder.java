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
public class ProbabilitiesSymbolBuilder 
{
    protected Map<String, Integer> symbols = new HashMap<>();        
    
    public ProbabilitiesSymbolBuilder withSymbol(String name, int probability)
    {
        symbols.put(name, probability);
        return this;
    }
    
    public ProbabilitiesSymbol build()
    {
        ProbabilitiesSymbol probabilities = new ProbabilitiesSymbol();
        probabilities.getSymbols().putAll(symbols);
        return probabilities;
    }     
}
