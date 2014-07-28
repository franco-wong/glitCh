package com.redrabbit.charachters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

import com.redrabbit.constants.GameNumbers;

import com.redrabbit.extendables.Living;
import com.redrabbit.logging.LoggerConfig;

public class Player extends Living{

    protected final String imagePath = "res/img/characters/badguy1.png";

    public Player(Vector2f vector, float angle, float velocity)
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
    
    /**
     * Turns player by given amount * a constant in the Numberxonstants class.
     * 
     * @param amount
     *            - The amount in degrees passed in.
     */
    @SuppressWarnings("unused")
    public void turn(int amount) {

	// make sure angles are positive.
	if (this.getAngle() >= 360) {
	    this.setAngle(this.getAngle() % 360);
	} else if (this.getAngle() <= 0) {
	    this.setAngle(this.getAngle() + 360);
	}

	// Set the angle.
	this.setAngle((this.getAngle() + amount
		* GameNumbers.PLAYER_ANGLE_CHANGE_AMOUNT));

	// Logging
	if (LoggerConfig.ON && LoggerConfig.TRACKING_PLAYER_MOVEMENT) {
	    Log.debug(TAG + "Angle: " + this.getAngle());
	}

    }
    

    public void bounceY() {
	this.setAngle(this.getAngle() * -1);

    }

    public void bounceX() {

	this.setAngle(this.getAngle() + 180);

    }
    
    /**
     * Changesa the velocity of the object.
     * 
     * @param s
     *            - the velocity passed in.
     */
    @SuppressWarnings("unused")
    public void changeVelocity(float s) {
	this.setVelocity(this.getVelocity() + s
		* GameNumbers.PLAYER_SPEED_CHANGE_AMOUNT);
	if (this.getVelocity() >= GameNumbers.PLAYER_MAX_SPEED)
	    this.setVelocity(GameNumbers.PLAYER_MAX_SPEED);
	if (this.getVelocity() <= -GameNumbers.PLAYER_MAX_SPEED)
	    this.setVelocity(-GameNumbers.PLAYER_MAX_SPEED);

	// Logging
	if (LoggerConfig.ON && LoggerConfig.TRACKING_PLAYER_MOVEMENT) {
	    Log.debug(" " + TAG + "Velocity: " + this.getVelocity());
	}

    }

}
