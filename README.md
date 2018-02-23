Skills Demonstration for Chris S.

On a new smartphone app that enables users to snap a photo of a business card and have the information from the card automatically extracted and added to their contact list.  Parse the results of the optical character recognition (OCR) component in order to extract the name, phone number, and email address from the processed business card image.

Built with Apache Maven 3.5.2 and Java jdk1.8.0_161. 

To test and build an executable jar, run **mvn clean package**.  The jar will be created in **executionDir/target**.

To run the executable jar, go to the directory with the jar (/target).  Then run:  **java -jar chris-businesscard.jar {filepath}** The filepath should be a text
file with the text from a single business card in it.  The parsed output will go to stdout.   


Implementation notes:  Identifying names was fun! Current simple implementation is found in NameValidator.  It is naive, and consists primarily of a negative selection for names.  Basically, it chooses the first line to match these criteria:  if a line has two or more whitespace separated words (tokens), is pure text (no numbers or funny symbols) and doesn't have certain not-a-name keywords, like corporation, the program says it's the name.   A better approach would be to use a more sophisticated NLP algorithm.  Probably a voting approach would be best, where each line was scored with likelihood it was a name.  It would then choose the best one instead of the first one.  An additional criteria for names would be to have a list of human names and compare tokens to that name list.  I would also look at some of the freely available NLP libraries out there for identifying names in web text.  Stanford seems to have a good one, and there are a lot of articles.   
