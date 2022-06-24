import java.util.*;

import java.lang.*;

import java.io.*;

class bmf

{

class Node

{

int source, destination, weight;

Node()

{

source = destination = weight = 0;

}

};

int V, E;

Node array[];



bmf(int v, int e)

{

V = v;

E = e;

array = new Node[e];

for (int i=0; i<e; ++i)

array[i] = new Node();

}


void method(bmf obj,int source)

{

int V = obj.V, E = obj.E;

int dist[] = new int[V];

for (int i=0; i<V; ++i)

{

dist[i] = Integer.MAX_VALUE;

}

dist[source] = 0;

for (int i=1; i<V; ++i)

{

for (int j=0; j<E; ++j)

{

int x = obj.array[j].source;

int y = obj.array[j].destination;

int weight = obj.array[j].weight;

if (dist[x]!=Integer.MAX_VALUE &&dist[x]+weight<dist[y])

{

dist[y]=dist[x]+weight;

}

}

}

for (int j=0; j<E; ++j)

{

int u = obj.array[j].source;

int v = obj.array[j].destination;

int weight = obj.array[j].weight;

if (dist[u] != Integer.MAX_VALUE &&dist[u]+weight < dist[v])

{

System.out.println("graph contains negative weight cycle");

}

}

printResults(dist, V);

}


void printResults(int dist[], int V)

{

System.out.println("Vertex Distance from Source");

for (int i=0; i<V; ++i)

System.out.println(i+"\t\t"+dist[i]);

}

//main method

public static void main(String[] args)

{

int V = 4; 

int E = 7;

bmf obj = new bmf(V, E);

obj.array[0].source = 0;

obj.array[0].destination = 1;

obj.array[0].weight = -2;
obj.array[1].source = 1;

obj.array[1].destination = 0;

obj.array[1].weight = 2;

obj.array[2].source = 0;

obj.array[2].destination = 2;

obj.array[2].weight = 5;

obj.array[3].source = 1;

obj.array[3].destination = 2;

obj.array[3].weight = 2;

obj.array[4].source = 1;

obj.array[4].destination = 3;

obj.array[4].weight = 6;

obj.array[5].source = 3;

obj.array[5].destination = 1;

obj.array[5].weight = -3;

obj.array[6].source = 3;

obj.array[6].destination = 2;

obj.array[6].weight = 8;

System.out.println("When source vertex is A  ");

obj.method(obj, 0);

System.out.println("When source vertex is B ");

obj.method(obj, 1);

System.out.println("When source vertex is C ");

obj.method(obj, 2);

System.out.println("When source vertex is D  ");

obj.method(obj, 3);

}

}