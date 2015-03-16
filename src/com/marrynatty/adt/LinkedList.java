package com.marrynatty.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is a basic implementation of the LinkedList<E> class.
 * @author Josue Rios
 * @param <E> the type of elements for this list to hold
 */

public class LinkedList<E> implements Iterable<E> {
	private ListNode head, tail;
	private int numElements;
	
	/**
	 * Creates an empty linked list
	 */
	public LinkedList() {
		head = null;
		tail = null;
		numElements = 0;
	}
	
	/**
	 * @return the size of this list
	 */
	public int size() {
		return numElements;
	}
	
	/**
	 * Pushes the element to the front of the list
	 * @param el the element to push to the front of the list
	 */
	public void push(E el) {
		if (empty()) {
			head = new ListNode(el, null, null);
			tail = head;
		} else {
			head = new ListNode(el, null, head);
		}
		numElements++;
	}
	
	/**
	 * Pops the first element off the list
	 * @throws NoSuchElementException if the list is empty
	 * @return the first element of the list
	 */
	public E pop() {
		if (empty()) throw new NoSuchElementException();
		else {
			E oldVal = head.value;
			if (head.next == null)
				head = tail = null;
			else {
				head = head.next;
				head.prev = null;
			}
			numElements--;
			return oldVal;
		}
	}
	
	/**
	 * Appends the element to the end of the list
	 * @param el the element to push to the front of the list
	 */
	public void append(E el) {
		if (empty()) { 
			push(el);
			tail = head;
		} else {
			tail.next = new ListNode(el, tail, null);
			tail = tail.next;
			numElements++;
		}
	}
	
	/**
	 * Slices the last element off the list
	 * @throws NoSuchElementException is the list is empty
	 * @return the last element of the list
	 */
	public E slice() {
		if (empty()) throw new NoSuchElementException();
		else {
			E oldVal = tail.value;
			if (tail.prev == null)
				head = tail = null;
			else {
				tail = tail.prev;
				tail.next = null;
				numElements--;
			}
			return oldVal;
		}
	}
	
	/**
	 * @return true if list is empty, false otherwise
	 */
	private boolean empty() {
		return head == null;
	}

	@Override
	public Iterator<E> iterator() {
		return new LLIterator();
	}
	
	/**
	 * Represents a node in the list, with references to previous and next nodes
	 * @author Josue Rios
	 */
	private class ListNode {
		E value;
		ListNode next, prev;
		
		public ListNode(E value, ListNode prev, ListNode next) {
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}
	
	/**
	 * Is an iterator for this list.
	 * @author Josue Rios
	 */
	private class LLIterator implements Iterator<E> {

		ListNode curr = new ListNode(null, null, head);
		boolean removeCalled;
		
		@Override
		public boolean hasNext() {
			return curr.next != null;
		}

		@Override
		public E next() {
			removeCalled = false;
			E oldVal = curr.next.value;
			curr = curr.next;
			return oldVal;
		}

		@Override
		public void remove() {
			if (removeCalled) throw new IllegalStateException();
			if (curr.next == head) {
				head = head.next;
				head.prev = null;
				curr = new ListNode(null, null, head);
			} else {
				curr.prev.next = curr.next;
				if (curr.next != null)
					curr.next.prev = curr.prev;
			}
		}

		public void insertBefore(E el) {
			if (curr == head)
				push(el);
			else {
				curr.prev.next = new ListNode(el, curr.prev, curr);
				curr.prev = curr.prev.next;
			}
		}
		
	}
}
