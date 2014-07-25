package com.redrabbit.engine.states;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

import com.redrabbit.charachters.ElectricSnakeList;
import com.redrabbit.charachters.EvilMouse;
import com.redrabbit.constants.GameNumbers;
import com.redrabbit.engine.hud.Crosshairs;
import com.redrabbit.helpers.ImageHelper;
import com.redrabbit.helpers.ParticleHelper;
import com.redrabbit.helpers.TransitionHelper;
import com.redrabbit.levels.SpaceStationArea;
import com.redrabbit.logging.LoggerConfig;
import com.redrabbit.maps.AreaMap;
import com.redrabbit.objects.Arena;
import com.redrabbit.objects.Rect;
import com.redrabbit.objects.LameShape;
import com.redrabbit.particles.ParticleEmitterSystem;

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

    // Particle Emitter System.
    ParticleEmitterSystem pes;

    // Animation
    LameShape shape;

    // New array list for evil mice.
    ArrayList<EvilMouse> evilMice;

    /***** TODO Snake *****/
    ElectricSnakeList snakeList;

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

	shape = new LameShape(new Vector2f(mouseX, mouseY), 0, 0);

	// X, Y, width, height, angle, speed
	rect = new Rect(new Vector2f((float) gc.getWidth() / 2 - 25,
		(float) gc.getHeight() / 2 - 25), 50, 50, -90, .1f);

	// New Arena. X, X, with, height.
	arena = new Arena(0, 0, gc.getWidth(), gc.getHeight());

	// New Tiled map. Vector, angle, velocity
	map = new SpaceStationArea(new Vector2f(0, 0));
	map.setTiled(true);

	// Create new particle system.
	pes = new ParticleEmitterSystem(new Vector2f(300, 300),
		ParticleHelper.PARTICLE_FIRE, ParticleHelper.TEST_XML, 210000);

	evilMice = new ArrayList<EvilMouse>();
	// Make thee evil mice.
	for (int i = 0; i <= 3; i++) {
	    // get a random x and y for the evil mouse
	    evilMice.add(new EvilMouse(new Vector2f(((int) Math.ceil(Math
		    .random() * GameNumbers.SMART_MAP_WIDTH - 1))
		    * GameNumbers.SMART_TILE_WIDTH, ((int) Math.ceil(Math
		    .random() * GameNumbers.SMART_MAP_HEIGHT - 1))
		    * GameNumbers.SMART_TILE_HEIGHT), 0, 0));
	}

	// Crosshairs
	crosshairs = new Crosshairs(new Vector2f(mouseX, mouseY), 0, 0);

	/***** TODO Snake *****/
	// Vector, angle, velocity, size
	snakeList = new ElectricSnakeList(new Vector2f(0, 600), 90,
		GameNumbers.INITIAL_SNAKE_VELOCITY,
		GameNumbers.INITIAL_SNAKE_SIZE);

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

		if (map.isTiled()) {
		    g.drawImage(map.getTiledMap()[i][j].getImage(),
			    map.getTiledMap()[i][j].getVector().getX(),
			    map.getTiledMap()[i][j].getVector().getY());
		}// End if
	    }// End for
	}// End for

	/*
	 * TODO -Experimental. If the R Mouse button is clicked, render endless
	 * particles.
	 */
	if (crosshairs.isrPressed()) {
	    // Render particle system.
	    pes.getParticleSystem().render();
	}

	// Set color and draw out "guy". <-- TODO: WIP
	g.setColor(Color.magenta);
	g.fillRect(rect.getVector().getX(), rect.getVector().getY(),
		rect.getWidth(), rect.getHeight());
	g.setColor(Color.yellow);

	// Logging.
	if (LoggerConfig.ON && LoggerConfig.TRACKING_MOUSE) {
	    // g.resetFont();
	    g.drawString("Mouse X: " + mouseX, 10, 30);
	    g.drawString("Mouse Y: " + mouseY, 10, 50);

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

	// pes.getParticleSystem

	// Draw the particle system.
	g.drawAnimation(shape.getAnimation(), 500, 400);

	// Draw the evil mice
	for (int i = 0; i < evilMice.size(); i++) {
	    g.drawAnimation(evilMice.get(i).getAnimation(), evilMice.get(i)
		    .getVector().getX(), evilMice.get(i).getVector().getY());
	}

	g.drawImage(crosshairs.getCrosshairsImage(), crosshairs.getVector()
		.getX(), crosshairs.getVector().getY());

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

	shape.getAnimation().start();

	// Update particle system.
	pes.getParticleSystem().update(delta);

	pes.getParticleSystem().setPosition(crosshairs.getVector().getX(),
		crosshairs.getVector().getY());

	if (crosshairs.isrPressed()) {
	    // pes.getParticleSystem().addEmitter(emitter);
	    // pes.getParticleSystem().getEmitter(1).

	}

	// Update the rec vector.
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
	    TransitionHelper.openPauseMenu(sbg);
	}

	// 0 T turn emitters off.
	if (input.isKeyPressed(Input.KEY_E)) {

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
	    // Add the particle to the emitter.

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
