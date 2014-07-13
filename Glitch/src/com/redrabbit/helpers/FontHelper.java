package com.redrabbit.helpers;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

import com.redrabbit.logging.LoggerConfig;

/**
 * This is a helper class for loading Truee Type Fonts safely and soundly using
 * an iput stream that grabs the font and first creates a plain AWT font, which
 * then gets passed into a TTF for return and use in our game. This class also
 * has logging capabilities built in for debugging purposes.
 * 
 * @author rabbitfighter & redragonX
 *
 */
public class FontHelper
{

	// TTF
	private static TrueTypeFont ttf;
	// Path to the fonts.
	private final static String path = "res/fonts/";
	// For logging.
	private static final String TAG = "FontHelper";

	/**
	 * Returns a True Type Font (the recommmended font standard for use in
	 * Slick2D), based on the name and the size given.
	 * 
	 * @param font
	 *            - A string of the desired font name
	 * @param size
	 *            - the size in pixels of the desired font
	 * @return ttf - the True Type font that was created for use in our game.
	 */
	public static TrueTypeFont setTTF(String font, float size)
	{

		try
		{
			// Open an input stream to get resources
			InputStream inputStream = ResourceLoader.getResourceAsStream(path
					+ font);

			// Create an awt Font object from the input stream as a TrueTypeFont
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);

			// Set font size
			awtFont = awtFont.deriveFont(size);

			// Create a new TrueTypeFont
			ttf = new TrueTypeFont(awtFont, false);

		}
		catch (Exception e)
		{
			e.printStackTrace();

			// If there was a problem, log it.
			if (LoggerConfig.ON)
			{
				Log.info(TAG + ": Could not load font");
			}

		}

		// Return the TTF
		return ttf;
	}

}// EOF
