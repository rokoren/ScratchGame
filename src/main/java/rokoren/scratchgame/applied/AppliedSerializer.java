/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.applied;

import rokoren.scratchgame.applied.AbstractApplied;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/**
 *
 * @author Rok Koren
 */
public class AppliedSerializer implements JsonSerializer<AbstractApplied>
{
    @Override
    public JsonElement serialize(AbstractApplied obj, Type type, JsonSerializationContext jsc) 
    {
        return new JsonPrimitive(obj.toString());
    }      
}
