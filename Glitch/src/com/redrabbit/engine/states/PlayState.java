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

import com.redrabbit.charachters.EvilMouse;
import com.redrabbit.charachters.Player;
import com.redrabbit.constants.GameNumbers;
import com.redrabbit.helpers.ImageHelper;
import com.redrabbit.helpers.ParticleHelper;
import com.redrabbit.helpers.StateTransitions;
import com.redrabbit.logging.LoggerConfig;
import com.redrabbit.objects.Arena;
import com.redrabbit.objects.Crosshairs;
import com.redrabbit.objects.Rect;
import com.redrabbit.objects.AreaMap;
import com.redrabbit.objects.LameShape;
import com.redrabbit.objects.SpaceStationArea;
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


    // Our "arena" WIP
    Arena arena;

    // Our map, and a buffer to swap maps if needed
    AreaMap map, bufferMap;

    // For mouse coords.
    protected float mouseX;
    protected float mouseY;

    // Crosshairs
    Crosshairs crosshairs;

    int timer = 60;

    // Particle Emitter System.
    ParticleEmitterSystem pes;

    // Animation
    LameShape shape;

    // New array list for evil mice.
    ArrayList<EvilMouse> evilMice;
    
    //Player
    Player player;

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
	player = new Player(new Vector2f((float) gc.getWidth() / 2 - 25,
		(float) gc.getHeight() / 2 - 25), 0, 0);

	// New Arena. X, X, with, height.
	arena = new Arena(0, 0, gc.getWidth(), gc.getHeight());

	// New Tiled map. Vector, angle, velocity
	map = new SpaceStationArea(new Vector2f(0, 0));
	map.setTiled(true);

	// Create new particle system.
	pes = new ParticleEmitterSystem(new Vector2f(300, 300),
		ParticleHelper.PARTICLE_FIRE, ParticleHelper.TEST_XML, 210000);
	// Set the blending mode.
	pes.getParticleSystem().setBlendingMode(ParticleSystem.BLEND_COMBINE);

	// Add emitter. TODO - figure this out?!?

	pes.getParticleSystem().setPosition(Display.getHeight() / 2,
		Display.getWidth() / 2);

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
		}

	    }
	}

	if (crosshairs.isrPressed()) {
	    // Render particle system.
	    pes.getParticleSystem().render();
	}

	// Set color and draw out "guy". <-- TODO: WIP
	g.setColor(Color.magenta);

	
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
	
	g.drawImage(crosshairs.getCrosshairsImage(), crosshairs.getVector().getX(), crosshairs.getVector().getY());

	g.drawAnimation(player.getAnimation(), player.getVector().getX(), player.getVector().getY());
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
	player.setVector(new Vector2f(player.updateVector()));

	/***** Input *****/

	// Get a reference to the game container's input.
	Input input = gc.getInput();

	// Get x,y coordinates from the input stream.
	mouseX = input.getMouseX();
	mouseY = input.getMouseY();

	// up
	if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
	    player.changeVelocity(1f);
	}

	// down
	if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
	    player.changeVelocity(-1f);
	}

	// left
	if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
	    player.turn(-1);
	}

	// right
	if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
	    player.turn(1);
	}

	// ESC
	if (input.isKeyPressed(Input.KEY_ESCAPE)) {
	    StateTransitions.openPauseMenu(sbg);
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

	if (player.getVector().getX() <= 0
		|| player.getVector().getX() + player.getWidth() >= arena
			.getWidth() - T) {
	    player.bounceX();
	}

	if (player.getVector().getY() <= 0 + T
		|| player.getVector().getY() + player.getHeight() >= arena
			.getHeight() - T) {
	    player.bounceY();
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
