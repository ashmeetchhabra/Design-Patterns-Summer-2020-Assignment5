package textdecorators.util;

import java.io.IOException;
import java.nio.file.InvalidPathException;

public class InputDetails implements FileDisplayInterface, StdoutDisplayInterface {
	
	String inputFile,outputFile;
	
	public InputDetails(String inputFile, String outputFile){
		this.inputFile=inputFile;
		this.outputFile=outputFile;
	}

	@Override
	public void printToConsole(Object[] obj) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToFile(String str) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	public void processFile() {
		try {
		FileProcessor fp;
		fp = new FileProcessor(inputFile);
		String line,fileContents = "";
		while ((line = fp.poll()) != null) {
			fileContents+=line;
		}
		System.out.println("Contents of the file are::\n"+fileContents);
		} catch (InvalidPathException | SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	Call processContents which will call all the decorators one by one

}
