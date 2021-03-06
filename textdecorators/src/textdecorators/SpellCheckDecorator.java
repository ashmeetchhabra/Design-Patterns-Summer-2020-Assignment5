package textdecorators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;

import textdecorators.util.FileProcessor;
import textdecorators.util.InputDetails;
import textdecorators.util.MyLogger;
import textdecorators.util.MyLogger.DebugLevel;

public class SpellCheckDecorator extends AbstractTextDecorator {
	AbstractTextDecorator dec;
	InputDetails det;
	String fileName;

	/**
	 * @param dec
	 * @param det
	 * @param fileName
	 * @throws IOException
	 */
	public SpellCheckDecorator(AbstractTextDecorator dec, InputDetails det, String fileName) throws IOException {
		MyLogger.writeMessage("SpellCheckDecorator Constructor", DebugLevel.CONSTRUCTOR);
		this.dec = dec;
		this.det = det;
		this.fileName = fileName;
	}

	/**
	 *Processes the input and add a spellcheck decorator
	 */
	@Override
	public void processInputDetails()
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		MyLogger.writeMessage("In SpellCheckDecorator", DebugLevel.SPELLCHECKDECORATOR);
		System.out.println("In SpellCheck Decorator");
		List<String> listOfKeywords = spellcheckParser();
		List<String> listOfSentences1 = new ArrayList<String>();
		List<String> listOfSentences = det.getListOfSentences();
		for (String sentence : listOfSentences) {
			String words[] = sentence.split(" ");
			for (String keyword : listOfKeywords) {
				for (int i = 0; i < words.length; i++) {
					if (keyword.equals(words[i].toLowerCase()))
						words[i] = "SPELLCHECK_" + words[i] + "_SPELLCHECK";
				}
			}
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < words.length; i++) {
				sb.append(words[i] + " ");
			}
			String sentence1 = sb.toString();
			MyLogger.writeMessage("SpellCheckDecorator_"+sentence1+"_SpellCheckDecorator", DebugLevel.SPELLCHECKDECORATOR);
			listOfSentences1.add(sentence1);
		}
		det.setListOfSentences(listOfSentences1);

		if (null != dec) {
			dec.processInputDetails();
		}

	}

	private List<String> spellcheckParser()
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		boolean isMissplelledFileEmpty=true;
		FileProcessor fp = new FileProcessor(fileName);
		List<String> listOfKeywords = new ArrayList<String>();

		String line;
		while ((line = fp.poll()) != null) {
			isMissplelledFileEmpty=false;
			listOfKeywords.add(line);
		}
		if(isMissplelledFileEmpty)
			throw new RuntimeException("Missplelled File is Empty");
		return listOfKeywords;

	}

}
