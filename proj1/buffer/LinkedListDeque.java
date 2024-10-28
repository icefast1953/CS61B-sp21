package buffer;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private Node sentionel;
    private int size;
    private Node Last;

    public class Node {
        public Node next;
        public T item;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }



    /** Create a blanket deque. */
    public LinkedListDeque(){
        sentionel = new Node(null,null);
        Last = sentionel;
        size = 0;
    }

    /** create a Node with a value. */
    public LinkedListDeque(T item){
        sentionel = new Node(null,null);
        sentionel.next = new Node(item,null);
        Last =sentionel.next;
        size = 1;
    }

    /** create a Node ,and put it to the First Node. */
    @Override
    public void addFirst(T item){
        sentionel.next =new Node(item,sentionel.next);
        size++;
    };



    @Override
    public void addLast(T item){
        Last.next = new Node(item,null);
        Last = Last.next;
        size++;
    };



    @Override
    public boolean isEmpty(){
        if (sentionel.next == null){
            return true;
        }
        return false;
    };



    @Override
    public int size(){
        return size;
    };



    @Override
    public void printDeque(){
        Node p = sentionel;
        while (p.next != null){
            System.out.print(p.item+" ");
            p = p.next;
        }
        System.out.println();
    };



    @Override
    public T removeFirst(){
        if (sentionel.next == null){
            return null;
        }
        T value = sentionel.next.item;
        sentionel.next = sentionel.next.next;
        size--;
        return value;
    };



    @Override
    public T removeLast(){
        if (sentionel.next == null){
            return null;
        }
        Node p = sentionel;
        while (p.next.next != null){
            p = p.next;
        }
        T value = p.next.item;
        p.next = null;
        Last = p;
        size--;
        return value;
    };



    @Override
    public T get(int index){
        Node p = sentionel;
        for (;index>0;index--){
            p = p.next;
        }
        return p.next.item;
    };


    public boolean equals(Object o){
        if (o instanceof LinkedListDeque){
            int size1 = size-1;
            for (;size1>=0;size1--){
                if (this.get(size1).equals(((LinkedListDeque<?>) o).get(size1)))
                {
                    continue;
                }else {
                return false;
                }
            }
        }
        return false;
    };


    public Iterator<T> interator(){
        return new LinkedListDequeIterator();
    }



    public class LinkedListDequeIterator implements Iterator<T> {
        Node p;

        @Override
        public boolean hasNext() {
            return p.next != null;
        }

        @Override
        public T next() {
            p = p.next;
            return p.item;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        public LinkedListDequeIterator(){
            Node p = sentionel.next;
        }
    }
}
