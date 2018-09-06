package com.practise.algo.service.graph;

import com.google.common.collect.Lists;
import com.practise.algo.entity.AdjacencyList;
import com.practise.algo.entity.Node;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class DfsTest {

    @Test
    public void testDfsTraverse1() {

        AdjacencyList adjacencyList = new AdjacencyList();

        adjacencyList.addEdgesForVertex(1, Lists.newArrayList(2, 3));
        adjacencyList.addEdgesForVertex(2, Lists.newArrayList(1, 5));
        adjacencyList.addEdgesForVertex(3, Lists.newArrayList(1, 4));
        adjacencyList.addEdgesForVertex(4, Lists.newArrayList(3, 5));
        adjacencyList.addEdgesForVertex(5, Lists.newArrayList(4));

        Dfs testDfs = new Dfs(adjacencyList);

        Node node = new Node(2);

        Map<Integer, Integer> bfsResult = testDfs.traverse(node);

        Assert.assertTrue(bfsResult.get(2) == 0);
        Assert.assertTrue(bfsResult.get(1) == 2);
        Assert.assertTrue(bfsResult.get(3) == 1);
        Assert.assertTrue(bfsResult.get(4) == 3);
        Assert.assertTrue(bfsResult.get(5) == 4);



    }

    @Test
    public void testDfsTraverseAll() {

        AdjacencyList adjacencyList = new AdjacencyList();

        adjacencyList.addEdgesForVertex(1, Lists.newArrayList(2, 3));
        adjacencyList.addEdgesForVertex(2, Lists.newArrayList(1, 5));
        adjacencyList.addEdgesForVertex(3, Lists.newArrayList(1, 4));
        adjacencyList.addEdgesForVertex(4, Lists.newArrayList(3, 5));
        adjacencyList.addEdgesForVertex(5, Lists.newArrayList(4));

        Dfs testDfs = new Dfs(adjacencyList);

        testDfs.traverseAll();

    }

    @Test
    public void testDfsCycleFalseeDag() {

        AdjacencyList adjacencyList = new AdjacencyList();

        adjacencyList.addEdgesForVertex(1, Lists.newArrayList(3));
        adjacencyList.addEdgesForVertex(2, Lists.newArrayList(3, 5));
        adjacencyList.addEdgesForVertex(3, Lists.newArrayList(4));
        adjacencyList.addEdgesForVertex(4, Lists.newArrayList());
        adjacencyList.addEdgesForVertex(5, Lists.newArrayList(4));

        Dfs testDfs = new Dfs(adjacencyList);

        testDfs.traverseAll();

        Assert.assertFalse(testDfs.hasCycle());

    }

    @Test
    public void testDfsCycleTrueDag() {

        AdjacencyList adjacencyList = new AdjacencyList();

        adjacencyList.addEdgesForVertex(1, Lists.newArrayList(3));
        adjacencyList.addEdgesForVertex(2, Lists.newArrayList(3, 5));
        adjacencyList.addEdgesForVertex(3, Lists.newArrayList(4));
        adjacencyList.addEdgesForVertex(4, Lists.newArrayList(1));
        adjacencyList.addEdgesForVertex(5, Lists.newArrayList(4));

        Dfs testDfs = new Dfs(adjacencyList);

        testDfs.traverseAll();

        Assert.assertTrue(testDfs.hasCycle());

    }

    @Test
    public void testDfsCycleTrueDag2() {

        AdjacencyList adjacencyList = new AdjacencyList();

        adjacencyList.addEdgesForVertex(1, Lists.newArrayList(2, 3));
        adjacencyList.addEdgesForVertex(2, Lists.newArrayList(3, 5));
        adjacencyList.addEdgesForVertex(3, Lists.newArrayList(4));
        adjacencyList.addEdgesForVertex(4, Lists.newArrayList(1));
        adjacencyList.addEdgesForVertex(5, Lists.newArrayList(4));

        Dfs testDfs = new Dfs(adjacencyList);

        testDfs.traverseAll();

        Assert.assertTrue(testDfs.hasCycle());

    }
}
