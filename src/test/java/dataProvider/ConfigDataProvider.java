package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	public ConfigDataProvider() throws IOException{
	
	
	File src = new File("./Configuration/config.properties");
	try {
		FileInputStream fis = new FileInputStream(src);
		
		prop = new Properties();
		
		prop.load(fis);
		
	} catch (FileNotFoundException e) 
	{
	
	System.out.println(e.getMessage());
	}
	}
	
	public String getChromePath(){
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
	}
	
	public String getApplicationUrl(){
		String url = prop.getProperty("url");
		return url;
	}
}
