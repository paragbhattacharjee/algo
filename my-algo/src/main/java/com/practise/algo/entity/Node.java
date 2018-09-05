package com.practise.algo.entity;

import lombok.Data;

@Data
public class Node {
    private Integer value;
    private Node next;

    public Node(Integer val) {
        value = val;
    }
}
