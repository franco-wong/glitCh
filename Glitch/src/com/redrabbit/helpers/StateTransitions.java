package com.redrabbit.helpers;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.util.Log;

import com.redrabbit.engine.states.PlayState;
import com.redrabbit.logging.LoggerConfig;

public class StateTransitions {

    private static final String TAG = "StateTransitions";
    private static boolean paused;
    private static boolean resumed;

    /**
     * Used for whenever we want to log something, we’ll check to see if this
     * constant is true or false. To turn the logging on or off, all we have to
     * do is update the constant and recompile the application.
     * 
     * @author rabbitfighter
     * 
     */

    /**
     * Opens the game where it left off.
     * 
     * @param sbg
     *            - The State Based Game object passed in.
     */
    public static void openPlayOption(StateBasedGame sbg) {

	// Enter state with transitions.
	sbg.enterState(1, new FadeOutTransition(Color.transparent, 1000),
		new FadeInTransition(Color.transparent, 1000));

    }

    public static void resumePlayOption(StateBasedGame sbg) {
	StateTransitions.setPaused(false);
	StateTransitions.setResumed(true);
	// Enter state with transitions.
	sbg.enterState(1, new FadeOutTransition(Color.transparent, 1000),
		new FadeInTransition(Color.transparent, 1000));

    }

    public static void openDirections(StateBasedGame sbg) {
	// TODO Auto-generated method stub

    }

    public static void openScores(StateBasedGame sbg) {
	// TODO Auto-generated method stub

    }

    public static void openCredits(StateBasedGame sbg) {
	// TODO Auto-generated method stub

    }

    /**
     * Quits the game.
     * 
     * @param gc
     *            - The gmae Container passed in.
     * @param sbg
     *            - The State Based Game object passed in.
     */
    public static void quitOption(GameContainer gc, StateBasedGame sbg) {
	if (LoggerConfig.ON) {

	    Log.debug(TAG + ": Game closed successfully.");
	    System.out.println(TAG + ": Game closed successfully.");
	}
	gc.exit();
    }

    /**
     * Opens the pause menu.
     * 
     * @param sbg
     *            - The State Based Game object passed in.
     */
    public static void openPauseMenu(StateBasedGame sbg) {
	StateTransitions.setPaused(true);
	StateTransitions.setResumed(false);
	sbg.enterState(2, new FadeOutTransition(Color.transparent, 1000),
		new FadeInTransition(Color.transparent, 1000));
    }

    /***** Getters/Setters *****/

    public static boolean isPaused() {
	return paused;
    }

    public static void setPaused(boolean paused) {
	StateTransitions.paused = paused;
    }

    public static boolean isResumed() {
	// TODO Auto-generated method stub
	return resumed;
    }

    public static void setResumed(boolean resumed) {
	StateTransitions.resumed = resumed;
    }

}
