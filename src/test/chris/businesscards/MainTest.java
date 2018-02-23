package chris.businesscards;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

	private ByteArrayOutputStream outBytes;
	private PrintStream outStream; 
	
	@Before
	public void setUpPrintStreamForValidation() throws UnsupportedEncodingException {
		outBytes = new ByteArrayOutputStream();
		outStream = new PrintStream(outBytes, true,  StandardCharsets.UTF_8.name());		
	}
	
	
	//// ~~~~~~~ test reading one successful file.  
	
	@Test
	public void testHappyRun() {
		new Main().run(new String[] {"classpath:mikeSmith.txt"}, outStream);
		outStream.close();
		String content = new String(outBytes.toByteArray(), StandardCharsets.UTF_8);
		assertTrue(content.contains("Name: Mike Smith"));
		assertTrue(content.contains("Phone: 4105551234"));
		assertTrue(content.contains("Email: msmith@asymmetrik.com"));		
	}
	
	
	//// ~~~~~~~ test a bunch of input errors with arguments
	
	@Test
	public void testNullArgs() {
		new Main().run(null, outStream);
		outStream.close();
		String content = new String(outBytes.toByteArray(), StandardCharsets.UTF_8);
		assertTrue(content, content.contains("Missing Argument"));
	}
	
	@Test
	public void testEmptyArgs() {
		new Main().run(new String[0], outStream);
		outStream.close();
		String content = new String(outBytes.toByteArray(), StandardCharsets.UTF_8);
		assertTrue(content, content.contains("Missing Argument"));
	}
	
	@Test
	public void testFileNotFound() {
		new Main().run(new String[] {"filenotexist"}, outStream);
		outStream.close();
		String content = new String(outBytes.toByteArray(), StandardCharsets.UTF_8);
		assertTrue(content, content.contains("File not found"));
	}
	
	@Test
	public void testExtraArgs() {
		new Main().run(new String[]{"foo", "foo2"} , outStream);
		outStream.close();
		String content = new String(outBytes.toByteArray(), StandardCharsets.UTF_8);
		assertTrue(content, content.contains("Too many arguments"));
	}
	
}
