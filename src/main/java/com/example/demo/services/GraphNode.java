package com.example.demo.services;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphNode {

	private int vertices;
	private LinkedList<Integer> adjacencyList[];

	public GraphNode(int vertex) {
		vertices = vertex;
		adjacencyList = new LinkedList[vertex];
		for (int i = 0; i < vertex; ++i)
			adjacencyList[i] = new LinkedList();
	}

	// add source and destination and making it as an directed graph
	public void addEdgesInDirectedGraph(int src, int dest) {
		adjacencyList[src].add(dest);
		adjacencyList[dest].add(src);

	}

	public boolean checkPaths(int src, int dest) {

		boolean visitedNodes[] = new boolean[vertices];

		LinkedList<Integer> queueData = new LinkedList<Integer>();

		visitedNodes[src] = true;

		queueData.add(src);

		Iterator<Integer> idxAdj;

		while (queueData.size() != 0) {

			src = queueData.poll();
			int number;
			idxAdj = adjacencyList[src].listIterator();
			while (idxAdj.hasNext()) {

				number = idxAdj.next();
				if (number == dest)// If theres is a path return true
				{
					return true;
				}

				if (!visitedNodes[number]) {
					visitedNodes[number] = true;
					queueData.add(number);
				}
			}
		}

		return false;

	}

}
