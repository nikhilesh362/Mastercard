package com.example.demo.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.component.ConnectComponent;
/*
 * Service class which will find path is valid or not
 */
@Service
public class NodeService {

	@Autowired
	ConnectComponent connectComponent;
	


	/**
	 * @param source
	 * @param destination
	 * @return yes or no
	 */
	public String getPath(String source, String destination) {
		String FLAG = "No";

		Set<String> listCities = new HashSet<String>();
		Map<String, Integer> cityIndexMap = new HashMap<String, Integer>();

		try {
			listCities = connectComponent.buildUniqueCities();

			int key = 0;
			for (String lst : listCities) {
				cityIndexMap.put(lst, key);
				key++;

			}
			GraphNode nodes = new GraphNode(listCities.size());
			addNodes(nodes, cityIndexMap);
			return checkPathExist(cityIndexMap, source, destination, nodes) ? "Yes" : "No";

		} catch (IOException e) {
			e.printStackTrace();
		}

		return FLAG;
	}
	
	
	

	/**
	 * @param nodes
	 * @param cityIndexMap
	 * @throws IOException
	 * 
	 *  This is used for adding edges between nodes from text file and build the directed graph
	 */
	public void addNodes(GraphNode nodes, Map<String, Integer> cityIndexMap) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/city.txt"));
		String line = reader.readLine();
		while (line != null) {

			String[] citiesFromFile = line.split(",");
			int src = cityIndexMap.get(citiesFromFile[0].trim());
			int dest = cityIndexMap.get(citiesFromFile[1].trim());
			nodes.addEdgesInDirectedGraph(src, dest);
			line = reader.readLine();

		}
		reader.close();

	}

	/**
	 * @param cityIndexMap
	 * @param source
	 * @param destination
	 * @param nodes
	 * @return True or False
	 * 
	 * This method check if the route exist
	 * 
	 */
	public boolean checkPathExist(Map<String, Integer> cityIndexMap, String source, String destination,
			GraphNode nodes) {

		if (cityIndexMap.get(source) != null && cityIndexMap.get(destination) != null) {
			int srcIdx = cityIndexMap.get(source);
			int destIdx = cityIndexMap.get(destination);

			if (nodes.checkPaths(srcIdx, destIdx)) {
				return true;
			}

		}

		return false;

	}

}
