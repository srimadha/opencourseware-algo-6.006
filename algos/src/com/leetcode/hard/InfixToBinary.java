package com.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by Sri on 1/22/2021.
 */
public class InfixToBinary {
    class Node {
        char c;
        Node left;
        Node right;
        Node( char c ){
            this.c = c;
        }
    }
    public Node expTree(String s) {
        Stack<Node> nodes = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                nodes.push(new Node(c));
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                collapseUntilLeftParen(nodes, op);
            } else {
                collapse(nodes, op, c);
            }
        }
        collapseAll(nodes, op);
        return nodes.pop();
    }

    private boolean shouldCollapse(Stack<Character> op, char c) {
        if (op.isEmpty()) {
            return false;
        }
        if (op.peek() == '(') {
            return false;
        }
        if ((op.peek() == '+' || op.peek() == '-') && (c == '*' || c == '/')) {
            return false;
        }
        return true;
    }

    private void collapseUntilLeftParen(Stack<Node> nodes, Stack<Character> op) {
        while (op.peek() != '(') {
            doCollapse(nodes, op);
        }
        op.pop(); // pop up the left bracket
    }

    private void collapse(Stack<Node> nodes, Stack<Character> op, char c) {
        while (shouldCollapse(op, c)) {
            // need a while because if it's 1+2*3*4*5 + 6 and we are at the last +then all the calculations before it can be collapsed
            doCollapse(nodes, op);
        }
        op.push(c);
    }

    private void collapseAll(Stack<Node> nodes, Stack<Character> op) {
        while (nodes.size() > 1) {
            doCollapse(nodes, op);
        }
    }

    private void doCollapse(Stack<Node> nodes, Stack<Character> op) {
        Node n1 = nodes.pop();
        Node n2 = nodes.pop();
        Node cur = new Node(op.pop());
        cur.left = n2; // n1== right operand is at the top hence n2 is left tree
        cur.right = n1;
        nodes.push(cur);
    }
}