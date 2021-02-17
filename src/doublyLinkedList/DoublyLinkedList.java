package doublyLinkedList;

import interfaces.List;

public class DoublyLinkedList implements List {
    private Element first, last;
    private Integer size;

    public DoublyLinkedList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }


    @Override
    public void insertToStart(Object content) {
        if(first == null){
            first = last = new Element(content);
        } else {
            Element newElement = new Element(content, null, first);
            first.prev = newElement;
            first = newElement;
        }
        size++;
    }

    @Override
    public void insertToEnd(Object content) {
        if(last == null){
            first = last = new Element(content);
        } else {
            Element newElement = new Element(content, last, null);
            last.next = newElement;
            last = newElement;
        }
        size++;
    }

    @Override
    public void insert(Object content, Integer position) {
        if(position<0 || position > size-1){
            throw new IndexOutOfBoundsException();
        }

        Element newElement = new Element(content);
        if(size == 0){
            first = last = newElement;
        }
        else{
            Element current = first;
            for(int i=0; i<position-1; i++){
                current = current.next;
            }
            //insert element after "current"
            newElement.prev = current;
            newElement.next = current.next;
            Element temp = current.next;
            current.next = newElement;
            temp.prev = newElement;
        }
        size++;
    }

    @Override
    public void deleteFromStart() {

    }

    @Override
    public void deleteFromEnd() {

    }

    @Override
    public void delete(Integer position) {

    }

    @Override
    public void setStart(Object setObject) {

    }

    @Override
    public void setEnd(Object setObject) {

    }

    @Override
    public void set(Object setObject, Integer position) {

    }

    @Override
    public Integer getIndex(Object getObject) {
        return null;
    }

    @Override
    public int sumInt() {
        return 0;
    }
}
