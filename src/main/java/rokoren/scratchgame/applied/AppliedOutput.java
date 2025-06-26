/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.applied;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rok Koren
 */
public class AppliedOutput 
{
    private final List<List<String>> matrix;
    
    @SerializedName("applied_winning_combinations")    
    private final Map<AppliedSymbol, List<AppliedWinCombination>> winCombinations;
    
    @SerializedName("applied_bonus_symbol") 
    private final AppliedSymbol bonus;
    
    private final int reward;

    public AppliedOutput(List<List<String>> matrix, Map<AppliedSymbol, List<AppliedWinCombination>> winCombinations, AppliedSymbol bonus, int reward) 
    {
        this.matrix = matrix;
        this.winCombinations = winCombinations;
        this.bonus = bonus;
        this.reward = reward;
    }   
    
    public List<List<String>> getMatrix()
    {
        return matrix;
    }
    
    public AppliedSymbol getBonus()
    {
        return bonus;
    }
}
