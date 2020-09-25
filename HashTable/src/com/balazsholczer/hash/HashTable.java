package com.balazsholczer.hash;

@SuppressWarnings("unchecked")
public class HashTable<Key, Value> {

	private Key[] keys;
	private Value[] values;
	private int numOfItems;
	private int capacity;

	public HashTable() {

		// Java does not let us create Generic arrays. (This does not mean Object
		// arrays. )
		// So we need to create Objects using Generics and then cast them to the
		// appropriate arrays.

		// Also notice how we don't have a single array here. We hold the keys and
		// values in different arrays.
		// Compared to the HashItem array which we have seen in earlier implementations
		// where the HashItem itself had key, value.
		this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
		this.values = (Value[]) new Object[Constants.TABLE_SIZE];
		this.capacity = Constants.TABLE_SIZE;
		this.numOfItems = 0;
	}

	// have to define a different constructor because when we resize the table we
	// use it !!!
	public HashTable(int capacity) {
		this.keys = (Key[]) new Object[capacity];
		this.values = (Value[]) new Object[capacity];
		this.capacity = capacity;
		this.numOfItems = 0;
	}

	public int size() {
		return this.numOfItems;
	}

	public boolean isEmpty() {
		return this.numOfItems == 0;
	}

	// This will be very similar to put method. Except update the value at the
	// matching key.
	public void update(int key) {

	}

	public Value get(Key key) {

		if (key == null)
			return null;

		// we have to calculate an array index from the key !!!
		int index = hash(key);

		// we have to consider the items right after each other because the item could
		// have been shifted down
		// because of the linear probing
		while (keys[index] != null) {
			if (keys[index].equals(key))
				return values[index];

			// have to check the next slot / array bucket
			index = (index + 1) % capacity;
		}

		// search miss: no value with the given key
		return null;
	}

	public int hash(Key key) {
		// because the key is not numeric, and is a char, we can use Java's inbuilt
		// function hashCode to convert it to a number and then modulo it with the max
		// table size to get the index.

		// sometimes readymade hashCode functions output negative numbers. So make sure
		// you do something to get only 0 and positive numbers becuase
		// otherwise Java will throw ArrayIndexutOfBoundsException.

		return key.hashCode() % this.capacity;
	}

	public void put(Key key, Value value) {

		if (key == null || value == null)
			return;

		// load balance is 0.75: so when the table is 75% full we resize it --> double
		// its size
		// why? when it is nearly empty --> we waste a lot of memory for no reason
		// when it is nearly full --> there will be lots of collisions --> O(1) will
		// reduce to O(N) or something like that
		if (numOfItems >= capacity * 0.75)
			resize(2 * capacity);

		int index = hash(key);

		// maybe there is a collision and there is already an item inserted to that
		// given index, so we have to
		// find an empty slot --> hence the condition != null
		while (keys[index] != null) {

			// update section: we update the value when the keys are equal
			if (keys[index].equals(key)) {
				values[index] = value;
				return;
			}

			index = (index + 1) % capacity;
		}

		// we have managed to found the array index where we can insert the value --> so
		// update accordingly !!!
		keys[index] = key;
		values[index] = value;
		numOfItems++;
	}

	public void remove(Key key) {

		if (key == null)
			return;

		int index = hash(key);

		// first we have to find the item we want to get rid of
		while (!keys[index].equals(key)) {
			index = (index + 1) % capacity;
		}

		// we delete the item: the key + the value
		keys[index] = null;
		values[index] = null;

		// we have to reconstruct the table starting from the item deleted: there is a
		// "hole" in the table in the middle,
		// the get() method will not work properly otherwise which relies on table being
		// full contiguously -- see while loop in get
		index = (index + 1) % capacity;

		while (keys[index] != null) {

			Key tempKey = keys[index];
			Value tempValue = values[index];

			keys[index] = null; // has to be made null for the while loop to work correctly
			values[index] = null;

			// we have to decrement the size, because with the put() method it will be
			// increased again
			// so it will be fine !!!
			numOfItems--;
			put(tempKey, tempValue);

			index = (index + 1) % capacity;
		}

		numOfItems--;

		// if only 33% of table is full, then reduce its size- else it will just be
		// wasting memory.
		if (numOfItems <= capacity / 3)
			resize(capacity / 2);
	}

	private void resize(int newCapacity) {

		System.out.println("Resize table with new capacity: " + newCapacity);

		HashTable<Key, Value> newTable = new HashTable<>(newCapacity);

		// have to rehash the table entries because the hashfunction relies heavily on
		// the
		// size: ~ key.hashCode() % sizeOfTable !!!
		// So it is a O(N) operation --> we should make as few resize operation as
		// possible !!!
		for (int i = 0; i < capacity; i++) {
			if (keys[i] != null) {
				newTable.put(keys[i], values[i]);
			}
		}

		// Now the new Hashtable becomes this Hashtable. So the keys and values
		// properties have to be updated to its keys and values arrays.
		// the capacity etc. other properties also need to be updated.
		keys = newTable.getKeys();
		values = newTable.getValues();
		capacity = newTable.getCapacity();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Key[] getKeys() {
		return keys;
	}

	public void setKeys(Key[] keys) {
		this.keys = keys;
	}

	public Value[] getValues() {
		return values;
	}

	public void setValues(Value[] values) {
		this.values = values;
	}
}
