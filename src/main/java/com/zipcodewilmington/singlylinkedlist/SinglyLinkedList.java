package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable>{

    private class Node{

        private T myData;
        private Node next;

        public Node(){
            this.myData= null;
            this.next = null;
        }

        public Node(T obj) {
             this.myData = obj;
             this.next = null;
        }


        public T getMyData() {
            return myData;
        }

        public void setMyData(T myData) {
            this.myData = myData;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public  SinglyLinkedList(T obj) {
        emptyFirstNode = new Node();
        this.emptyFirstNode.next = new Node(obj);
        this.emptyFirstNode.next.next = null;
        this.last = this.emptyFirstNode.next;
        this.count = 1;
    }


     public  SinglyLinkedList() {
        this.emptyFirstNode = new Node();
        this.count = 0;
        this.emptyFirstNode.next = null;
    }
    private  Node emptyFirstNode;
    private  Node last;
    private Integer count;

    public void add(T obj) {
        Node newNode = new Node(obj);
        if(this.emptyFirstNode.next==null) {
            this.emptyFirstNode.next = newNode;
        }
        else {
            this.last.next = newNode;
            this.last=newNode;
            this.count++;
        }
    }
    public void remove(T obj) {

        Integer index = this.find(obj);
        if(index>-1){
            Node prev = this.emptyFirstNode.next;
            for(int i=0; i<index;i++){
                prev=prev.next;

            }
            prev.next=prev.next.next;
            if(index == this.count){
                last = prev;
            }
            this.count--;
        }


    }
    public  Boolean contains(T obj) {
        return  (this.find(obj) >-1);
    }

    public Integer find(T obj) {
        if(this.count==0) {
            return  -1;
        }
        Node toCheck = this.emptyFirstNode.next;
        for(int i = 0; i< count; i++) {
            if(toCheck.myData.equals(obj)) {
                return  i;
            }
            else {
                toCheck = toCheck.next;
            }
        }
        return -1;
    }
    public Integer size() {
        return  this.count;
    }

    public  T get(Integer target) {

        if(target < this.count) {
            Node thisNode =this.emptyFirstNode.next;
            for(int i=0; i<target; i++) {
                thisNode = thisNode.next;
            }
            return thisNode.myData;
        }
        return null;
    }

    public void sort() {
        Boolean swapped;
        Node prev;
        for(int i = 0; i<this.count-1; i++) {
            swapped = false;
            prev = this.emptyFirstNode;
            for (int j = 0; j<this.count-1-i; j++) {
                if(prev.next.myData.compareTo(prev.next.next.myData) > 0) {
                    swwapNodes(prev);
                    swapped = true;
                }
                prev = prev.next;
            }
            if(!swapped) break;;
        }
    }

    private void swwapNodes(Node prev) {
        Node node1 = prev.next;
        Node node2 = node1.next;
        prev.next = node2.next;
        node1.next = node2.next;
        node2.next =node1;
    }

    public  void reverse() {
        if(this.count > 1) {
            Node pointer1;
            Node pointer2 = this.emptyFirstNode.next.next;
        }
    }

}
