package com.balazsholczer.linear;

public class HashTable {

	private HashItem[] hashTable;

	public HashTable() {
		this.hashTable = new HashItem[Constants.TABLE_SIZE];
	}

	// This will be very similar to put method. Except update the value at the
	// matching key.
	public void update(int key) {

	}

	public int get(int key) {

		int generatedIndex = hashFunction(key);

		while (hashTable[generatedIndex] != null && hashTable[generatedIndex].getKey() != key) {
			generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE; // Linear Probing - we increment the
																			// generatedIndex by 1 if the generatedIndex
																			// is not the key we are looking for

			// Here is where we will change the logic for Quadratic probling i.e 1,2,4,8
			// and for rehashing or double hashing.
			System.out.println("Hopping to the next index: " + generatedIndex);
		}

		if (hashTable[generatedIndex] == null) {
			return -1;
		} else {
			return hashTable[generatedIndex].getValue();
		}
	}

	public void put(int key, int value) {

		int generatedIndex = hashFunction(key);
		System.out.println("put() method called with value: " + value + " - generatedIndex:" + generatedIndex);

		// loop until you find a null to put your key
		while (hashTable[generatedIndex] != null) {
			generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE; // Linear Probing - we increment the
			// generatedIndex by 1 if the generatedIndex
			// is full

			// Here is where we will change the logic for Quadratic probling i.e 1,2,4,8
			// and for rehashing or double hashing.

			System.out.println("Collision -> nexIndex: " + generatedIndex);
		}

		System.out.println("Inserted finally with index: " + generatedIndex);
		hashTable[generatedIndex] = new HashItem(key, value);
	}

	private int hashFunction(int key) {
		// return key % Constants.TABLE_SIZE;
		return 0;
	}
}
