package com.redrabbit.extendables;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Characters extends Living{
    
  

    /**
     * @param vector
     * @param angle
     * @param velocity
     */
    public Characters(Vector2f vector, float angle, float velocity) {
	super(vector, angle, velocity);
	this.setHealth(super.MAX_HEALTH);
	this.setStamina(super.MAX_STAMINA);
	this.setLiving(true);
    }

   
    
    

}
