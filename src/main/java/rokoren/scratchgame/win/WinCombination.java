/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.win;

/**
 *
 * @author Rok Koren
 */
public interface WinCombination 
{  
    String WHEN_SAME_SYMBOLS   = "same_symbols";
    String WHEN_LINEAR_SYMBOLS = "linear_symbols";
    
    String GROUP_SAME_SYMBOLS = "same_symbols";
    
    float getRewardMultiplier();
}
