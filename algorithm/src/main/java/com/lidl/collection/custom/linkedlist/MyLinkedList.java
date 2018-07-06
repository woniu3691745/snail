package com.lidl.collection.custom.linkedlist;

/**
 * 自定义LinkedList
 *
 * @author lidongliang
 * @date 2018-7-6 14:05
 */
public class MyLinkedList {

    // 定义一个头结点
    private Node head = new Node();
    // 节点个数属性
    private int size = 0;

    // 添加节点操作
    void add(int value) {
        Node node = new Node();
        node.data = value;
        Node nextNode = new Node();
        nextNode = head;
        // 找到为空的下一个节点
        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }
        nextNode.next = node;
        size++;
    }

    // 插入节点操作
    void insert(int value, int index) {
        Node node = new Node();
        node.data = value;
        int count = 0;
        Node nextNode = head;
        while (count < index) {
            nextNode = nextNode.next;
            count++;
        }
        node.next = nextNode.next;
        nextNode.next = node;
        size++;
    }

    // 得带指定位置的节点操作
    public int get(int index) {
        Node nextNode = new Node();
        nextNode = head;
        int count = 0;
        while (count < index) {
            nextNode = nextNode.next;
            count++;
        }
        return nextNode.data;
    }

    // 查找元素
    void search(int value) {
        Node nextNode = new Node();
        nextNode = head;
        int count = 0;
        while (nextNode.next != null) {
            if (nextNode.next.data == value) {
                System.out.println("找到索引为" + count + "元素与待查找的元素相等！");
                nextNode = nextNode.next;
                count++;
            } else {
                nextNode = nextNode.next;
                count++;
            }
        }
    }

    // 删除元素
    void delete(int index) {
        Node nextNode = new Node();
        nextNode = head;
        int count = 0;
        while (count < index) {
            nextNode = nextNode.next;
            count++;
        }
        nextNode.next = nextNode.next.next;
        size--;
    }

    // 更新元素操作
    void update(int value, int index) {
        Node nextNode = new Node();
        nextNode = head;
        int count = 0;
        while (count <= index) {
            nextNode = nextNode.next;
            count++;
        }
        nextNode.data = value;

    }

    // 得到大小
    public int getSize() {
        return size;
    }

    // 遍历输出
    void out() {
        Node nextNode = new Node();
        nextNode = head.next;
        while (nextNode != null) {
            System.out.println(nextNode.data);
            nextNode = nextNode.next;
        }
    }

    // 非递归实现
    void reverse() {
        Node previous = null;
        Node next = null;

        while (head != null) {
            // 存储下一节点
            next = head.next;
            head.next = previous;        // 反转

            // 更新遍历节点
            previous = head;
            head = next;

//            next = previous;
//            previous = head;
//            head = head.next;
//            previous.next = next;
        }
    }

}

