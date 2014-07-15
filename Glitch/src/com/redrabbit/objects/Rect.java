package com.redrabbit.objects;

/**
 * To be deleted soon. WIP
 * 
 * @author rabbitfighter
 *
 */
public class Rect {

    private int width;
    private int height;
    private float x, y;
    private float velocityX, velocityY;
    private boolean collidedX, collidedY;

    public Rect() {
	this.setWidth(50);
	this.setHeight(100);
	this.setX(50);
	this.setY(50);
	this.setCollidedX(false);
	this.setCollidedY(false);

    }

    public void rectGo(int delta) {

	// Set initial velocities (before collision)
	if (!this.isCollidedX()) {
	    velocityX = delta * .50f;
	}

	if (!this.isCollidedY()) {
	    velocityY = delta * .50f;
	}

	// If collision with walls, reverse velocity for x, y
	if (this.getX() < 0) {
	    this.setX(0);
	    velocityX = -velocityX;
	    this.setCollidedX(true);
	} else if (this.getX() + this.getWidth() > 900) {
	    this.setX(900 - 50);
	    velocityX = -1 * velocityX;
	    this.setCollidedX(true);
	}

	if (this.getY() < 0) {
	    this.setY(0);
	    velocityY = -velocityY;
	    this.setCollidedY(true);
	} else if (this.getY() + this.getHeight() > 700) {
	    this.setY(700 - this.getHeight());
	    velocityY = -velocityY;
	    this.setCollidedY(true);
	}

	// Move x, y
	this.setX(this.getX() + velocityX);
	this.setY(this.getY() + velocityY);

    }

    private void randomColor() {

    }

    public float getX() {
	return x;
    }

    public void setX(float x) {
	this.x = x;
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(int height) {
	this.height = height;
    }

    public float getY() {
	return y;
    }

    public void setY(float y) {
	this.y = y;
    }

    public int getWidth() {
	return width;
    }

    public void setWidth(int width) {
	this.width = width;
    }

    public boolean isCollidedX() {
	return collidedX;
    }

    public void setCollidedX(boolean collidedX) {
	this.collidedX = collidedX;
    }

    public boolean isCollidedY() {
	return collidedY;
    }

    public void setCollidedY(boolean collidedY) {
	this.collidedY = collidedY;
    }

}
