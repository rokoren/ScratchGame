/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rokoren.scratchgame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import rokoren.scratchgame.model.Symbol;

/**
 *
 * @author Rok Koren
 */
public class ScratchGame
{
    private static final Logger LOG = Logger.getLogger(ScratchGame.class.getName());  
    
    public static void main(String[] args) 
    {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Symbol.class, new SymbolDeserializer());   
        Gson gson = builder.create();

        try
        {
            //String url = getClass().getResource("resources/config.json").toExternalForm();          
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Rok Koren\\NetBeansProjects\\ScratchGame\\src\\main\\java\\rokoren\\scratchgame\\resources\\config.json")));
            Config config = gson.fromJson(reader, Config.class);              
            System.out.println("Hello World!");            
        }
        catch(IOException e)
        {
            LOG.warning(e.getMessage());
        }
    }
}
