/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author Rok Koren
 */
public class Probabilities 
{
    @SerializedName("standard_symbols")
    List<ProbabilitySymbolExt> standardSymbols;
    
    @SerializedName("bonus_symbols")
    ProbabilitySymbol bonusSymbols;
}
