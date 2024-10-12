package utilities;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropReader {

	public Properties readPropertyFile(String fileName) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);

	      } catch(IOException fnfe) {
	         fnfe.printStackTrace();
	      } finally {
	         Objects.requireNonNull(fis).close();
	      }
	      return prop;

	}
}
