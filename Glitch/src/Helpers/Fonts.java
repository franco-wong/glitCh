package Helpers;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class Fonts {


	TrueTypeFont font;
	

	public static TrueTypeFont getTTF(TrueTypeFont font, int size) {
		
		String path = "res/fonts/";

		try {
			InputStream inputStream = ResourceLoader
					.getResourceAsStream(path + font);

			Font ttf = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			
			ttf = ttf.deriveFont(size); // set font size
			font = new TrueTypeFont(ttf, false);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return font;

	}
	
	
}
