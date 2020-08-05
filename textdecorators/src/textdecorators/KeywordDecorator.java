package textdecorators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;

import textdecorators.util.FileProcessor;
import textdecorators.util.InputDetails;

public class KeywordDecorator extends AbstractTextDecorator {
	AbstractTextDecorator dec;
	InputDetails det;
	String fileName;

	public KeywordDecorator(AbstractTextDecorator dec, InputDetails det, String fileName) {
		this.dec = dec;
		this.det = det;
		this.fileName = fileName;
	}

	@Override
	public void processInputDetails()
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		System.out.println("In Keyword Decorator");
		List<String> listOfKeywords = keywordParser();
		List<String> listOfSentences1 = new ArrayList<String>();
		List<String> listOfSentences = det.getListOfSentences();
		for (String sentence : listOfSentences) {
			String words[] = sentence.split(" ");
			for (String keyword : listOfKeywords) {
				for (int i = 0; i < words.length; i++) {
					if (keyword.equals(words[i].toLowerCase()))
						words[i] = "KEYWORD_" + words[i] + "_KEYWORD";
				}
			}
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < words.length; i++) {
				sb.append(words[i] + " ");
			}
			String sentence1 = sb.toString();
			listOfSentences1.add(sentence1);
		}
		det.setListOfSentences(listOfSentences1);
		if (null != dec) {
			dec.processInputDetails();
		}
	}

	private List<String> keywordParser()
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		FileProcessor fp = new FileProcessor(fileName);
		List<String> listOfKeywords = new ArrayList<String>();

		String line;
		while ((line = fp.poll()) != null) {
			listOfKeywords.add(line);
		}
		return listOfKeywords;

	}

}
