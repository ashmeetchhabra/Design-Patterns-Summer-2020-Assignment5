package textdecorators.driver;

import java.io.IOException;
import java.nio.file.InvalidPathException;

import textdecorators.util.FileProcessor;
import textdecorators.util.InputDetails;

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
		
		InputDetails id = new InputDetails(args[0], args[3]);
		id.processFile();
		
		
	}

}
