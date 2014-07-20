package com.redrabbit.engine.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.redrabbit.constants.GameStrings;
import com.redrabbit.engine.states.MainMenuState;
import com.redrabbit.engine.states.PauseState;
import com.redrabbit.engine.states.PlayState;

/**
 * @authors rabbitfighter, redragonx
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
	    appgc.setDisplayMode(1024, 832, false);
	    appgc.setTargetFrameRate(60);
	    appgc.start();
	} catch (SlickException e) {
	    appgc.destroy();
	    e.printStackTrace();
	}

    }

}// EOF
