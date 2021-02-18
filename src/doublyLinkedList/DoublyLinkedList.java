package doublyLinkedList;

import interfaces.List;

import java.util.NoSuchElementException;

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
        if(position<=0 || position > size-1){
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
        if(first == null){
            throw new NullPointerException("There are no elements");
        }

        first = first.next;
        first.prev = null;
        size--;
    }

    @Override
    public void deleteFromEnd() {
        if(last == null){
            throw new NullPointerException("There are no elements");
        }

        last = last.prev;
        last.next = null;
        size--;
    }

    @Override
    public void delete(Integer position) {
        if(position<=0 || position >= size-1){
            throw new IndexOutOfBoundsException();
        }

        if(size == 0){
            throw new NullPointerException("There are no elements");
        }
        else{
            Element current = first;
            for(int i=0; i<position; i++){
                current = current.next;
            }
            //delete current
            Element tempBefore = current.prev;
            Element tempAfter = current.next;
            tempBefore.next = current.next;
            tempAfter.prev = current.prev;
            size--;
        }
    }

    @Override
    public void setStart(Object content) {
        if(first == null){
            throw new NullPointerException("There are no elements");
        } else {
            Element newElement = new Element(content, null, first.next);
            first = newElement;
        }
    }

    @Override
    public void setEnd(Object content) {
        if(last == null){
            throw new NullPointerException("There are no elements");
        } else {
            Element newElement = new Element(content, last.prev, null);
            last = newElement;
        }
    }

    @Override
    public void set(Object content, Integer position) {
        if(position<=0 || position >= size-1){
            throw new IndexOutOfBoundsException();
        }

        Element newElement = new Element(content);
        if(size == 0){
            throw new NullPointerException("There are no elements");
        }
        else{
            Element current = first;
            for(int i=0; i<position; i++){
                current = current.next;
            }
            //set element instead of "current"
            newElement.next = current.next;
            newElement.prev = current.prev;
            Element tempBefore = current.prev;
            Element tempAfter = current.next;
            tempBefore.next = newElement;
            tempAfter.prev = newElement;
        }
    }

    @Override
    public Integer getIndex(Object content) {
        if(size == 0) {
            throw new NullPointerException("There are no elements");
        }
        else{
            int i = 0;
            Element current = first;
            while (current.content != content){
                i++;
                current = current.next;
                if (current == null){
                    throw new NoSuchElementException();
                }
            }
            return i;
        }
    }

    @Override
    public int sumInt() {
        if(size == 0) {
            throw new NullPointerException("There are no elements");
        }
        Element current = first;
        int sum = 0;
        for(int i = 0; i<size; i++) {
            if (current.content instanceof Integer) {
                sum += (int) current.content;
                current = current.next;
            } else {
                throw new IllegalArgumentException("Element is not Integer");
                }
            }
        return sum;
    }
}
