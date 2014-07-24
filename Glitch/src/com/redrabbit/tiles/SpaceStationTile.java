package com.redrabbit.tiles;

import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.helpers.ImageHelper;
import com.redrabbit.objects.SmartTile;

/**
 * A ground tile. Extends Smart tile, adding an image.
 * 
 * @author rabbitfighter, redragonX
 *
 */
public class SpaceStationTile extends SmartTile {

    protected final String tilesPathAddition = "spacestation/";

    protected final String tilePlain = "tile4.png";
    protected final String tileCutaway = "tile1.png";
    protected final String tileDoor1 = "tile2.png";
    protected final String tileDoor2 = "tile3.png";
    protected final String tileDirty1 = "tileDirty1.png";
    protected final String tileDirty2 = "tileDirty2.png";
    protected final String tileDirty3 = "tileDirty3.png";
    protected final String tileDirty4 = "tileDirty4.png";
    protected final String tileMetal = "tileMetal.png";

    /**
     * Constructor for ground tiles. Creates 
     * 
     * @param vector
     *            - The vector passed in.
     */
    public SpaceStationTile(Vector2f vector) {

	super(vector);

	int random = (int) (Math.ceil(Math.random() * 36));

	if (random <= 20) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition
		    + tilePlain));
	}
	if (random > 20 && random <= 26) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition
		    + tileCutaway));
	}
	if (random > 26 && random <= 30) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition
		    + tileDoor1));
	}
	if (random == 31) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition
		    + tileDoor2));
	}
	if (random == 32) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition
		    + tileDirty1));
	}
	if (random == 33) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition
		    + tileDirty2));
	}
	if (random == 34) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition
		    + tileDirty3));
	}
	if (random == 35) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition
		    + tileDirty4));
	}
	if (random == 36) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition
		    + tileMetal));
	}
	
	
	
	

    }

}// EOF
