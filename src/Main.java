import arrayList.MyArray;
import doublyLinkedList.DoublyLinkedList;
import interfaces.List;
import onesidedLinkedList.OnesidedLinkedList;

public class Main {
    static public void main(String[] args){
        MyArray<Integer> testArray = new MyArray<>();
        tst(testArray, "Test MyArray");

        OnesidedLinkedList testOnesidedLL = new OnesidedLinkedList();
        tst(testOnesidedLL, "Test OnesidedLinkedList");

        DoublyLinkedList testDLL = new DoublyLinkedList();
        tst(testDLL, "Test DoublyLinkedList");
    }

    static void tst(List test, String msg){
        System.out.println("---------------- " + msg + " --------------------");
        long startTime;
        // Time to add 10^5 elements to end
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            test.insertToEnd(1);
        }
        System.out.println("Time to add 10^5 elements to end: " + (System.currentTimeMillis() - startTime) + " ms");

        // Time to add element to the end of list with size 10^5
        startTime = System.currentTimeMillis();
        test.insertToEnd(1);
        System.out.println("Time to add element to the end of list with size 10^5: " +
                (System.currentTimeMillis() - startTime) + " ms");

        // Time to delete element from the end of list with size 10^5 + 1
        startTime = System.currentTimeMillis();
        test.deleteFromEnd();
        System.out.println("Time to delete element from the end of list with size 10^5 + 1: " +
                (System.currentTimeMillis() - startTime) + " ms");

        // Time to add element to the start of list with size 10^5
        startTime = System.currentTimeMillis();
        test.insertToStart(1);
        System.out.println("Time to add element to the start of list with size 10^5: " +
                (System.currentTimeMillis() - startTime) + " ms");

        // Time to delete element from the start of list with size 10^5 + 1
        startTime = System.currentTimeMillis();
        test.deleteFromStart();
        System.out.println("Time to delete element from the start of list with size 10^5 + 1: " +
                (System.currentTimeMillis() - startTime) + " ms");

        // Time to set data in the last element of list with size 10^5
        startTime = System.currentTimeMillis();
        test.setEnd(2);
        System.out.println("Time to set data in the last element of list with size 10^5: " +
                (System.currentTimeMillis() - startTime) + " ms");

        // Time to set data i the first of list with size 10^5
        startTime = System.currentTimeMillis();
        test.setStart(3);
        System.out.println("Time to set data in the first element of list with size 10^5: " +
                (System.currentTimeMillis() - startTime) + " ms");

        // Time to count sum of list with 10^5 elements
        startTime = System.currentTimeMillis();
        test.sumInt();
        System.out.println("Time to count sum of list with 10^5 elements: " +
                (System.currentTimeMillis() - startTime) + " ms");

        // Time to find index of the first element in list with 10^5 elements
        startTime = System.currentTimeMillis();
        test.getIndex(3);
        System.out.println("Time to find index of the first element in list with 10^5 elements: " +
                (System.currentTimeMillis() - startTime) + " ms");

        // Time to find index of the last element in list with 10^5 elements
        startTime = System.currentTimeMillis();
        test.getIndex(2);
        System.out.println("Time to find index of the last element in list with 10^5 elements: " +
                (System.currentTimeMillis() - startTime) + " ms");

    }
}
