package com.redrabbit.tiles;

import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.extendables.SmartTile;
import com.redrabbit.helpers.ImageHelper;

/**
 * A ground tile. Extends Smart tile, adding an image.
 * 
 * @author rabbitfighter, redragonX
 *
 */
public class ComputerTerminalTile extends SmartTile {

    protected final String tilesPathAddition = "spacestation/";

    protected final String imageName = "computerTerminal1.png";

    /**
     * Constructor for ground tiles. Creates
     * 
     * @param vector
     *            - The vector passed in.
     */
    public ComputerTerminalTile(Vector2f vector) {

	super(vector);

	this.setImage(ImageHelper.setTileImage(tilesPathAddition + imageName));

    }

}// EOF
