/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rokoren.scratchgame;

import rokoren.scratchgame.applied.AppliedOutput;

/**
 *
 * @author Rok Koren
 */
public interface JsonProvider 
{
    Config getConfig(String json);
    String toJson(AppliedOutput output);    
}
