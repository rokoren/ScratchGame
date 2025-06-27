/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.scratchgame.applied;

/**
 *
 * @author Rok Koren
 */
public abstract class AbstractApplied 
{
    protected final String name;

    public AbstractApplied(String name) 
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }    
}
