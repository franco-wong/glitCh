package com.redrabbit.engine.states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

import com.redrabbit.constants.GameColors;
import com.redrabbit.constants.GameNumbers;
import com.redrabbit.helpers.ImageHelper;
import com.redrabbit.helpers.StateTransitions;
import com.redrabbit.logging.LoggerConfig;
import com.redrabbit.objects.Arena;
import com.redrabbit.objects.Crosshairs;
import com.redrabbit.objects.Rect;
import com.redrabbit.objects.AreaMap;
import com.redrabbit.objects.SpaceStationArea;

/**
 * Purely experimental at this point... WIP...
 * 
 * @author rabbitfighter, redragonX
 *
 */
public class PlayState extends BasicGameState {

    protected static final String TAG = "PlayState";

    protected static final int T = 1;

    // Our rectangle to play with
    Rect rect;

    // Our "arena" WIP
    Arena arena;

    // Our map, and a buffer to swap maps if needed
    AreaMap map, bufferMap;

    // For mouse coords.
    protected float mouseX;
    protected float mouseY;

    // Crosshairs
    Crosshairs crosshairs;

    /**
     * Constructor. Not sure what it would do in slick, when you have init(),
     * but... Need to investigate.
     * 
     * @param state
     */
    public PlayState(int state) {
	// TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc) Initializes the game state
     * 
     * @see
     * org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer,
     * org.newdawn.slick.state.StateBasedGame)
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg)
	    throws SlickException {

	// X, Y, width, height, angle, speed
	rect = new Rect(new Vector2f((float) gc.getWidth() / 2 - 25,
		(float) gc.getHeight() / 2 - 25), 50, 50, -90, .1f);

	// New Arena. X, X, with, height.
	arena = new Arena(0, 0, gc.getWidth(), gc.getHeight());

	// Crosshairs
	crosshairs = new Crosshairs(new Vector2f(mouseX, mouseY), 0, 0);

	// New Tiled map. Vector, angle, velocity
	map = new SpaceStationArea(new Vector2f(0, 0));
	map.setTiled(true);

    }

    /*
     * (non-Javadoc) Renders the game statte.
     * 
     * @see
     * org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer,
     * org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
     */
    @SuppressWarnings("unused")
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	    throws SlickException {

	// Draw the tiles.
	for (int i = 0; i < map.getWidth(); i++) {
	    for (int j = 0; j < map.getHeight(); j++) {
		// Get the tile's random color.
		/*
		 * g.setColor(map.getMap()[i][j].getColor()); if (map.isFilled()
		 * && !map.isTiled()) {
		 * g.fillRect(map.getMap()[i][j].getVector().getX(),
		 * map.getMap()[i][j].getVector().getY(),
		 * map.getMap()[i][j].getWidth(),
		 * map.getMap()[i][j].getHeight()); } else if (!map.isFilled()
		 * && !map.isTiled()) {
		 * g.drawRect(map.getMap()[i][j].getVector().getX(),
		 * map.getMap()[i][j].getVector().getY(),
		 * map.getMap()[i][j].getWidth(),
		 * map.getMap()[i][j].getHeight()); } else
		 */
		if (map.isTiled()) {
		    g.drawImage(map.getTiledMap()[i][j].getImage(),
			    map.getTiledMap()[i][j].getVector().getX(),
			    map.getTiledMap()[i][j].getVector().getY());
		}

	    }
	}

	// g.drawRect(x, y, 50, 100);
	g.setColor(Color.red);
	g.fillRect(rect.getVector().getX(), rect.getVector().getY(),
		rect.getWidth(), rect.getHeight());
	g.setColor(Color.yellow);

	// Logging.
	if (LoggerConfig.ON && LoggerConfig.TRACKING_MOUSE) {
	    g.resetFont();
	    g.drawString("X: " + mouseX, 10, 30);
	    g.drawString("Y: " + mouseY, 10, 50);

	}

	// If left mouse button is clicked or pressed.
	if (crosshairs.islClicked() || crosshairs.islPressed()) {
	    // Draw the crosshairs.
	    crosshairs.setCrosshairsImage(ImageHelper
		    .setCrosshairsImage(Crosshairs.c_dot_hit));
	    g.drawImage(crosshairs.getCrosshairsImage(), crosshairs.getVector()
		    .getX(), crosshairs.getVector().getY());
	} else if (!crosshairs.islClicked() && !crosshairs.islPressed()) {
	    // Draw the crosshairs.
	    crosshairs.setCrosshairsImage(ImageHelper
		    .setCrosshairsImage(Crosshairs.c_cross_hit));
	    g.drawImage(crosshairs.getCrosshairsImage(), crosshairs.getVector()
		    .getX(), crosshairs.getVector().getY());
	}// END

    }

    /*
     * (non-Javadoc) Updates the game state.
     * 
     * @see
     * org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer,
     * org.newdawn.slick.state.StateBasedGame, int)
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
	    throws SlickException {

	rect.setVector(new Vector2f(rect.updateVector()));

	/***** Input *****/

	// Get a reference to the game container's input.
	Input input = gc.getInput();

	// Get x,y coordinates from the input stream.
	mouseX = input.getMouseX();
	mouseY = input.getMouseY();

	// up
	if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
	    rect.changeVelocity(1f);
	}

	// down
	if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
	    rect.changeVelocity(-1f);
	}

	// left
	if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
	    rect.turn(-1);
	}

	// right
	if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
	    rect.turn(1);
	}

	// ESC
	if (input.isKeyPressed(Input.KEY_ESCAPE)) {
	    StateTransitions.openPauseMenu(sbg);
	}

	// Mouse Left Clicked
	if (input.isMousePressed(GameNumbers.MOUSE_LEFT)) {
	    crosshairs.setlClicked(true);
	} else {
	    crosshairs.setlClicked(false);
	}

	// Mouse Right Clicked
	if (input.isMousePressed(GameNumbers.MOUSE_RIGHT)) {
	    crosshairs.setrClicked(true);
	} else {
	    crosshairs.setrClicked(false);
	}

	// Mouse Left Pressed
	if (input.isMouseButtonDown(GameNumbers.MOUSE_LEFT)) {
	    crosshairs.setlPressed(true);
	} else {
	    crosshairs.setlPressed(false);
	}

	// Mouse Right Pressed
	if (input.isMouseButtonDown(GameNumbers.MOUSE_RIGHT)) {
	    crosshairs.setrPressed(true);
	} else {
	    crosshairs.setrPressed(false);
	}

	/***** End Input *****/

	// For every sqaure, run collision detection against crosshairs
	for (int i = 0; i < map.getWidth(); i++) {
	    for (int j = 0; j < map.getHeight(); j++) {

		// If the tile iterated intersects the mouse...
		if (map.getTiledMap()[i][j].getBounds().intersects(
			new Circle(input.getMouseX(), input.getMouseY(), 1))) {

		    // Snap to grid.
		    crosshairs.setVector(new Vector2f(map.getTiledMap()[i][j]
			    .getBounds().getCenterX()
			    - crosshairs.getWidth()
			    / 2, map.getTiledMap()[i][j].getBounds()
			    .getCenterY() - crosshairs.getHeight() / 2));

		    // For debugging crosshairs.
		    if (LoggerConfig.CROSSHAIR_DEBUG) {
			Log.debug(TAG + " Crosshair X:"
				+ crosshairs.getBounds().getCenterX()
				+ " Crosshair Y: "
				+ crosshairs.getBounds().getCenterY());
		    }

		}// end if
	    }
	}// END

	/*
	 * F to fill the colored tiles. F will swap between filled and not
	 * filled.
	 */
	if (input.isKeyPressed(Input.KEY_C)) {
	    map.setTiled(false);
	    if (map.isFilled()) {

		map.setFilled(false);
	    } else {
		map.setFilled(true);
	    }

	    bufferMap = map;

	    for (int i = 0; i < map.getWidth(); i++) {
		for (int j = 0; j < map.getHeight(); j++) {
		    map.getMap()[i][j].setColor(GameColors.getRandomColor());
		}
	    }
	}

	/* G for Greyscale tiles. G will swap between filled and not filled. */
	if (input.isKeyPressed(Input.KEY_G)) {
	    map.setTiled(false);
	    if (map.isFilled()) {
		map.setFilled(false);
	    } else {
		map.setFilled(true);
	    }

	    bufferMap = map;

	    // BUG <== TODO

	}

	// I for Tiled Images
	if (input.isKeyPressed(Input.KEY_I)) {

	    if (map.isTiled()) {
		map.setTiled(false);
	    } else {
		map.setTiled(true);
	    }

	    bufferMap = map;

	    for (int i = 0; i < map.getWidth(); i++) {
		for (int j = 0; j < map.getHeight(); j++) {
		    map.getMap()[i][j].setColor(GameColors.getRandomHue());
		}
	    }
	}

	/***** End Input *****/

	if (rect.getVector().getX() <= 0
		|| rect.getVector().getX() + rect.getWidth() >= arena
			.getWidth() - T) {
	    rect.bounceX();
	}

	if (rect.getVector().getY() <= 0 + T
		|| rect.getVector().getY() + rect.getHeight() >= arena
			.getHeight() - T) {
	    rect.bounceY();
	}
    }

    /*
     * (non-Javadoc) Returns tthe ID os the current state for state based games
     * 
     * @see org.newdawn.slick.state.BasicGameState#getID()
     */
    @Override
    public int getID() {
	// TODO Auto-generated method stub
	return 1;
    }

}
