//Victor Lin
//APCS2 pd01
//HW32  Leon Leonwood Stack
//2018-04-12 R

import java.util.*;

public class ALStack<T> implements Stack<T>{
	private ArrayList<T> _stack;

	public ALStack(){
		_stack = new ArrayList<T>();
	}

	public boolean isEmpty(){
		return _stack.isEmpty();
	}

	public T peek(){
		return _stack.get(0);
	}

	public T pop(){
		return _stack.remove(0);
	}

	public void push(T x){
		_stack.add(0,x);
	}
}