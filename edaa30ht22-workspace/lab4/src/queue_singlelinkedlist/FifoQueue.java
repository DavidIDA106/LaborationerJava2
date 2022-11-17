package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> q = new QueueNode<E>(e);
		if(last == null) {
			q.next = q;
		} else {
			q.next = last;
			last.next = q;

		}
		last = q;
		size++;
		return true;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if(last == null) {
			return null;
		}
		return last.next.element;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
	    E element = null;
	    if (last != null) {
	        element = last.next.element;

	        if (last.next == last) {
	            last = null;
            } else {
	            last.next = last.next.next;
            }

            size--;
        }

		return element;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E>{

		private QueueNode<E> pos;

		private void QueueIterator(){
			pos = (last != null) ? last.next : null;
		}

		public boolean hasNext(){
			return pos != null;
		}

		public E next(){
			if (hasNext()) {
	            E element = pos.element;
	            if (pos != last) {
	                pos = pos.next;
                } else {
	                pos = null;
                }
                return element;
            } else {
	            throw new NoSuchElementException();
            }
		}
		
	}

		public void append(FifoQueue<E> q) {
			if (q != this) {
				if (q.last != null) {
					QueueNode<E> last_node = q.last;
					QueueNode<E> first_node = q.last.next;
	
					if (last != null) {
						last_node.next = last.next;
						last.next = first_node;
					}
	
					last = last_node; // Point to the new end of the list
					size += q.size; // Update size
	
					// Reset queue
					q.last = null;
					q.size = 0;
				}
			} else {
				throw new IllegalArgumentException();
			}
		
	}

}
