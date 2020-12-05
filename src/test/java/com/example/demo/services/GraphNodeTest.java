package com.example.demo.services;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

@ContextConfiguration(classes={GraphNodeTest.class})
@SpringBootTest
public class GraphNodeTest {
	
	
	
	@Test
	public void test_checkPathExistsForValidPath() {
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
		
		assertEquals(Boolean.TRUE, nodes.checkPaths(cityIndexMap.get(source), cityIndexMap.get(destination)));
	}
	@Test
	public void test_checkPathExistsForInValidPath() {
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
		assertEquals(Boolean.FALSE, nodes.checkPaths(cityIndexMap.get(source), cityIndexMap.get(destination)));
	}
	
	
	

}
