package com.practise.algo.Util;

import com.google.common.collect.Lists;
import com.practise.algo.entity.AdjacencyList;
import com.practise.algo.entity.Node;

public class DataProvider {

    public static AdjacencyList getBasicUndirectedAdjacencyList() {

        /*
        Returns UN-DIRECTED Graph.
         */

        AdjacencyList  adjacencyList = new AdjacencyList();

        adjacencyList.addEdgesForVertex(1, Lists.newArrayList(2, 3));
        adjacencyList.addEdgesForVertex(2, Lists.newArrayList(1));
        adjacencyList.addEdgesForVertex(3, Lists.newArrayList(1, 4));
        adjacencyList.addEdgesForVertex(4, Lists.newArrayList(3, 5));
        adjacencyList.addEdgesForVertex(5, Lists.newArrayList(4));

        return adjacencyList;

    }
}
