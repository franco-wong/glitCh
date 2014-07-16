package com.redrabbit.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.redrabbit.objects.Rect;

/**
 * Purely experimental at this point... WIP...
 * 
 * @author rabbitfighter, redragonX
 *
 */
public class PlayState extends BasicGameState {

    // Our rectangle to play with
    Rect rect;
    
    // For mouse coords.
    private float mouseX;
    private float mouseY;

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
		(float) gc.getHeight() / 2 - 25), 50, 50, 0, 0);

    }

    /*
     * (non-Javadoc) Renders the game statte.
     * 
     * @see
     * org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer,
     * org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	    throws SlickException {

	// g.drawRect(x, y, 50, 100);
	g.drawRect(rect.getVector().getX(), rect.getVector().getX(),
		rect.getWidth(), rect.getHeight());

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
	    rect.turn(1);
	}

	// right
	if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
	    rect.turn(-1);
	}

	/***** End Input *****/

	rect.updateVector();

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
