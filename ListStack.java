class ListStack implements Stack {
   private Node head = null;  //Head of list that
                              //holds the Stack
    
   public void push(Object x) { head = new Node(x, head); }
   public Object pop() {
      Node temp = head;
      head = head.getNext();
      return temp.getDatum();
   }
   public Object peek() { return head.getDatum(); }
   public boolean isEmpty() { return head == null; }
   public void clear() { head = null; }
}
