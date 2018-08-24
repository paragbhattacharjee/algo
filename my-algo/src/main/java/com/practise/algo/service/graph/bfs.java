package com.practise.algo.service.graph;

import com.practise.algo.entity.AdjacencyList;
import com.practise.algo.entity.Node;
import com.practise.algo.entity.SingleLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bfs {

    AdjacencyList adjList;

    bfs (AdjacencyList list) {
        adjList = list;
    }

    /*
        Traverse in BFS. Starting from Vertex vertex
     */
    public void traverse(Node vertex) {

        Map<Node, Integer> level = new HashMap<>();
        Map<Node, Node> parent = new HashMap<>();

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
                    if (!level.containsKey(currEdge)) {
                        level.put(currEdge, curLevel);
                        parent.put(currEdge, currVertex);
                        next.add(currEdge);
                    }
                }
            }

            current = next;
            curLevel++;
        }

    }
}
