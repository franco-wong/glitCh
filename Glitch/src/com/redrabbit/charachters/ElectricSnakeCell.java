package com.redrabbit.charachters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.extendables.Living;

public class ElectricSnakeCell extends Living {

    public static final String imagePath = "res/img/charachters/snake/worm_blinking0.png";

    public ElectricSnakeCell(Vector2f vector, float angle, float velocity)
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
	// TODO :: Experimental :: Set bounds (in this case, I felt a circle
	// more appropriate.
	this.setBoundsC(new Circle(vector.getX(), vector.getY(), this
		.getWidth()));
	// Start the animation.
	this.getAnimation().start();
	// Set looping to true
	this.getAnimation().setLooping(true);

    }

    // Define what the snake cell is according to how long the snake is...

}
