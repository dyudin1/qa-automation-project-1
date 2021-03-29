package ru.dyudin.homework.collections;

import java.util.*;

@SuppressWarnings("NullableProblems")
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
        for (int j = 0; j < size; j++) {
            Object i = elementData[j];
            if (Objects.equals(i, o)) {
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
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        for (int j = 0; j < size; j++) {
            a[j] = (T) elementData[j];
        }
        return a;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if (Objects.equals(elementData[i], o)) {
                System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsAll(Collection<?> c) {
        int cache = 0;
        MyCollection objectsCache = new MyCollection();
        for (int a = 0; a < c.size(); a++) {
            for (Object i : elementData) {
                if (Objects.equals(i, c.toArray()[a]) && !objectsCache.contains(i)) {
                    objectsCache.add(i);
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
                if (Objects.equals(elementData[i], c.toArray()[a])) {
                    System.arraycopy(elementData, i + 1, elementData, i, elementData.length - i - 1);
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
                if (Objects.equals(elementData[a], c.toArray()[i])) {
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
            System.arraycopy(elementData, cursor, elementData, cursor - 1, elementData.length - cursor);
            size--;
            cursor--;
            cache = false;
        }
    }
}
