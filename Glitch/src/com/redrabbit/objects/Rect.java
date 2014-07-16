package com.redrabbit.objects;



import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.helpers.Moveable;

/**
 * To be deleted soon. WIP
 * 
 * @author rabbitfighter
 *
 */
public class Rect extends Moveable {

    private float width;
    private float height;
    private float speed;
    private Rectangle bounds;

    public final static float SPEEDCHANGEAMOUNT = .010f;
    public final static float ANGLECHANGEAMOUNT = 2f;
    public final static float MAX_SPEED = 2f;

    /**
     * Constructor for a "Rectangle" of sorts for testing purposes.
     * 
     * @param x
     *            The x coord.
     * @param y
     *            The y coord.
     * @param width
     *            The width of the rectangle in pixels.
     * @param height
     *            The height of the rectangle in pixels.
     * @param angle
     *            The angle of the rectangle in pixels.
     * @param speed
     *            The speed the object is moving.
     */

    public Rect(Vector2f vector, float width, float height, float angle,
	    float velocity) {
	
	super(vector, angle, velocity);
	this.setWidth(width);
	this.setHeight(height);
	// Make a rectangle to represent bounds for collision testing.
	this.setBounds(new Rectangle(this.getVector().getX(), this.getVector()
		.getY(), this.getWidth(), this.getHeight()));
	this.setVelocity(velocity);

    }

    public void changeVelocity(float s) {
	this.setVelocity(this.getVelocity() + s * SPEEDCHANGEAMOUNT);
	if (this.getVelocity() >= MAX_SPEED)
	    this.setVelocity(MAX_SPEED);
	if (this.getVelocity() <= -MAX_SPEED)
	    this.setVelocity(-MAX_SPEED);
	System.out.println("Velocity: " + this.getVelocity());
    }

    // turn the player by a given angle amount
    public void turn(int amount) {

	this.setAngle((this.getAngle() + amount * ANGLECHANGEAMOUNT));

	if (this.getAngle() <= 0) {
	    this.setAngle(this.getAngle() + 360);
	} 

	System.out.println("Angle: " + this.getAngle());

    }


    public float getHeight() {
	return height;
    }

    public void setHeight(float height) {
	this.height = height;
    }

    public float getWidth() {
	return width;
    }

    public void setWidth(float width) {
	this.width = width;
    }

    public Rectangle getBounds() {
	return bounds;
    }

    public void setBounds(Rectangle bounds) {
	this.bounds = bounds;
    }

    public float getSpeed() {
	return speed;
    }

    public void setSpeed(float speed) {
	this.speed = speed;
    }

}
