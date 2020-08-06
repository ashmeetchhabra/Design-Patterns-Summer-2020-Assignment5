package textdecorators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;

import textdecorators.util.InputDetails;
import textdecorators.util.MyLogger;
import textdecorators.util.MyLogger.DebugLevel;

public class SentenceDecorator extends AbstractTextDecorator {
	private AbstractTextDecorator dec;
	private InputDetails det;

	public SentenceDecorator(AbstractTextDecorator dec, InputDetails det) throws IOException {
		MyLogger.writeMessage("SentenceDecorator Constructor", DebugLevel.CONSTRUCTOR);
		this.dec = dec;
		this.det = det;
	}

	/**
	 *Processes the input and add a sentence decorator
	 */
	@Override
	public void processInputDetails()
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		MyLogger.writeMessage("In Sentence Decorator", DebugLevel.SENTENCEDECORATOR);
		System.out.println("In Sentence Decorator");
		List<String> listOfSentences = det.getListOfSentences();
		List<String> listOfSentences1 = new ArrayList<String>();
		for (String sentence : listOfSentences) {
			String sentence1 = "BEGIN_SENTENCE__" + sentence + "__END_SENTENCE.";
			MyLogger.writeMessage("SentenceDecorator_"+sentence1+"_SentenceDecorator", DebugLevel.SENTENCEDECORATOR);
			listOfSentences1.add(sentence1);
		}
		det.setListOfSentences(listOfSentences1);
		if (null != dec) {
			dec.processInputDetails();
		}
	}
}
