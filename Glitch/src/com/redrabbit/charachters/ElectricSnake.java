package com.redrabbit.charachters;

//Slick imports
import java.util.LinkedList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

import com.redrabbit.animations.SnakeAnimation;
import com.redrabbit.constants.GameNumbers;
import com.redrabbit.extendables.Living;
import com.redrabbit.logging.LoggerConfig;

/**
 * An electrical snake list.
 * 
 * @author rabbitfighter
 *
 */
public class ElectricSnake extends Living {

    public final static String TAG = " Electric Snake";

    private LinkedList<ElectricSnakeCell> snakeCellsList;

    @SuppressWarnings("unused")
    public ElectricSnake(Vector2f vector, float angle, float velocity, int size) {

	// Set the vector, angle, and velocity.
	super(vector, angle, velocity);

	// Create a new list that will represent the cells of our snake.
	this.setSnakeCellsList(new LinkedList<ElectricSnakeCell>());

	// For the size passed in, create a snake with N (size) cells.
	for (int i = 0; i < size; i++) {

	    try {

		// For each cell, set it's x coor for now to (current x + i *
		// width)
		this.getSnakeCellsList().add(
			new ElectricSnakeCell(new Vector2f(vector.getX() + i
				* GameNumbers.SMART_TILE_WIDTH, 0), 0, 0));

		// Logging.
		if (LoggerConfig.ON && LoggerConfig.SNAKE_CELLS_DEBUG) {
		    Log.debug(TAG + "Snake cell index " + i
			    + " has sucessfully been created.");
		}

	    } catch (SlickException e) {

		// TODO::WIP::Logging.
		if (LoggerConfig.ON && LoggerConfig.SNAKE_CELLS_DEBUG) {
		    Log.debug(TAG + "Snake cell index " + i
			    + " has not been created.");
		}

		e.printStackTrace();

	    }// End try/catch.

	}// End for

    }// End constructor.

    /**
     * Updates the snake according to size
     */
    @SuppressWarnings("unused")
    public void update() {

	if (this.getSnakeCellsList().size() == 1) {
	    this.getSnakeCellsList().get(0)
		    .setAnimation(SnakeAnimation.SNAKE_HEAD_BLINKING);
	}

	if (this.getSnakeCellsList().size() == 2) {
	    this.getSnakeCellsList().get(0)
		    .setAnimation(SnakeAnimation.SNAKE_HEAD_BLINKING);
	    this.getSnakeCellsList().get(1)
		    .setAnimation(SnakeAnimation.SNAKE_TAIL3);
	}

	if (this.getSnakeCellsList().size() == 3) {
	    this.getSnakeCellsList().get(0)
		    .setAnimation(SnakeAnimation.SNAKE_HEAD_BLINKING);
	    this.getSnakeCellsList().get(1)
		    .setAnimation(SnakeAnimation.SNAKE_TAIL3);
	    this.getSnakeCellsList().get(2)
		    .setAnimation(SnakeAnimation.SNAKE_TAIL2);

	}

	if (this.getSnakeCellsList().size() == 4) {
	    this.getSnakeCellsList().get(0)
		    .setAnimation(SnakeAnimation.SNAKE_HEAD_BLINKING);
	    this.getSnakeCellsList().get(1)
		    .setAnimation(SnakeAnimation.SNAKE_TAIL3);
	    this.getSnakeCellsList().get(2)
		    .setAnimation(SnakeAnimation.SNAKE_TAIL2);
	    this.getSnakeCellsList().get(3)
		    .setAnimation(SnakeAnimation.SNAKE_TAIL1);
	}

	if (this.getSnakeCellsList().size() > 4) {
	    this.getSnakeCellsList().get(0)
		    .setAnimation(SnakeAnimation.SNAKE_HEAD_BLINKING);

	    this.getSnakeCellsList().get(this.getSnakeCellsList().size())
		    .setAnimation(SnakeAnimation.SNAKE_TAIL3);
	    this.getSnakeCellsList().get(this.getSnakeCellsList().size() - 1)
		    .setAnimation(SnakeAnimation.SNAKE_TAIL2);
	    this.getSnakeCellsList().get(this.getSnakeCellsList().size() - 2)
		    .setAnimation(SnakeAnimation.SNAKE_TAIL3);

	    for (int i = 0; i < this.getSnakeCellsList().size(); i++) {
		if (i > 0 && i < this.getSnakeCellsList().size() - 2) {
		    this.getSnakeCellsList().get(i)
			    .setAnimation(SnakeAnimation.SNAKE_TAIL0);

		}
	    }

	}// End setting snakes.

	
    }

    public LinkedList<ElectricSnakeCell> getSnakeCellsList() {
	return snakeCellsList;
    }

    public void setSnakeCellsList(LinkedList<ElectricSnakeCell> snakeCellsList) {
	this.snakeCellsList = snakeCellsList;
    }

}// EOF