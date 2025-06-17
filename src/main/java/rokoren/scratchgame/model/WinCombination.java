/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Rok Koren
 */
public class WinCombination 
{
    private final String when;
    private final String group;
    
    @SerializedName("reward_multiplier")
    private final float rewardMultiplier;
    
    private final int count;

    public WinCombination(String when, String group, float rewardMultiplier, int count) {
        this.when = when;
        this.group = group;
        this.rewardMultiplier = rewardMultiplier;
        this.count = count;
    }        
}
