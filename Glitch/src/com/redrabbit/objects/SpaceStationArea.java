package com.redrabbit.objects;

import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.tiles.ComputerTerminalTile;
import com.redrabbit.tiles.SpaceStationTile;

public class SpaceStationArea extends AreaMap {

    public SpaceStationArea(Vector2f vector) {
	super(vector);
	System.out.println("SmartTileWidth" + this.getWidth());
	this.setTiledMap(new SmartTile[GameNumbers.SMART_MAP_WIDTH][GameNumbers.SMART_MAP_HEIGHT]);

	// Set a new randomely generated map
	for (int i = 0; i < this.getWidth(); i++) {
	    for (int j = 0; j < this.getHeight(); j++) {
		// Set a new Smart Tile.

		this.getTiledMap()[i][j] = new SpaceStationTile(new Vector2f(i
			* GameNumbers.SMART_TILE_WIDTH, j
			* GameNumbers.SMART_TILE_HEIGHT));
	    }
	}

	// Put computers in area
	for (int i = 0; i < GameNumbers.NUMBER_COMPUTERS_PER_AREA; i++) {
	    // get a random x and y
	    int randomX = (int) Math.ceil(Math.random()
		    * GameNumbers.SMART_MAP_WIDTH - 1);
	    int randomY = (int) Math.ceil(Math.random()
		    * GameNumbers.SMART_MAP_HEIGHT - 1);

	    // Put random computer terminal.
	    if (this.getTiledMap()[randomX][randomY].isPassable()) {
		this.getTiledMap()[randomX][randomY] = new ComputerTerminalTile(
			new Vector2f(randomX * GameNumbers.SMART_TILE_WIDTH,
				randomY * GameNumbers.SMART_TILE_HEIGHT));
	    }

	    // Set the tile's passable boolean to false.
	    this.getTiledMap()[randomX][randomY].setPassable(false);

	}

    }
}// EOF

