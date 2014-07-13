package com.redrabbit.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

import Constants.Colors;

import com.redrabbit.helpers.FontHelper;
import com.redrabbit.logging.LoggerConfig;

/**
 * @author rabbitfighter & redragonX
 *
 */
public class Menu extends BasicGameState
{
	// For logging.
	@SuppressWarnings("unused")
	private final String TAG = "BasicGameState";
	private final String DIRECTIONS = "direcions";
	private final String PLAY = "play";
	private final String SCORES = "scores";
	private final String CREDITS = "credits";
	private final String QUIT = "	quit";
	private Image menulayer;
	private final String imagePath = "res/img/layer.png";
	protected float mouseX, mouseY;

	// Fonts int use.
	TrueTypeFont checkbook, cosmicfade, plasmati, twobit;

	public Menu(int state)
	{

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException
	{

		menulayer = new Image(imagePath);
		checkbook = FontHelper.setTTF("checkbook.ttf", 18);
		plasmati = FontHelper.setTTF("plasmati.ttf", 48);
		cosmicfade = FontHelper.setTTF("cosmicfade.ttf", 100);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException
	{

		g.setBackground(Colors.darkGrey);
		g.drawImage(menulayer, 0, 0);
		// gc.setDefaultFont(checkbook);
		g.setFont(cosmicfade);
		g.setColor(Colors.yellow);
		g.drawString("glitCh", 380, 30);
		g.setColor(Color.white);
		g.setFont(cosmicfade);
		g.drawString(PLAY, 410, 160);
		g.drawString(DIRECTIONS, 320, 270);
		g.drawString(SCORES, 375, 370);
		g.drawString(CREDITS, 362, 480);
		g.drawString(QUIT, 410, 590);

		if (LoggerConfig.ON)
		{
			g.resetFont();
			g.drawString("X: " + mouseX, 10, 30);
			g.drawString("Y: " + mouseY, 10, 50);
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException
	{

		/***** Input *****/

		Input input = gc.getInput();

		mouseX = input.getMouseX();
		mouseY = input.getMouseY();

		// up
		if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
		{
			// Key Up
		}

		// down
		if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))
		{
			// Key Down
		}

		// left
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A))
		{
			// Key Left
		}

		// right
		if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D))
		{
			// Key Right
		}

	}

	public Image getMenulayer()
	{
		return menulayer;
	}

	public void setMenuLayer(Image image)
	{
		this.menulayer = image;
	}

	@Override
	public int getID()
	{
		return 0;
	}

}
