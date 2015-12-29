package First_Mobile.Price_Raja_App.Lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;
import java.io.FileReader;


public class Properties {
	
	public static String getPropertyValue(String propertyKey) throws IOException{
		String value = "";
		File deviceProperty = new File(".\\src\\test\\java\\First_Mobile\\Price_Raja_App\\Properties\\Device.properties");
		BufferedReader reader = new BufferedReader(new FileReader(deviceProperty));
		String line;
		Iterator<String> lines = reader.lines().iterator();
		while(lines.hasNext()){
			line=lines.next();
			if(line.contains(propertyKey)){
				value = line.split("=")[1];
			}
		}
		return value;
	}
}
