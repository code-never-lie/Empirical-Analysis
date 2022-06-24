
import java.util.*;

import java.lang.*;

import java.io.*;

class Dijkstra

{

int mindis(int distance[], Boolean isSet[], int nov)

{

int min = Integer.MAX_VALUE;

int position=-1;

for (int v = 0; v < nov; v++)

if (isSet[v] == false && distance[v] <= min)

{

min = distance[v];

position = v;

}

return position;

}

void spath(int adjacencyMatrix[][], int source, int numberOfVertices)

{

int distance[] = new int[numberOfVertices];

Boolean isSet[] = new Boolean[numberOfVertices];

for (int i = 0; i < numberOfVertices; i++)

{

distance[i] = Integer.MAX_VALUE;

isSet[i] = false;

}

distance[source] = 0;

for (int count = 0; count < numberOfVertices-1; count++)

{

int u = mindis(distance, isSet, numberOfVertices);

isSet[u] = true;

for (int v = 0; v < numberOfVertices; v++)
if (!isSet[v] && adjacencyMatrix[u][v]!=0 &&

distance[u] != Integer.MAX_VALUE &&

distance[u]+adjacencyMatrix[u][v] < distance[v])

distance[v] = distance[u] + adjacencyMatrix[u][v];

}

System.out.println("\nSource - > destination = Distance");

for (int i = 0; i < numberOfVertices; i++)

System.out.println(source + " -> " + i+ " : "+distance[i]);

}

// Main

public static void main (String[] args)

{

int adjacenyMatrix[][] = new int[][]{{0, 2, 3, 0, 0, 0},

{2, 3, 4, 7, 7, 2},

{5, 2, 5, 7, 8, 9},

{0, 5, 0, 0, 1, 2},

{2, 3, 4, 7, 7, 2},

{5, 2, 5, 7, 8, 9}

};

Dijkstra dijkstra = new Dijkstra();

Scanner scanner = new Scanner(System.in);

System.out.print("\nEnter number of vertices : ");

int numberOfVertices = scanner.nextInt();

System.out.print("\nEnter source node: ");

int source = scanner.nextInt();

  

dijkstra.spath (adjacenyMatrix, source, numberOfVertices );

}

}