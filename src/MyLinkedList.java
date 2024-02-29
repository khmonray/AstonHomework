public class MyLinkedList<T> implements MyCollection<T>{

    private Node<T> startNode;
    private Node<T> endNode;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> last;
        Node(T element) {
            this.element = element;
        }
    }
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if(endNode == null) {
            startNode = newNode;
        } else {
            endNode.next = newNode;
            newNode.last = endNode;
        }
        endNode = newNode;
        size++;
    }

    @Override
    public void add(int index, T element) {
        if(index >= 0 && index < size) {
            Node<T> newNode = new Node<T>(element);
            if(index == 0) {
                newNode.next = startNode;
                startNode.last = newNode;
                startNode = newNode;
            } else {
                Node<T> temp = startNode;
                for(int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                newNode.last = temp;
                temp.next = newNode;
                if(newNode.next != null) {
                    newNode.next.last = newNode;
                } else {
                    endNode = newNode;
                }
            }
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T get(int index) {
        if(index >= 0 && index < size) {
            Node<T> temp = startNode;
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void deleteAll() {
        startNode = null;
        endNode = null;
        size = 0;
    }

    @Override
    public void sort() {
        Node<T> temp = startNode;
        if (size > 0) {
            boolean swapped;
            do {
                swapped = false;
                temp = startNode;
                while (temp.next != null) {
                    if (((Comparable<T>) temp.element).compareTo((T) temp.next.element) > 0) {
                        T tempData = temp.element;
                        temp.element = temp.next.element;
                        temp.next.element = tempData;
                        swapped = true;
                    }
                    temp = temp.next;
                }
            } while (swapped);
        }
    }

    @Override
    public void delete(int index) {
        if(index >= 0 && index < size) {
            Node<T> temp = startNode;
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
            if(temp.last != null) {
                temp.last.next = temp.next;
            } else {
                startNode = temp.next;
            }
            if(temp.next != null) {
                temp.next.last = temp.last;
            } else {
                endNode = temp.last;
            }
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int getSize() {
        return size;
    }
}
