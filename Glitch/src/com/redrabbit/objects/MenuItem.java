package com.redrabbit.objects;

import com.redrabbit.helpers.Moveable;

/**
 * A class that hold information about menu items.
 * 
 * @author rabbitfighter
 *
 */
public class MenuItem extends Moveable
{

	private String name;
	private float width, height;

	/**
	 * Constructor for a menu item with x and y position passed in
	 * 
	 * @param name
	 * @param width
	 * @param height
	 */
	public MenuItem(String name, float x, float y)
	{
		this.setName(name);
		super.setX(x);
		super.setY(y);
	}

	/**
	 * Constructor with width and height variables passed in
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public MenuItem(String name, float x, float y, float width, float height)
	{
		this.setName(name);
		this.setWidth(width);
		this.setHeight(height);
		super.setX(x);
		super.setY(y);

	}

	/**
	 * A simple method to reverse the string of a menu item
	 * 
	 * @param name
	 *            - the name passed in
	 * @return the reversed string
	 */
	public static String reverseString(String name)
	{

		// Create a new string builder object
		StringBuilder sb = new StringBuilder();
		/*
		 * Iterator appends characters to string builder starting at the end of
		 * the string and moving backwards until completion
		 */
		for (int i = name.length(); i > 0; i--)
		{
			// Add character to String Builder
			sb.append(name.toCharArray()[i]);
		}

		// Return the reversed string
		return sb.toString();
	}

	/***** Getters and Setters *****/

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public float getHeight()
	{
		return height;
	}

	public void setHeight(float height)
	{
		this.height = height;
	}

	public float getWidth()
	{
		return width;
	}

	public void setWidth(float width)
	{
		this.width = width;
	}

}// EOF
