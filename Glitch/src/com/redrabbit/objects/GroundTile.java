package com.redrabbit.objects;

import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.helpers.ImageHelper;

/**
 * A ground tile. Extends Smart tile, adding an image.
 * 
 * @author rabbitfighter
 *
 */
public class GroundTile extends SmartTile {

    protected final String imageName = "ground.png";

    /**
     * Constructor for ground tile.
     * 
     * @param vector
     *            - The vector passed in.
     */
    public GroundTile(Vector2f vector) {
	super(vector);
	this.setImage(ImageHelper.setImage(imageName));
    }

}//EOF
