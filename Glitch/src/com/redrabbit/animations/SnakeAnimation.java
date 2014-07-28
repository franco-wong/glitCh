package com.redrabbit.animations;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

import com.redrabbit.constants.GameStrings;
import com.redrabbit.helpers.ImageHelper;

/**
 * A class to hold snake animation constants
 * 
 * @author rabbitfighter
 *
 */
public class SnakeAnimation {

    protected final static String imagePath = "res/img/charachters/snake/";

    protected final static String snake_head_normal = "worm_blinking0.png";

    protected final static String snake_head_blinking0 = "worm_blinking0.png";
    protected final static String snake_head_blinking1 = "worm_blinking1.png";
    protected final static String snake_head_blinking2 = "worm_blinking2.png";
    protected final static String snake_head_blinking3 = "worm_blinking3.png";

    protected final static String snake_body_normal = "worm_morphing0.png";

    protected final static String snake_head_morphing0 = "worm_morphing0.png";
    protected final static String snake_head_morphing1 = "worm_morphing1.png";
    protected final static String snake_head_morphing2 = "worm_morphing2.png";
    protected final static String snake_head_morphing3 = "worm_morphing3.png";

    protected final static String snake_tail0 = "worm_tail0.png";
    protected final static String snake_tail1 = "worm_tail1.png";
    protected final static String snake_tail2 = "worm_tail2.png";
    protected final static String snake_tail3 = "worm_tail3.png";

    /***** Snake head blinking *****/

    // Snake head blinking image array.
    public static final Image[] SNAKE_HEAD_BLINKING_INAGE_ARRAY = new Image[] {
	    ImageHelper.setSnakeCellImage(imagePath + snake_head_blinking0),
	    ImageHelper.setSnakeCellImage(imagePath + snake_head_blinking1),
	    ImageHelper.setSnakeCellImage(imagePath + snake_head_blinking2),
	    ImageHelper.setSnakeCellImage(imagePath + snake_head_blinking3) };

    // Snake head image duration array.
    public static final int[] SNAKE_HEAD_IMAGE_DURATION_ARRAY = new int[] {
	    1000, 1000, 1000, 1000 };

    // Set the animation
    public static final Animation SNAKE_HEAD_BLINKING = new Animation(
	    SNAKE_HEAD_BLINKING_INAGE_ARRAY, SNAKE_HEAD_IMAGE_DURATION_ARRAY);

    /***** Snake body *****/

    // Snake body Morphing array. WIP.
    public static final Image[] SNAKE_BODY_INAGE_ARRAY = new Image[] {
	    ImageHelper.setSnakeCellImage(imagePath + snake_head_blinking0),
	    ImageHelper.setSnakeCellImage(imagePath + snake_head_morphing1),
	    ImageHelper.setSnakeCellImage(imagePath + snake_head_morphing2),
	    ImageHelper.setSnakeCellImage(imagePath + snake_head_morphing3) };

    // Snake head image duration array.
    public static final int[] SNAKE_BODY_IMAGE_DURATION_ARRAY = new int[] {
	    1000, 1000, 1000, 1000 };

    // Set snake body animation
    public static final Animation SNAKE_BODY = new Animation(
	    SNAKE_BODY_INAGE_ARRAY, SNAKE_BODY_IMAGE_DURATION_ARRAY);

    public static final Animation SNAKE_TAIL0 = new Animation(
	    new Image[] { ImageHelper
		    .setSnakeCellImage(imagePath + snake_tail0) },
	    new int[] { 1000 });

    public static final Animation SNAKE_TAIL1 = new Animation(
	    new Image[] { ImageHelper
		    .setSnakeCellImage(imagePath + snake_tail1) },
	    new int[] { 1000 });

    public static final Animation SNAKE_TAIL2 = new Animation(
	    new Image[] { ImageHelper
		    .setSnakeCellImage(imagePath + snake_tail2) },
	    new int[] { 1000 });

    public static final Animation SNAKE_TAIL3 = new Animation(
	    new Image[] { ImageHelper
		    .setSnakeCellImage(imagePath + snake_tail3) },
	    new int[] { 1000 });

}// EOF
