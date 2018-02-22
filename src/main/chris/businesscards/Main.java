package chris.businesscards;

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
		new Main().run(args); 
	}
	
	
	/**
	 * Runs the OCR application.  
	 * @param args
	 */
	public void run(String[] args) {
		try {			
			if(args.length != 1)
				printErrorExit("This program expects one argument--the file path of the input file.");
		
		}catch(Throwable t) {
			printErrorExit("Unexpected runtime error.", t);
		}
	}
	
	/**
	 * Prints the error message to standard error 
	 * @param message  An informative error
	 */
	private void printErrorExit(String message) {
		printErrorExit(message, null);
	}

	/**
	 * prints the error message and the stack trace to standard error 
	 * @param message An informative error
	 * @param t a throwable.  May be null
	 */
	private void printErrorExit(String message, Throwable t) {
		System.err.println("FATAL ERROR: " + message);
		if(t != null)
			t.printStackTrace(System.err);
	
	}

}
