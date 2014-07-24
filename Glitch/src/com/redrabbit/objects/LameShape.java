package com.redrabbit.objects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.extendables.Animated;

public class LameShape extends Animated {

    protected final String PATH = "res/img/shapes/";

    public LameShape(Vector2f vector, float angle, float velocity)
	    throws SlickException {
	super(vector, angle, velocity);

	// Set the image array.
	this.setImageArray(new Image[] { new Image(PATH + "shape1.png"),
		new Image(PATH + "shape2.png"), new Image(PATH + "shape3.png"),
		new Image(PATH + "shape4.png"), new Image(PATH + "shape5.png") });

	// Set duration array.
	this.setDurationArray(new int[] { 400, 400, 400, 400, 400 });

	// Set the animation
	this.setAnimation(new Animation(this.getImageArray(), this.getDurationArray()));
	
    }
}
