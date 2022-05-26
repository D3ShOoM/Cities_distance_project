
public class MSLLNode<T extends Comparable<T>> {
	public T info;
	public SLL<T> list;
	public MSLLNode<T> next;

	public MSLLNode() {
		this(null, null, null);
	}

	public MSLLNode(T el) {
		this(el,null,new SLL<T>());
	}
	
	public MSLLNode(T el, MSLLNode<T> ptr) {
		this(el,ptr,new SLL<T>());
	}
	
	public MSLLNode(T el, SLL<T> list) {
		this(el, null, list);
	}

	public MSLLNode(T el, MSLLNode<T> ptr, SLL<T> list) {
		info = el;
		next = ptr;
		this.list = list;
	}
}
