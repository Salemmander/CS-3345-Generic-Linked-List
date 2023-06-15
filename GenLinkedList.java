import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
	
public class GenLinkedList<T> {

		private Node<T> head;
		private Node<T> tail;
		int size = 0;
		
		public void addFront(T d) {
			if (head == null) {// in the case of an empty list
				head = new Node<T>(d, null);
				tail = head;
			}
			else {// in the case of a non empty list
				head = new Node<T>(d, head);
			}
			size++;
		}
		
		public void addEnd(T d) {
			if (head != null) {// list is not empty
				tail.next = new Node<T>(d,null);
				tail = tail.next;
				size++;
			}
			else {// list is empty so same as adding to the front
				addFront(d);
			}
		}
		
		public void removeFront() {
			if (head == null) // empty list
				throw new NoSuchElementException();
			if(head == tail){// one node only
				head = tail = null;
			}
			else {				// More than one node
				head = head.next;
			}
			size--;
		}
		
		public void removeEnd() {		
			if(head == null) //empty list
				throw new NoSuchElementException();
			if (head == tail) {// one node only
				head = tail = null;
			}
			else {   // multiple nodes
				Node<T> p = head;
				while(p.next != tail) 
					p = p.next;
				tail = p;
				tail.next = null;
			}
			size--;
		}
		
		public String toString() {
			String s = "[ ";
			
			Node<T> p = head;
			while (p != null) {
				s += p.data +" ";
				p = p.next;
			}
			return s+ "]";
		}
		
		public void set(T d, int i) {
			if(i < 0 || i >= size) //out of bounds
				throw new ArrayIndexOutOfBoundsException("Index " + i + "; Size is "+ size);
			else {// not out of bounds
				Node<T> p = head;
				for (int k = 0;k<i;k++)
					p = p.next;
				p.data = d;
			}
		}
		
		public T get(int i) {
			if(i < 0 || i >= size) //out of bounds
				throw new ArrayIndexOutOfBoundsException("Index :" + i + "; Size is "+ size);
			else {// not out of bounds
				Node<T> p = head;
				for (int k = 0; k < i; k++)
					p=p.next;
				return p.data;
			}
		}
		
		public void swap(int i, int j) {
			Node<T> prevNode1 = null, prevNode2 = null;
			Node<T> Node1 = head, Node2 = head;
			
			if (head == null)// list is empty
				throw new IllegalStateException("List is empty.");
			else if(i > size - 1 || i < 0|| j < 0 || j > size - 1)
				throw new ArrayIndexOutOfBoundsException("Index is not in list's bounds.");
			else if(i == j)// trying to swap  the same node so nothing needs to be done
				return;
			else {
				for (int k=0;k<i;k++) {// finding 1st node
					prevNode1 = Node1;
					Node1 = Node1.next;
				}
				
				for (int g=0;g<j;g++) {// finding 2nd node
					prevNode2 = Node2;
					Node2 = Node2.next;
				}
				if(Node1 != null && Node2 != null) { // if nodes aren't null swap them
					if(prevNode1 != null)
						prevNode1.next = Node2;
					else
						head = Node2;
					
					if(prevNode2 != null)
						prevNode2.next = Node1;
					else
						head = Node1;
					
					// swapping the next pointers
					Node<T> temp = Node1.next;
					Node1.next = Node2.next;
					Node2.next = temp;		
				}
			}
		}
		
		public void shift(int i) {
			if (head == null)
				throw new IllegalStateException("List is empty.");
			else if(head == tail)
				throw new IllegalStateException("List only contains one element.");
			else if(i==0)
				return;
			if (i < 0) {
				i *= -1;
				if (i > size)
					i = i % size;
				i = size - i;
			}
			Node<T> curr = head;
				if (i > size)
					i = i % size;
				int count = 1;
				while (count < i && curr != null) {
					curr = curr.next;
					count++;
				}
				Node<T> tempCurr = curr;
				while (curr.next != null)
					curr = curr.next;
				curr.next = head;
				head = tempCurr.next;
				tempCurr.next = null;
		}
		
		public void removeMatching(T d) {
			if (head == null)// empty list
				throw new NoSuchElementException("The list is empty.");
			else if (head == tail) {// only one element
				if (head.data == d) {
					removeFront();
				}
			}
			else {// more than one element
				Node<T>currPrev=null;
				Node<T>curr = head;
				
				while (curr != null && curr.data == d) {// deleting when head contains element
					head =  curr.next;
					curr = head;
				}
				while(curr != null) {
					while(curr != null && curr.data != d) {
						currPrev = curr;
						curr = curr.next;
					}
					if(curr == null)//
						return;
					
					currPrev.next = curr.next;
					curr = currPrev.next;
				}
			}
		}
		
		public void erase(int index, int num) {
			if (head == null) {
				throw new IllegalStateException("List is empty");
			}
			else {
				Node<T> curr = head;
				
				if (index < 0)
					throw new ArrayIndexOutOfBoundsException("Index cannot be negative.");
				
				if (index > size - 1)
					throw new ArrayIndexOutOfBoundsException("Index is beyond bounds of the list.");
				
				if((size-index) >= num && (index + num) <= size) {
					if(index == 0) {
						for (int k = 1;k <= num;k++) {
							head = head.next;
						}
					}
					else if(index < size) {
						for (int i = 0; i < index - 1; i++) {
							curr = curr.next;
						}
						for (int k = 1;k <= num;k++) {
							curr.next = curr.next.next;
						}
					}
				}
			}
		}
		
		public void insertList(List<T> list, int index) {
			if (head == null) {// list is empty
				for (int i = 0; i < list.size(); i++) {
					addEnd(list.get(i));
				}
			}
			else if(index >= 0 && index < size){// if index is in bounds add list
				Node<T> curr = head;
				
				for (int k = 0; k < index; k++) {
					curr = curr.next;
				}
				for(int j = 0; j < list.size(); j++) {
					curr.next = new Node<T>(list.get(j), curr.next);
				}
			}
		}
		
		private static class Node<T>{
			Node(T d, Node<T> n){
				data = d;
				next = n;
			}
			
			T data;
			Node<T> next;
		}
		
		
	

	public static void main(String[] args) {
		GenLinkedList<Integer> list = new GenLinkedList<>();
		list.addFront(0);
		System.out.println("Starting list: " + list);

		// show addEnd
		list.addEnd(1);
		System.out.println("Add End: " + list);// all the print statements show toString
		// show addFront
		list.addFront(2);
		System.out.println("Add Front: " + list);
		
		// showing removeEnd
		list.removeEnd();
		System.out.println("Remove End: " + list);
		list.removeFront();
		System.out.println("Remove Front: " + list);
		list.removeEnd();
		line();

		for (int i = 0; i < 10; i++)
			list.addEnd(i);
		System.out.println("New Starting List: " + list);
		

		// showing set
		list.set(60, 0);
		System.out.println("Set: " + list);
		
		//showing get
		System.out.println("Get: " + list.get(0));
		
		//showing swap
		list.swap(0,1);
		System.out.println("Swap: " + list);
		
		line();

		//clearing and adding 0-9 to list
		list.removeFront();
		list.removeFront();
		list.addFront(1);
		System.out.println("New Starting List: " + list);
		//showing shift
		list.shift(5);
		System.out.println("Shift: " + list);
		list.shift(-5);
		System.out.println("Shift: "  + list);	

		line();

		// showing remove matching
		for(int h = 0; h < 10; h++) {
			list.removeFront();
			list.addEnd(5);
			list.addEnd(h);
		}
		System.out.println("New Starting List: " + list);

		list.removeMatching(5);
		System.out.println("Remove Matching: " + list);
		
		// showing erase
		list.erase(0, 5);
		System.out.println("Erase: " + list);
		
		//showing insertList
		ArrayList<Integer> arr = new ArrayList<>();
		for(int f = 0; f<10;f++) {
			arr.add(f);
		}
		System.out.println("List to Insert: " + arr);
		list.insertList(arr, 0);
		System.out.println("Insert List: " + list);
	}

	public static void line(){
		System.out.println("___________________________________");
		System.out.println("");
	}
}
