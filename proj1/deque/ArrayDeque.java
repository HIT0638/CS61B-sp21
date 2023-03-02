package deque;

/**
 * 用数组实现的双向队列
 * @param <T>
 */
public class ArrayDeque<T> {
    T[] item;
    int size;

    public ArrayDeque(){
        item = (T[]) new Object[8];
        size = 0;
    }

    /**
     * 在队列头部添加元素
     * @param key
     */
    public void addFirst(T key){
        if(size == item.length){
            resize(size * 2);
        }
        for(int i = size; i > 0; i --){
            item[i] = item[i-1];
        }
        item[0] = key;
        size += 1;
    }

    public void addLast(T key){
        if(size == item.length){
            resize(size * 2);
        }
        item[size] = key;
        size += 1;
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = item[0];
        for(int i = 0; i < size - 1; i ++){
            item[i] = item[i+1];
        }
        size -= 1;
        return first;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T last = item[size-1];
        size -= 1;

        return last;
    }

    public T get(int index){
        if(isEmpty() || (index < 0 || index >= size)){
            System.out.println("下标不合法.");
            return null;
        }
        return item[index];
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    public int size(){
        return size;
    }
    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];

        System.arraycopy(item,0,a,0,size);
        item = a;
    }
}
