package com.redrabbit.tiles;

import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.extendables.SmartTile;
import com.redrabbit.helpers.ImageHelper;

public class DisketteTile extends SmartTile{
    
    protected final String tilesPathAddition = "objects/"; 
    
    protected final String imageName = "diskette.png";

    public DisketteTile(Vector2f vector) {
	super(vector);
	this.setImage(ImageHelper.setTileImage(imageName));
    }

}
