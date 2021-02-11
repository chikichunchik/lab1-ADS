package onesidedLinkedList;

import interfaces.LinkedList;

public class OnesidedLinkedList implements LinkedList {

    private Element firstElement;

    public OnesidedLinkedList(){
        this.firstElement = null;
    }

    @Override
    public void insertToStart(Object insertObject) {
        if (this.firstElement == null){
            this.firstElement = new Element(insertObject);
        } else {
            Element newFirstElement = new Element(insertObject, this.firstElement);
            this.firstElement = newFirstElement;
        }
    }

    @Override
    public void insertToEnd(Object insertObject) {
        if (this.firstElement == null){
            this.firstElement = new Element(insertObject);
        } else {
            Element lastElement = this.firstElement;
            while (lastElement.getNextElement() != null){
                lastElement = lastElement.getNextElement();
            }
            lastElement.setNextElement(new Element(insertObject));
        }
    }

    @Override
    public void insert(Object insertObject, Integer position) {

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

    public int size(){
        Element currentElement = this.firstElement;
        int result = 0;
        while (currentElement != null){
            result++;
            currentElement = currentElement.getNextElement();
        }
        return result;
    }

    @Override
    public String toString(){
        Element currentElement = this.firstElement;
        String out = "[";
        while (currentElement != null){
            if (currentElement.getNextElement() != null) {
                out += (currentElement.getContent().toString() + ", ");
            } else {
                out += (currentElement.getContent().toString());
            }
            currentElement = currentElement.getNextElement();
        }
        out += "]";
        return out;
    }

}
