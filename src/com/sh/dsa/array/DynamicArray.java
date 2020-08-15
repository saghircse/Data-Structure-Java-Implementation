package com.sh.dsa.array;

@SuppressWarnings("unchecked")

public class DynamicArray <T> implements Iterable<T>{

	private T[] arr;
	private int len=0;		// Number of elements in the array
	private int capacity =0;	// Actual array size
	
	public DynamicArray() {
		this(16);
	}
	
	public DynamicArray(int capacity) {
		if(capacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity :"+capacity);
		}
		this.capacity = capacity;
		
		arr = (T[])new Object[capacity];
	}
	
	// Get the size of array
	public int size() {
		return len;
	}
	
	// To check if the array is empty
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// Get an element from array using index 
	public T get(int index) {
		if(index >= len || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		return arr[index];
	}
	
	// Set an element to given index of array
	public void set(int index, T element) {
		if(index >= len || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		arr[index] = element;
	}
	
	// Clear the array
	public void clear() {
		for(int i=0; i<len; i++) {
			arr[i] = null;
		}
		
		len=0;
	}
	
	// Add an element to array
	public void add(T elem) {
		
		// Time to resize
		if(len+1 >= capacity) {
			
			if(capacity == 0) {
				capacity = 1;
			}
			else {
				capacity = capacity * 2;
			}
			
			// Copy all the elements to new array from old array
			T[] new_arr = (T[]) new Object[capacity];
			for(int i=0; i<len; i++) {
				new_arr[i] = arr[i];
			}
			arr = new_arr;	
		}
		
		arr[len++] = elem;
	}
	
	// Remove an element from specific index
	public T removeAt(int index) {
		if(index >= len || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		T data = arr[index];
		
		T[] new_arr = (T[]) new Object[len-1];
		
		for(int i=0, j=0; i < len; i++, j++) {
			if(i == index) {
				j--; 	// if index is removing index, skip adding to new array by fixing j temporarily 
			}else {
				new_arr[j] = arr[i];
			}
		}
		
		arr = new_arr;
		capacity = --len;
		
		return data;
	}
	
	// Remove an element from array
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if(index == -1) {
			return false;
		}
		
		removeAt(index);
		return true;
	}
	
	
	// Find the index of element
	public int indexOf(Object obj) {
		for(int i=0; i<len; i++) {
			if(obj == null) {
				if(arr[i]==null) {
					return i;
				}
			}else {
				if(obj.equals(arr[i])) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	// Check if an element present in array
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}
	
	// Iterater is still fast but not as fast as iterative for loop
	
	@ Override
	public java.util.Iterator<T> iterator(){
	
		return new java.util.Iterator<T>() {
			int index = 0;
			
			@ Override
			public boolean hasNext() {
				return index < len;
			}
			
			@ Override
			public T next() {
				return arr[index++];
			}
			
			@ Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	// Override toString method
	@Override
	public String toString() {
		
		int iMax=len-1;
		
		if(len==0) {
			return "[]";
		}else {
			StringBuilder sb = new StringBuilder(len);
			sb.append("[");
			
			for(int i=0; i< len; i++) {
				sb.append(arr[i]);
				if(i == iMax) {
					sb.append("]");
				}else {
					sb.append(", ");
				}
			}
			return sb.toString();
		}
	}	
}
