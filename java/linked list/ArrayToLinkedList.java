public class ArrayToLinkedList {
    public static class Node {
   int data;
   Node next;
   
   Node(int data) {
      this.data = data;
      this.next = null;
   }
}
   public static void main(String[] args) {
      
      // Creating an array
      int[] array = {1, 2, 3, 3, 5};
      int count = 0;
      int[] arr= new int[array.length+1];
      boolean flag = false;
      //removing duplicates
      for(int i=0;i< array.length; i++){
          flag = false;
          for(int j=i+1 ; j<array.length;j++)
          {
             if(array[i] == array[j]) {
              flag = true;
              break;
             }
          }
             if(!flag){
                 arr[count] = array[i];
                 count++;
                 
             }
          
          
      }
      
      // Converting the array to a linked list
      Node head = null;
      Node tail = null;
      
      for (int i = 0; i < count; i++) {
         Node node = new Node(arr[i]);
         if (head == null) {
            head = node;
            tail = node;
         } else {
            tail.next = node;
            tail = node;
         }
      }
      
      // Printing the linked list
      Node current = head;
      System.out.print("Linked list: ");
      while (current != null) {
         System.out.print(current.data + " ");
         current = current.next;
      }
   }
}



