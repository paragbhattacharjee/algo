package com.practise.algo.service.graph;

import com.practise.algo.entity.AdjacencyList;
import com.practise.algo.entity.Node;
import com.practise.algo.entity.SingleLinkedList;

import java.util.HashMap;
import java.util.Map;

public class Dfs {

    private AdjacencyList adjacencyList;

    private Map<Integer, Integer> parent = new HashMap<>();

    private int[] traversedVertices = new int[20];

    private int counter = 0;

    public Dfs(AdjacencyList adjList) {
        adjacencyList = adjList;
    }

    /* Visit from a given vertex. Recursively to all connected vertices */
    private void dfsVisit(Node vertex) {

        SingleLinkedList adjVertices = adjacencyList.getAdjListForVertex(vertex);

        if (adjVertices != null) {

            Node connectedVertex = adjVertices.getHead();
            while (connectedVertex != null) {
                if (!parent.containsKey(connectedVertex.getValue())) {
                    parent.put(connectedVertex.getValue(), vertex.getValue());
                    traversedVertices[counter++] = connectedVertex.getValue();

                    dfsVisit(connectedVertex);

                }
                connectedVertex = connectedVertex.getNext();
            }
        }
    }


    public Map<Integer, Integer> traverse (Node vertex) {
        parent.put(vertex.getValue(), 0);

        dfsVisit(vertex);

        printTraversal();

        return parent;
    }

    public void printTraversal() {
        System.out.print("DFS Travarsal: ");
        for(int i = 0; i < counter; i++) {
            System.out.print(traversedVertices[i] + " ");
        }

        System.out.println("");
    }
}
