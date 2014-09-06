import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
public class HashExample {

    /**
     * Main method contains general program logic flow... TODO: cleanup.
     * 
     * @param args
     */

    // Final variables.
    final static int MOD_SIZE = 26;
    final static int BLOCK_SIZE = 16;
    final static int BLOCK_ARRAY_WIDTH = 4;
    final static int BLOCK_ARRAY_HEIGHT = 4;
    
    static Message message;

    // TODO: Probably don't need.
    final static String[] alphabet_array = new String[] { "A", "B", "C", "D",
	    "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
	    "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

    public static void main(String[] args) {
	

	/*
	 * Get input from user.
	 */
	Scanner input = null;
	
	System.out
		.println("Please enter a string to be converted into a 4 charachter hash and press [Enter]");
	try {
	    input = new Scanner(System.in);

	} catch (Exception e) {
	    System.out.println("Input failed. :(");
	    e.printStackTrace();
	}

	/*
	 * 1) Get input
	 */
	message = new Message(input.next());
	message.performBadHash(message.getMessageArray(), new int[]{0,0,0,0}, 0);

    }// END Main

 

   

}// EOF
