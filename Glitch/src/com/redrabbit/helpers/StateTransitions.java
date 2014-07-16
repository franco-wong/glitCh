package com.redrabbit.helpers;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.util.Log;

import com.redrabbit.logging.LoggerConfig;

public class StateTransitions {



    private static final String TAG = "StateTransitions";

    public static void openPlayOption(StateBasedGame sbg) {
	sbg.enterState(1, new FadeOutTransition(Color.white, 4000),
		new FadeInTransition(Color.white, 4000));
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

    public static void quitOption(GameContainer gc, StateBasedGame sbg) {
	if (LoggerConfig.ON) {
	  Log.debug(TAG + ": Game closed successfully.");
	  System.out.println(TAG + ": Game closed successfully.");
	}
	gc.exit();
    }

}
