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
public class ScratchGameOutput 
{
    private final List<List<String>> matrix;
    
    @SerializedName("applied_winning_combinations")    
    private final Map<AppliedSymbol, List<AppliedWinCombination>> appliedWinCombinations;
    
    @SerializedName("applied_bonus_symbol") 
    private final AppliedSymbol bonus;
    
    private final int reward;

    public ScratchGameOutput(List<List<String>> matrix, Map<AppliedSymbol, List<AppliedWinCombination>> appliedWinCombinations, AppliedSymbol bonus, int reward) 
    {
        this.matrix = matrix;
        this.appliedWinCombinations = appliedWinCombinations;
        this.bonus = bonus;
        this.reward = reward;
    }   
}
