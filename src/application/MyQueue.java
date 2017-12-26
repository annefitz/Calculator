//Anne Fitz
//CPS 350
//Project 2

package application;


public class MyQueue<T> {

	private T[] arr; //used to store data into this array in a queue manner

	private int total; //the total number of elements in the queue
	private int first; //the location of the first element in the queue
	private int rear; //the location of the next available element (last one's next)

	//Default constructor, by default the capacity is two elements of type T 
	public MyQueue()
    {
        arr = (T[]) new Object[2];
    }

	//Resizes the MyQueue to the capacity as the input argument specifies
    private void resize(int capacity)
    {
        T[] tmp = (T[]) new Object[capacity];

        for (int i = 0; i < total; i++)
            tmp[i] = arr[(first + i) % arr.length];

        arr = tmp;
        first = 0;
        rear = total;
    }
    
    //Checks if the queue is empty: if empty, returns true; otherwise returns false
    public boolean isEmpty()
    {
    	if (total == 0){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    //Adds one element "ele" into the queue
    //	(1) if the current queue is full, resizes it to twice of the current size.
    //  (2) if the "rear" is already pointing to the end of the queue, but there is available space
    	//       in the beginning, "loops" the rear position.
    public void enqueue(T ele)
    {	
    	//if current queue is full, resize
    	if (rear >= arr.length){
    		resize(arr.length*2);
    	}
    	if (rear == first){
    		rear = 0;
    	}
    	arr[rear] = ele;
    	rear++;
    	total++;
    }

    
    //Deletes the first (oldest) element from the queue and returns this element.

    	//			 (2) If the "first" is pointing to the end of the queue, but there is available space
    //				 in the beginning, you need to consider "loop" the first position.
    public T dequeue()
    {
    	// if number of elements is less than or equal to 1/4 of the capacity, shrink capacity to half original size
    	if (total <= arr.length/4){
    		resize(arr.length/2);
    	}
        T ele = arr[first];
        arr[first] = null;
        first++;
        total--;
     // if first is pointing to end of the queue, but available space in beginning, consider loop in first position
        if (first == arr.length){
    		first = 0;
    	}

        return ele;
    }
	
}
