package com.sh.dsa.array;

public class TestDynamicArray {

	public static void main(String[] args) {
		
		DynamicArray<Integer> dynamicArray = new DynamicArray<Integer>();
		
		dynamicArray.add(50);
		dynamicArray.add(25);
		dynamicArray.add(35);
		
		System.out.println(dynamicArray);
	}

}
