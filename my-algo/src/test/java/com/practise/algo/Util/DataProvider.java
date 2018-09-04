package com.practise.algo.Util;

import com.google.common.collect.Lists;
import com.practise.algo.entity.AdjacencyList;
import com.practise.algo.entity.Node;

public class DataProvider {

    public static AdjacencyList getBasicUndirectedAdjacencyList() {

        /*
        Returns UN-DIRECTED Graph.
         */

        Node node1 = new Node();
        node1.setValue(1);

        Node node2 = new Node();
        node2.setValue(2);

        Node node3 = new Node();
        node3.setValue(3);

        Node node4 = new Node();
        node4.setValue(4);

        Node node5 = new Node();
        node5.setValue(5);

        AdjacencyList  adjacencyList = new AdjacencyList();
        adjacencyList.addVertex(node1);
        adjacencyList.addVertex(node2);
        adjacencyList.addVertex(node3);
        adjacencyList.addVertex(node4);
        adjacencyList.addVertex(node5);

        adjacencyList.addEdgesForVertex(node1, Lists.newArrayList(node2, node3));
        adjacencyList.addEdgesForVertex(node2, Lists.newArrayList(node1));
        adjacencyList.addEdgesForVertex(node3, Lists.newArrayList(node1, node4));
        adjacencyList.addEdgesForVertex(node4, Lists.newArrayList(node3, node5));
        adjacencyList.addEdgesForVertex(node5, Lists.newArrayList(node4));

        return adjacencyList;

    }
}
