package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> {
    T[] item;
    int size;

    Comparator<T> comparator = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return 0;
        }
    };
    public MaxArrayDeque(Comparator<T> c) {
        item = (T[]) new Object[8];
        size = 0;
    }
}
