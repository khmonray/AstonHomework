/*Реализовать свой ArrayList и LinkedList (не потокобезопасный
Методы – добавить элемент, добавить элемент по индексу, получить элемент,
удалить элемент, очистить всю коллекцию, отсортировать, остальное по желанию. Реализация с java.util не принимаются!*/
public class MyArrayList<T> implements MyCollection<T> {
    private Object[] innerArray;
    private int size;

    public MyArrayList() {
        innerArray = new Object[10];
        size = 0;
    }

    private void checkOrResize() {
        if(size == innerArray.length) {
            Object[] newInnerArray = new Object[size * 2];
            System.arraycopy(innerArray, 0, newInnerArray, 0, size);
            innerArray = newInnerArray;
        }
    }

    @Override
    public void add(T element) {
        checkOrResize();
        innerArray[size++] = element;
    }

    @Override
    public void add(int index, T element) {
        checkOrResize();
        if(index >= 0 && index < size) {
            System.arraycopy(innerArray, index, innerArray, index + 1, size - index);
            innerArray[index] = element;
            size++;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T get(int index) {
        if(index >= 0 && index < size) {
            return (T) innerArray[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void delete(int index) {
        System.arraycopy(innerArray, index + 1, innerArray, index, size - index - 1);
        size--;
    }

    @Override
    public void deleteAll() {
        innerArray = new Object[10];
        size = 0;
    }

    @Override
    public void sort() {
        for(int i = 0; i < size - 1; i++) {
            for(int j = 0; j < size - i - 1; j++) {
                if(((Comparable<T>) innerArray[j]).compareTo((T) innerArray[j + 1]) > 0) {
                    T temp = (T) innerArray[j];
                    innerArray[j] = innerArray[j + 1];
                    innerArray[j + 1] = temp;
                }
            }
        }
    }
    @Override
    public int getSize() {
        return size;
    }
}
