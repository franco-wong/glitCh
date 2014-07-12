package com.redrabbit.helpers;

import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

/**
 * @author rabbitfighter & redragonX
 *
 */
public class FontHelper
{

	// Instance variablees
	private static TrueTypeFont ttf;
	private final static String path = "res/fonts/";
	private static final String TAG = "FontHelper";

	/**
	 * Returns a TTF based on the name and the size given.
	 * 
	 * @param font
	 * @param size
	 * @return
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
			Log.error(TAG + " - Could not load font");
		}

		// Return the TTF
		return ttf;
	}

}// EOF
