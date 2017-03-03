package clueGame;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class BadConfigFormatException extends Exception {
	
	public BadConfigFormatException() throws FileNotFoundException{
		super ("Configuration Failed");
	
	}
	public BadConfigFormatException(String format) throws FileNotFoundException{
		super ("Configuration of " + format + "failed");
		PrintWriter out = new PrintWriter("logfile.txt");
		out.println("Configuration of " + format + "failed");
		out.close();
	}



}
