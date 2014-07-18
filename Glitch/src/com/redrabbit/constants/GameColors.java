package com.redrabbit.constants;

import org.newdawn.slick.Color;

/**
 * A helper class to hold color constants.
 * 
 * @author rabbitfighter, redragonX
 *
 */
public class GameColors {

    public static final Color darkGrey = new Color(.05f, .05f, .05f);
    public static final Color red = new Color(.95f, .13f, .13f);
    public static final Color yellow = new Color(.95f, .95f, .05f);
    public static final Color purple = new Color(.9f, .1f, .9f);

    /**
     * Gets a random color for a tile.
     * 
     * @return
     */
    public static Color getRandomColor() {
	// Return a new random color
	return new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random());
    }

    public static Color getRandomHue() {
	float gradientLevel = (float) Math.random();
	return new Color(gradientLevel, gradientLevel, gradientLevel);
    }

}
