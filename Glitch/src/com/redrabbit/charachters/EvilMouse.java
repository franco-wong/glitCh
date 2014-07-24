package com.redrabbit.charachters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.extendables.Characters;

public class EvilMouse extends Characters {

    protected final String imagePath = "res/img/characters/evil_mouse.png";

    public EvilMouse(Vector2f vector, float angle, float velocity)
	    throws SlickException {
	super(vector, angle, velocity);
	
	
	    
	    
	// Set the image Array.
	this.setImageArray(new Image[] { new Image(imagePath) });
	// Set the duration
	this.setDurationArray(new int[] { 1000 });
	// Set the animation.
	this.setAnimation(new Animation(this.getImageArray(), this
		.getDurationArray()));
	this.setWidth(GameNumbers.SMART_TILE_WIDTH);
	this.setHealth(GameNumbers.SMART_TILE_HEIGHT);
	// Set bounds
	this.setBounds(new Rectangle(vector.getX(), vector.getY(),
		this.getWidth(), this.getHealth()));
	this.getAnimation().start();
	this.getAnimation().setLooping(false);
    }
}
