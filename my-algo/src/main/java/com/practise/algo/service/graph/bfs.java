package com.practise.algo.service.graph;

import com.practise.algo.entity.AdjacencyList;
import com.practise.algo.entity.Node;
import com.practise.algo.entity.SingleLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bfs {

    AdjacencyList adjList;

    private int[] traversedVertices = new int[20];

    private int counter = 0;

    Bfs (AdjacencyList list) {
        adjList = list;
    }

    /*
        Traverse in BFS. Starting from Vertex vertex
     */
    public Map<Integer, Integer> traverse(Node vertex) {

        Map<Integer, Integer> level = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        // Adding the starting node as level 0
        level.put(vertex.getValue(), 0);

        List<Node> current = new ArrayList<>();
        current.add(vertex);

        List<Node> next;
        int curLevel = 1;


        while (current.size() > 0) {
            next = new ArrayList<>();

            for (Node currVertex : current) {
                SingleLinkedList nextList = adjList.getAdjListForVertex(currVertex);

                Node currEdge = nextList.getHead();

                while (currEdge != null) {
                    if (!level.containsKey(currEdge.getValue())) {
                        level.put(currEdge.getValue(), curLevel);
                        parent.put(currEdge.getValue(), currVertex.getValue());
                        next.add(currEdge);

                        traversedVertices[counter++] = currEdge.getValue();
                    }
                    currEdge = currEdge.getNext();
                }
            }

            current = next;
            curLevel++;
        }

        printTraversal();
        return level;

    }

    public void printTraversal() {
        System.out.print("BFS Travarsal: ");
        for(int i = 0; i < counter; i++) {
            System.out.print(traversedVertices[i] + " ");
        }
        System.out.println("");
    }
}
