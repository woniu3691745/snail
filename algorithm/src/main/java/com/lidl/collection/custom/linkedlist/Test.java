package com.lidl.collection.custom.linkedlist;

/**
 * @author lidongliang
 * @date 2018-7-6 14:07
 */
public class Test {
    public static void main(String[] args) {

        MyLinkedList linked = new MyLinkedList();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(3);

        linked.reverse();

        linked.update(5, 4);
        linked.insert(0, 0);
        linked.out();
        System.out.println("=======");
        linked.delete(5);

        linked.add(3);
        linked.out();
        linked.search(3);
    }
}
