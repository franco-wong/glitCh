package com.redrabbit.helpers;

import org.newdawn.slick.geom.Vector2f;

/**
 * A Wrapper class for moveable objectts
 * 
 * @author rabbitfighter, redragonX
 *
 */
public class Moveable {
    private float x, y;
    private float angle;
    private float speed;
    private Vector2f vector;

    public Moveable(float x, float y, float angle, float speed) {

	this.setX(x);
	this.setY(y);
	this.setAngle(angle);
	this.setVector(new Vector2f(x, y));

    }

    /**
     * A simple method to return the new vector based on trajectory
     * 
     * @return new vector position
     */
    public Vector2f updateVector() {
	float angleRadians = (float) Math.toRadians(this.getAngle());
	return new Vector2f((float) (speed * Math.cos(angleRadians)),
		(float) (speed * Math.cos(angleRadians)));

    }

    /***** Getters/Setters *****/

    public float getX() {
	return this.x;
    }

    public void setX(float x) {
	this.x = x;
    }

    public float getY() {
	return this.y;
    }

    public void setY(float y) {
	this.y = y;
    }

    public float getAngle() {
	return this.angle;
    }

    public void setAngle(float angle) {
	this.angle = angle;
    }

    public float getSpeed() {
	return speed;
    }

    public void setSpeed(float speed) {
	this.speed = speed;
    }

    public Vector2f getVector() {
	return vector;
    }

    public void setVector(Vector2f vector) {
	this.vector = vector;
    }

}// EOF
