/**
 * Created by justinkim on 2016-10-01.
 */
public class ShapeLinkedList {
    public Node head;
    private int size=0;

    //Constructors
    public ShapeLinkedList(){
        head = new Node(null, null);
    }

    //ShapeLinkedList Functions
    public boolean isEmpty(){
        return length() == 0;
    }

    public void insertAtEnd(Shape data){
        Node curr = head;
        while (curr.next != null){
            curr = curr.next;
        }
        Node end = new Node();
        end.setNode(data, null);
        curr.setNext(end);

        size++;
    }

    public void insertAtBeginning(Shape data){
        Node temp = new Node();
        temp.setNode(data, head.next);
        head.next = temp;
        size++;
    }
    public Node tail(){
        Node curr = head.next;
        while (curr.next != null){
            curr = curr.next;
        }
        return curr.getNode();
    }
    //Length returns the number of nodes in the list minus the head & tail(sentinels) node
    public int length(){
        return size;
    }

    //inserts at any point in the array (not index 0 at moment)
    void insertAtIndex(int idx, Shape data){
        int counter = 0;
        Node curr = head;
        while(curr.next != null) {
            counter++;
            curr = curr.next;
            if(counter == idx){
                Node temp = new Node();
                temp.setNode(data, curr.next);
                curr.next = temp;
                counter++;
            }
        }
        size++;
    }


    //Not including Head Sentinel node. Tail Sentinel will return null
    Node findAtIndex(int idx){
        int counter = 0;
        Node curr = head;
        if (curr.next != null) {
            while (counter - 1 < idx) {
                curr = curr.next;
                counter++;
            }
        }
        return curr ;
    }
    void deleteAtIndex(int idx){
        int counter = 0;
        Node temp = head;
        while(counter  < (idx + 1)) {
            temp = temp.next;
            counter++;
        }
        temp.setNode(temp.next.getData(), temp.next.getNext());
        size--;
    }
    void deleteData(Shape s){
        int counter = 0;
        Node temp = head;

        while(counter < size){

            if(temp.data == s){
                temp.setNode(temp.next.getData(), temp.next.getNext());
            }
            else{
                temp = temp.next;
            }
            counter++;
        }
        size--;
    }

    //the following does not work **** need to print the elements of the list
    public String print(int index){
        Node pnode = head;
        int counter = 0;
        while(counter != index+1){
            pnode = pnode.next;
            counter++;
        }

        String rc =  "The shape is: " + pnode.data;
        return rc;
    }

    @Override
    public String toString() {
        return "ShapeLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    //Node class
    public static class Node{
        private Shape data;
        private Node next;

        //Constructors
        public Node(){
            this.data=null;
            this.next=null;
        }
        public Node(Shape data, Node next){
            this.setNode(data, next);
        }

        //Node functions
        public void setNode(Shape data, Node next){
            this.setData(data);
            this.setNext(next);
        }
        public void setData(Shape data){
            this.data=data;
        }
        public Shape getData(){
            return this.data;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next=next;
        }
        public Node getNode(){return this;}

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            return this.getClass().equals(obj.getClass());
        }

    }//Node class
}//ShapeLinkedList class
