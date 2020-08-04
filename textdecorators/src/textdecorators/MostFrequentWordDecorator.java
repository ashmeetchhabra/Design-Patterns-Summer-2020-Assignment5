package textdecorators;

import textdecorators.util.InputDetails;

public class MostFrequentWordDecorator  extends AbstractTextDecorator {
	AbstractTextDecorator dec;
	InputDetails det;
	
	public MostFrequentWordDecorator(AbstractTextDecorator dec, InputDetails det) {
		this.dec=dec;
	}

	@Override
	void processInputDetails() {
		// TODO Auto-generated method stub
		
	}

}
