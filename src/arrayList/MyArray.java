package arrayList;

import interfaces.List;
import java.util.Iterator;

public class MyArray<E> implements Iterable<E>, List {
	private int size = 10;
	private Object[] array = new Object[size];
	private double loadfactor = 1/3;
	private int current = 0;
	
	private class ArrIterator<E> implements Iterator<E>{
		int index=0;
		@Override
		public boolean hasNext() {
			if(index<current) {
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			return (E) array[index++];
		}
	}
	
	
	
	private void changeSize(int size) {
		this.size=size;
		Object[] temparr = new Object[size];
		System.arraycopy(this.array, 0, temparr, 0, this.current);
		this.array=temparr;
	}
	
	@Override
	public int sumInt(){
        if (this.current == 0){
            return 0;
        }
        try {
        	int element = (Integer) this.array[0];
        }
        catch(ClassCastException e) {
        	throw new IllegalArgumentException("Array not consist with integer");
        }
        int result = 0;
        for(int i=0;i<current;i++) {
        	int number = (Integer) array[i];
        	result+=number;
        }
        return result;
    }
	
	@Override
	public void setEnd (Object setObject) {
		try {
			E element = (E) setObject;
		if(this.current>=this.size-1) {
			changeSize(this.size*2);
		}
		array[this.current++]=element;
		}
		catch(ClassCastException e) {
			throw new IllegalArgumentException("Invalid type of element");
		}
	}
	
	@Override
	public void insert(Object obj, Integer index) {
		if(index>this.current) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		try {
			E element = (E) obj;
		if(this.current>=this.size-1) {
			this.size=this.size*2;
			Object[] temparr = new Object[size];
			for(int i=0;i<index;i++) {
				temparr[i]=this.array[i];
			}
			temparr[index]=element;
			for(int i =index+1;i<=this.current;i++) {
				temparr[i]=this.array[i-1];
			}
			this.array=temparr;
		}
		else {
			for(int i=current;i>index;i--) {
				this.array[i]=this.array[i-1];
			}
			this.array[index]=element;
		}
		this.current++;
		}
		catch (ClassCastException e) {
			throw new IllegalArgumentException("Invalid type of element");
		}
	}
	
	@Override
	public void delete(Integer index){
		if(index>=this.current) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		for(int i=index;i<this.current;i++) {
			this.array[i]=this.array[i+1];
		}
		this.current--;
		if (this.current>3 && this.current<=this.loadfactor*this.size) {
			changeSize(this.size/2);
		}
	}
	
	@Override
	public void set(Object elem, Integer index) {
		try {
			E element= (E) elem;
		if(index>=this.current) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if(index<this.current) {
			this.array[index]=element;
		}
		} catch(ClassCastException e) {
    	throw new IllegalArgumentException("Invalid type of element");
		}
	}
	
	public int getSize() {
		return current;
	}
	
	@Override
	public Integer getIndex(Object object) {
		try {
			E element= (E) object;
		for(int i =0;i<current;i++) {
			if(array[i]==object) {
				return i;
			}
		}
		throw new IllegalArgumentException("Element not exist");
		} catch(ClassCastException e) {
    	throw new IllegalArgumentException("Invalid type of element",e);
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ArrIterator<E>();
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for(int i=0;i<this.current;i++) {
			E element =(E) this.array[i];
			buffer.append(element.toString());
			buffer.append(", ");
			if(i!=0 && i%100==0) {
				buffer.append("\n");
			}
		}
		buffer.delete(buffer.length()-2, buffer.length());
		buffer.append("]");
		return buffer.toString();
	}

	@Override
	public void insertToStart(Object insertObject) {
		this.insert(insertObject, 0);
	}

	@Override
	public void insertToEnd(Object insertObject) {
		this.insert(insertObject, this.current);	
	}

	@Override
	public void deleteFromStart() {
		this.delete(0);
		
	}

	@Override
	public void deleteFromEnd() {
		this.delete(this.current-1);
		
	}

	@Override
	public void setStart(Object setObject) {
		this.set(setObject, 0);
		
	}


	
}
