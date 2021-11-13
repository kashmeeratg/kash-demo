package eventListeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class justlikethat {

	public static void main(String[] args) throws IOException {
		String path = new File("src/main/resources/data.properties").getAbsolutePath();
		Properties prop = new Properties();
		FileInputStream fileStream = new FileInputStream(path);
		prop.load(fileStream);
		System.out.println(prop.get("url"));
		
		Enumeration keys = prop.propertyNames();
		
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			System.out.println(key+" ="+prop.get(key));
			
		}
		
		fileStream.close();
	}

}
