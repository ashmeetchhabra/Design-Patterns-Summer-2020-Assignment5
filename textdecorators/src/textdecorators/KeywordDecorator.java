package textdecorators;

import textdecorators.util.InputDetails;

public class KeywordDecorator extends AbstractTextDecorator {
	AbstractTextDecorator dec;
	InputDetails det;
	
	public KeywordDecorator(AbstractTextDecorator dec, InputDetails det) {
		this.dec=dec;
	}

	@Override
	void processInputDetails() {
		// TODO Auto-generated method stub
		
	}

}
