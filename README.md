Skills Demonstration for Chris S.

On a new smartphone app that enables users to snap a photo of a business card and have the information from the card automatically extracted and added to their contact list.  Parse the results of the optical character recognition (OCR) component in order to extract the name, phone number, and email address from the processed business card image.

Built with Apache Maven 3.5.2 and Java jdk1.8.0_161. 

To test and build an executable jar, run **mvn clean package**.  The jar will be created in **executionDir/target**.

To run the executable jar, go to the directory with the jar (/target).  Then run:  **java -jar chris-businesscard.jar {filepath}** The filepath should be a text
file with the text from a single business card in it.  The parsed output will go to stdout.   


Implementation notes:  Identifying names was fun! Current simple implementation is found in NameValidator.  It is naive, and consists of a negative selection for names--basically, if a line is pure text (no numbers or funny symbols) and doesn't have certain not-a-name keywords, like corporation, the program says it's the name.   With more time, a voting approach, which ranks each line of text with the likelihood that it was a name, and then chooses the best one, would be preferable.  Aside from selecting against dirty words like corporation or developer, looking at lists of names to boost the likelihood of getting the correct human name would be a good idea.  
