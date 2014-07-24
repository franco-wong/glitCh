package com.redrabbit.extendables;

import org.newdawn.slick.geom.Vector2f;

public class Living extends Animated {

    public final float MAX_STAMINA = 100;
    public final float MAX_HEALTH = 100;

    private float health;
    private float stamina;
    private boolean living;
    private boolean hit;

    public Living(Vector2f vector, float angle, float velocity) {
	super(vector, angle, velocity);

    }

    public float getHealth() {
	return health;
    }

    public void setHealth(float health) {
	this.health = health;
    }

    public float getStamina() {
	return stamina;
    }

    public void setStamina(float stamina) {
	this.stamina = stamina;
    }

    public boolean isLiving() {
	return living;
    }

    public void setLiving(boolean living) {
	this.living = living;
    }

    public boolean isHit() {
	return hit;
    }

    public void setHit(boolean hit) {
	this.hit = hit;
    }

}
