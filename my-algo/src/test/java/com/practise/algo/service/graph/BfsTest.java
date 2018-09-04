package com.practise.algo.service.graph;

import com.practise.algo.Util.DataProvider;
import com.practise.algo.entity.AdjacencyList;
import com.practise.algo.entity.Node;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BfsTest {

    @Test
    public void testBfsTraverse() {

        List<Node> vertices = new ArrayList<>();
        AdjacencyList adjacencyList = DataProvider.getBasicUndirectedAdjacencyList();

        Bfs testBfs = new Bfs(adjacencyList);

        Node node = new Node();
        node.setValue(2);

        testBfs.traverse(node);

    }
}
