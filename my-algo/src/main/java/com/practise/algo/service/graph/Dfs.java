package com.practise.algo.service.graph;

import com.practise.algo.entity.AdjacencyList;
import com.practise.algo.entity.Node;
import com.practise.algo.entity.SingleLinkedList;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dfs {

    private AdjacencyList adjacencyList;

    private Map<Integer, Integer> parent = new HashMap<>();

    private int[] traversedVertices = new int[20];

    private boolean cycle = false;

    public boolean hasCycle() {
        return cycle;
    }

    /*
        To be used for Cycle detection
        Cycle exists if backward-Edge exists.
        Backward-Edge can be found while recursing in a DFS.
     */
    private List<Integer> recurseTracker = new ArrayList<>();

    private int counter = 0;

    public Dfs(AdjacencyList adjList) {
        adjacencyList = adjList;
    }

    /* Visit from a given vertex. Recursively to all connected vertices */
    private void dfsVisit(Node vertex) {

        /*
            Add vertex currently being processed (in recursion) to the recursion checker.
         */
        addToRecursionTracker(vertex);


        SingleLinkedList adjVertices = adjacencyList.getAdjListForVertex(vertex);

        if (adjVertices != null) {

            Node connectedVertex = adjVertices.getHead();
            while (connectedVertex != null) {

                if (nodeAlreadyInRecursion(connectedVertex)) {
                    System.out.println("Cycle detected. " + vertex.getValue() + "-->" + connectedVertex.getValue());
                    cycle = true;
                }

                if (!parent.containsKey(connectedVertex.getValue())) {
                    parent.put(connectedVertex.getValue(), vertex.getValue());
                    traversedVertices[counter++] = connectedVertex.getValue();

                    dfsVisit(connectedVertex);

                }
                connectedVertex = connectedVertex.getNext();
            }
        }

        removeFromnRecursionTracker(vertex);
    }


    public Map<Integer, Integer> traverse (Node vertex) {
        if (!parent.containsKey(vertex.getValue())) {
            parent.put(vertex.getValue(), 0);
            traversedVertices[counter++] = vertex.getValue();

            dfsVisit(vertex);

            printTraversal();
        }

        return parent;
    }

    public Map<Integer, Integer> traverseAll() {
        List<Integer> vertices = adjacencyList.getAllVertices();

        vertices.forEach( (vertex) -> {
            traverse(new Node(vertex));
        });

        return parent;
    }

    public void printTraversal() {
        System.out.print("DFS Travarsal: ");
        for(int i = 0; i < counter; i++) {
            System.out.print(traversedVertices[i] + " ");
        }

        System.out.println("");
    }

    private void addToRecursionTracker(Node vertex) {
        this.recurseTracker.add(vertex.getValue());
    }

    private void removeFromnRecursionTracker(Node vertex) {
        recurseTracker.remove(vertex.getValue());
    }

    private boolean nodeAlreadyInRecursion(Node vertex) {
         return recurseTracker.contains(vertex.getValue());
    }
}
