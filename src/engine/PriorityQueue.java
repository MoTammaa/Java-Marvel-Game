package engine;

public class PriorityQueue implements Cloneable {

	@SuppressWarnings("rawtypes")
	private Comparable[] elements;
	private int nItems;
	private int maxSize;

	public PriorityQueue(int size) {
		maxSize = size;
		elements = new Comparable[maxSize];
		nItems = 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insert(Comparable item) {

		int i;
		for (i = nItems - 1; i >= 0 && item.compareTo(elements[i]) > 0; i--)
			elements[i + 1] = elements[i];

		elements[i + 1] = item;
		nItems++;
	}

	@SuppressWarnings("rawtypes")
	public Comparable remove() {
		nItems--;
		return elements[nItems];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	@SuppressWarnings("rawtypes")
	public Comparable peekMin() {
		return elements[nItems - 1];
	}

	public int size() {
		return nItems;
	}
	public PriorityQueue clone(){
		PriorityQueue tmp =new PriorityQueue(this.size());
		PriorityQueue returnable =new PriorityQueue(this.size());
		while(!this.isEmpty())
			tmp.insert(this.remove());
		while(!tmp.isEmpty()){
			this.insert(tmp.peekMin());
			returnable.insert(tmp.remove());
		}
		return returnable;
	}
}
