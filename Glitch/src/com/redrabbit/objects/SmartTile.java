package com.redrabbit.objects;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import com.redrabbit.constants.GameColors;
import com.redrabbit.constants.GameNumbers;
import com.redrabbit.helpers.Moveable;

/**
 * A class to hold information about Smart Tiles.
 * 
 * @author rabbitfighter, redgragonX
 *
 */
public class SmartTile extends Moveable {

    private Rectangle bounds;
    private Color color;
    private int width, height;

    // Constructor.
    public SmartTile(Vector2f vector) {
	// Set the vector for the new Smart Tile. Velocity and angle are 0.
	super(vector, 0f, 0f);
	// Set width and height.
	this.setWidth(GameNumbers.SMART_TILE_WIDTH);
	this.setHeight(GameNumbers.SMART_TILE_HEIGHT);
	// Set a random color <== WIP
	this.setColor(GameColors.getRandomHue());
	// Set bounds
	this.setBounds(new Rectangle(this.getVector().getX(), this.getVector()
		.getY(), this.getWidth(), this.getHeight()));
    }

    /***** Getters/Setters *****/

    public Rectangle getBounds() {
	return bounds;
    }

    public void setBounds(Rectangle bounds) {
	this.bounds = bounds;
    }

    public Color getColor() {
	return color;
    }

    public void setColor(Color color) {
	this.color = color;
    }

    public int getWidth() {
	return width;
    }

    public void setWidth(int width) {
	this.width = width;
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(int height) {
	this.height = height;
    }

}// EOF
