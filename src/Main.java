public class Main {
    public static void main(String[] args) {
        MyCollection<String> myArrayList = new MyArrayList<>();

        for (int i = 1; i <= 6; i++) {
            myArrayList.add("i = " + i);
            myArrayList.add("a = " + i);
        }
        myArrayList.sort();
        myArrayList.delete(5);
        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.print(myArrayList.get(i) + ", ");
        }
        System.out.println();

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        for (int i = 1; i <= 6; i++) {
            myLinkedList.add("x = " + i);
            myLinkedList.add("b = " + i);
        }

        myLinkedList.deleteFirst();
        myLinkedList.deleteLast();
        myLinkedList.sort();
        for (int i = 0; i < myLinkedList.getSize(); i++) {
            System.out.print(myLinkedList.get(i) + ", ");
        }
    }

}