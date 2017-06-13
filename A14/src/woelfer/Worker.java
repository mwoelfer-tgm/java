package woelfer;

import java.io.IOException;

public class Worker implements TextReader {
	/**
	 * Reads the user input
	 * @param s the String to be encrypted
	 */
	public void write( String[] s ) {
		System.out.print( "INPUT:    " );
		try {
			s[0] = in.readLine();
		} catch (IOException ex) { ex.printStackTrace(); }
	}

	/**
	 * Puts out the decrypted String to the console
	 * @param s the String to be decrypted
	 */
	public void read( String[] s ) {
		System.out.println( "Output:   " + s[0] );
	} 
}