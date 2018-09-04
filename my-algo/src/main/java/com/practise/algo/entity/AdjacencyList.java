package com.practise.algo.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {

    /*
        Map of Vertices as keys and SingleLinkedList of Nodes to which an edge exists
     */
    Map<Integer, SingleLinkedList> adjList = new HashMap<>();

    public Map<Integer, SingleLinkedList> addVertex(Node vertex) {

        if (!adjList.containsKey(vertex.getValue())) {
            adjList.put(vertex.getValue(), new SingleLinkedList());
        }

        return adjList;
    }

    public Map<Integer, SingleLinkedList> addEdgeForVertex(Node vertex, Node edge) {
        addVertex(vertex);

        SingleLinkedList list = adjList.get(vertex);

        if (list.search(edge) != null) {
            System.out.println("Node already present. Edge cannot be added");
        }

        list.addAtTail(edge);

        return adjList;
    }

    public Map<Integer, SingleLinkedList> addEdgesForVertex(Node vertex, List<Node> edges) {
        addVertex(vertex);

        SingleLinkedList list = adjList.get(vertex.getValue());

        for (Node edge : edges) {

            if (list == null) {
                System.out.print("Something Wrong. No defined edges for vertex: " + vertex.getValue());
            }

            if (list.search(edge) != null) {
                System.out.println("Node already present. Edge cannot be added");
            }

            list.addAtTail(edge);
        }

        return adjList;
    }

    public void printList() {
        adjList.forEach((vertex, edge) -> {
            System.out.println(vertex + "  >> ");
            edge.printList();
        });
    }

    public SingleLinkedList getAdjListForVertex(Node vertex) {
        if (!adjList.containsKey(vertex.getValue())) {
            return null;
        }

        return adjList.get(vertex.getValue());
    }
}
