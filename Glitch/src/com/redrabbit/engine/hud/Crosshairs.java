package com.redrabbit.engine.hud;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.extendables.Moveable;
import com.redrabbit.helpers.ImageHelper;

public class Crosshairs extends Moveable {

    // Paths
    public static final String c_cross_hit = "c_cross_hit.png";
    public static final String c_cross = "c_cross.png";
    public static final String cross_hit = "cross_hit.png";
    public static final String cross = "cross.png";
    public static final String c_dot_hit = "c_dot_hit.png";

    // Crosshairs
    private Image crosshairsImage;
    private float width, height;
    private Rectangle bounds;
    private boolean rPressed, lPressed, rClicked, lClicked;

    /**
     * Crosshairs object constructor.
     * 
     * @param vector
     *            The vector passed in.
     * @param angle
     *            The angle passed in.
     * @param velocity
     *            The velocity passed in.
     */
    public Crosshairs(Vector2f vector, float angle, float velocity) {
	// Get variables from superclass
	super(vector, angle, velocity);
	// Set the crosshairs image using our imgae helper.
	this.setCrosshairsImage(ImageHelper.setCrosshairsImage(c_cross));
	// Set the width and height.
	this.setWidth(GameNumbers.SMART_TILE_WIDTH);
	this.setHeight(GameNumbers.SMART_TILE_HEIGHT);
	// Set the bounds of our crosshairs
	this.setBounds(new Rectangle(this.getVector().getX(), this.getVector()
		.getY(), this.getWidth(), this.getHeight()));

    }

    public Image getCrosshairsImage() {
	return crosshairsImage;
    }

    public void setCrosshairsImage(Image crosshairs) {
	this.crosshairsImage = crosshairs;
    }

    public Rectangle getBounds() {
	return bounds;
    }

    public void setBounds(Rectangle bounds) {
	this.bounds = bounds;
    }

    public boolean isrPressed() {
	return rPressed;
    }

    public void setrPressed(boolean rPressed) {
	this.rPressed = rPressed;
    }

    public boolean islPressed() {
	return lPressed;
    }

    public void setlPressed(boolean lPressed) {
	this.lPressed = lPressed;
    }

    public boolean isrClicked() {
	return rClicked;
    }

    public void setrClicked(boolean rClicked) {
	this.rClicked = rClicked;
    }

    public boolean islClicked() {
	return lClicked;
    }

    public void setlClicked(boolean lClicked) {
	this.lClicked = lClicked;
    }

    public float getWidth() {
	return width;
    }

    public void setWidth(float width) {
	this.width = width;
    }

    public float getHeight() {
	return height;
    }

    public void setHeight(float height) {
	this.height = height;
    }

}
