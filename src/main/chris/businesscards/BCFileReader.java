package chris.businesscards;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * A small class that reads in files from directory path or classpath.  
 * @author Chris
 *
 */
public class BCFileReader {

	/**
	 * Given a filename that is either a full path, a la {@link java.io.File} or a classpath:{filename}, returns the contents of the file as a
	 * UTF-8 String. 
	 * @param filename null causes an IO exception
	 * @return the contents of the file as a string
	 * @throws IOException if there is a problem reading from file or classpath
	 */
	public String readToString(String filename) throws IOException {
		if(filename == null) throw new IOException("Cannot read null filename");
		
		// check for classpath resource.  Used mostly for testing.
		if(filename.startsWith("classpath:")) {
			InputStream inStream = null;
			try {
				inStream = this.getClass().getClassLoader().getResourceAsStream(filename.replace("classpath:", ""));
				return IOUtils.toString(inStream, StandardCharsets.UTF_8);
			}catch(Throwable t) {
				throw new IOException("Unable to read file from classpath.  Filename=" + filename, t);
			}finally {
				if(inStream != null)
					inStream.close();
			}
		}
		else // read file
			return FileUtils.readFileToString(new File(filename), StandardCharsets.UTF_8);
	}

	
}
