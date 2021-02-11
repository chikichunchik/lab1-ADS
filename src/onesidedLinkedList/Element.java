package onesidedLinkedList;

public class Element {
    private Object content;
    private Element nextElement;

    public Element (Object content){
        this.content = content;
        this.nextElement = null;
    }

    public Element (Object content, Element nextElement){
        this.content = content;
        this.nextElement = nextElement;
    }

    public Object getContent() {
        return content;
    }

    public Element getNextElement() {
        return nextElement;
    }
    protected void setNextElement(Element nextElement){
        this.nextElement = nextElement;
    }
}
