//Victor Lin
//APCS2 pd01
//HW34 The English Do Not Wait in Line
//2018-04-16 M

public class NodeQueue<T> implements Queue<T>{
	private LLNode<T> _head;
	private LLNode<T> _tail;
	private int _size;

	public NodeQueue(){
		_head = new LLNode<T>(null,null);
		_tail = _head;
		_size = 0;
	}

	public T dequeue(){
		T temp = _head.getValue();
		_head = _head.getNext();
		_size--;
		return temp;
	}

	public void enqueue(T x){
		_tail.setNext(new LLNode<T>(x,_tail));
		_tail = _tail.getNext();
		if(isEmpty())
			_head = _tail;
		_size++;
	}

	public boolean isEmpty(){
		return _size == 0;
	}

	public T peekFront(){
		return _head.getValue();
	}
}