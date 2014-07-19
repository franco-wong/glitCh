package com.redrabbit.objects;

import org.newdawn.slick.geom.Rectangle;

public class Arena {

    private float x;
    private float y;
    private float width;
    private float height;
    private Rectangle bounds;

    public Arena(float x, float y, float width, float height) {
	this.setX(x);
	this.setY(y);
	this.setWidth(width);
	this.setHeight(height);
	this.setBounds(new Rectangle(this.getX(), this.getY(),
		this.getX() + this.getWidth(), this.getY() + this.getHeight()));
    }

    /***** Getters/Setters *****/

    public float getX() {
	return x;
    }

    public void setX(float x) {
	this.x = x;
    }

    public float getY() {
	return y;
    }

    public void setY(float y) {
	this.y = y;
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

    public Rectangle getBounds() {
	return bounds;
    }

    public void setBounds(Rectangle bounds) {
	this.bounds = bounds;
    }

}// EOF
