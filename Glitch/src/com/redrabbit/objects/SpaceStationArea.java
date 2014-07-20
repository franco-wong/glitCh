package com.redrabbit.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import tiles.SpaceStationTile;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.helpers.ImageHelper;

public class SpaceStationArea extends AreaMap {

    public SpaceStationArea(Vector2f vector) {
	super(vector);
	System.out.println("SmartTileWidth" + this.getWidth());
	this.setTiledMap(new SmartTile[GameNumbers.SMART_MAP_WIDTH][GameNumbers.SMART_MAP_HEIGHT]);

	// We want 2 of each "other tile" and the rest normal.
	for (int i = 0; i < this.getWidth(); i++) {
	    for (int j = 0; j < this.getHeight(); j++) {
		// Set a new Smart Tile.

		this.getTiledMap()[i][j] = new SpaceStationTile(new Vector2f(i
			* GameNumbers.SMART_TILE_WIDTH, j
			* GameNumbers.SMART_TILE_HEIGHT));
	    }
	}

    }

}

/*
 * 
 * 
 * this.setMap(new
 * SmartTile[GameNumbers.SMART_MAP_WIDTH][GameNumbers.SMART_MAP_HEIGHT]);
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * // New Smart Map made of Smart tiles. <==WIP (RANDOM COLOR)
 * 
 * 
 * 
 * // New tiled map. this.setTiledMap(new
 * SmartTile[GameNumbers.SMART_MAP_WIDTH][GameNumbers.SMART_MAP_HEIGHT]); //
 * Draw the tiles. for (int i = 0; i < this.getWidth(); i++) { for (int j = 0; j
 * < this.getHeight(); j++) { // Set a new Smart Tile.
 * 
 * 
 * this.getTiledMap()[i][j] = new SpaceStationTile(new Vector2f(i
 * GameNumbers.SMART_TILE_WIDTH, j GameNumbers.SMART_TILE_HEIGHT)); } }
 * 
 * // Set filled false upon build. this.setFilled(false);
 */