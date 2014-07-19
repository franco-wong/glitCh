package com.redrabbit.objects;

import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.helpers.ImageHelper;

/**
 * A ground tile. Extends Smart tile, adding an image.
 * 
 * @author rabbitfighter
 *
 */
public class SpaceStationTile extends SmartTile {


    protected final String additionalPath = "spacestation/";
    protected final String imageName = "tile1.png";

    /**
     * Constructor for ground tile.
     * 
     * @param vector
     *            - The vector passed in.
     */
    public SpaceStationTile(Vector2f vector) {
	super(vector);
	this.setImage(ImageHelper.setTileImage(additionalPath+imageName));
    }

}// EOF
