package ru.dyudin.homework.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {

    private int size;

    private Object[] elementData = new Object[10];

    @Override
    public boolean add(E e) {
        if (size == 0) {
            if (size == elementData.length) {
                elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
            }
            elementData[size++] = e;
            return true;
        }
        elementData = Arrays.copyOf(elementData, 8);
        elementData[size++] = e;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public boolean contains(Object o) {
        for (Object i : elementData) {
            if (i.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return Arrays.copyOf(a, size);
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(o)) {
                System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int cache = 0;
        for (int a = 0; a < c.size(); a++) {
            for (Object i : elementData) {
                if (i.equals(c.toArray()[a])) {
                    cache++;
                }
            }
        }
        return cache == c.toArray().length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean addAll(Collection<? extends E> c) {
        for (int i = 0; i < c.size(); i++) {
            add((E) c.toArray()[i]);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (int a = 0; a < c.size(); a++) {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i].equals(c.toArray()[a])) {
                    System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                    size--;
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        for (int a = 0; a < size; a++) {
            boolean found = false;
            for (int i = 0; i < c.toArray().length; i++) {
                if (elementData[a].equals(c.toArray()[i])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.arraycopy(elementData, a + 1, elementData, a, size - a - 1);
                size--;
                a--;
                result = true;
            }
        }
        return result;
    }

        
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        elementData = Arrays.copyOf(elementData, 0);
        size = 0;
    }

    private class MyIterator<T> implements Iterator<T> {

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        private boolean cache = false;

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            cache = true;
            return (T) elementData[cursor++];
        }

        @Override
        public void remove() {
            if (!cache) {
                throw new IllegalStateException("No such element");
            }
            System.arraycopy(elementData, cursor + 1, elementData, cursor, size - cursor - 1);
            size--;
            cache = false;
        }
    }
}
