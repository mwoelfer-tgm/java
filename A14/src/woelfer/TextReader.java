package woelfer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public interface TextReader {
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	void write(String[] s) throws Throwable;
	void read(String[] s) throws Throwable;
}