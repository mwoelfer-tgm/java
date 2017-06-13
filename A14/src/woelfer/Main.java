package woelfer;

public class Main {

	public static void main( String[] args ) throws Throwable {
		System.out.println( "main: let's start!");
	    TextReader stream = new Authentication( new Scrambling( new Worker() ) );
	    String[] str =  {new String()};
	    stream.write(str);
	    System.out.println( "main:     " + str[0] );
	    stream.read( str );
	}
}
