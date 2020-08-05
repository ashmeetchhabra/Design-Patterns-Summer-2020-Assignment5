package textdecorators.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Arrays;
import java.util.List;


public class InputDetails implements FileDisplayInterface, StdoutDisplayInterface {
	
	BufferedWriter write;
	String inputFile,outputFile;
	private String fileContents="";
	private List<String> listOfSentences;
	private String finalContent="";
	
	
	public InputDetails(String inputFile, String outputFile) throws IOException{
		write = new BufferedWriter(new FileWriter(outputFile));
		this.inputFile=inputFile;
		this.outputFile=outputFile;
		processFile();
		processContents();
	}

	@Override
	public void printToConsole(Object[] obj) throws IOException {
//		MyLogger.writeMessage("Printing to console", DebugLevel.RESULTS);
		for (int i = 0; i < obj.length; i++) {
			System.out.print(obj[i]);
		}
	}

	@Override
	public void writeToFile(String str) throws IOException {
//		MyLogger.writeMessage("Data is written to a file", DebugLevel.RESULTS);
		write.write(str);
	}
	
	public String processFile() {
		
		try {
		FileProcessor fp;
		fp = new FileProcessor(inputFile);
		String line;
		while ((line = fp.poll()) != null) {
			fileContents+=line;
		}
		System.out.println("Contents of the file are::\n"+fileContents);

		} catch (InvalidPathException | SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileContents;
	}
	
	public void printContents() {
		System.out.println("\nIn Input Details:::PRINTING STRING");
		System.out.println(fileContents);
	}

	
	public List<String> getListOfSentences() {
		return listOfSentences;
	}
	
	public void setListOfSentences(List<String> listOfSentences) {

		this.listOfSentences = listOfSentences;
	}
	
	private void processContents() { 
		System.out.println(fileContents);
	String sentenceArr[]=fileContents.split("\\.");
	listOfSentences = Arrays.asList(sentenceArr);
	}
	public void closeFile() throws IOException {
//		MyLogger.writeMessage("Closing of the file", DebugLevel.RESULTS);
		write.close();
	}
	
	public String getFinalContent() {
		List<String> sentences =getListOfSentences();
		for (String sentence : sentences) {
			System.out.println(sentence);
			finalContent +=sentence;
		}
		return finalContent;	
	}


}
