package com.redrabbit.charachters;

//Slick imports
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
//Package imports. 
import com.redrabbit.animations.SnakeAnimation;

/**
 * An electrical snake list (a glorified linked list).
 * 
 * @author rabbitfighter
 *
 */
public class ElectricSnakeList {

    // reference to the head node.
    private Node head;
    private int listCount;

    // LinkedList constructor
    public ElectricSnakeList(Vector2f vector, float angle, float velocity,
	    int size) throws SlickException {

	// Set the list size to the size you want the list to be.
	listCount = size;

	// this is an empty list, so the reference to the head node
	// is set to a new node with no snakeCell
	if (size > 0) {
	    head = new Node(new ElectricSnakeCell(vector, angle, velocity));
	} else {
	    head = new Node(null);
	}

	// TODO::WIP
	for (int i = 0; i < size; i++) {
	    this.add(new ElectricSnakeCell(new Vector2f(
		    (vector.getX() + i * 64), 0), 90, 0));

	    if (size == 1) {
		this.get(0).setAnimation(SnakeAnimation.SNAKE_HEAD_BLINKING);
	    }
	}

	// TODO: Add cells...

    }

    /**
     * Appends the specified element to the end of this list.
     * 
     * @param snakeCell
     */
    public void add(ElectricSnakeCell snakeCell) {
	Node temp = new Node(snakeCell);
	Node current = head;
	// starting at the head node, crawl to the end of the list
	while (current.getNext() != null) {
	    current = current.getNext();
	}
	// the last node's "next" reference set to our new node
	current.setNext(temp);
	listCount++;// increment the number of elements variable
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param snakeCell
     * @param index
     */
    public void add(ElectricSnakeCell snakeCell, int index) {
	Node temp = new Node(snakeCell);
	Node current = head;
	// crawl to the requested index or the last element in the list,
	// whichever comes first
	for (int i = 1; i < index && current.getNext() != null; i++) {
	    current = current.getNext();
	}
	// set the new node's next-node reference to this node's next-node
	// reference
	temp.setNext(current.getNext());
	// now set this node's next-node reference to the new node
	current.setNext(temp);
	listCount++;// increment the number of elements variable
    }

    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     */
    public ElectricSnakeCell get(int index) {
	// index must be 1 or higher
	if (index <= 0)
	    return null;

	Node current = head.getNext();
	for (int i = 1; i < index; i++) {
	    if (current.getNext() == null)
		return null;

	    current = current.getNext();
	}
	return current.getSnakeCell();
    }

    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     */
    public boolean remove(int index) {
	// if the index is out of range, exit
	if (index < 1 || index > size())
	    return false;

	Node current = head;
	for (int i = 1; i < index; i++) {
	    if (current.getNext() == null)
		return false;

	    current = current.getNext();
	}
	current.setNext(current.getNext().getNext());
	listCount--; // decrement the number of elements variable
	return true;
    }

    /**
     * Returns the number of elements in this list.
     * 
     * @return
     */
    public int size() {
	return listCount;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
	Node current = head.getNext();
	String output = "";
	while (current != null) {
	    output += "[" + current.getSnakeCell().toString() + "]";
	    current = current.getNext();
	}
	return output;
    }

    /**
     * A node in the "snake list".
     * 
     * @author rabbitfighter
     *
     */
    private class Node {
	
	// reference to the next node in the chain,
	// or null if there isn't one.
	Node next;
	
	// snakeCell node.
	ElectricSnakeCell snakeCell;

	// Node constructor if we want to
	// specify the node to point to.
	public Node(ElectricSnakeCell snakeCell, Node next) {
	    this.next = next;
	    this.snakeCell = snakeCell;
	}

	// Node constructor if pointer is null.
	public Node(ElectricSnakeCell snakeCell) {
	    this(snakeCell, null);
	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public int size() {
	    return listCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
	    Node current = head.getNext();
	    String output = "";
	    while (current != null) {
		output += "[" + current.getSnakeCell().toString() + "]";
		current = current.getNext();
	    }
	    return output;
	}

	/***** Getters/Setters *****/

	public ElectricSnakeCell getSnakeCell() {
	    return snakeCell;
	}

	@SuppressWarnings("unused")
	public void setSnakeCell(ElectricSnakeCell snakeCell) {
	    this.snakeCell = snakeCell;
	}

	public Node getNext() {
	    return next;
	}

	public void setNext(Node next) {
	    this.next = next;
	}
    }// End Node

}// EOF