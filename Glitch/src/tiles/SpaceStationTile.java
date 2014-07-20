package tiles;

import org.newdawn.slick.geom.Vector2f;

import com.redrabbit.helpers.ImageHelper;
import com.redrabbit.objects.SmartTile;

/**
 * A ground tile. Extends Smart tile, adding an image.
 * 
 * @author rabbitfighter
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
    protected final String tileMetal = "tileDirty4.png";

 

    /**
     * Constructor for ground tile.
     * 
     * @param vector
     *            - The vector passed in.
     */
    public SpaceStationTile(Vector2f vector) {

	super(vector);

	int random = (int) (Math.ceil(Math.random() * 11));

	if (random <= 6) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition+tilePlain));
	}
	if (random == 7) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition+tileCutaway));
	}
	if (random == 8) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition+tileDoor1));
	}
	if (random == 9) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition+tileDoor2));
	}
	if (random == 10) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition+tileDirty1));
	}
	if (random == 11) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition+tileDirty2));
	}
	if (random == 12) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition+tileDirty3));
	}
	if (random == 13) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition+tileDirty4));
	}
	if (random == 14) {
	    this.setImage(ImageHelper.setTileImage(tilesPathAddition+tileMetal));
	}

    }

}// EOF
