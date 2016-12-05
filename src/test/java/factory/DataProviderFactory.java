package factory;

import java.io.IOException;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	
	
	public static ConfigDataProvider getConfig() throws IOException
	{
	
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}
	public static ExcelDataProvider getExcel() throws IOException
	{
	
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
	}
}
