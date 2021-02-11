package interfaces;

public interface LinkedList {
    void insertToStart (Object insertObject);
    void insertToEnd (Object insertObject);
    void insert (Object insertObject, Integer position);
    void deleteFromStart ();
    void deleteFromEnd ();
    void delete (Integer position);
    void setStart (Object setObject);
    void setEnd (Object setObject);
    void set (Object setObject, Integer position);
}
