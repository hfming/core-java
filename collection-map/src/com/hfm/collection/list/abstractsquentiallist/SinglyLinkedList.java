package com.hfm.collection.list.abstractsquentiallist;

import java.util.NoSuchElementException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-11 11:07
 * @Description 单向链表
 * @date 2021/6/11
 */
public class SinglyLinkedList<E> extends MyAbstractLisy<E> {
    /**
     * 单向链表首个节点
     */
    private Node<E> first;

    /**
     * 单向链表内部节点
     *
     * @param <E>
     */
    private class Node<E> {
        /**
         * 节点存储的数据
         */
        E element;
        /**
         * 指向下一个节点
         */
        Node<E> next;

        /**
         * 构造函数
         *
         * @param element
         * @param next
         */
        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public E get(int index) {
        return geteNode(index).element;
    }

    /**
     * 获取指定位置节点
     *
     * @param index
     * @return
     */
    private Node<E> geteNode(int index) {
        checkIndex(index);
        Node<E> currentNode = first;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
            if (currentNode == null) {
                throw new NoSuchElementException();
            }
        }
        return currentNode;
    }

    /**
     * 检查是否超出集合范围
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E set(int index, E element) {
        Node<E> currnetNode = geteNode(index);
        E oldEmlement = currnetNode.element;
        currnetNode.element = element;

        return oldEmlement;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if (size() == 0) {
            first = new Node<>(element, null);
        } else if (index == 0 && size() != 0) {
            Node<E> addNode = new Node<>(element, first);

            first = addNode;
        } else {
            Node<E> prevNode = geteNode(index - 1);
            Node<E> addNode = new Node<>(element, prevNode.next);

            prevNode.next = addNode;
        }
        setSize(getSize() + 1);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> currentNode = geteNode(index);
        if (currentNode == first) {
            first = currentNode.next;
            currentNode.next = null;
        } else {
            Node<E> prevNode = geteNode(index - 1);
            prevNode.next = currentNode.next;

            currentNode.next = null;
        }
        setSize(getSize() - 1);
        return currentNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> currnetNode = first;
        if (element == null) {
            for (int i = 0; i < size(); i++) {
                if (currnetNode.element == element) {
                    return i;
                }
                currnetNode = currnetNode.next;
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (element.equals(currnetNode.element)) {
                    return i;
                }
                currnetNode = currnetNode.next;
            }
        }
        return -1;
    }

    @Override
    public void clean() {
        this.first = null;
        setSize(0);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        Node<E> currentNode = first;
        if (first == null) {
            return null;
        }
        if (size() == 0) {
            sb.append("[]");
        }
        if (size() == 1) {
            sb.append("[" + currentNode.element.toString() + "]");
        }
        if (size() > 1) {
            for (int i = 0; i < size(); i++) {
                if (i == 0) {
                    sb.append("[" + currentNode.element.toString() + ",");
                }
                if (i == size() - 1) {
                    sb.append(currentNode.element.toString() + "]");
                }
                if (i != 0 && i != size() - 1) {
                    sb.append(currentNode.element.toString() + ",");
                }
                currentNode = currentNode.next;
            }
        }
        return sb.toString();
    }
}
