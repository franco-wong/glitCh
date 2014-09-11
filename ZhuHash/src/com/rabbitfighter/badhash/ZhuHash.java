package com.rabbitfighter.badhash;
import java.util.Scanner;


/**
 * From Computer Security: Principles and Prctice 3rd edition textbook, Page 68,
 * Question 2.7: This problem introduces a hash function similar in spirit to
 * SHA that operates on letters instead of binary data. It is called the Toy
 * Telegraph Hash (TTH). Given a message consisting of a sequence of letters,
 * TTH produces a hash value consisting of four letters. First TTH divides the
 * message into blocks of 16 letters, ignoring spaces, punctuation, and
 * capitalization. If the message length is not divisible by 16, it is padded
 * out with nulls. A four number running total is maintained that starts out
 * with the value (0, 0, 0, 0); this is input to a function, known as a
 * compression.
 * 
 * This problem introduces a hash function similar in spirit to SHA that
 * operates on letters instead of binary data. It is called the toy tetragraph
 * hash (TTH). Given a message consisting of a sequence of letters, TTH produces
 * a hash value consisting of four letters. First, TTH divides the message into
 * blocks of 16 letters, ignoring spaces, punctuation, and capitalization. If
 * the message length is not divisible by 16, it is padded out with nulls. A
 * four number running total is maintained that starts out with the value (0, 0,
 * 0, 0); this is input to a function, known as a compression function, for
 * processing the first block. The compression function consists of two rounds.
 * 
 * Round 1: Get the next block of text and arrange it as a row-wise 4 × 4 block
 * of text and covert it to numbers (A = 0, B =1, ... Z = 26). Then, add each
 * column mod 26 and add the result to the running total, mod 26. In this
 * example, the running total is (24, 2, 6, 10).
 * 
 * Round 2: Using the matrix from round 1, rotate the first row left by 1,
 * second row left by 2, third row left by 3, and reverse the order of the
 * fourth row. Now, add each column mod 26 and add the result to the running
 * total. The new running total is (5, 7, 9, 11). This running total is now the
 * input into the first round of the compression function for the next block of
 * text. After the final block is processed, convert the final running total to
 * letters. For example, if the message is ABCDEFGHIJKLMNOP, then the hash is
 * FHJL.
 * 
 * Problem a) Calculate the hash function for the 48-letter message “I leave
 * twenty million dollars to my friendly cousin Bill.”
 * 
 * Problem b) To demonstrate the weakness of tth, can you find a 48-letter block
 * that produces the same hash as that just derived? Show your detailed
 * calculation steps for verification. (Hint: Use lots of A’s.)
 * 
 * @author rabbitfighter
 *
 */

public class ZhuHash {

    // Mod size based on the length of the alphabet.
    public static final int BLOCK_SIZE = 16;
    public static final int MOD_SIZE = 26;
    public static final int ROW_WIDTH = 4;
    public static final int ROW_HEIGHT = 4;
    public static final int OFFSET = 65;

    /**
     * Main method.
     * 
     * @param args
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {

	// Get input from the user in the form of a string.
	String originalMessage = getOriginalMessage();

	// Strip the message of all non a-zA-Z characvters using regex.
	String paddedMessage = getPaddedMessage(originalMessage);

	/*
	 * Call this recursive message to get the hash. String padded message,
	 * Vars: int[] running total of zeros to start, int runNumber
	 */
	int[] hashValues = calculateHash(paddedMessage,
		new int[] { 0, 0, 0, 0 }, 1);

	System.gc();
	System.exit(0);

    }

    /**
     * Gets the original message from the user.
     * 
     * @return
     */
    @SuppressWarnings("resource")
    private static String getOriginalMessage() {

	Scanner input = null;

	System.out
		.println("================================================================================");
	System.out
		.println("======================= Example of a Bad Hash Function =========================");
	System.out
		.println("================================================================================");

	/*
	 * Get input from user.
	 */
	System.out
		.println("\nPlease enter a string to be converted into a 4 charachter hash and press [Enter]");
	try {
	    input = new Scanner(System.in);
	} catch (Exception e) {
	    System.out.println("Input failed. :(");
	    e.printStackTrace();
	    System.exit(0);
	}

	String message = input.nextLine();

	return message;
    }

    /**
     * Gets a formatted and padded message using regular expressions.
     * 
     * @param _originalMessage
     * @return
     */
    private static String getPaddedMessage(String _originalMessage) {

	String message = new String(_originalMessage.toUpperCase()
		.replaceAll("[^a-zA-Z]", "").replaceAll("\\s+", ""));

	int length = message.length();

	int padding;

	if (message.length() == BLOCK_SIZE) {
	    padding = 0;
	} else {
	    padding = BLOCK_SIZE - (length % BLOCK_SIZE);
	}

	/*
	 * Concatenate with A's to make 16 length sequences or blocks
	 */
	for (int i = 0; i < padding; i++) {
	    message = message + "A";
	}

	System.out.println("\nPadded message: \n" + message);

	return message;

    }

    /**
     * Performs the steps necessary to create the hash
     * 
     * @param _message
     * @param _runningTotal
     * @param _block
     * @return
     */
    private static int[] calculateHash(String _message, int[] _runningTotal,
	    int _block) {

	if (_message.length() == 0 || _message == null) {

	    System.out.println("\nRunning total after all blocks of "
		    + BLOCK_SIZE + " letters:" + "\n[ " + _runningTotal[0]
		    + " " + _runningTotal[1] + " " + _runningTotal[2] + " "
		    + _runningTotal[3] + " ]\n\nHash: "
		    + (char) (_runningTotal[0] + OFFSET) + " "
		    + (char) (_runningTotal[1] + OFFSET) + " "
		    + (char) (_runningTotal[2] + OFFSET) + " "
		    + (char) (_runningTotal[3] + OFFSET));

	    return _runningTotal;
	}

	int counter = 0;

	int[][] values = new int[ROW_WIDTH][ROW_HEIGHT];

	for (int i = 0; i < ROW_WIDTH; i++) {
	    for (int j = 0; j < ROW_HEIGHT; j++) {
		// Cast values of letters to integers. (i.e. A=0, B=1...Z=25).
		values[i][j] = (int) _message.charAt(counter) - OFFSET;
		// Incriment countter.
		counter++;
	    }
	}

	int[] T = _runningTotal;

	// Column one arithmatic performs shifts synthetically
	T[0] = (values[0][0] + values[1][0] + values[2][0] + values[3][0]
		+ values[0][1] + values[1][2] + values[2][3] + values[3][3] + _runningTotal[0])
		% MOD_SIZE;// correct?
	T[1] = (values[0][1] + values[1][1] + values[2][1] + values[3][1]
		+ values[0][2] + values[1][3] + values[2][0] + values[3][2] + _runningTotal[1])
		% MOD_SIZE;// correct?
	T[2] = (values[0][2] + values[1][2] + values[2][2] + values[3][2]
		+ values[0][3] + values[1][0] + values[2][1] + values[3][1] + _runningTotal[2])
		% MOD_SIZE;// correct?
	T[3] = (values[0][3] + values[1][3] + values[2][3] + values[3][3]
		+ values[0][0] + values[1][1] + values[2][2] + values[3][0] + _runningTotal[3])
		% MOD_SIZE;// correct?

	if (_message.length() != BLOCK_SIZE) {
	    System.out.println("\nString remaining after block " + _block
		    + ":\n" + _message.substring(BLOCK_SIZE));

	    System.out.println("\nRunning total after block " + _block
		    + ":\n[ " + T[0] + " " + T[1] + " " + T[2] + " " + T[3]
		    + " ]\n\n" + (char) (T[0] + OFFSET) + " "
		    + (char) (T[1] + OFFSET) + " " + (char) (T[2] + OFFSET)
		    + " " + (char) (T[3] + OFFSET));
	} else {
	    System.out.println("\nString remaining after block " + _block
		    + ":\n" + "Nothing... We're done.");
	}

	int block = _block++;

	return calculateHash(_message.substring(BLOCK_SIZE), T, _block++);
    }

}// EOF
