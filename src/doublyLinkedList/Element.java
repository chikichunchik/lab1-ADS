package doublyLinkedList;

public class Element {
    protected Object content;
    protected Element prev, next;

    public Element(Object content){
        this.content = content;
    }

    public Element(Object content, Element prev, Element next) {
        this.content = content;
        this.next = next;
        this.prev = prev;
    }

//    public Element getNextElement() {
//        return next;
//    }
//
//    public Element getPrevElement() {
//        return prev;
//    }

}
