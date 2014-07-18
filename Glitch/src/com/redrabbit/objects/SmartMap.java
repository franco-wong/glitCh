package com.redrabbit.objects;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.helpers.Moveable;

/**
 * Creates a map with tiles that are automatically generated upon a smart map
 * construcor call. 7.18.14 - Tiles are random color generated right now. <==WIP
 * 
 * @author rabbitfighter, redragonX
 *
 */
public class SmartMap extends Moveable {

    // New smart Map.
    private SmartTile[][] map;
    private Rectangle bounds;
    private int width, height;
    
    // WIP
    private boolean filled;
    

    /**
     * Constructor
     * 
     * @param vector
     * @param angle
     * @param velocity
     */
    public SmartMap(Vector2f vector) {
	// Vector for x and y, but usually, angle and velocity should be zero,
	// unless the map is moving.
	super(vector, 0f, 0f);
	// Set width and height.
	this.setWidth(GameNumbers.SMART_MAP_WIDTH);
	this.setHeight(GameNumbers.SMART_MAP_HEIGHT);
	// New Smart Map made of Smart tiles. <==WIP (RANDOM COLOR)
	this.setMap(new SmartTile[GameNumbers.SMART_MAP_WIDTH][GameNumbers.SMART_MAP_HEIGHT]);
	// Set bounds.
	this.setBounds(new Rectangle(this.getVector().getX(), this.getVector()
		.getY(), this.getWidth(), this.getHeight()));

	// Draw the tiles.
	for (int i = 0; i < this.getWidth(); i++) {
	    for (int j = 0; j < this.getHeight(); j++) {
		// Set a new Smart Tile.
		this.getMap()[i][j] = new SmartTile(new Vector2f(i
			* GameNumbers.SMART_TILE_WIDTH, j
			* GameNumbers.SMART_TILE_HEIGHT));
	    }
	}
	
	// Set filed false upon build.
	this.setFilled(false);
    }

    /***** Getters/Setters *****/

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

    public SmartTile[][] getMap() {
	return map;
    }

    public void setMap(SmartTile[][] map) {
	this.map = map;
    }

    public Rectangle getBounds() {
	return bounds;
    }

    public void setBounds(Rectangle bounds) {
	this.bounds = bounds;
    }

    public boolean isFilled() {
	return filled;
    }

    public void setFilled(boolean filled) {
	this.filled = filled;
    }

}
