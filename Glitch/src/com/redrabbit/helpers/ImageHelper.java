package com.redrabbit.helpers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

import com.redrabbit.logging.LoggerConfig;

/**
 * A class to hehlp loading images.
 * 
 * @author rabbitfighter
 *
 */
public class ImageHelper {

    private static final String TAG = "ImageHelper";
    public final static String PATH = "res/img/";

    /**
     * Sets the image for a tile.
     * 
     * @param imageName
     *            The name of the image, with extension.
     * @return
     */
    public static Image setImage(String imageName) {

	// Initialize image to null before try/catch.
	Image image = null;

	try {
	    // Get the image from path.
	    image = new Image(PATH + imageName);

	    if (LoggerConfig.ON) {
		Log.debug(TAG + "Successfully loaded image.");
	    }

	} catch (SlickException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    if (LoggerConfig.ON) {
		Log.debug(TAG + "Couldn't load image.");
	    }
	    // Return null if no image loaded.
	    return null;
	}

	// Return the image.
	return image;
    }

}//EOF
