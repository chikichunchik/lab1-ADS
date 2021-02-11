import onesidedLinkedList.OnesidedLinkedList;

public class Main {
    static public void main(String[] args){
        OnesidedLinkedList test = new OnesidedLinkedList();
        test.insertToEnd(1);
        test.insertToEnd(2);
        System.out.println(test);
        System.out.println(test.size());
    }
}
