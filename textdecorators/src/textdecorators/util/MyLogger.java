package textdecorators.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyLogger {

	static BufferedWriter logWriter;

	public static enum DebugLevel {
		CONSTRUCTOR, FILE_PROCESSOR, NONE, ALL, ABSTRACTTEXTDECORATOR, KEYWORDDECORATOR, MOSTFREQUENTWORDDECORATOR,
		DRIVER, SENTENCEDECORATOR, ERROR, RESULTS, SPELLCHECKDECORATOR, INPUTDETAILS,
	};

	private static DebugLevel debugLevel;

	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 12:
			debugLevel = DebugLevel.ABSTRACTTEXTDECORATOR;
			break;
		case 11:
			debugLevel = DebugLevel.RESULTS;
			break;
		case 10:
			debugLevel = DebugLevel.ERROR;
			break;
		case 9:
			debugLevel = DebugLevel.KEYWORDDECORATOR;
			break;
		case 8:
			debugLevel = DebugLevel.DRIVER;
			break;
		case 7:
			debugLevel = DebugLevel.MOSTFREQUENTWORDDECORATOR;
			break;
		case 6:
			debugLevel = DebugLevel.SENTENCEDECORATOR;
			break;
		case 5:
			debugLevel = DebugLevel.SPELLCHECKDECORATOR;
			break;
		case 4:
			debugLevel = DebugLevel.ALL;
			break;
		case 3:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 2:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 1:
			debugLevel = DebugLevel.FILE_PROCESSOR;
			break;
		default:
			debugLevel = DebugLevel.NONE;
			break;
		}
	}

	/**
	 * @param levelIn
	 * sets the debuglevel
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	/**
	 * Writes the message to the file
	 * @param message
	 * @param levelIn
	 * @throws IOException
	 */
	public static void writeMessage(String message, DebugLevel levelIn) throws IOException {

		if (levelIn == DebugLevel.ERROR)
			System.err.println(message);
		else if (levelIn == debugLevel) {
			System.out.println(message);
			logWriter.write(message);
		}
	}

	public static void initLogger() throws IOException {
		logWriter = new BufferedWriter(new FileWriter("log.txt"));
	}

	/**Closes the log file
	 * @throws IOException
	 */
	public static void closeLogFile() throws IOException {
		logWriter.close();
	}

	public String toString() {
		return "The debug level has been set to the following " + debugLevel;
	}

}
