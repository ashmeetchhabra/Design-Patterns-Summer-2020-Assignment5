package textdecorators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public abstract class AbstractTextDecorator {
	public abstract void processInputDetails() throws InvalidPathException, SecurityException, FileNotFoundException, IOException;
	

}
