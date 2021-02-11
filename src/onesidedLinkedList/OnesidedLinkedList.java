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
        if (position == 0){
            this.insertToStart(insertObject);
            return;
        }
        Element insertElement = this.firstElement;
        for (int i = 0; i < position - 1; i++){
            if(insertElement.getNextElement() == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            insertElement = insertElement.getNextElement();
        }
        if (insertElement == null) { throw new ArrayIndexOutOfBoundsException(); }
        if (insertElement.getNextElement() == null){
            this.insertToEnd(insertObject);
            return;
        }
        insertElement.setNextElement(new Element(insertObject, insertElement.getNextElement()));
    }

    @Override
    public void deleteFromStart() {
        if (this.firstElement == null){
            throw new ArrayIndexOutOfBoundsException();
        }
        this.firstElement = firstElement.getNextElement();
    }

    @Override
    public void deleteFromEnd() {
        if (this.firstElement == null){
            throw new ArrayIndexOutOfBoundsException();
        } else if (this.firstElement.getNextElement() == null){
            this.deleteFromStart();
            return;
        }
        Element penultimateElement = this.firstElement;
        while (penultimateElement.getNextElement().getNextElement() != null){
            penultimateElement = penultimateElement.getNextElement();
        }
        penultimateElement.setNextElement(null);
    }

    @Override
    public void delete(Integer position) {
        if (position == 0){
            this.deleteFromStart();
            return;
        }
        Element deleteElement = this.firstElement;
        for (int i = 0; i < position - 1; i++){
            if(deleteElement == null || deleteElement.getNextElement() == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            deleteElement = deleteElement.getNextElement();
        }
        if (deleteElement == null) { throw new ArrayIndexOutOfBoundsException(); }
        deleteElement.setNextElement(deleteElement.getNextElement().getNextElement());
    }

    @Override
    public void setStart(Object setObject) {
        if (this.firstElement == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.firstElement.setContent(setObject);
    }

    @Override
    public void setEnd(Object setObject) {
        if (this.firstElement == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Element lastElement = this.firstElement;
        while (lastElement.getNextElement() != null){
            lastElement = lastElement.getNextElement();
        }
        lastElement.setContent(setObject);
    }

    @Override
    public void set(Object setObject, Integer position) {
        if (position == 0) {
            this.setStart(setObject);
            return;
        }
        if (this.firstElement == null) { throw new ArrayIndexOutOfBoundsException(); }
        Element currentElement = this.firstElement;
        for (int i = 0; i < position; i++){
            currentElement = currentElement.getNextElement();
            if (currentElement == null) { throw new ArrayIndexOutOfBoundsException(); }
        }
        currentElement.setContent(setObject);
    }

    @Override
    public Integer getIndex(Object getObject){
        int counter = 0;
        Element currentElement = this.firstElement;
        while (currentElement != null) {
            if (currentElement.getContent() == getObject) {
                return counter;
            }
            currentElement = currentElement.getNextElement();
            counter++;
        }
        throw new IllegalArgumentException("This list doesn't contain this object");
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

    public int sumInt(){
        if (this.firstElement == null){
            return 0;
        }
        int result = 0;
        Element currentElement = this.firstElement;
        while (currentElement != null){
            if (currentElement.getContent() instanceof Integer){
                result += (int)currentElement.getContent();
            } else {
                throw new IllegalArgumentException("Element is not Integer");
            }
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
