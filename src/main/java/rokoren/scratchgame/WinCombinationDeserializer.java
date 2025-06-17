/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import rokoren.scratchgame.model.WinCombination;
import rokoren.scratchgame.model.WinCombinationLinearSymbols;
import rokoren.scratchgame.model.WinCombinationSameSymbols;

/**
 *
 * @author Rok Koren
 */
public class WinCombinationDeserializer implements JsonDeserializer<WinCombination>
{
    private static final String MEMBER_REWARD_MULTIPLIER = "reward_multiplier";
    private static final String MEMBER_WHEN              = "when";    
    private static final String MEMBER_GROUP             = "group";
    private static final String MEMBER_COUNT             = "count";
    private static final String MEMBER_COVERED_AREAS     = "covered_areas";
    
    @Override
    public WinCombination deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jdc) throws JsonParseException 
    {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        float rewardMultiplier = jsonObject.get(MEMBER_REWARD_MULTIPLIER).getAsFloat();
        String when = jsonObject.get(MEMBER_WHEN).getAsString();
        if(when.equals(WinCombination.WHEN_SAME_SYMBOLS))
        {
            String group = jsonObject.get(MEMBER_GROUP).getAsString(); 
            if(group.equals(WinCombination.GROUP_SAME_SYMBOLS))
            {
                int count = jsonObject.get(MEMBER_COUNT).getAsInt();
                return new WinCombinationSameSymbols(count, rewardMultiplier);                
            }
        }
        else if(when.equals(WinCombination.WHEN_LINEAR_SYMBOLS))
        {
            JsonArray jsonArray = jsonObject.get(MEMBER_COVERED_AREAS).getAsJsonArray();
            List<List<String>> coveredAreas = new ArrayList<>(jsonArray.size());
            for(JsonElement line : jsonArray.asList())
            {
                List<String> coveredArea = new ArrayList<>(line.getAsJsonArray().size());
                for(JsonElement cell : line.getAsJsonArray().asList())
                {
                    coveredArea.add(cell.getAsString());
                }                
                coveredAreas.add(coveredArea);
            }
            return new WinCombinationLinearSymbols(rewardMultiplier, coveredAreas);
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }      
}
