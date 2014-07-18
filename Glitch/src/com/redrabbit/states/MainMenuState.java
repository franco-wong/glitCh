package com.redrabbit.states;

import javax.swing.text.StyleConstants.ColorConstants;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.redrabbit.constants.GameColors;
import com.redrabbit.constants.GameStrings;
import com.redrabbit.helpers.FontHelper;
import com.redrabbit.helpers.StateTransitions;
import com.redrabbit.logging.LoggerConfig;
import com.redrabbit.objects.Menu;
import com.redrabbit.objects.MenuItem;

/**
 * @author rabbitfighter & redragonX
 *
 */
public class MainMenuState extends BasicGameState {

    // For logging.
    @SuppressWarnings("unused")
    private final String TAG = "BasicGameState";

       // ==> WIP ... Path to image. Need to clean this up <==
    private final String imagePath = "res/img/layer.png";

    // x, y coordinates
    protected float mouseX, mouseY;

    // Menu Items array.
    MenuItem[] menuItems;

    // Menu variabel
    private Menu mainMenu;

    // Fonts int use.
    TrueTypeFont checkbook, cosmicfade, plasmati, twobit;

    public MainMenuState(int state) {
	// WIP -- Investigate...
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg)
	    throws SlickException {

	// Initialize array.
	menuItems = new MenuItem[5];

	// Add menu items: (title, x, y, width, height, angle, speed, selected)
	menuItems[0] = new MenuItem(GameStrings.PLAY, 472f, 160f, 110f, 100f, 0f, 0f, false);
	menuItems[1] = new MenuItem(GameStrings.DIRECTIONS, 392f, 270f, 290f, 100f, 0f, 0f,
		false);
	menuItems[2] = new MenuItem(GameStrings.SCORES, 437, 380, 210, 100, 0f, 0f, false);
	menuItems[3] = new MenuItem(GameStrings.CREDITS, 428, 490, 220, 100, 0f, 0f, false);
	menuItems[4] = new MenuItem(GameStrings.QUIT, 472, 600, 110, 100, 0f, 0f, false);

	// Create the menu object with (title, the menu items array, and the
	// image).
	mainMenu = new Menu(GameStrings.TITLE, menuItems, new Image(imagePath));

	// Initialize fonts.
	checkbook = FontHelper.setTTF("checkbook.ttf", 18);
	plasmati = FontHelper.setTTF("plasmati.ttf", 48);
	cosmicfade = FontHelper.setTTF("cosmicfade.ttf", 100);

    }

    /*
     * (non-Javadoc) Renders the game state
     * 
     * @see
     * org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer,
     * org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	    throws SlickException {

	// g.setBackground(Colors.darkGrey);
	g.drawImage(mainMenu.getBgImage(), 0, 0);
	// gc.setDefaultFont(checkbook);

	// Title
	g.setFont(cosmicfade);
	g.setColor(GameColors.yellow);
	g.drawString(GameStrings.TITLE, 442, 30);

	// Menu Items
	g.setColor(Color.white);
	g.setFont(cosmicfade);

	// Find if mouse is hovering.
	for (int i = 0; i < menuItems.length; i++) {
	    if (menuItems[i].isSelected()) {
		g.drawString(MenuItem.reverseString(menuItems[i].getName()),
			menuItems[i].getVector().getX(), menuItems[i]
				.getVector().getY());
	    } else {
		g.drawString(menuItems[i].getName(), menuItems[i].getVector()
			.getX(), menuItems[i].getVector().getY());
	    }
	}

	g.setColor(GameColors.yellow);
	// Logging.
	if (LoggerConfig.ON) {
	    g.resetFont();
	    g.drawString("X: " + mouseX, 10, 30);
	    g.drawString("Y: " + mouseY, 10, 50);
	}

    }

    /*
     * (non-Javadoc) Updates the game.
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
	if (input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP)) {

	}

	// down
	if (input.isKeyPressed(Input.KEY_S)
		|| input.isKeyPressed(Input.KEY_DOWN)) {

	}

	// left
	if (input.isKeyPressed(Input.KEY_LEFT)
		|| input.isKeyPressed(Input.KEY_A)) {
	    // Key Left
	}

	// right
	if (input.isKeyPressed(Input.KEY_RIGHT)
		|| input.isKeyPressed(Input.KEY_D)) {
	    // Key Right
	}

	/***** End Input *****/

	/*
	 * If the mouse is hovering the bounds of the menu item, the items
	 * selected variable is set to true, otherwise, it is set to false
	 */
	for (int i = 0; i < menuItems.length; i++) {
	    if (menuItems[i].isHovering(mouseX, mouseY)) {
		
		// Set the menu's selected proerty to tru.
		menuItems[i].setSelected(true);
		
		// If mouse clicks on an item, handle it.
		if (input.isMousePressed(0)) {

		    switch (i) {

		    case 0:
			StateTransitions.openPlayOption(sbg);
			break;
			
		    case 1: 
			StateTransitions.openDirections(sbg);
			break;
			
		    case 2:
			StateTransitions.openScores(sbg);
			break;
			
		    case 3: 
			StateTransitions.openCredits(sbg);
			break;
			
		    case 4:
			StateTransitions.quitOption(gc, sbg);
			break;
		    }

		}
	    } else {
		menuItems[i].setSelected(false);
	    }
	}

    }

    /*
     * (non-Javadoc) Returns the ID of the state.
     * 
     * @see org.newdawn.slick.state.BasicGameState#getID()
     */
    @Override
    public int getID() {
	return 0;
    }

}
