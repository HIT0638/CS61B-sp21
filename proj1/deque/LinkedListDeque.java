package deque;

import java.util.Iterator;
import java.util.Objects;


/**
 * 泛型链表双向列表的实现及其功能实现
 *
 * @param <T>
 */
public class LinkedListDeque<T> implements Deque<T> {
    /**
     * Node类，声明了各个结点的基本属性和析构方法
     */
    private class LLDNode {
        // 元素值
        T value;
        // 上一个结点
        LLDNode prev;
        // 下一个结点
        LLDNode next;

        public LLDNode(T key,LLDNode p,LLDNode n){
            value = key;
            prev = p;
            next = n;
        }
    }

    LLDNode sentFirst;
    LLDNode sentLast;
    int size;


    /**
     * 创建新的LLD
     */
    public LinkedListDeque() {
        sentFirst = new LLDNode(null,null, null);
        sentLast = new LLDNode(null,null,null);
        sentFirst.next = sentLast;
        sentLast.prev = sentFirst;
        size = 0;
    }

    /**
     * 在队列的头添加结点
     */
    public void addFirst(T item) {
        size += 1;
        LLDNode p = new LLDNode(item, sentFirst, sentFirst.next);
        sentFirst.next.prev = p;
        sentFirst.next = p;
    }

    /**
     * 在队列尾添加结点
     */
    public void addLast(T item) {
        size += 1;
        LLDNode p = new LLDNode(item, sentLast.prev,sentLast);
        sentLast.prev.next = p;
        sentLast.prev = p;
    }
    /**
     * 返回队列的元素个数
     * @return size 元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 打印整个队列但不改变队列值
     */
    public void printDeque() {
        LLDNode p = sentFirst.next;

        while(p != sentLast){
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 删除队列头元素并返回
     * @return FirstNode
     */
    public T removeFirst() {
        if(isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }
        size -= 1;
        LLDNode head = sentFirst.next;

        sentFirst.next = head.next;
        head.next.prev = sentFirst;

        return head.value;
    }

    /**
     * 删除队列尾元素并返回
     * @return LastNode
     */
    public T removeLast() {
        if(isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }
        size -= 1;
        LLDNode last = sentLast.prev;
        sentLast.prev = last.prev;
        last.prev.next = sentLast;

        return last.value;
    }

    /**
     * 获得队列第 index 个元素
     * @param index
     * @return 处于第 index 位置的元素
     */
    public T get(int index) {
        LLDNode p = sentFirst.next;

        for(int i = 0; i < index; i ++){
            p = p.next;
        }

        return p.value;
    }

    /**
     * 使用递归的方式获得index元素
     *
     * @param index
     * @return index元素
     */
    public T getRecursive(int index) {

        return null;
    }

    //    public Iterator<T> iterator(){
//        return null;
//    }

    /**
     * 判断队列与Object o是否相同
     * 如果object 不为T类型，则只需要各个元素值相同即可
     * @param o
     * @return true如果相同
     */
    public boolean equals(Object o) {
        return true;
    }

}
