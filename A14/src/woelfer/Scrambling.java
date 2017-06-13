package woelfer;

public class Scrambling implements TextReader{
	private TextReader tr;

	/**
	 * initialize attributes
	 * @param tr the textreader from which methods get called, in this case Worker
	 */
	public Scrambling(TextReader tr) {
		this.tr = tr;
	}

	/**
	 * encrypts the String and also calls the write method of Worker
	 * 
	 * @param s the String which gets encrypted
	 */
	@Override
	public void write(String[] s) throws Throwable {
		this.tr.write(s);
		System.out.println("Encrypt: ");
		s[0] = this.encrypt(s[0]);
	}

	
	/**
	 * Decrypts the String and also calls the read function of Worker
	 * @param s the String which gets decrypted
	 */
	@Override
	public void read(String[] s) throws Throwable{
		System.out.println("Decrypt: ");
		s[0] = this.decrypt(s[0]);
		this.tr.read(s);
	}
	
	/**
	 * src: http://stackoverflow.com/questions/4421400/how-to-get-0-padded-binary-representation-of-an-integer-in-java
	 * 
	 * @param text the String to be encrypted
	 * @return a String encrypted to binary
	 * @throws Throwable this method can throw an exception because of NumberFormatExceptions
	 */
	private String encrypt(String text) throws Throwable {
		// this was challenging, because toBinaryString(c) "forgets" about the leading zeros, which makes decrypting incredibly hard
		String output = "";
		for(char c : text.toCharArray()){
			output += String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
		}
		return output;
	}

	/**
	 * src: http://stackoverflow.com/questions/35881823/string-binary-to-string-8-digits-in-java
	 * @param text String to be decrypted
	 * @return a String decrypted from binary
	 */
	private String decrypt(String text) {
		String output = "";
	    for (int i=0; i< text.length(); i+=8){
	        String next = text.substring(i,i+8);
	        int code = Integer.parseInt(next,2);
	        output += ((char) code);
	    }
	    return output;
	}
}
