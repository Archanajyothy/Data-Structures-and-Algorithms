/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class SinglyLinkedList
{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public Node head;
    public Node tail;
    
    public void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.next = null;
        }
        tail = newNode;
    }
    
    public void addFront(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void addMiddle(int data, int key){
        Node newNode = new Node(data);
        Node temp = head;
        while(temp.next != null && temp.data != key){
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node with key " + key + " not found in the list");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    public void deleteNode(){
        Node temp = head;
        if(head == null || head.next == null){
            head = null;
        }
        while(temp.next.next != null){
            temp =temp.next;
        }
        temp.next = null;
    }
    
    public void delFront(){
        Node temp = head;
        if(temp != null){
            head = temp.next  ;
        }
        
    }
    
    public void delBetween(int k){
        Node temp = head;
        while(temp.next.next != null && temp.next.data != k){
            temp = temp.next;
        }
        if(temp.next.data == k){
            temp.next = temp.next.next;
        }
    }
    
    public void search(int k){
        Node temp = head;
        int count =1;
        while(temp != null && temp.data != k){
            temp = temp.next;
            count = count + 1;
        }
        if(temp.data == k){
            System.out.println("The number "+k+" found at "+count+" node ");
        }
    }
    
	public static void main(String[] args) {
	    SinglyLinkedList l = new SinglyLinkedList();
	    l.addNode(10);
	    l.addNode(20);
        l.addNode(30);
        l.addNode(40);
        l.addFront(5);
        l.addMiddle(25,10);
        //l.delBetween(25);
        l.search(25);
        l.display();
        System.out.println("deleting node from tail");
        l.deleteNode();
        l.display();
        System.out.println("deleting from front");
        l.delFront();
        l.display();
		System.out.println("Hello World");
	}
}
