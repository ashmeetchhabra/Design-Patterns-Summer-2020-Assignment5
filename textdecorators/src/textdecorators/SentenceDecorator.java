package textdecorators;

import textdecorators.util.InputDetails;

public class SentenceDecorator  extends AbstractTextDecorator {
	AbstractTextDecorator dec;
	InputDetails det;
	
	public SentenceDecorator(AbstractTextDecorator dec, InputDetails det) {
		this.dec=dec;
	}

	@Override
	void processInputDetails() {
		// TODO Auto-generated method stub
		
	}

}
