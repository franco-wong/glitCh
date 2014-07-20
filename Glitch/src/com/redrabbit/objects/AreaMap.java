package com.redrabbit.objects;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import tiles.SpaceStationTile;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.helpers.Moveable;

/**
 * Creates a map with tiles that are automatically generated upon a smart map
 * construcor call. 7.18.14 - Tiles are random color generated right now. <==WIP
 * 
 * @author rabbitfighter, redragonX
 *
 */
public class AreaMap extends Moveable {

    // New smart Map.
    private SmartTile[][] map;
    private SmartTile[][] tiledMap;
    private Rectangle bounds;
    private int width, height;
    
    // WIP
    private boolean filled, tiled;
    

    /**
     * Constructor
     * 
     * @param vector
     * @param angle
     * @param velocity
     */
    public AreaMap(Vector2f vector) {
	// Vector for x and y, but usually, angle and velocity should be zero,
	// unless the map is moving.
	super(vector, 0f, 0f);
	// Set width and height.
	this.setWidth(GameNumbers.SMART_MAP_WIDTH);
	this.setHeight(GameNumbers.SMART_MAP_HEIGHT);
	// Set bounds.
		this.setBounds(new Rectangle(this.getVector().getX(), this.getVector()
			.getY(), this.getWidth(), this.getHeight()));
		
	
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

    public boolean isTiled() {
	return tiled;
    }

    public void setTiled(boolean tiled) {
	this.tiled = tiled;
    }

    public SmartTile[][] getTiledMap() {
	return tiledMap;
    }

   
    public void setTiledMap(SmartTile[][] smartTiles) {
	this.tiledMap = smartTiles;
    }

   

}
