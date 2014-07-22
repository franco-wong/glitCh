package com.redrabbit.logging;

/**
 * Used for whenever we want to log something, we’ll check to see if this
 * constant is true or false. To turn the logging on or off, all we have to do
 * is update the constant and recompile the application.
 * 
 * @author rabbitfighter
 * 
 */
public class LoggerConfig {
    public static final boolean ON = true;
    public static final boolean TRACKING_PLAYER_MOVEMENT = false;
    public static final boolean TRACKING_MOUSE = false;
    public static final boolean CROSSHAIR_IMAGE_DEBUG = false;
    public static final boolean CROSSHAIR_DEBUG = false;
}
