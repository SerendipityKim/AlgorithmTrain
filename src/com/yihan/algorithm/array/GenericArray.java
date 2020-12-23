package com.yihan.algorithm.array;

import java.util.Objects;

public class GenericArray<T> {
    private T[] array;
    private int size;

    GenericArray(int capacity) {
        array = (T[]) new Objects[capacity];
        size = 0;

    }

    //修改指定位置的元素
    public void set(int index, T element) {
        checkIndex(index);
        array[index] = element;
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    public boolean contain(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index, T e) {
        checkIndexForAdd(index);
        if (size == array.length) {
            resize(2 * array.length);
        }
        for (int i = size - 1; i > index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = e;

        size++;
    }

    public T remove(int index) {
        checkIndex(index);
        T e = array[index];
        for (int i = index + 1; i < size; i--) {
            array[i - 1] = array[i];
        }
        size--;
        array[size] = null;

        //缩容
        if (size == array.length / 4 && array.length / 2 != 0) {
            resize(array.length / 2);
        }
        return e;
    }

    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    private void resize(int capacity) {
        T[] data = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            data[i] = array[i];
        }
        array = data;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is invalid");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is invalid");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GenericArray{");
        sb.append("size=").append(size);
        sb.append(" [ ");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(" ");
            }
        }
        sb.append("] }");
        return sb.toString();
    }

    public static void main(String[] args) {
        GenericArray<Object> genericArray = new GenericArray<>(5);
//
        System.out.println(genericArray.toString());

    }
}
