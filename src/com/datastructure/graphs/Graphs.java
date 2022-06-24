package com.datastructure.graphs;


public class Graphs {

	private final int MAX_VERTS = 10;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private StackX theStack;
	private Queue theQueue;
	private char sortedArray[];
	
	public Graphs() {
		vertexList = new Vertex[MAX_VERTS];
		
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j = 0; j < MAX_VERTS; j++) {
			for(int k = 0; k < MAX_VERTS; k++) {
				adjMat[j][k] = 0;
			}
		}
		
		theStack = new StackX();
		theQueue = new Queue();
		sortedArray = new char[MAX_VERTS];
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEgde(int start,int end) {
		adjMat[start][end] = 1;
		//adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	
	public int getAdjUnvisitedVertex(int v) {
		for(int j = 0; j < nVerts; j++) {
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
				return j;
			}
		}
		return -1;
	}
	
	public void dfs() {

		vertexList[0].wasVisited = true;
		displayVertex(0);
		theStack.push(0);
		
		
		
		while(!theStack.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStack.peek());
			if(v == -1) {
				theStack.pop();
			} else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		for(int j = 0; j < nVerts; j++) {
			vertexList[j].wasVisited = false;
		}
		
		
	}
	
	public void bfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theQueue.insert(0);
		int v2;
		
		while(!theQueue.isEmpty()) {
			int v1 = theQueue.remove();
			while((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				theQueue.insert(v2);
			}
		}
		
		for(int j = 0; j < nVerts; j++) {
			vertexList[j].wasVisited = false;
		}
		
		
	}
	
	public void minimumSpanningTree() {
		vertexList[0].wasVisited = true;
		theStack.push(0);
		
		while(!theStack.isEmpty()) {
			int currentVertex = theStack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if(v == -1) {
				theStack.pop();
			} else {
				vertexList[v].wasVisited = true;
				theStack.push(v);
				
				displayVertex(currentVertex);
				displayVertex(v);
				System.out.println(" ");
			}
		}
		
		for(int j =0; j < nVerts; j++) {
			vertexList[j].wasVisited = false;
		}
	}
	
	
	public void topo() {
		int orig_nVerts = nVerts;
		while(nVerts > 0) {
			int currentVertex = noSuccessors();
			if(currentVertex == -1) {
				System.out.println("ERRR: Graph has cycles");
				return;
			}
			Vertex v = vertexList[currentVertex];
			sortedArray[nVerts - 1] = v.label;
			deleteVertex(currentVertex);
		}
		System.out.println("Topologically sorted order:");
		for(int j = 0; j < orig_nVerts; j++) {
			System.out.print(sortedArray[j]);
			System.out.println("");
		}
		
	}
	
	
	public int noSuccessors() {
		boolean isEdge;
		int result = -1;
		for(int row = 0; row < nVerts; row++) {
			isEdge = false;
			for(int col = 0; col < nVerts; col++) {
				if(adjMat[row][col] > 0) {
					isEdge = true;
					break;
				}
			}
			
			if(!isEdge) {
				result = row;
			}
			
		}
		return result;
	}
	
	public void deleteVertex(int delVert) {
		if(delVert == nVerts - 1) {
			for(int j = delVert; j < nVerts ; j++) {
				vertexList[j] = vertexList[j + 1];
			}
			
			for(int row = delVert; row > nVerts ; row++) {
				moveRowUp(row, nVerts);
			}
			
			for(int col = delVert; col > nVerts ; col++) {
				moveRowLeft(col, nVerts - 1);
			}
			
			
		}
		nVerts--;
	}
	
	private void moveRowUp(int row, int length) {
		for(int col = 0; col < length; col++) {
			adjMat[row][col] = adjMat[row+1][col];
		}
	}
	
	private void moveRowLeft(int col, int length) {
		for(int row = 0; row < length; row++) {
			adjMat[row][col] = adjMat[row][col+1];
		}
	}
}














