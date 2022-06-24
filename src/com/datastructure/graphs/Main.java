package com.datastructure.graphs;

public class Main {

	public static void main(String[] args) {

		Graphs graphs = new Graphs();
		
		graphs = topoData(graphs);
		
		//graphs.dfs();

		//graphs.bfs();
		graphs.topo();
	}

	
	public static Graphs search(Graphs graphs) {
		graphs.addVertex('A');
		graphs.addVertex('B');
		graphs.addVertex('C');
		graphs.addVertex('D');
		graphs.addVertex('E');

		
		graphs.addEgde(0, 1);
		graphs.addEgde(1, 2);
		graphs.addEgde(0, 3);
		graphs.addEgde(3, 4);
		
		return graphs;
	}
	
	
	public static Graphs minimumSpanningTreeData(Graphs graphs) {

		graphs.addVertex('A');
		graphs.addVertex('B');
		graphs.addVertex('C');
		graphs.addVertex('D');
		graphs.addVertex('E');

		graphs.addEgde(0, 1);
		graphs.addEgde(0, 2);
		graphs.addEgde(0, 3);
		graphs.addEgde(0, 4);

		graphs.addEgde(1, 2);
		graphs.addEgde(1, 3);
		graphs.addEgde(1, 4);
		
		graphs.addEgde(2, 3);
		graphs.addEgde(2, 4);
		
		graphs.addEgde(3, 4);

		return graphs;
	}
	
	
	public static Graphs topoData(Graphs graphs) {

		graphs.addVertex('A');
		graphs.addVertex('B');
		graphs.addVertex('C');
		
		graphs.addVertex('D');
		graphs.addVertex('E');
		graphs.addVertex('F');
		
		graphs.addVertex('G');
		graphs.addVertex('H');
		
		
		graphs.addEgde(0, 3);
		graphs.addEgde(0, 4);
		graphs.addEgde(1, 4);
		
		graphs.addEgde(2, 5);
		graphs.addEgde(3, 6);
		graphs.addEgde(4, 6);
		
		graphs.addEgde(5, 7);
		graphs.addEgde(6, 7);
		
		return graphs;
	}
	
	
	public static Graphs topoSimple(Graphs graphs) {

		graphs.addVertex('A');
		//graphs.addVertex('B');
		//graphs.addVertex('C');
		graphs.addVertex('B');
		//graphs.addVertex('E');
		//graphs.addVertex('F');
		graphs.addVertex('C');
		graphs.addVertex('D');
		
		
		graphs.addEgde(0, 1);
		//graphs.addEgde(0, 4);
		//graphs.addEgde(1, 4);
		
		//graphs.addEgde(2, 5);
		graphs.addEgde(1, 2);
		//graphs.addEgde(4, 6);
		//graphs.addEgde(5, 7);
		graphs.addEgde(2, 3);
		
		return graphs;
	}
	
	
	
	
	
	
}
