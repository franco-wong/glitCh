package com.redrabbit.logging;

/**
 * Used for whenever we want to log something. If we want to debug a particluar
 * system, we can use constants for these systems of interest, and so, in
 * logging situations, we check to see if this constant is true or false. To
 * turn the logging on or off, all we have to do is update the constant and run
 * the application in debug mode. Loggin is importnat to this project because
 * SLick2D's debugging is horrible and gives little insight into what's going
 * on.
 * 
 * @author rabbitfighter, redgragonX
 * 
 */
public class LoggerConfig {
    public static final boolean ON = true;
    public static final boolean TRACKING_PLAYER_MOVEMENT = false;
    public static final boolean TRACKING_MOUSE = false;
    public static final boolean CROSSHAIR_IMAGE_DEBUG = false;
    public static final boolean CROSSHAIR_DEBUG = false;
    public static final boolean PARTICLE_SYSTEM_DEBUG = false;
    public static final boolean TILE_DEBUG = false;
    public static final boolean BACKGROUND_DEBUG = false;
    public static final boolean CHARACHTER_IMAGE_DEBUG = false;
    public static final boolean SOUND_ON = false;
}// EOF
