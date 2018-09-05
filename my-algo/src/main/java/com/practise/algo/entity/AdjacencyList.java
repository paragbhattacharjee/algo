package com.practise.algo.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {

    /*
        Map of Vertices as keys and SingleLinkedList of Nodes to which an edge exists
     */
    Map<Integer, SingleLinkedList> adjList = new HashMap<>();

    public Map<Integer, SingleLinkedList> addVertex(Integer vertex) {

        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new SingleLinkedList());
        }

        return adjList;
    }

    public Map<Integer, SingleLinkedList> addEdgeForVertex(Integer vertex, Integer edge) {
        addVertex(vertex);

        SingleLinkedList list = adjList.get(vertex);

        if (list.search(edge) != null) {
            System.out.println("Node already present. Edge cannot be added");
        }

        list.addAtTail(edge);

        return adjList;
    }

    public Map<Integer, SingleLinkedList> addEdgesForVertex(Integer vertex, List<Integer> edges) {
        addVertex(vertex);

        SingleLinkedList list = adjList.get(vertex);

        for (Integer edge : edges) {

            if (list == null) {
                System.out.print("Something Wrong. No defined edges for vertex: " + vertex);
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

    public List<Integer> getAllVertices() {
        List<Integer> vertices = new ArrayList<>();
        adjList.forEach((vertex, edge) -> {
            vertices.add(vertex);
        });

        return vertices;
    }
}
