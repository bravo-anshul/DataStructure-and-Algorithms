import java.util.*;

public class linkedList{

	public static class Node{
			int data;
			Node next; 

			Node(int d){
				data = d;
				next = null;
			}
		}


	public static class LinkedList{
		Node head;

		// THIS PUSHES A NODE
		
		public void push(int d){
			Node newNode = new Node(d);
			newNode.next = head;
			head = newNode;

		}

		// THIS INSERTS A NODE AFTER A SPECIFIC NODE

		public void insertAfter(Node preNode, int d){
			if(preNode == null){
				System.out.println("Given node cannot be null.");
				return;
			}
			Node newNode = new Node(d);
			newNode.next = preNode.next;
			preNode.next = newNode;

		}

		// THIS APPENDS A NODE

		public void append(int d){
			Node newNode = new Node(d);

			if(head == null){
				head = newNode;
				return;
			}
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			temp.next = newNode;
		}

		// THIS INSERTS THE NODE INTO SORTED ORDER

		}
		public void appendSort(int d){
			Node newNode = new Node(d);
			Node preNode = null;
			Node temp = head;
			if(head == null){
				head = newNode;	
				return;
			}	
			else if(newNode.data<=head.data){
				newNode.next = head;
				head = newNode;
				return;
			}
			while(temp!=null){
				
				if(newNode.data<=temp.data){
					preNode.next = newNode;
					newNode.next = temp;
					return;
				}
				preNode = temp;
				temp = temp.next;
			}
			preNode.next = newNode;
			
		}

		// THIS PRINTS THE LIST

		public void printList(){
			Node temp = head;
			while(temp != null){
				System.out.println(temp.data);
				temp = temp.next;
		}

	}	

	public static void main(String[] args){
		/* Start with the empty list */
        LinkedList list1 = new LinkedList(); 
       
       list1.appendSort(8);
       list1.appendSort(1);
       list1.appendSort(2);
       list1.appendSort(4);
       list1.appendSort(3);
       list1.appendSort(4);
       list1.appendSort(9);
       list1.appendSort(5);
     
       list1.printList();

	}


}