package com.practise.algo.service.graph;

import com.google.common.collect.Lists;
import com.practise.algo.Util.DataProvider;
import com.practise.algo.entity.AdjacencyList;
import com.practise.algo.entity.Node;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BfsTest {

    @Test
    public void testBfsTraverse1() {

        AdjacencyList  adjacencyList = new AdjacencyList();

        adjacencyList.addEdgesForVertex(1, Lists.newArrayList(2, 3));
        adjacencyList.addEdgesForVertex(2, Lists.newArrayList(1));
        adjacencyList.addEdgesForVertex(3, Lists.newArrayList(1, 4));
        adjacencyList.addEdgesForVertex(4, Lists.newArrayList(3, 5));
        adjacencyList.addEdgesForVertex(5, Lists.newArrayList(4));

        Bfs testBfs = new Bfs(adjacencyList);

        Node node = new Node(2);

        Map<Integer, Integer> bfsResult = testBfs.traverse(node);

        Assert.assertTrue(bfsResult.get(2) == 0);
        Assert.assertTrue(bfsResult.get(1) == 1);
        Assert.assertTrue(bfsResult.get(3) == 2);
        Assert.assertTrue(bfsResult.get(4) == 3);
        Assert.assertTrue(bfsResult.get(5) == 4);
    }

    @Test
    public void testBfsTraverse2() {

        AdjacencyList  adjacencyList = new AdjacencyList();

        adjacencyList.addEdgesForVertex(1, Lists.newArrayList(2, 3));
        adjacencyList.addEdgesForVertex(2, Lists.newArrayList(1, 5));
        adjacencyList.addEdgesForVertex(3, Lists.newArrayList(1, 4));
        adjacencyList.addEdgesForVertex(4, Lists.newArrayList(3, 5));
        adjacencyList.addEdgesForVertex(5, Lists.newArrayList(4));

        Bfs testBfs = new Bfs(adjacencyList);

        Node node = new Node(2);

        Map<Integer, Integer> bfsResult = testBfs.traverse(node);

        Assert.assertTrue(bfsResult.get(2) == 0);
        Assert.assertTrue(bfsResult.get(1) == 1);
        Assert.assertTrue(bfsResult.get(3) == 2);
        Assert.assertTrue(bfsResult.get(4) == 2);
        Assert.assertTrue(bfsResult.get(5) == 1);
    }
}
