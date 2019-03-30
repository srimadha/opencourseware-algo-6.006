package com.leetcode.medium;

public class ReverseLinked{
    public class LinkedNode{
        int val;
        LinkedNode next;

        LinkedNode( int x) {
            this.val = x;
        }

        public LinkedNode append( LinkedNode curr, LinkedNode tail){
            LinkedNode temp = curr;
            while( temp.next != null) temp = temp.next;
            temp.next = tail;

            return curr;
        }
    }

    public void reverse(int start,int end){
        LinkedNode node = new LinkedNode(1);
        node.next = new LinkedNode(2);
        node.next.next = new LinkedNode(3);
        node.next.next.next = new LinkedNode(4);
        node.next.next.next.next = new LinkedNode(5);
        node.next.next.next.next.next = new LinkedNode(6);

        LinkedNode prePart = node;
        LinkedNode prePartTemp = prePart;
        for(int i=1;i<start; i++){
            prePartTemp = prePartTemp.next;
        }
        LinkedNode postPart = prePartTemp.next;
        prePartTemp.next = null;
        int n = end - start;
        LinkedNode firstpart = postPart;
        LinkedNode secondPart = null;

        while(--n != 0){
            firstpart = firstpart.next;
        }

        secondPart = firstpart.next;
        firstpart.next = null;

        LinkedNode prev = null;
        LinkedNode curr = postPart;

        while(curr.next != null ){
            LinkedNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        curr.next = prev;


        curr = curr.append( curr, secondPart);
        curr = curr.append( prePart, curr);

        while( curr != null){
            System.out.print( curr.val + " ");
            curr = curr.next;
        }

    }
    public static void main( String []args){
        new ReverseLinked().reverse(2, 4);
        System.out.println("Hello");
    }
}