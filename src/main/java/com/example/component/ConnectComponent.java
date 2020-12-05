package com.example.component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ConnectComponent {
	
	BufferedReader reader;
	Set<String> listCities = new HashSet<String>();
	
	
	
	/**
	 * @throws IOException
	 * 
	 * Adding unique cities from the file
	 */
	public void buildConnect() throws IOException {
		
		reader = new BufferedReader(new FileReader(
				"src/main/resources/city.txt"));
		String line = reader.readLine();
		while (line != null) {
			
			String[] citiesFromFile  = line.split(",");
			listCities.add(citiesFromFile[0].trim());
			listCities.add(citiesFromFile[1].trim());
			line = reader.readLine();
			
			
		}
		reader.close();
		
	}
	
	public Set<String> buildUniqueCities() {
		return listCities;
	}

}
