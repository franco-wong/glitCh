package com.redrabbit.engine.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.redrabbit.constants.GameColors;
import com.redrabbit.constants.GameNumbers;
import com.redrabbit.constants.GameStrings;
import com.redrabbit.engine.audio.EAudio;
import com.redrabbit.helpers.FontHelper;
import com.redrabbit.helpers.ImageHelper;
import com.redrabbit.helpers.TransitionHelper;
import com.redrabbit.logging.LoggerConfig;
import com.redrabbit.menus.Menu;
import com.redrabbit.menus.MenuItem;

/**
 * @author rabbitfighter & redragonX
 *
 */
public class MainMenuState extends BasicGameState {

    // For logging.
    @SuppressWarnings("unused")
    private final String TAG = "BasicGameState";

    // ==> WIP ... Path to image. Need to clean this up <==
    // private final String imagePath = "res/img/backgrounds/"; //Dont think I
    // need this.
    private final String imageName = "mainMenu.jpg";

    // x, y coordinates
    protected float mouseX, mouseY;

    // Menu Items array.
    MenuItem[] menuItems;

    // Menu variable
    private Menu mainMenu;

    // Fonts int use.
    TrueTypeFont checkbook, cosmicfade, plasmati, twobit;

    // Music
    EAudio bgMusic;

    // Path to music
    private String sweetDream = "res/sound/music/sweetdre.xm";

    // Boolean for paused
    private boolean paused;

    /**
     * Constructor
     * 
     * @param state
     */
    public MainMenuState(int state) {
	// WIP -- Investigate...
	// Initialize audio

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg)
	    throws SlickException {

	// Initialize array.
	menuItems = new MenuItem[5];

	// Add menu items: (title, x, y, width, height, angle, speed, selected)
	menuItems[0] = new MenuItem(GameStrings.PLAY,
		gc.getWidth() / 2 - GameNumbers.PLAY_MENU_ITEM_WIDTH / 2, 140f,
		GameNumbers.PLAY_MENU_ITEM_WIDTH, 100f, 0f, 0f, false);
	menuItems[1] = new MenuItem(GameStrings.DIRECTIONS,
		gc.getWidth() / 2 - GameNumbers.DIRECTIONS_MENU_ITEM_WIDTH / 2, 240f,
		GameNumbers.DIRECTIONS_MENU_ITEM_WIDTH, 100f, 0f, 0f, false);
	menuItems[2] = new MenuItem(GameStrings.SCORES,
		gc.getWidth() / 2 - GameNumbers.SCORES_MENU_ITEM_WIDTH / 2, 340, GameNumbers.SCORES_MENU_ITEM_WIDTH, 100, 0f, 0f, false);
	menuItems[3] = new MenuItem(GameStrings.CREDITS,
		gc.getWidth() / 2 - GameNumbers.CREDITS_MENU_ITEM_WIDTH / 2, 440, GameNumbers.CREDITS_MENU_ITEM_WIDTH, 100, 0f, 0f, false);
	menuItems[4] = new MenuItem(GameStrings.QUIT,
		gc.getWidth() / 2 - GameNumbers.QUIT_MENU_ITEM_WIDTH / 2, 540, GameNumbers.QUIT_MENU_ITEM_WIDTH, 100, 0f, 0f, false);

	// Create the menu object with (title, the menu items array, and the
	// image).
	mainMenu = new Menu(GameStrings.TITLE, menuItems,
		ImageHelper.setBackgroundImage(imageName));

	// Initialize fonts.
	checkbook = FontHelper.setTTF("checkbook.ttf", 18);
	plasmati = FontHelper.setTTF("plasmati.ttf", 48);
	cosmicfade = FontHelper.setTTF("cosmicfade.ttf", 100);

	// Music
	bgMusic = new EAudio(sweetDream);
	//bgMusic.getMusic().loop();

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
	g.drawString(GameStrings.TITLE, gc.getWidth() / 2 - 175 / 2, 30);

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
			// bgMusic.getMusic().stop();
			TransitionHelper.openPlayOption(sbg);

			break;

		    case 1:
			TransitionHelper.openDirections(sbg);
			break;

		    case 2:
			TransitionHelper.openScores(sbg);
			break;

		    case 3:
			TransitionHelper.openCredits(sbg);
			break;

		    case 4:
			TransitionHelper.quitOption(gc, sbg);
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

    public boolean isPaused() {
	return paused;
    }

    public void setPaused(boolean paused) {
	this.paused = paused;
    }

}
