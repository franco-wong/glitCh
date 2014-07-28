package com.redrabbit.charachters;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.extendables.Living;

/**
 * An evil mouse. Experimental.
 * 
 * @author rabbitfighter
 *
 */
public class ElectricSnakeCell extends Living {



    public ElectricSnakeCell(Vector2f vector, float angle, float velocity)
	    throws SlickException {
	super(vector, angle, velocity);

	// Set the image Array.
	//this.setImageArray(new Image[] { ImageHelper
		//.setSnakeCellImage(null) });
	// Set the duration
	//this.setDurationArray(new int[] { 1000 });
	// Set the animation.
	//this.setAnimation(new Animation(this.getImageArray(), this
		//.getDurationArray()));
	this.setWidth(GameNumbers.SMART_TILE_WIDTH);
	this.setHealth(GameNumbers.SMART_TILE_HEIGHT);
	// Set bounds
	this.setBounds(new Rectangle(vector.getX(), vector.getY(), this
		.getWidth(), this.getHealth()));
	//this.getAnimation().start();
	//this.getAnimation().setLooping(true);
    }

    

}
