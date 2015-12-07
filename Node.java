class Node<T> {
   private T datum;
   private Node next;

   public Node(T datum, Node<T> next){
      this.datum = datum;
      this.next = next;
   }

   public T getDatum() { return datum; }
   public Node getNext() { return next; }
   public void setDatum(T obj) { datum = obj; }
   public void setNext(Node c) { next = c; }
}
