package textdecorators.driver;

import java.io.IOException;
import java.nio.file.InvalidPathException;

import textdecorators.util.FileProcessor;

public class Driver {
	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;

	public static void main(String[] args) {

		if ((args.length != 5) || (args[0].equals("${input}")) || (args[1].equals("${misspelled}"))
				|| (args[2].equals("${keywords}")) || (args[3].equals("${output}"))
				|| (args[4].equals("${debug}"))) {

			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
					REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
			throw new RuntimeException("Incorrect number of arguments.");
		}
		
		FileProcessor fp;
		try {
			fp = new FileProcessor(args[0]);
		
		String line;
		while ((line = fp.poll()) != null) {
//			MyLogger.writeMessage("Reading of input file", DebugLevel.DRIVER);
//			HashMap<String, Object> hm = (HashMap<String, Object>) lh.lineInputProcessor(line);
//			th.insert(hm);
		}
		} catch (InvalidPathException | SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
