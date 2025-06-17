/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.generator;

import java.util.Map;
import java.util.Random;
import rokoren.scratchgame.Config;
import rokoren.scratchgame.applied.AppliedSymbol;
import rokoren.scratchgame.symbol.Symbol;

/**
 *
 * @author Rok Koren
 */
public class BonusGenerator 
{
    private final Random random = new Random();  
    
    public AppliedSymbol generateBonus(Config config) 
    {
        Map<String, Integer> probabilities = config.getProbabilities().getBonusSymbols();
        int totalWeight = probabilities.values().stream().mapToInt(Integer::intValue).sum();
        int rand = random.nextInt(totalWeight);
        int cumulative = 0;

        for (String key : probabilities.keySet()) 
        {
            cumulative += probabilities.get(key);
            if (rand < cumulative) 
            {
                Symbol symbol = config.getSymbols().get(key);
                return new AppliedSymbol(key, symbol);
            }
        }

        return null;
    }     
}
