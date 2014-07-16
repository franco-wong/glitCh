package com.redrabbit.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

import com.redrabbit.helpers.FontHelper;
import com.redrabbit.helpers.StateTransitions;
import com.redrabbit.logging.LoggerConfig;

/**
 * The pause menu for our game.
 * 
 * @author rabbitfighter, redragonX
 *
 */
public class PauseState extends BasicGameState {

    private static final String TAG = "PauseState";
    private TrueTypeFont cosmicfade;
    Input input;

    public PauseState(int pause) {

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg)
	    throws SlickException {

	// Get the input stream
	input = gc.getInput();

	// Font
	cosmicfade = FontHelper.setTTF("cosmicfade.ttf", 100);

    }

    /* (non-Javadoc) Renders the game state.
     * @see org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	    throws SlickException {

	g.setFont(cosmicfade);
	g.drawString("Press ESC to return to game", gc.getWidth() / 2 - 390,
		gc.getHeight() / 2);

    }

    /* (non-Javadoc) Updates the game state.
     * @see org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
	    throws SlickException {

	if (input.isKeyPressed(Input.KEY_ESCAPE)) {
	    
	    // go back to play 
	    StateTransitions.openPlayOption(sbg);
	    
	    // Logging
	    if (LoggerConfig.ON) {
		Log.debug(TAG + " Returned to game.");
	    }

	}

    }

    /* (non-Javadoc) Returns the ID of the current state.
     * @see org.newdawn.slick.state.BasicGameState#getID()
     */
    @Override
    public int getID() {

	return 2;
    }

}//EOF
