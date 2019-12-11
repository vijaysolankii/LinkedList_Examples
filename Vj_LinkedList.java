/*
Instructions for methods which we going to use in this program
	
Node:
	variables:->
		int data
		node next 

	Methods:->
		Node();
		Node(int d,node n);
		void getNext(node n);   // node getNext();
		void setNext(node n);  // node setNext();
		void getData(int d);  // int getData();
		void setData(int d); // int setData();

LinkedList:
	variables:->
		int size;
		node start;

	Methods:->
		LinkedList();
		boolean isEmpty();
		int getListSize();
		void viewList();
		void insertAtFirst(int val);
		void insertAtLast(int val);
		void insertAtPos(int val,int pos);
		void deleteAtFirst();
		void deleteAtLast();
		void deleteAtPos(int pos);
*/
import java.util.Scanner;
class Node{
	private int data;
	private Node next;

	public Node(){
		data = 0;
		next = null;
	}

	public Node(int d,Node n){
		data = d;
		next = n;
	}

	public void setData(int d){
		data=d;
	}
	
	public void setNext(Node n){
		next=n;
	}

	public int getData(){
		return(data);
	}

	public Node getNext(){
		return(next);
	}
}

class LinkedList{
	private int size;
	private Node start;

	public LinkedList(){
		size = 0;
		start = null;
	}

	public boolean isEmpty(){
		if(start == null)
			return(true);
		else
			return(false);
	}

	public int getListSize(){
		return(size);
	}

	public void viewList(){
		Node t;
		t = new Node();
		if(isEmpty())
			System.out.println("List is Empty");
		else
			t = start;
			for(int i = 1; i<=size; i++){
				System.out.println(" " + t.getData());
				t = t.getNext();
			}
	}

	public void insertAtPos(int val,int pos){
		if(pos==1)
			insertAtFirst(val);
		else if (pos==size+1)
			insertAtLast(val);
		else if (pos>1 && pos<=size){
			Node n,t; 
			n = new Node(val,null);
			t = start;
			for(int i=1;i<=pos-1;i++){
				t = t.getNext();
			}
			n.setNext(t.getNext());
			t.setNext(n);
			size++;
		}
		else
			System.out.println("You Entered Invalid Data");
	}

	public void insertAtFirst(int val){
		Node n = new Node();
		n.setData(val);
		n.setNext(start);	
		start=n;
		size++;
	}

	public void insertAtLast(int val){
		Node n,t;
		n = new Node();
		n.setData(val);
		t = start;
		if (t == null)
			start = n;
		else{
			while(t.getNext() != null)
				t = t.getNext();
			t.setNext(n);
		}
		size++;
	}
		

	public void deleteAtFirst(){
		if(start==null){
			System.out.println("List is already Empty");
		}else{
			start = start.getNext();
			size--;
		}
	}

	public void deleteAtLast(){
		if(start == null)
			System.out.println("List is already Empty");
		else if (size == 1){
			start=null;
			size--;
		}else{ 
			Node t;
			t = start;
			for(int i = 1; i<=size-1; i++)
				t = t.getNext();	
			t.setNext(null);
			size--;
		}
	}

	public void deleteAtPos(int pos){
		if(start==null)
			System.out.println("List is already empty");
		else if (pos < 1 || pos > size) 
			System.out.println("Invalid Position");
		else if (pos == 1)
			deleteAtFirst();
		else if (pos == size)
			deleteAtLast();
		else{
			Node t,t1;
			t = start;
			for (int i = 0; i<pos-1; i++)
				t = t.getNext();
			t1 = t.getNext();
			t.setNext(t1.getNext());
			size--;
		}
	}
}

class Test{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList l = new LinkedList();
		boolean flag = true;
		while(flag){
			System.out.println("-------------------------------------------");
			System.out.println("| 1.Add item from the list at Start       |");
			System.out.println("| 2.Add item from the list at Last        |");
			System.out.println("| 3.Add item from the list at Position    |");
			System.out.println("| 4.Delete item from the list at Start    |");
			System.out.println("| 5.Delete item from the list at Last     |");	
			System.out.println("| 6.Delete item from the list at Position |");
			System.out.println("| 7.View List                             |");
			System.out.println("| 8.Exit                                  |");
			System.out.println("|-----------------------------------------|");
			System.out.println("|Enter Your Choice                        |");
			System.out.println("|-----------------------------------------|");
			//System.out.println("\n\n");
			int position,val;
			int choice = sc.nextInt();
			switch(choice){
				case 1: 
						System.out.println("insert value at First");
						val = sc.nextInt();
						l.insertAtFirst(val);
						break;				
				case 2: 
						System.out.println("insert value at Last");
						val = sc.nextInt();
						l.insertAtLast(val);
						break;
				case 3: 
						System.out.println("Enter Position to add value in the list");
						position = sc.nextInt();
						System.out.println("Enter value of list item");
						val = sc.nextInt();
						l.insertAtPos(val,position);
						break;
				case 4: 
						l.deleteAtFirst();
						break;
				case 5: 
						l.deleteAtLast();
						break;
				case 6: 
						System.out.println("Enter Position");
						position = sc.nextInt();
						l.deleteAtPos(position);
						break;
				case 7: 
						l.viewList();
						break;

				case 8:
						flag = false;
						break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
}