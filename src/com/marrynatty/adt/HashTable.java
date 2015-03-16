package com.marrynatty.adt;

import java.util.Iterator;
import java.util.List;

public class HashTable<K,V> {
	List<LinkedList<KeyValue>> buckets;
	int numElements;
	
	/**
	 * @return the number of elements in this hash table
	 */
	public int size() {
		return numElements;
	}
	
	/**
	 * Inserts the given key-value pair into the table, replacing any previously
	 * associated value.
	 * @param key the key to insert
	 * @param value the value to insert associated with the key
	 * @return the old value associated with the key, or null if it's a new key
	 * @modifies this
	 * @effects inserts this key-value pair into the table
	 */
	public V insert(K key, V value) {
		KeyValue newKV = new KeyValue(key, value);
		// TODO:
		return null;
	}
	
	/**
	 * Looks up the given key the table, and if it is in it, returns the value
	 * associated with it.
	 * @param key the key to look up
	 * @return the value associated with the key, or null if the key was not found
	 */
	public V lookUp(K key) {
		// TODO:
		return null;
	}
	
	/**
	 * Removes a key-value from the HashTable and returns the value to the caller.
	 * @param key the key to lookup whose value will be removed
	 * @return the value associated with key, or null if the key was not found
	 * @modifies this
	 * @effects removes this key and its value from the table
	 */
	public V remove(K key) {
		// TODO:
		return null;
	}
	
	private class KeyValue {
		K key;
		V value;
		
		public KeyValue(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private class HTIterator implements Iterator<KeyValue> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public KeyValue next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
