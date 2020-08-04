package textdecorators;

import textdecorators.util.InputDetails;

public class SpellCheckDecorator extends AbstractTextDecorator {
	AbstractTextDecorator dec;
	InputDetails det;
	
	public SpellCheckDecorator(AbstractTextDecorator dec, InputDetails det) {
		this.dec=dec;
	}

	@Override
	void processInputDetails() {
		// TODO Auto-generated method stub
		
	}

}
