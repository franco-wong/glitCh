/**
 * Message is self contained and holds information regarding a message object.
 * 
 * @author rabbitfighter
 *
 */
public class Message {

    private String message;
    private String strippedMessage;
    private String paddedMessage;
    private int length;
    private int padding;
    private char[] messageArray;
    private int[][] valueArray = new int[HashExample.BLOCK_ARRAY_WIDTH][HashExample.BLOCK_ARRAY_HEIGHT];
    private int block;
    private int[] runningTotal;

    /**
     * Constructor for message object.
     * 
     * @param _message
     *            - The message passed in
     */
    Message(String _message) {

	this.message = _message;

	/*
	 * Strip of whitespace, non a-z or A-Z characters using a regular
	 * expression.
	 */
	this.strippedMessage = _message.toUpperCase()
		.replaceAll("[^a-zA-Z]", "").trim();

	/*
	 * Pad the message with A's to make it a multiple of BlOCK_SIZE and set
	 * paddin, length and.
	 */
	if (this.strippedMessage.length() % HashExample.BLOCK_SIZE != 0) {
	    this.padding = HashExample.BLOCK_SIZE
		    - (this.strippedMessage.length() % HashExample.BLOCK_SIZE);
	} else {
	    this.padding = 0;
	}

	this.paddedMessage = this.strippedMessage;

	for (int i = 0; i < this.padding; i++) {
	    this.paddedMessage = this.paddedMessage + "A";
	}

	/*
	 * Set the length of the message
	 */
	this.length = this.paddedMessage.length();

	/*
	 * Set the character array.
	 */

	this.setMessageArray(this.paddedMessage.toCharArray());

	/*
	 * Set the value array object.
	 */
	this.setValueArray(this.getMessageArray());
	/*
	 * Sys-out with message information
	 */
	System.out.println("Original message: " + message
		+ "\nOriginal length: " + length + "\nPadded ength: "
		+ this.padding + "\nStripped message: " + this.strippedMessage
		+ "\nPadded message: " + this.paddedMessage.toString());

    }// END constructor

    /**
     * Print the value array.
     */
    public void printValueArray(int[][] _valueArray, int _blockNumber) {
	System.out.println("\nBlock: " + _blockNumber + "\n~~~~~~~~~~~~");
	for (int i = 0; i < HashExample.BLOCK_ARRAY_WIDTH; i++) {
	    /*
	     * Print four elements ata a time
	     */
	    System.out.println(" " + _valueArray[i][0] + " "
		    + _valueArray[i][1] + " " + _valueArray[i][2] + " "
		    + _valueArray[i][3]);

	}
	System.out.println("~~~~~~~~~~~~\n");
    }

    /***** Getters/Setters *****/

    public int[][] getValueArray() {
	return valueArray;
    }

    public int[][] setValueArray(char[] _messageArray) {

	int counter = 0;

	for (int i = 0; i < HashExample.BLOCK_ARRAY_WIDTH; i++) {
	    for (int j = 0; j < HashExample.BLOCK_ARRAY_HEIGHT; j++) {
		// (i.e. A=0, B=1...Z=25).
		this.valueArray[i][j] = (int) _messageArray[counter] - 65;
		counter++;
	    }
	}

	return this.valueArray;
    }

    /**
     * The heart of this program is this recursive method that performs all the
     * claculations on the matrix. WIP.
     * 
     * @param _message
     * @param _runningTotal
     * @param _blockNumber
     * @return
     */
    public int[] performBadHash(char[] _message, int[] _runningTotal,
	    int _blockNumber) {

	/*
	 * 1) If remiaing length is zero, break the recursive method.
	 */
	if (this.paddedMessage.length() == 0) {
	    return _runningTotal;
	} else {

	    /*
	     * 2) Put the next 16 letters into a 4 by 4 cube. This may seem a
	     * bit complex, but really, i'm just sending thie first 16 letters
	     * of the character sequence to the set ValueArray() method.
	     */
	    int[][] valueSet = setValueArray(_message.toString()
		    .substring(0, HashExample.BLOCK_SIZE-1).toCharArray());
	    /*
	     * 3) Print the sequence.
	     */
	    printValueArray(valueSet, _blockNumber);

	    /*
	     * 4) Get a running total and print it.
	     */
	    this.runningTotal = calculateRunningTotal(valueSet,
		    this.runningTotal);
	    printRunningTotal(this.runningTotal);

	    /*
	     * 5)Perform row-wise shifts, and reversals.
	     */
	    valueSet = shiftValues(valueSet);

	    /*
	     * 6) Get a running total and print it.
	     */
	    this.runningTotal = calculateRunningTotal(valueSet,
		    this.runningTotal);
	    printRunningTotal(this.runningTotal);

	    /*
	     * 7) Keep going with the next block.
	     */
	    return performBadHash(
		    _message.toString()
			    .substring(HashExample.BLOCK_SIZE, _message.length)
			    .toCharArray(), this.runningTotal, _blockNumber++);

	    /*
	     * 9) Pray...
	     */
	}

    }

    private void printRunningTotal(int[] _runningTotal) {
	System.out.println(" Running total is: " + _runningTotal[0] + " "
		+ _runningTotal[1] + " " + _runningTotal[2] + " "
		+ _runningTotal[3]);

    }

    private int[][] shiftValues(int[][] _valueSet) {

	int[][] temp_valueSet = new int[4][4];

	for (int i = 0; i < HashExample.BLOCK_ARRAY_WIDTH; i++) {
	    for (int j = 0; j < HashExample.BLOCK_ARRAY_HEIGHT; j++) {
		if (i == 0) {

		    temp_valueSet[(i)][((j + 3) % HashExample.BLOCK_ARRAY_WIDTH)] = _valueSet[(i)][(j)
			    % HashExample.BLOCK_ARRAY_WIDTH];
		}
		if (i == 1) {
		    temp_valueSet[(i)][((j + 4) % HashExample.BLOCK_ARRAY_WIDTH)] = _valueSet[(i)][(j)
			    % HashExample.BLOCK_ARRAY_WIDTH];
		}
		if (i == 2) {
		    temp_valueSet[(i)][((j + 5) % HashExample.BLOCK_ARRAY_WIDTH)] = _valueSet[(i)][(j)
			    % HashExample.BLOCK_ARRAY_WIDTH];
		}
		if (i == 3) {
		    temp_valueSet[3][0] = _valueSet[3][3];
		    temp_valueSet[3][1] = _valueSet[3][2];
		    temp_valueSet[3][2] = _valueSet[3][1];
		    temp_valueSet[3][3] = _valueSet[3][0];
		}
	    }
	}

	return temp_valueSet;
    }

    /**
     * Calculates the running total of a matrix. This always calculates the
     * running total of the matrix and then adds it to the previous running
     * total.
     * 
     * @param _valueSet
     * @param runningTotal
     * @return
     */
    @SuppressWarnings("null")
    private int[] calculateRunningTotal(int[][] _valueSet, int[] runningTotal) {

	int[] temp_running_total = null;

	temp_running_total[0] = ((_valueSet[0][0] + _valueSet[1][0]
		+ _valueSet[2][0] + _valueSet[3][0]) % HashExample.MOD_SIZE);
	temp_running_total[1] = ((_valueSet[0][1] + _valueSet[1][1]
		+ _valueSet[2][1] + _valueSet[3][1]) % HashExample.MOD_SIZE);
	temp_running_total[2] = ((_valueSet[0][2] + _valueSet[1][2]
		+ _valueSet[2][2] + _valueSet[3][2]) % HashExample.MOD_SIZE);
	temp_running_total[3] = ((_valueSet[0][3] + _valueSet[1][3]
		+ _valueSet[2][3] + _valueSet[3][3]) % HashExample.MOD_SIZE);

	for (int i = 0; i < 4; i++) {
	    temp_running_total[i] = (temp_running_total[i] + runningTotal[i]) % 26;
	}
	return temp_running_total;
    }

    public char[] getMessageArray() {
	return messageArray;
    }

    public void setMessageArray(char[] messageArray) {
	this.messageArray = messageArray;
    }

}