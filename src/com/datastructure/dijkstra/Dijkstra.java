package com.datastructure.dijkstra;


/**
 * Created by Joshua Freedman on 11/14/2016, based on Lafore Data Structures.
 */
public class Dijkstra {

  class DistPar {
    public int distance;
    public int parentVert;

    public DistPar(int pv, int d) {
      distance = d;
      parentVert = pv;
    }

  }

  class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char lab) {
      label = lab;
      isInTree = false;
    }

  }

  class Graph {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private int nTree;
    private DistPar sPath[];
    private int currentVert;
    private int startToCurrent;

    public Graph() {
      vertexList = new Vertex[MAX_VERTS];

      adjMat = new int[MAX_VERTS][MAX_VERTS];
      nVerts = 0;
      nTree = 0;
      for (int j = 0; j < MAX_VERTS; j++)
        for (int k = 0; k < MAX_VERTS; k++)
          adjMat[j][k] = INFINITY;
      sPath = new DistPar[MAX_VERTS];
    }

    public void addVertex(char lab) {
      vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
      adjMat[start][end] = weight;
    }

    public void path(int startTree) {

      vertexList[startTree].isInTree = true;
      nTree = 1;

      // save distance from start node to other
      for (int j = 0; j < nVerts; j++) {
        int tempDist = adjMat[startTree][j];
        sPath[j] = new DistPar(startTree, tempDist);
      }


      while (nTree < nVerts) {
    	// node have minimum distance of current node to other 
        int indexMin = getMin();
        int minDist = sPath[indexMin].distance;

        if (minDist == INFINITY) {
          System.out.println("There are unreachable vertices");
          break;
        } else {
          // make node minimum distance  to current node
          currentVert = indexMin;
          // distance current node to start node
          startToCurrent = sPath[indexMin].distance;
        }
        // not calculator
        vertexList[currentVert].isInTree = true;
        // continue for other node (not understand yet)
        nTree++;
        adjust_sPath();
      }

      displayPaths();

      nTree = 0;
      for (int j = 0; j < nVerts; j++)
        vertexList[j].isInTree = false;
    }

    public int getMin() {
      int minDist = INFINITY;
      int indexMin = 0;
      for (int j = 0; j < nVerts; j++) {
        if (!vertexList[j].isInTree && sPath[j].distance < minDist) {
          minDist = sPath[j].distance;
          indexMin = j;
        }
      }
      return indexMin;
    }

    public void adjust_sPath() {

      int column = 0;
      while (column < nVerts) {

        if (vertexList[column].isInTree) {
          column++;
          continue;
        }

        // real adjacency matrix
        int currentToFringe = adjMat[currentVert][column];

        int startToFringe = startToCurrent + currentToFringe;

        // old value distance 
        int sPathDist = sPath[column].distance;

        // if new value distance is smaller
        if (startToFringe < sPathDist) {
        	//  current  parent of other node
          sPath[column].parentVert = currentVert;
          sPath[column].distance = startToFringe;
        }
        column++;
      }
    }

    public void displayPaths() {
      for (int j = 0; j < nVerts; j++) {
        System.out.print(vertexList[j].label + "=");
        if (sPath[j].distance == INFINITY)
          System.out.print("inf");
        else
          System.out.print(sPath[j].distance);
        char parent = vertexList[sPath[j].parentVert].label;
        System.out.print("(" + parent + ") ");
      }
      System.out.println("");
    }

  }

  public static void main(String[] args) {
	Dijkstra app = new Dijkstra();
    Graph theGraph = app.new Graph();
    theGraph.addVertex('A');
    theGraph.addVertex('B');
    theGraph.addVertex('C');
    theGraph.addVertex('D');
    theGraph.addVertex('E');

    theGraph.addEdge(0, 1, 50);
    theGraph.addEdge(0, 3, 80);
    theGraph.addEdge(1, 2, 60);
    theGraph.addEdge(1, 3, 90);
    theGraph.addEdge(2, 4, 40);
    theGraph.addEdge(3, 2, 20);
    theGraph.addEdge(3, 4, 70);
    theGraph.addEdge(4, 1, 50);
    
    
    int vertex = 2;
    System.out.println("Shortest paths from vertex " + vertex + ":");
    theGraph.path(vertex);
    System.out.println();
  }

}

