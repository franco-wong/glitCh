package com.redrabbit.objects;

import org.newdawn.slick.Image;

public class Menu {

    // For testing
    @SuppressWarnings("unused")
    private final String TAG = "Menu";
    
    /* A menu has a title, a list of menu items, a background image, */
    private String menuTitle;
    private MenuItem[] menuItems;
    private Image bgImage;

    public Menu() {
	// blank constructor...
    }

    /**
     * Constructor for a Menu
     * 
     * @param menuTitle
     * @param menuItems
     * @param bgImage
     */
    public Menu(String menuTitle, MenuItem[] menuItems, Image bgImage) {
	this.setMenuTitle(menuTitle);
	this.setMenuItems(menuItems);
	this.setBgImage(bgImage);
    }

    /***** Getters/Setters *****/
    public Image getBgImage() {
	return bgImage;
    }

    public void setBgImage(Image bgImage) {
	this.bgImage = bgImage;
    }

    public MenuItem[] getMenuItems() {
	return menuItems;
    }

    public void setMenuItems(MenuItem[] menuItems) {
	this.menuItems = menuItems;
    }

    public String getMenuTitle() {
	return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
	this.menuTitle = menuTitle;
    }

}