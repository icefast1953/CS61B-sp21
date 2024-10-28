package buffer;

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    public T item;
    private T[] arrayDeque;

    private int next_First;
    private int next_Last;
    private int max_size;


    public ArrayDeque() {
        arrayDeque = (T[]) new Object[8];
        size = 0;
        next_First = 3;
        next_Last = 4;
        max_size = 8;
    }


    public ArrayDeque(T item) {
        arrayDeque = (T[]) new Object[8];
        arrayDeque[4] = item;
        size = 1;
        next_First = 3;
        next_Last = 5;
    }


    private void resize(int size1) {
        T[] array = (T[]) new Object[size1];
        int mid = size1 / 4;
        int mid1 = size1 / 2;
        if (next_First == size - 1 || next_Last == 0) {
            System.arraycopy(arrayDeque, 0, array, mid1 - mid, size);
        } else if (next_First >= mid) {
            T[] temArray = (T[]) new Object[size];
            System.arraycopy(arrayDeque, next_First + 1, temArray, 0, size - next_Last);
            System.arraycopy(arrayDeque, 0, temArray, size - next_Last - 1, next_Last);
            System.arraycopy(temArray, 0, array, mid1 - mid, size);
        } else if (next_Last <= mid) {
            T[] temArray = (T[]) new Object[size];
            System.arraycopy(arrayDeque, next_First + 1, temArray, 0, size - next_First - 1);
            System.arraycopy(arrayDeque, 0, temArray, size - next_First - 1, next_Last);
            System.arraycopy(temArray, 0, array, mid1 - mid, size);
        }

        arrayDeque = array;
        next_First = mid1 - mid - 1;
        next_Last = mid1 - mid + size;

    }

    @Override
    public void addFirst(T item) {
        if (isFull()) {
            max_size *= 2;
            resize(size * 2);
        }
        arrayDeque[next_First] = item;
        next_First--;
        size++;
        if (next_First == -1) {
            next_First = max_size - 1;
        }
    };


    @Override
    public void addLast(T item) {
        if (isFull()) {
            max_size *= 2;
            resize(size * 2);
        }
        arrayDeque[next_Last] = item;
        next_Last++;
        size++;
        if (next_Last == max_size) {
            next_Last = 0;
        }
    };

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    ;

    @Override
    public int size() {
        return size;
    }

    ;

    @Override
    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        sortArray(arrayDeque);
        for (int i = size;i >0;i--){
            System.out.print(arrayDeque+" ");
        }
    }

    ;

    @Override
    public T removeFirst() {
        T value;
        if (size == 0) {
            return null;
        }

        if (next_First == max_size - 1) {
            value = arrayDeque[0];
            arrayDeque[0] = null;
            size--;
            next_First = 0;
        } else {
            value = arrayDeque[next_First + 1];
            //arrayDeque[next_First + 1] = null;
            next_First++;
            size--;
        }
        return value;
    }

    @Override
    public T removeLast() {
        T value;
        if (size == 0) {
            return null;
        }

        if (next_Last == 0) {
            value = arrayDeque[max_size - 1];
            arrayDeque[max_size - 1] = null;
            size--;
            next_Last = max_size - 1;
        } else {
            value = arrayDeque[next_Last - 1];
            //arrayDeque[next_Last - 1] = null;
            next_Last--;
            size--;
        }
        return value;
    }

    ;

    @Override
    public T get(int index){
        return arrayDeque[index];
    };

    public boolean equals(Object o){
        return true;
    };


    public boolean isFull() {
        if (next_Last - next_First == 1 && size != 0) {
            return true;
        }
        return false;
    }

    private T[] sortArray(T[] arrayDeque) {
        T[] array = (T[]) new Object[size];
        int mid = size / 2;
        if (!isFull())
        {
            if (next_First == size - 1){
                System.arraycopy(arrayDeque,0,array,0,size);
            } else if (next_Last == 0){
                System.arraycopy(arrayDeque,next_First + 1,array,0,size);
            } else if (next_First>= mid) {
                System.arraycopy(arrayDeque, next_First + 1, array, 0, size - next_Last);
                System.arraycopy(arrayDeque, 0, array, size - next_Last - 1, next_Last);
            } else if (next_Last <= mid) {
                System.arraycopy(arrayDeque, next_First + 1, array, 0, size - next_First + 1);
                System.arraycopy(arrayDeque, 0, array, size - next_First + 1, next_Last);
            }
        }
            if (next_First == size - 1 || next_Last == 0) {
                System.arraycopy(arrayDeque, 0, array, 0, size);
            } else if (next_First >= mid) {
                System.arraycopy(arrayDeque, next_First + 1, array, 0, size - next_Last);
                System.arraycopy(arrayDeque, 0, array, size - next_Last - 1, next_Last);
            } else if (next_Last <= mid) {
                System.arraycopy(arrayDeque, next_First + 1, array, 0, size - next_First + 1);
                System.arraycopy(arrayDeque, 0, array, size - next_First + 1, next_Last);
            }
            return array;
    }
}
