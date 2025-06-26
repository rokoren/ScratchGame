/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.win;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rok Koren
 */
public class WinCombinationLinearSymbolsBuilder 
{
    private List<List<String>> coveredAreas = new ArrayList<>();
    
    private float rewardMultiplier;

    WinCombinationLinearSymbolsBuilder() {}
    
    public WinCombinationLinearSymbolsBuilder rewardMultiplier(float rewardMultiplier)
    {
        this.rewardMultiplier = rewardMultiplier;
        return this;
    }    
    
    public WinCombinationLinearSymbolsBuilder withCoveredArea(List<String> cells)
    {
        coveredAreas.add(cells);
        return this;
    }
    
    public WinCombinationLinearSymbols build()
    {
        WinCombinationLinearSymbols combinations = new WinCombinationLinearSymbols(rewardMultiplier, coveredAreas);
        return combinations;
    }    
}
