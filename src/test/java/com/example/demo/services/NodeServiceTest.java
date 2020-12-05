package com.example.demo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.component.ConnectComponent;

@RunWith(SpringRunner.class)

@ContextConfiguration(classes={NodeServiceTest.class})
@SpringBootTest
public class NodeServiceTest {
	
	@InjectMocks
	NodeService nodeService;
	
	@Mock
	ConnectComponent connectComponent;
	
	@Test
	public void test_checkPathExistsValid() {
		NodeService nodeService = new NodeService();
		Map<String, Integer> cityIndexMap = new  HashMap<String, Integer>();		
		String source ="Boston";
		String destination ="Albany";
		cityIndexMap.put("Boston", 1);
		cityIndexMap.put("New York", 2);
		cityIndexMap.put("Trenton", 3);
		cityIndexMap.put("Albany", 4);
		cityIndexMap.put("New Jersey", 5);
		GraphNode nodes = new GraphNode(5);
		nodes.addEdgesInDirectedGraph(1, 2);
		nodes.addEdgesInDirectedGraph(2, 4);
		assertEquals(Boolean.TRUE, nodeService.checkPathExist(cityIndexMap, source, destination, nodes));
	}
	
	@Test
	public void test_checkPathExistsInValid() {
		NodeService nodeService = new NodeService();
		Map<String, Integer> cityIndexMap = new  HashMap<String, Integer>();		
		String source ="Boston";
		String destination ="Albany";
		cityIndexMap.put("Boston", 1);
		cityIndexMap.put("New York", 2);
		cityIndexMap.put("Trenton", 3);
		cityIndexMap.put("Albany", 4);
		cityIndexMap.put("New Jersey", 5);
		GraphNode nodes = new GraphNode(5);
		nodes.addEdgesInDirectedGraph(1, 2);
		nodes.addEdgesInDirectedGraph(2, 3);
		assertEquals(Boolean.FALSE , nodeService.checkPathExist(cityIndexMap, source, destination, nodes));
	}

	
	@Test
	public void test_getPathInValidRoute() {
		Set<String> listOfCities = new HashSet<String>();
		listOfCities.add("Boston");
		listOfCities.add("New York");
		listOfCities.add("Trenton");
		listOfCities.add("Albany");
		listOfCities.add("Newark");
		listOfCities.add("Philadelphia");
	
		String source ="Boston";
		String destination ="Albany";
		when(connectComponent.buildUniqueCities()).thenReturn(listOfCities);
		assertEquals("No", nodeService.getPath(source, destination));
	}
	
	@Test
	public void test_getPathValidRoute() {
		Set<String> listOfCities = new HashSet<String>();
		listOfCities.add("Boston");
		listOfCities.add("New York");
		listOfCities.add("Trenton");
		listOfCities.add("Albany");
		listOfCities.add("Newark");
		listOfCities.add("Philadelphia");
	
		String source ="Boston";
		String destination ="Newark";
		when(connectComponent.buildUniqueCities()).thenReturn(listOfCities);
		assertEquals("Yes", nodeService.getPath(source, destination));
	}
}
