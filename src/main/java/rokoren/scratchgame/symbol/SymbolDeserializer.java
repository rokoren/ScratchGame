/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.symbol;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/**
 *
 * @author Rok Koren
 */
public class SymbolDeserializer implements JsonDeserializer<Symbol>
{
    private static final String MEMBER_TYPE              = "type";
    private static final String MEMBER_REWARD_MULTIPLIER = "reward_multiplier";
    private static final String MEMBER_IMPACT            = "impact";
    private static final String MEMBER_EXTRA             = "extra";
    
    @Override
    public Symbol deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jdc) throws JsonParseException 
    {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String symbolType = jsonObject.get(MEMBER_TYPE).getAsString();
        if(symbolType.equals(Symbol.TYPE_STANDARD))
        {
            float rewardMultiplier = jsonObject.get(MEMBER_REWARD_MULTIPLIER).getAsFloat();
            return new SymbolMultiplyReward(rewardMultiplier);
        }
        else if(symbolType.equals(Symbol.TYPE_BONUS))
        {
            String impact = jsonObject.get(MEMBER_IMPACT).getAsString();
            if(impact.equals(Symbol.IMPACT_MULTIPLY_REWARD))
            {
                float rewardMultiplier = jsonObject.get(MEMBER_REWARD_MULTIPLIER).getAsFloat();
                return new SymbolMultiplyReward(rewardMultiplier);
            }
            else if(impact.equals(Symbol.IMPACT_EXTRA_BONUS))
            {
                int extra = jsonObject.get(MEMBER_EXTRA).getAsInt();
                return new SymbolExtraBonus(extra);
            }
            else if(impact.equals(Symbol.IMPACT_MISS))
            {
                return new SymbolMiss();
            }            
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }   
}
