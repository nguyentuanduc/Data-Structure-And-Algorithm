package com.datastructure.astar;

import java.util.ArrayList;
import java.util.List;

import com.datastructure.astar.StatAlgoritgm.Vertex;

public class StatAlgoritgm {

	class Vertex {
		
		public String value;
		public Integer index;
		public Integer x;
		public Integer y;
		public Integer g;
		public Integer f;
		public Vertex parent;
		
		public Vertex(String value, Integer index, Integer x, Integer y) {
			this.value = value;
			this.index = index;
			this.x = x;
			this.y = y;
			this.f = 0;
		}
		
		public Integer h(Vertex destination) {
			System.out.println( "destination.x = " + destination.x );
			System.out.println( "this.x = " + this.x);
			System.out.println( "destination.y = " + destination.y);
			System.out.println( "this.y = " + this.y);
			System.out.println( "this.value = " + this.value);
			Integer sum = Integer.sum((destination.x - this.x), (destination.y - this.y));
			System.out.println( "h = " + sum);
			return sum;
		}
		
	}
	

	class Graph {
		public Integer TOTAL_VERTICES   = 4;//52
		public Vertex[] vertices;
		private Integer[][] adjacencyMatrix;
		private Integer iVertex;
		
		public Graph() {
			this.vertices = new Vertex[TOTAL_VERTICES];
			this.adjacencyMatrix = new Integer[TOTAL_VERTICES][TOTAL_VERTICES];
			this.iVertex = 0;
			
			for(int j = 0; j < TOTAL_VERTICES; j++) {
				for(int k = 0; k < TOTAL_VERTICES; k++) {
					adjacencyMatrix[j][k] = 0;
				}
			}
		}
		
		public void addVertex(Integer value ,String index, Integer x, Integer y) {
			vertices[iVertex] = new Vertex(index, value, x, y);
			iVertex += 1;
		}

		public void AddEdge(Integer startVertex, Integer endVertex, Integer weight) {
			adjacencyMatrix[startVertex][endVertex] = weight;
			adjacencyMatrix[endVertex][startVertex] = weight;
		}
	   
		public List<String>  aStatAlgoritgm(Integer start , Integer destination  ) {
			java.util.List<Integer> openVertices = new ArrayList<Integer>();
			java.util.List<Integer> closedVertices = new ArrayList<Integer>();
			java.util.List<Integer> unvisitedVertices = new ArrayList<Integer>();
			Vertex currentVertex;

			for(int j = 0; j < TOTAL_VERTICES; j++) {
				unvisitedVertices.add(j);
			}
			//unvisitedVertices.remove(start);
			unvisitedVertices.set(start, 0);
			currentVertex = vertices[start];
			
			vertices[start].g = 0;
			vertices[start].f =  vertices[start].g +  vertices[start].h(vertices[destination]);
			
			while(currentVertex != vertices[destination]) {
				for(int i = 0; i < TOTAL_VERTICES; i++) {
					System.out.println("currentVertex index " + currentVertex.index);
					System.out.println("i " + i);

					if(adjacencyMatrix[currentVertex.index][i] > 0) {
						if(!closedVertices.contains(i) && !openVertices.contains(i)) {
							unvisitedVertices.set(i, 0); // unvisitedVertices.remove(i);
			                openVertices.add(i);
			                vertices[i].parent = currentVertex;
						}
					
			            Integer g = currentVertex.g + adjacencyMatrix[currentVertex.index][i];
			            Integer f = g + vertices[i].h(vertices[destination]);
			            
			            // f = 0 : node not add calculator 
			            // f <   : found a new path, that shorter 
			            if((vertices[i].f == 0) || (f < vertices[i].f)) {
			            	vertices[i].f = f;
			            	vertices[i].g = g;
			            	vertices[i].parent = currentVertex;
			            }
					}
				}
			    closedVertices.add(currentVertex.index);
			    
			    Integer iSmallestf = 1000;
			    Integer iNextCurrent = 0;
			    
			    // find smallest node to continue
			    for (Integer i : openVertices) {
			    	if(vertices[i].f < iSmallestf) {
			    		iSmallestf = vertices[i].f;
			    		iNextCurrent = i;
			    	}
			    }
			    
			    openVertices.remove(iNextCurrent);
			    currentVertex = vertices[iNextCurrent];
			}
			
			List<String> shortestpath = new ArrayList<>();
		    Vertex v;
		    v = vertices[destination];
		    while(v != null) {
		    	shortestpath.add(v.value);
		        v = v.parent;
		    }
		    //shortestpath.reverse();
		    shortestpath.add(currentVertex.g.toString());
		     
		    return shortestpath;
		}
	}
	
	
	public static void main(String[] args) {
		StatAlgoritgm statAlgoritgm = new StatAlgoritgm();
		Graph graph = statAlgoritgm.new Graph();
		  
		//graph.addVertex(0, "A", 0, 8);
		graph.addVertex(0, "A", 0, 7); // de h tu A toi D lon hon tu B toi D
		graph.addVertex(1, "B", 2, 11);
		graph.addVertex(2, "C", 3, 8);
		graph.addVertex(3, "D", 4, 12);
		
		
		graph.AddEdge(0, 1, 5);
		graph.AddEdge(0, 2, 5);
		
		graph.AddEdge(1, 0, 5);
		graph.AddEdge(1, 2, 4);
		graph.AddEdge(1, 3, 3);
		
		graph.AddEdge(2, 0, 5);
		graph.AddEdge(2, 1, 4);
		graph.AddEdge(2, 3, 7);
		
		graph.AddEdge(3, 1, 3);
		graph.AddEdge(3, 2, 7);
		List<String> path = graph.aStatAlgoritgm(0, 3);
		
		for (String e : path) {
			System.out.println(e);
		}
	  }
}




















