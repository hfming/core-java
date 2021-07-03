package com.hfm.collection.list.abstractsquentiallist;

import java.util.NoSuchElementException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-11 11:07
 * @Description 双向链表
 * @date 2021/6/11
 */
public class DoubleLinkedList<E> extends MyAbstractLisy<E> {
    /**
     * 双向链表首个节点
     */
    private Node<E> first;
    /**
     * 双向链表最后一个节点
     */
    private Node<E> last;

    /**
     * 双向链表内部节点
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
         * 指向下一个节点
         */
        Node<E> prev;

        /**
         * 构造函数
         *
         * @param element
         * @param next
         */
        Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
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
        Node<E> currentNode;
        if (index < (size() >> 1)) {
            currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
                if (currentNode == null) {
                    throw new NoSuchElementException();
                }
            }
        } else {
            currentNode = last;
            for (int i = size() - 1; i > index; i--) {
                currentNode = currentNode.prev;
                if (currentNode == null) {
                    throw new NoSuchElementException();
                }
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
            // 添加首个元素
            first = new Node<>(element, null, null);
            last = first;
        } else if (index == 0 && size() != 0) {
            // 添加到首位置
            Node<E> addNode = new Node<>(element, first, null);
            first = addNode;
        } else if (index == size()) {
            // 添加到最后一个位置
            Node<E> lastNode = this.last;
            Node<E> addNode = new Node<>(element, null, this.last);
            lastNode.next = addNode;
            this.last = addNode;
        } else {
            Node<E> currnentNode = geteNode(index);
            Node<E> addNode = new Node<>(element, currnentNode, currnentNode.prev);
            currnentNode.prev.next = addNode;
            currnentNode.prev = addNode;
        }
        setSize(getSize() + 1);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> currentNode = geteNode(index);
        if (size() > 1) {
            if (currentNode == first) {
                first = currentNode.next;
                first.prev = null;
            } else if (currentNode == last) {
                Node<E> prevNode = last.prev;
                last = prevNode;
                last.next = null;
            } else {
                Node<E> prevNode = currentNode.prev;
                prevNode.next = currentNode.next;

                currentNode.next = null;
                currentNode.prev = null;
            }
        } else {
            last = first = null;
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
        this.last = null;
        setSize(0);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append("[");
        Node<E> currentNode = first;
        if (size() == 0) {
            return "[]";
        }
        if (size() > 1) {
            for (Node<E> i = first; i != null; i = i.next) {
                sb.append(i.element);
                if (i.next == null) {
                    return sb.append("]").toString();
                }
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
