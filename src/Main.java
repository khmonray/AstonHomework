public class Main {
    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyArrayList<>();

        for (int i = 1; i <= 6; i++) {
            myCollection.add("i = " + i);
            myCollection.add("a = " + i);
        }
        myCollection.sort();
        myCollection.delete(5);
        for(int i = 0; i < myCollection.getSize(); i++) {
            System.out.print(myCollection.get(i) + ", ");
        }
    }
}