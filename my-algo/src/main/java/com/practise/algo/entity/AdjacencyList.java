package com.practise.algo.entity;

import java.util.HashMap;
import java.util.Map;

public class AdjacencyList {

    /*
        Map of Vertices as keys and SingleLinkedList of Nodes to which an edge exists
     */
    Map<Node, SingleLinkedList> adjList;

    public Map<Node, SingleLinkedList> addVertex(Node vertex) {
        if (adjList == null) {
            adjList = new HashMap<Node, SingleLinkedList>();
        }

        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new SingleLinkedList());
        }

        return adjList;
    }

    public Map<Node, SingleLinkedList> addEdgeForVertex(Node vertex, Node edge) {
        addVertex(vertex);

        SingleLinkedList list = adjList.get(vertex);

        if (list.search(edge) != null) {
            System.out.println("Node already present. Edge cannot be added");
        }

        list.addAtTail(edge);

        return adjList;
    }

    public void printList() {
        adjList.forEach((vertex, edge) -> {
            System.out.println(vertex.getValue() + "  >> ");
            edge.printList();
        });
    }

    public SingleLinkedList getAdjListForVertex(Node vertex) {
        if (!adjList.containsKey(vertex)) {
            return null;
        }

        return adjList.get(vertex);
    }
}
