package com.redrabbit.engine;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.redrabbit.states.Menu;
import com.redrabbit.states.Pause;
import com.redrabbit.states.Play;

/**
 * @authors rabbitfighter, redragonx
 * 
 */
public class Game extends StateBasedGame
{

	public static final String gamename = "glitCh";

	// States
	public static final int menu = 0;
	public static final int play = 1;
	public static final int pause = 2;

	/**
	 * @param gamename
	 *            The name of the game
	 */
	public Game(String gamename)
	{
		super(gamename);
		this.addState(new Play(menu));
		this.addState(new Menu(play));
		this.addState(new Pause(pause));
	}

	public void initStatesList(GameContainer gc) throws SlickException
	{
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(pause).init(gc, this);
		this.enterState(menu);

	}

	public static void main(String[] args)
	{

		AppGameContainer appgc;

		try
		{
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(900, 700, false);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}
		catch (SlickException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
