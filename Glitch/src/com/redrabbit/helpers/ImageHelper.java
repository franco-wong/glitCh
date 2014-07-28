package com.redrabbit.helpers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.Log;

import com.redrabbit.logging.LoggerConfig;

/**
 * A class to hehlp loading images.
 * 
 * @author rabbitfighter
 *
 */
public class ImageHelper {

    public static final String TAG = "ImageHelper";
    public static final String TILE_PATH = "res/img/tiles/";
    public static final String BG_PATH = "res/img/backgrounds/";
    public static final String CROSSHAIRS_PATH = "res/img/crosshairs/";
    public static final String PARTICLES_PATH = "res/img/particles/";

    /**
     * Sets the image for a tile.
     * 
     * @param imageName
     *            The name of the image, with extension.
     * @return
     */
    @SuppressWarnings("unused")
    public static Image setTileImage(String imageName) {

	// Initialize image to null before try/catch.
	Image image = null;

	try {
	    // Get the image from path.
	    image = new Image(TILE_PATH + imageName);

	    if (LoggerConfig.ON && LoggerConfig.TILE_DEBUG) {
		Log.debug(TAG + "Successfully loaded tile image.");
	    }

	} catch (SlickException e) {

	    // Print the stack trace
	    e.printStackTrace();

	    // If logging is on, log the event.
	    if (LoggerConfig.ON && LoggerConfig.TILE_DEBUG) {
		Log.debug(TAG + "Couldn't load tile image.");
	    }

	    // Return null if no image loaded.
	    return null;
	}

	// Return the image.
	return image;

    }// End

    @SuppressWarnings("unused")
    public static Image setBackgroundImage(String imageName) {

	// Initialize image to null before try/catch.
	Image image = null;

	try {

	    // Get the image from path.
	    image = new Image(BG_PATH + imageName);

	    // If logging on, log the event.
	    if (LoggerConfig.ON && LoggerConfig.BACKGROUND_DEBUG) {
		Log.debug(TAG + "Successfully loaded background image.");
	    }

	} catch (SlickException e) {

	    // Print stack trace.
	    e.printStackTrace();

	    // If logging on, log the event.
	    if (LoggerConfig.ON && LoggerConfig.BACKGROUND_DEBUG) {
		Log.debug(TAG + "Couldn't load background image '" + imageName
			+ "'.");
	    }

	    // Return null if no image loaded.
	    return null;
	}

	// Return the image.
	return image;

    }// END

    @SuppressWarnings("unused")
    public static Image setCrosshairsImage(String imageName) {

	// Initialize image to null before try/catch.
	Image image = null;

	try {
	    // Get the image from path.
	    image = new Image(CROSSHAIRS_PATH + imageName);

	    if (LoggerConfig.ON && LoggerConfig.CROSSHAIR_IMAGE_DEBUG) {
		Log.debug(TAG + "Successfully loaded crosshair image '"
			+ imageName + "'.");
	    }

	} catch (SlickException e) {

	    // Print stack trace.
	    e.printStackTrace();

	    // If logging on, log the event.
	    if (LoggerConfig.CROSSHAIR_IMAGE_DEBUG) {
		Log.debug(TAG + "Couldn't load crosshair image '" + imageName
			+ "'.");
	    }

	    // Return null if no image loaded.
	    return null;

	}

	// Return the image.
	return image;

    }// END

    @SuppressWarnings("unused")
    public static Image setParticleImage(String imageName) {
	// Initialize image to null before try/catch.
	Image image = null;

	try {
	    // Get the image from path.
	    image = new Image(PARTICLES_PATH + imageName);

	    if (LoggerConfig.ON && LoggerConfig.PARTICLE_SYSTEM_DEBUG) {
		Log.debug(TAG + "Successfully loaded particle image '"
			+ imageName + "'.");
	    }

	} catch (SlickException e) {

	    // Print stack trace.
	    e.printStackTrace();

	    // If logging on, log the event.
	    if (LoggerConfig.ON && LoggerConfig.PARTICLE_SYSTEM_DEBUG) {
		Log.debug(TAG + "Couldn't load particle image '" + imageName
			+ "'.");
	    }

	    // Return null if no image loaded.
	    return null;

	}

	// Return the image.
	return image;
    }

    @SuppressWarnings("unused")
    public static Image setCharachterImage(String imageName) {
	// Initialize image to null before try/catch.
	Image image = null;

	try {
	    // Get the image from path.
	    image = new Image(imageName);

	    if (LoggerConfig.ON && LoggerConfig.CHARACHTER_IMAGE_DEBUG) {
		Log.debug(TAG + "Successfully loaded character image '"
			+ imageName + "'.");
	    }

	} catch (SlickException e) {

	    // Print stack trace.
	    e.printStackTrace();

	    // If logging on, log the event.
	    if (LoggerConfig.ON && LoggerConfig.CHARACHTER_IMAGE_DEBUG) {
		Log.debug(TAG + "Couldn't load charachter image '" + imageName
			+ "'.");
	    }

	    // Return null if no image loaded.
	    return null;

	}

	// Return the image.
	return image;
    }

    @SuppressWarnings("unused")
    public static Image setSnakeCellImage(String imagepath) {
	// Initialize image to null before try/catch.
	Image image = null;

	try {
	    // Get the image from path.
	    image = new Image(imagepath);

	    if (LoggerConfig.ON && LoggerConfig.CHARACHTER_IMAGE_DEBUG) {
		Log.debug(TAG + "Successfully loaded snake image '"
			+ imagepath + "'.");
	    }

	} catch (SlickException e) {

	    // Print stack trace.
	    e.printStackTrace();

	    // If logging on, log the event.
	    if (LoggerConfig.ON && LoggerConfig.CHARACHTER_IMAGE_DEBUG) {
		Log.debug(TAG + "Couldn't load snake image '" + imagepath
			+ "'.");
	    }

	    // Return null if no image loaded.
	    return null;

	}

	// Return the image.
	return image;

    }

}// EOF
