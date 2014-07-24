package com.redrabbit.objects;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.extendables.Moveable;

/**
 * A class that hold information about menu items.
 * 
 * @author rabbitfighter & redragonX
 *
 */
public class MenuItem extends Moveable {

    private String name;
    private float width, height;
    private Rectangle bounds;
    private boolean selected;
    private int selectedItemID;

    /**
     * Constructor for a Menu Item
     * 
     * @param x
     *            - the x coord
     * @param y
     *            - the y coord
     * @param angle
     *            - the angle of the object
     * @param speed
     *            - the speed of the the object
     */
    public MenuItem(String name, float x, float y, float width, float heigth,
	    float angle, float speed, boolean selected) {
	/*
	 * Super class variables. Will set vector in super class's constructor,
	 * as well as set the width and height.
	 */
	super(new Vector2f(x, y), angle, speed);
	this.setName(name);
	this.setWidth(width);
	this.setHeight(heigth);
	/*
	 * This will create a Rectangle that will represent the bounds, for
	 * collision detection
	 */
	this.setBounds(new Rectangle(x, y, width, height));
	this.setSelected(selected);
    }

    /**
     * A simple method to reverse the string of a menu item
     * 
     * @param name
     *            - the name passed in
     * @return the reversed string
     */
    public static String reverseString(String name) {

	// Create a new string builder object
	StringBuilder sb = new StringBuilder();
	/*
	 * Iterator appends characters to string builder starting at the end of
	 * the string and moving backwards until completion
	 */
	for (int i = name.length() - 1; i >= 0; i--) {
	    // Add character to String Builder
	    sb.append(name.toCharArray()[i]);
	}

	// Return the reversed string
	return sb.toString();
    }

    /***** Getters and Setters *****/

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public float getHeight() {
	return this.height;
    }

    public void setHeight(float height) {
	this.height = height;
    }

    public float getWidth() {
	return this.width;
    }

    public void setWidth(float width) {
	this.width = width;
    }

    public boolean isHovering(float mouseX, float mouseY) {
	return new Circle(mouseX, mouseY, 1, 1).intersects(this.getBounds());

    }

    public Rectangle getBounds() {
	return bounds;
    }

    public void setBounds(Rectangle bounds) {
	this.bounds = bounds;
    }

    public boolean isSelected() {
	return this.selected;
    }

    public void setSelected(boolean selected) {
	this.selected = selected;
    }

    public int getSelectedItemID() {
	return this.selectedItemID;
    }

    public void setSelectedItemID(int selectedItemID) {
	this.selectedItemID = selectedItemID;
    }

}// EOF
