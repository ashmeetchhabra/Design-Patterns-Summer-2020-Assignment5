package textdecorators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import textdecorators.util.InputDetails;
import textdecorators.util.MyLogger;
import textdecorators.util.MyLogger.DebugLevel;

public class MostFrequentWordDecorator extends AbstractTextDecorator {
	AbstractTextDecorator dec;
	InputDetails det;

	/**
	 * @param dec
	 * @param det
	 * @throws IOException
	 */
	public MostFrequentWordDecorator(AbstractTextDecorator dec, InputDetails det) throws IOException {
		MyLogger.writeMessage("MostFrequentWordDecorator Constructor", DebugLevel.CONSTRUCTOR);
		this.dec = dec;
		this.det = det;
	}

	/**
	 *Processes the input and add a MostFrequentWord decorator
	 */
	@Override
	public void processInputDetails()
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		System.out.println("In Most Frequent Word Decorator");
		MyLogger.writeMessage("In MostFrequentWordDecorator", DebugLevel.MOSTFREQUENTWORDDECORATOR);
		Map<String, Integer> frequencyCalculator = new HashMap<String, Integer>();
		Integer n;
		int prevMax = 1;
		String maxFreqWord = "";
		List<String> listOfSentences = det.getListOfSentences();
		List<String> listOfSentences1 = new ArrayList<String>();
		for (String sentence : listOfSentences) {
			String words[] = sentence.split(" ");
			for (String word : words) {
				if (frequencyCalculator.containsKey(word.toLowerCase())) {
					n = frequencyCalculator.get(word.toLowerCase());
					n++;
					frequencyCalculator.put(word.toLowerCase(), n);
					if (prevMax < n) {
						prevMax = n;
						maxFreqWord = word;
					}
				} else
					frequencyCalculator.put(word.toLowerCase(), 1);
			}
		}
		for (int j = 0; j < listOfSentences.size(); j++) {
			String sentence = listOfSentences.get(j);
			String words[] = sentence.split(" ");
			for (int i = 0; i < words.length; i++) {
				if (words[i].toLowerCase().equals(maxFreqWord)) {
					words[i] = "MOST_FREQUENT_" + words[i] + "_MOST_FREQUENT";
				}
			}
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < words.length; i++) {
				sb.append(words[i] + " ");
			}
			String sentence1 = sb.toString();
			MyLogger.writeMessage("MostFrequentWordDecorator_"+sentence1+"_MostFrequentWordDecorator", DebugLevel.MOSTFREQUENTWORDDECORATOR);
			listOfSentences1.add(sentence1);
		}
		det.setListOfSentences(listOfSentences1);

		if (null != dec) {
			dec.processInputDetails();
		}
	}
}
