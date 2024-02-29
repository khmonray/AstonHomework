public interface MyCollection<T> {
    void add(T element);
    void add(int index, T element);
    T get(int index);
    void deleteAll();
    void sort();
    void delete(int index);
    int getSize();
}
