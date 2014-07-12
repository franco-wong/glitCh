package com.redrabbit.states;
import java.awt.Color;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import com.redrabbit.objects.Rect;

public class Play extends BasicGameState {


	private String dumbString = "Stephen... Are you ready to make a game?";
	Rect rect;

	float velocityX, velocityY;

	public Play(int state) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {

		rect = new Rect();

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		// g.drawRect(x, y, 50, 100);
		g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
		
		

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {

		rect.rectGo(delta);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

	

}
