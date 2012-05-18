package com.playtech;

/**
 * Simple class implementing linked list which supports reversing elements
 * operation.
 * 
 * @author Anton Kharenko
 * 
 */
public class ReversableLinkedList {
	
	private static class Entry {
		Object element;
		Entry next;
		Entry previous;

		public Entry(Object element, Entry next, Entry previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
	}
	
	private Entry header = new Entry(null, null, null);

	public ReversableLinkedList() {
		header.next = header.previous = header;
	}

	/**
	 * Reverses given linked list.
	 */
	public void reverse() {
		Entry currentEntry = header; 
		do {
			swapLinks(currentEntry);
			currentEntry = currentEntry.previous;
		} while (currentEntry != header);
	}
	
	private void swapLinks(Entry entry) {
		Entry tmp = entry.next;
		entry.next = entry.previous;
		entry.previous = tmp;
	}
	
	/**
	 * Appends the specified element to the end of the list.
	 * 
	 * @param element
	 *            element to be appended to this list
	 */
	public void add(Object element) {
		Entry newEntity = new Entry(element, header, header.previous);
		header.previous.next = newEntity;
		header.previous = newEntity;
	}

	@Override
	public String toString() {
		Entry currentEntry = header.next;
		StringBuilder s = new StringBuilder("[");
		boolean firstElement = true;
		while (currentEntry != header) {
			if (!firstElement) {
				s.append(", ");
			}
			s.append(currentEntry.element);
			currentEntry = currentEntry.next;
			firstElement = false;
		}
		s.append("]");
		return s.toString();
	}
}
