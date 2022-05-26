//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T extends Comparable<T>> {
	protected SLLNode<T> head, tail;

	public SLL() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addCityToSublistAtRear(T el) throws Exception {
		if (isInList((City)el))
			throw new Exception("City already in list");
		addToTail(el);
	}

	public void addToCitySublistList(T el, int position) throws Exception {
		if (isInList((City)el))
			throw new Exception("City already in list");

		int n = length();
		if (position > (n + 1) || position <= 0)
			throw new Exception("Invalid postion");

		if (position == 1)
			addToHead(el);
		else if (position == (n + 1))
			addToTail(el);
		else {
			SLLNode<T> curr = head.next, pre = head;
			for (int i = 2; i < position; i++) {
				pre = curr;
				curr = curr.next;
			}
			pre.next = new SLLNode<T>(el, curr);
		}
	}

	public boolean cityIsInSubList(T el) {
		return isInList((City)el);
	}

	public void deleteCityFromSublist(T el) throws Exception {
		if (!isInList(getCity((String)el)))
			throw new Exception("City not in list");
		delete((T)getCity((String)el));
	}

	public City getCity(String s) {
		if(!isEmpty()) {
			SLLNode<T> curr = head;
			City city = new City(s);
			for(int i = 0; i<length() && !city.equals((City)curr.info) ;i++,curr = curr.next);
			if(curr == null)
				return null;
			return (City) curr.info;
		}
		return null;
	}
	
	public void addToHead(T el) {
		head = new SLLNode<T>(el, head);
		if (tail == null)
			tail = head;
	}

	public void addToTail(T el) {
		if (!isEmpty()) {
			tail.next = new SLLNode<T>(el);
			tail = tail.next;
		} else
			head = tail = new SLLNode<T>(el);
	}

	public T deleteFromHead() { // delete the head and return its info;
		if (isEmpty())
			return null;
		T el = head.info;
		if (head == tail) // if only one node on the list;
			head = tail = null;
		else
			head = head.next;
		return el;
	}

	public T deleteFromTail() { // delete the tail and return its info;
		if (isEmpty())
			return null;
		T el = tail.info;
		if (head == tail) // if only one node in the list;
			head = tail = null;
		else { // if more than one node in the list,
			SLLNode<T> tmp; // find the predecessor of tail;
			for (tmp = head; tmp.next != tail; tmp = tmp.next)
				;
			tail = tmp; // the predecessor of tail becomes tail;
			tail.next = null;
		}
		return el;
	}

	public void delete(T el) { // delete the node with an element el;
		if (!isEmpty())
			if (head == tail && el.equals(head.info)) // if only one
				head = tail = null; // node on the list;
			else if (el.equals(head.info)) // if more than one node on the list;
				head = head.next; // and el is in the head node;
			else { // if more than one node in the list
				SLLNode<T> pred, tmp;// and el is in a nonhead node;
				for (pred = head, tmp = head.next; tmp != null
						&& !tmp.info.equals(el); pred = pred.next, tmp = tmp.next)
					;
				if (tmp != null) { // if el was found;
					pred.next = tmp.next;
					if (tmp == tail) // if el is in the last node;
						tail = pred;
				}
			}
	}

	public void printAll() {
		for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
			System.out.println(tmp.info);
	}

	public boolean isInList(City el) {
		SLLNode<T> tmp;
		for (tmp = head; tmp != null && !el.equals((City)tmp.info); tmp = tmp.next)
			;
		return tmp != null;
	}

	
	public int length() {
		int i = 0;
		SLLNode<T> tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			i++;
		}
		return i;
	}

}
