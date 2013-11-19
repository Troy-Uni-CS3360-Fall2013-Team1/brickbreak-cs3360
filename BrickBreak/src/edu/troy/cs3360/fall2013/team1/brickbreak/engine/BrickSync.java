package edu.troy.cs3360.fall2013.team1.brickbreak.engine;
import java.util.Arrays;


public class BrickSync<E> {
	
	private int size = 0;
	private static final int Capacity = 20;
	private Object elements[];

	public BrickSync()
	{
		elements = new Object[Capacity];
		
	}
	
	public void add (E e)
	{
		if (size == elements.length)
		{
			ensureCapa();
			
		}
		elements[size++] = e;
	}
	
	private void ensureCapa()
	{ 
		int newSize = elements.length *2;
		elements = Arrays.copyOf(elements, newSize);
		
	}
	
	@SuppressWarnings("unchecked")
	public E get(int i)
	{
		if ( i>= size || i<0)
		{
			throw new IndexOutOfBoundsException( " Index:" + i + ", Size" + i);
			
		}
		return(E) elements[i];
	}
}
