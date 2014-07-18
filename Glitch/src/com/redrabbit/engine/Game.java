package com.redrabbit.engine;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.redrabbit.constants.GameStrings;
import com.redrabbit.states.MainMenuState;
import com.redrabbit.states.PauseState;
import com.redrabbit.states.PlayState;

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
	this.addState(new PlayState(play));
	this.addState(new MainMenuState(menu));
	this.addState(new PauseState(pause));
    }

    public void initStatesList(GameContainer gc) throws SlickException {
	this.getState(menu).init(gc, this);
	this.getState(play).init(gc, this);
	this.getState(pause).init(gc, this);
	this.enterState(menu);

    }

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

}
