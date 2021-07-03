package com.hfm.map.sortedmap.treeMap;

import java.util.Comparator;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-12 16:36
 * @Description
 * @date 2021/6/12
 */
public class MyTreeMap<K, V> {
    /**
     * 内部类节点用于存储键值对
     *
     * @param <K>
     * @param <V>
     */
    private class Node<K, V> {
        /**
         * 左子节点
         */
        Node<K, V> left;
        /**
         * 右子节点
         */
        Node<K, V> right;
        /**
         * 父节点
         */
        Node<K, V> parent;

        /**
         * 存储的键
         */
        K key;
        /**
         * 存储的值
         */
        V value;

        /**
         * 构造函数
         *
         * @param left
         * @param right
         * @param parent
         * @param key
         * @param value
         */
        Node(Node<K, V> left, Node<K, V> right, Node<K, V> parent, K key, V value) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 比较器对象
     */
    private final Comparator<? super K> comparator;

    /**
     * 无参构造函数
     */
    public MyTreeMap() {
        comparator = null;
    }

    /**
     * 有参构造函数，传入比较器，按比较器对键进行排序
     *
     * @param comparator
     */
    public MyTreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    /**
     * 根节点
     */
    private Node<K, V> root;

    /**
     * 记录节点的个数，集合元素的个数
     */
    private int size;

    /**
     * 获取集合元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 通过键获取值
     *
     * @param key
     * @return
     */
    public V get(K key) {
        Node<K, V> node = getNode(key);
        // 没有找到抛出异常，没有该键
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private Node<K, V> getNode(K key) {
        // 传入的键为空
        if (key == null) {
            throw new NullPointerException();
        }
        Node<K, V> currentNode = root;
        int compare;
        if (this.comparator == null) {
            Comparable<? super K> k = (Comparable<? super K>) key;

            while (currentNode != null) {
                compare = k.compareTo(currentNode.key);
                if (compare == 1) {
                    // 节点的值小于输入值，节点替换为右子节点
                    currentNode = currentNode.right;
                } else if (compare == -1) {
                    // 节点的值大于输入值，节点替换为左子节点
                    currentNode = currentNode.left;
                } else {
                    // 键相等，将值返回
                    return currentNode;
                }
            }
        } else {
            while (currentNode != null) {
                compare = comparator.compare(currentNode.key, key);
                if (compare == 1) {
                    // 节点的值小于输入值，节点替换为右子节点
                    currentNode = currentNode.right;
                } else if (compare == -1) {
                    // 节点的值大于输入值，节点替换为左子节点
                    currentNode = currentNode.left;
                } else {
                    // 键相等，将值返回
                    return currentNode;
                }
            }
        }
        return null;
    }

    /**
     * 存储键值对
     *
     * @param key
     * @param value
     * @return 被覆盖的值
     */
    public V put(K key, V value) {
        // 校验空值
        if (key == null) {
            throw new NullPointerException();
        }
        Node<K, V> currentNode = root;
        // 如果集合为空直接创建新节点作为根节点
        if (size == 0 || currentNode == null) {
            root = new Node<>(null, null, null, key, value);
            size++;
            return null;
        }

        Node<K, V> parentNode = null;

        int compare = 0;
        // 目的就是找到父节点
        if (this.comparator != null) {
            while (currentNode != null) {
                parentNode = currentNode;
                compare = comparator.compare(key, currentNode.key);
                if (compare < 0) {
                    currentNode = currentNode.left;
                } else if (compare > 0) {
                    currentNode = currentNode.right;
                } else {
                    // 找到 key 相同的节点，不用添加，将值更新即可
                    return currentNode.value = value;
                }
            }
        } else {
            Comparable<? super K> k = (Comparable<? super K>) key;
            while (currentNode != null) {
                parentNode = currentNode;
                compare = k.compareTo(currentNode.key);
                if (compare < 0) {
                    currentNode = currentNode.left;
                } else if (compare > 0) {
                    currentNode = currentNode.right;
                } else {
                    // 找到 key 相同的节点，不用添加，将值更新即可
                    return currentNode.value = value;
                }
            }
        }
        Node<K, V> addNode = new Node<>(null, null, parentNode, key, value);
        size++;
        // 判断在父节点的左边还是右边
        if (compare > 0) {
            parentNode.right = addNode;
        } else {
            parentNode.left = addNode;
        }
        return null;
    }

    /**
     * 删除节点
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        Node<K, V> node = getNode(key);
        if (node == null) {
            return null;
        }
        V oldValue = node.value;
        // 删除节点
        deleteNode(node);
        return oldValue;
    }

    /**
     * 删除节点，并平衡
     *
     * @param currentNode
     */
    private void deleteNode(Node<K, V> currentNode) {
        size--;
        if (currentNode.left == null && currentNode.right == null) {
            // 删除节点没有子节点
            if (currentNode.parent.left == currentNode) {
                currentNode.parent.left = null;
            } else if (currentNode.parent.right == currentNode) {
                currentNode.parent.right = null;
            } else {
                root = null;
            }
            currentNode.parent = null;
        }
        if (currentNode.left == null && currentNode.right != null) {
            // 删除节点只有右节点
            if (currentNode.parent.left == currentNode) {
                currentNode.parent.left = currentNode.right;
            } else if (currentNode.parent.right == currentNode) {
                currentNode.parent.right = currentNode.right;
            } else {
                root = currentNode.right;
            }
            currentNode.right.parent = currentNode.parent;
            currentNode.parent = null;
        }
        if (currentNode.left != null && currentNode.right == null) {
            // 删除节点只有左节点
            if (currentNode.parent.left == currentNode) {
                currentNode.parent.left = currentNode.left;
            } else if (currentNode.parent.right == currentNode) {
                currentNode.parent.right = currentNode.left;
            } else {
                root = currentNode.left;
            }
            currentNode.left.parent = currentNode.parent;
            currentNode.parent = null;
        }
        if (currentNode.left != null && currentNode.right != null) {
            // 删除的节点有左右节点
            // 找到要替代的节点
            Node<K, V> targetNode = currentNode.right;
            while (targetNode.left != null) {
                targetNode = targetNode.left;
            }

            if (currentNode.right == targetNode) {
                // 右边只有一个节点
                targetNode.parent = currentNode.parent;
                if (currentNode.parent.right == currentNode) {
                    currentNode.parent.right = targetNode;
                } else if (currentNode.parent.left == currentNode) {
                    currentNode.parent.left = targetNode;
                } else {
                    root = targetNode;
                }
                currentNode.left.parent = targetNode;
                targetNode.left = currentNode.left;
            } else {
                // 右边有多个节点
                if (targetNode == root) {
                    root = targetNode;
                } else if (targetNode.right == null) {
                    // 右边最左节点没有右子节点
                    targetNode.parent.left = null;
                } else {
                    // 右边最左节点有右子节点
                    targetNode.parent.left = targetNode.right;
                    targetNode.right.parent = targetNode.parent;
                }
                // 替换节点
                if (currentNode.parent.left == currentNode) {
                    currentNode.parent.left = targetNode;
                } else if (currentNode.parent.right == currentNode) {
                    currentNode.parent.right = targetNode;
                } else {

                }

                currentNode.left.parent = targetNode;
                currentNode.right.parent = targetNode;
                targetNode.left = currentNode.left;
                targetNode.right = currentNode.right;
            }
        }
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        }
        sb = new StringBuilder("[");
        preorderTraversal(root);
        int i = sb.lastIndexOf(",");

        sb.replace(i, i + 1, "]");
        return sb.toString();
    }

    private StringBuilder sb;

    /**
     * 前序遍历
     *
     * @param currentNode
     * @return
     */
    private void preorderTraversal(Node<K, V> currentNode) {
        // 先打印左边
        if (currentNode.left != null) {
            preorderTraversal(currentNode.left);
        }
        // 在打印中间
        sb.append(currentNode.key + "=" + currentNode.value + ",");

        // 最后打印右边
        if (currentNode.right != null) {
            preorderTraversal(currentNode.right);
        }
    }
}
