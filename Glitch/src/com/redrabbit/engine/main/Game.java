package com.redrabbit.engine.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.redrabbit.constants.GameNumbers;
import com.redrabbit.constants.GameStrings;
import com.redrabbit.engine.states.MainMenuState;
import com.redrabbit.engine.states.PauseState;
import com.redrabbit.engine.states.PlayState;
import com.redrabbit.logging.LoggerConfig;

/**
 * The class that creates the screen, establishes the states, and initializes
 * them. Contains main().
 * 
 * @authors rabbitfighter, redragonX
 * 
 */
public class Game extends StateBasedGame {

    // States
    public static final int menu = 0;
    public static final int play = 1;
    public static final int pause = 2;

    /**
     * @param gamename
     *            The name of the game
     */
    public Game(String gamename) {
	super(gamename);
	// Bufg fix. If menu is not first, other screens will breifly flash.
	this.addState(new MainMenuState(menu));
	this.addState(new PlayState(play));
	this.addState(new PauseState(pause));
    }

    /*
     * (non-Javadoc) Initializes the states.
     * 
     * @see
     * org.newdawn.slick.state.StateBasedGame#initStatesList(org.newdawn.slick
     * .GameContainer)
     */
    public void initStatesList(GameContainer gc) throws SlickException {
	this.getState(menu).init(gc, this);
	this.getState(play).init(gc, this);
	this.getState(pause).init(gc, this);
	this.enterState(menu);

    }

    /**
     * Main class runs the application and calls a new AppGameContainer for our
     * game.
     * 
     * @param args
     */
    public static void main(String[] args) {

	AppGameContainer appgc = null;

	try {
	    appgc = new AppGameContainer(new Game(GameStrings.GAME_NAME));
	    appgc.setDisplayMode(GameNumbers.DISPLAY_WIDTH,
		    GameNumbers.DISPLAY_HEIGHT, false);
	    appgc.setTargetFrameRate(60);
	    appgc.setSoundOn(LoggerConfig.SOUND_ON);
	    appgc.start();
	} catch (SlickException e) {
	    appgc.destroy();
	    e.printStackTrace();
	}

    }

}// EOF
