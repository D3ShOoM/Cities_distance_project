//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class MSLL<T extends Comparable<T>> {
	protected MSLLNode<T> head, tail;

	public MSLL() {
		head = tail = null;
	}

//	public void deleteCitySublist(String str) throws Exception {
//		if(!isInList((T)str)
//			throw new Exception("Node does not exist");
//		delete((T)str);
//	}

	public void makeCitySublistEmpty(String str) throws Exception {
		if (!isInList((T) str))
			throw new Exception("Node does not exist");
		MSLLNode<T> curr = head;
		while (!curr.info.equals(str))
			curr = curr.next;
		curr.list = new SLL<T>();
	}

	public void displayCitySublist(T el) throws Exception {
		if (!isInList(el))
			throw new Exception("Node does not exist");
		MSLLNode<T> curr = head;
		while (!curr.info.equals(el))
			curr = curr.next;
		curr.list.printAll();
	}

	public void addToMSLLHead(T el) throws Exception {
		if (isInList(el))
			throw new Exception("Node already exist");
		addToHead(el);
	}

	public void addToMSLLTail(T el) throws Exception {
		if (isInList(el))
			throw new Exception("Node already exist");
		addToTail(el);
	}

	public void deleteFromMSLL(T el) throws Exception {
		if (isEmpty())
			throw new Exception("MSLL is empty");
		if (!isInList(el))
			throw new Exception("Node does not exist");
		delete(el);
	}

	public boolean isInMSLList(T el) {
		return isInList(el);
	}

	public double getDistance(String city1, String city2) throws Exception {
		if (isEmpty())
			throw new Exception("Empty list");
		if(getMSLL(city1.charAt(0)+"" )== null || getMSLL(city1.charAt(0) + "")==null)
			throw new Exception("City is not in list");
		City c1 = getMSLL(city1.charAt(0) + "").list.getCity(city1),
				c2 = getMSLL(city2.charAt(0) + "").list.getCity(city2);
		if (c1 == null || c2 == null)
			throw new Exception("City is not in list");
		else {
			
			double la1 = Math.toRadians(c1.getLat()), la2 = Math.toRadians(c2.getLat()),
					lo1 = Math.toRadians(c1.getLon()), lo2 = Math.toRadians(c2.getLon());
			double distance = 2.0 * 6372.8 * Math.asin(Math.sqrt(Math.pow(Math.sin((la2 - la1) / 2.0), 2)
					+ Math.cos(la1) * Math.cos(la2) * Math.pow(Math.sin((lo2 - lo1) / 2.0), 2)));
			return distance;
		}
	}

	public MSLLNode<T> getMSLL(String s) {
		if (isInList((T) s)) {
			MSLLNode<T> curr = head;
			for (; !curr.info.equals(s); curr = curr.next)
				;
			return curr;
		}
		return null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addToHead(T el) {
		head = new MSLLNode<T>(el, head);
		if (tail == null)
			tail = head;
	}

	public void addToTail(T el) {
		if (!isEmpty()) {
			tail.next = new MSLLNode<T>(el);
			tail = tail.next;
		} else
			head = tail = new MSLLNode<T>(el);
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
			MSLLNode<T> tmp; // find the predecessor of tail;
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
				MSLLNode<T> pred, tmp;// and el is in a nonhead node;
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
		for (MSLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.info + " ");
	}

	public boolean isInList(T el) {
		MSLLNode<T> tmp;
		for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next)
			;
		return tmp != null;
	}

	
	public int length() {
		int i = 0;
		MSLLNode<T> tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			i++;
		}
		return i;
	}


}
