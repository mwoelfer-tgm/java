package woelfer;

/**
 * @author Wölfer
 * @version 2017-03-26
 *
 */
public class Authentication implements TextReader {
	private TextReader tr;
	private String pw;
	
	/**
	 * initiliaze attributes
	 * @param tr the textreader which is used by Authentication - in our case textreader is Scrambling
	 */
	public Authentication(TextReader tr) {
		this.tr = tr;
		this.pw = "";
	}
	
	/**
	 * sets the password for later checking
	 * 
	 * also calls the write method of the textreader in order to scramble the password
	 * @param s the user input which gets encrypted
	 */
	public void write(String[] s) throws Throwable{
		System.out.print("Password: ");
		this.pw = in.readLine();
		this.tr.write(s);
	}
	
	/**
	 * checks the input if the password is correct
	 * 
	 * If it is correct, call read function of Textreader(scrambling) in order to decrypt the encrypted message
	 * @param s user input which gets decrypted
	 */
	public void read(String[] s) throws Throwable{
		System.out.print("Password: ");
		if (this.pw.equals(in.readLine())){
			this.tr.read(s);
		} else{
			System.out.println("Wrong password!");
		}
	}
}
