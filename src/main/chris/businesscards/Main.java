package chris.businesscards;

import java.io.IOException;
import java.io.PrintStream;

import chris.businesscards.contactInfo.ContactInfo;
import chris.businesscards.contactInfo.ContactInfoFormatter;
import chris.businesscards.contactInfo.ContactInfoFormatterImpl;
import chris.businesscards.parser.BCPSimpleImpl;
import chris.businesscards.parser.BusinessCardParser;

/**
 * Run the BusinessCard OCR program, a challenge.  
 * 
 * We’ve created a new smartphone app that enables users to snap a photo of a business card and have the 
 * information from the card automatically extracted and added to their contact list. We need you to 
 * write the component that parses the results of the optical character recognition (OCR) component 
 * in order to extract the name, phone number, and email address from the processed business card image.
 * 
 * This program expects a runtime argument--the file path of the expected input file.   
 * 
 * @author Chris
 *
 */
public class Main {

	/**
	 * main method.  
	 * @param args.  Expects one argument; the filepath of the input file.  
	 */
	public static void main(String[] args) {
		new Main().run(args, System.out); 
	}
	
	
	/**
	 * Runs the OCR application.  Checks the arguments, reads the input file, prints out the output to provided output stream.  
	 * @param args
	 */
	public void run(String[] args, PrintStream outputStream) {
		
		
		try {			
		
			// check args
			if(args == null || args.length == 0)
				printErrorExit("Missing Argument--the file path of the input file.", outputStream);
			else if(args.length > 1)
				printErrorExit("Too many arguments.  Only one permitted--the file path of the input file.", outputStream);
			else {
				
				// read in file
				String filename = args[0];				
				if(filename == null)
					printErrorExit("Missing Argument--the file path of the input file.", outputStream);
				
				try {
					
					
					// import results and transform.  Expect a single card.
					String input = new BCFileReader().readToString(filename);
					BusinessCardParser parser = new BCPSimpleImpl();
					ContactInfo result = parser.getContactInfo(input);
															
					// print results to standard out
					ContactInfoFormatter formatter = new ContactInfoFormatterImpl();
					outputStream.println(formatter.format(result));
					
					
				}catch(IOException e) {
					printError("File not found.  Filename " + filename, e, outputStream);
				}
			}
			
			
		}catch(Throwable t) {
			printError("Unexpected runtime error.", t, outputStream);
		}
	}
	
	/**
	 * Prints the error message to standard error 
	 * @param message  An informative error
	 * @param errorOutputStream the output stream to print errors to
	 */
	private void printErrorExit(String message, PrintStream errorOutputStream) {
		printError(message, null, errorOutputStream);
	}

	/**
	 * prints the error message and the stack trace to standard error 
	 * @param message An informative error
	 * @param t a throwable.  May be null
	 * @param errorOutputStream the output stream to print errors to
	 */
	private void printError(String message, Throwable t, PrintStream errorOutputStream) {
		errorOutputStream.println("FATAL ERROR: " + message);
		if(t != null)
			t.printStackTrace(errorOutputStream);
	
	}

}
