package textdecorators.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import textdecorators.AbstractTextDecorator;
import textdecorators.KeywordDecorator;
import textdecorators.MostFrequentWordDecorator;
import textdecorators.SentenceDecorator;
import textdecorators.SpellCheckDecorator;
import textdecorators.util.InputDetails;
import textdecorators.util.MyLogger;
import textdecorators.util.MyLogger.DebugLevel;

/**
 * @author ashmeet kaur chhabra
 *
 */
public class Driver {
	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;

	/**
	 * @param args
	 * @throws InvalidPathException
	 * @throws SecurityException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		if ((args.length != 5) || (args[0].equals("${input}")) || (args[1].equals("${misspelled}"))
				|| (args[2].equals("${keywords}")) || (args[3].equals("${output}")) || (args[4].equals("${debug}"))) {

			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
					REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
			throw new RuntimeException("Incorrect number of arguments.");
		}
		try {
			MyLogger.setDebugValue(Integer.parseInt(args[4]));
			MyLogger.initLogger();
			MyLogger.writeMessage("In Driver", DebugLevel.DRIVER);

			if (args[0] == args[1])
				throw new RuntimeException("The input and misspelled files provided has same path or name");
			if (args[1] == args[2])
				throw new RuntimeException("The misspelled and and keyword files provided has same path or name");
			if (args[2] == args[0])
				throw new RuntimeException("The input and keyword files provided has same path or name");

			InputDetails inputD = new InputDetails(args[0], args[3]);
			AbstractTextDecorator sentenceDecorator = new SentenceDecorator(null, inputD);
			AbstractTextDecorator spellCheckDecorator = new SpellCheckDecorator(sentenceDecorator, inputD, args[1]);
			AbstractTextDecorator keywordDecorator = new KeywordDecorator(spellCheckDecorator, inputD, args[2]);
			AbstractTextDecorator mostFreqWordDecorator = new MostFrequentWordDecorator(keywordDecorator, inputD);
			mostFreqWordDecorator.processInputDetails();
			String finalContent = inputD.getFinalContent();
			inputD.writeToFile(finalContent);
			inputD.closeFile();
			MyLogger.closeLogFile();
		} catch (InvalidPathException | SecurityException | IOException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

}
