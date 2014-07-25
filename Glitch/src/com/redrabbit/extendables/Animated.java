package com.redrabbit.extendables;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * This class bisically is just a class that provides getters/setters for
 * animations.
 * 
 * @author rabbitfighter, redraginX
 *
 */
public class Animated extends Moveable {

    

    // Shapes animation
    private Animation animation;

    // Shapes animation image array
    private Image[] imageArray;

    // Variable for current animation
    private Animation currentAnimation;

    // Durations for animations.
    private int[] durationArray;

    public Animated(Vector2f vector, float angle, float velocity) {
	super(vector, angle, velocity);

    }

    /***** Getters/Setters *****/

    public Animation getAnimation() {
	return animation;
    }

    public void setAnimation(Animation animation) {
	this.animation = animation;
    }

    public Image[] getImageArray() {
	return imageArray;
    }

    public void setImageArray(Image[] imageArray) {
	this.imageArray = imageArray;
    }

    public Animation getCurrentAnimation() {
	return currentAnimation;
    }

    public void setCurrentAnimation(Animation currentAnimation) {
	this.currentAnimation = currentAnimation;
    }

    public int[] getDurationArray() {
	return durationArray;
    }

    public void setDurationArray(int[] durationArray) {
	this.durationArray = durationArray;
    }

}