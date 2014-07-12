package com.redrabbit.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.redrabbit.helpers.FontHelper;

import Helpers.Fonts;


public class Menu extends BasicGameState
{
	
	TrueTypeFont checkbook, cosmicfade, plasmati, twobit;
	

	public Menu(int state)
	{
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException
	{
		
		checkbook = FontHelper.setTTF("checkbook.ttf", 18);
		plasmati = FontHelper.setTTF("plasmati.ttf", 48);
		cosmicfade = FontHelper.setTTF("cosmicfade.ttf",  100);
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException
	{
		
		gc.setDefaultFont(checkbook);
		g.setFont(cosmicfade);
		g.setColor(Color.yellow);
		g.drawString("glitCh", 380, 50);
		g.setColor(Color.white);
		g.drawString("Play", 410, 170);
		g.drawString("Directions", 320, 280);
		g.drawString("Scores", 375, 380);
		g.drawString("Credits",362, 490);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException
	{
		
		
	}

	@Override
	public int getID()
	{
		
		return 0;
	}

	
}
