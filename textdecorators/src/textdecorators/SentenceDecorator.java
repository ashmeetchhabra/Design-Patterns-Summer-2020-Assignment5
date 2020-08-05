package textdecorators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;

import textdecorators.util.InputDetails;

public class SentenceDecorator  extends AbstractTextDecorator {
	private AbstractTextDecorator dec;
	private InputDetails det;
	
	public SentenceDecorator(AbstractTextDecorator dec, InputDetails det) {
		this.dec=dec;
		this.det=det;
	}
	@Override
	public void processInputDetails() throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		System.out.println("In Sentence Decorator");
		List<String> listOfSentences = det.getListOfSentences();
		List<String> listOfSentences1 = new ArrayList<String>();
		for (String sentence : listOfSentences) {
			String sentence1 = "BEGIN_SENTENCE__"+sentence+"__END_SENTENCE.";
			listOfSentences1.add(sentence1);
		}
		det.setListOfSentences(listOfSentences1);
		if (null != dec) {
			dec.processInputDetails();
		}
	}
}
