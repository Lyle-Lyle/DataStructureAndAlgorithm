package com.lannister;

/**
 * @author Lannister
 */
public class LinkedList<E> extends AbstractList<E>{
    private Node<E> firstNode;

    /**
     * 因为节点类只供链表类内部使用，所以做成内部类
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        firstNode = null;

    }

    /**
     * 获得索引对应位置的节点的元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return getNode(index).element;

    }

    /**设置索引位置节点的元素
     *
     * @param index
     * @param element
     */
    @Override
    public void set(int index, E element) {
        getNode(index).element = element;
    }


    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //对index = 0 的情况进行特殊处理,因为下面0-1会等于-1，因为头节点没有index
        if (index == 0) {
            firstNode.next = new Node<E>(element,getNode(index));
        } else {
            Node<E> newNode = new Node<E>(element,getNode(index));
            //让前一个节点的next指向newNode
            getNode(index-1).next = newNode;
        }
        size++;
    }



    @Override
    public void remove(int index) {
        rangeCheck(index);
        if (index == 0) {
            firstNode = getNode(index).next;
        } else {
            Node<E> prev = getNode(index - 1);
            prev = getNode(index).next;
        }
        size--;
    }

    @Override
    public int indexOf(E element) {
        //TODO 需要考虑element为null的情况吗？

        Node<E> node = firstNode.next;
        int count = 0;
        while(node.element != element) {
            node = node.next;
            count++;
        }
        return count;
        if(count > size -1) {
            //不能使用接口中的static final 变量？
            return ELEMENT_NOT_FOUND;
        }
    }


    /**
     * 获取index位置对应的节点对象
     *      巨好用的方法
     * @param index
     * @return
     */
    private Node<E> getNode(int index) {
        rangeCheck(index);
        Node<E> node = firstNode;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        //TODO

    }
}
