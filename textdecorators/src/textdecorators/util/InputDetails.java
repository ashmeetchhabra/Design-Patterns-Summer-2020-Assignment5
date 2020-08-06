package textdecorators.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Arrays;
import java.util.List;

import textdecorators.util.MyLogger.DebugLevel;

public class InputDetails implements FileDisplayInterface, StdoutDisplayInterface {

	BufferedWriter write;
	String inputFile, outputFile;
	private String fileContents = "";
	private List<String> listOfSentences;
	private String finalContent = "";

	/**
	 * @param inputFile
	 * @param outputFile
	 * @throws IOException
	 */
	public InputDetails(String inputFile, String outputFile) throws IOException {
		MyLogger.writeMessage("Input Details Constructor", DebugLevel.CONSTRUCTOR);
		write = new BufferedWriter(new FileWriter(outputFile));
		this.inputFile = inputFile;
		this.outputFile = outputFile;
		processFile();
		processContents();
	}

	/**
	 *Prints to console
	 */
	@Override
	public void printToConsole(Object[] obj) throws IOException {
//		MyLogger.writeMessage("Printing to console", DebugLevel.RESULTS);
		for (int i = 0; i < obj.length; i++) {
			System.out.print(obj[i]);
		}
	}

	/**
	 *Writes to a file
	 */
	@Override
	public void writeToFile(String str) throws IOException {
		MyLogger.writeMessage("Data is written to a file", DebugLevel.INPUTDETAILS);
		write.write(str);
	}

	/**
	 * Reads data from a file 
	 * @return String
	 * @throws InvalidPathException
	 * @throws SecurityException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String processFile() throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		FileProcessor fp;
		fp = new FileProcessor(inputFile);
		String line;
		int lineCount = 0;
		while ((line = fp.poll()) != null) {
			
			if(!line.matches("[a-zA-Z0-9\\.,\\s]*"))
				throw new RuntimeException("Incorrect Format of Input File");
				
			
			if (lineCount > 0)
				fileContents += "\n";
			lineCount++;
			fileContents += line;
		}

		if (lineCount<=0)
			throw new RuntimeException("Empty Input file");

		return fileContents;
	}

	/**
	 * @return List<String>
	 */
	public List<String> getListOfSentences() {
		return listOfSentences;
	}

	/**
	 * sets list of sentences
	 * @param listOfSentences
	 * @throws IOException 
	 */
	public void setListOfSentences(List<String> listOfSentences) throws IOException {
		MyLogger.writeMessage("updating the sentences in Input details", DebugLevel.INPUTDETAILS);
		this.listOfSentences = listOfSentences;
	}

	/**
	 * splits the contents of file by . 
	 */
	private void processContents() {
		String sentenceArr[] = fileContents.split("\\.");
		listOfSentences = Arrays.asList(sentenceArr);
	}

	/**
	 * Closes the file
	 * @throws IOException
	 */
	public void closeFile() throws IOException {
		MyLogger.writeMessage("Closing of the file", DebugLevel.INPUTDETAILS);
		write.close();
	}

	/**
	 * @return Final content after joining the sentences
	 * @throws IOException 
	 */
	public String getFinalContent() throws IOException {
		MyLogger.writeMessage("Return String after joining sentences", DebugLevel.INPUTDETAILS);
		List<String> sentences = getListOfSentences();
		for (String sentence : sentences) {
			finalContent += sentence;
		}
		System.out.println(finalContent);
		return finalContent;
	}

}
