package com.redrabbit.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.extendables.Moveable;

/**
 * A class to hold information about Smart Tiles.
 * 
 * @author rabbitfighter, redgragonX
 *
 */
public class SmartTile extends Moveable {

    private Rectangle bounds;
    private int width, height;
    private Image groundImage;
    private boolean passable;

    /**
     * Constructor only needs a vector to build.
     * 
     * @param vector
     *            - the vector passed in.
     */
    public SmartTile(Vector2f vector) {
	// Set the vector for the new Smart Tile. Velocity and angle are 0.
	super(vector, 0f, 0f);
	// Set width and height.
	this.setWidth(GameNumbers.SMART_TILE_WIDTH);
	this.setHeight(GameNumbers.SMART_TILE_HEIGHT);
	// Set bounds
	this.setBounds(new Rectangle(this.getVector().getX(), this.getVector()
		.getY(), this.getWidth(), this.getHeight()));
	this.setPassable(true);
    }

    /***** Getters/Setters *****/

    public Rectangle getBounds() {
	return bounds;
    }

    public void setBounds(Rectangle bounds) {
	this.bounds = bounds;
    }

    public Image getImage() {
	return groundImage;
    }

    public void setImage(Image image) {
	this.groundImage = image;
    }

    public boolean isPassable() {
	return passable;
    }

    public void setPassable(boolean passable) {
	this.passable = passable;
    }

}// EOF
