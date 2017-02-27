
public class Main {

    public static void main(String[] args) {
        // write your code here

        /* ****testing for Override functions****

        //test.bitTest();
        //System.out.println(test.bitTest());
        //System.out.println(test2.hashCode());
        //System.out.println(test3.hashCode());

        //System.out.println(test.equals(test2));

        */
        /* Personal Testing
        ShapeLinkedList test = new ShapeLinkedList();
        Circle jj = new Circle(88);
        Triangle kk = new Triangle(3, 44, 44);
        Square zz = new Square(3);
        Rectangle qwer = new Rectangle(3, 4);
        Circle index = new Circle(3);

        test.insertAtBeginning(jj);
        test.insertAtBeginning(zz);
        test.insertAtBeginning(kk);
        test.insertAtBeginning(qwer);
        test.insertAtIndex(2, index);
        test.deleteData(kk);

        System.out.println(test.toString());
        System.out.println(test.findAtIndex(2));
        System.out.println(test.length());
        */

        ShapeLinkedList sll = new ShapeLinkedList();
        int[] values = {2, 1, 3, 5, 1, 4, 5, 3, 5, 7, 1, 2, 8, 9};

        Circle c1 = new Circle(values[0]);
        Circle c2 = new Circle(values[1]);

        Square sq1 = new Square(values[2]);
        Square sq2 = new Square(values[3]);

        Triangle t1 = new Triangle(values[4], values[5], values[6]);
        Triangle t2 = new Triangle(values[7], values[8], values[9]);

        Rectangle r1 = new Rectangle(values[10], values[11]);
        Rectangle r2 = new Rectangle(values[12], values[13]);

        sll.insertAtBeginning(r1);
        sll.insertAtBeginning(r2);
        sll.insertAtBeginning(c1);
        sll.insertAtBeginning(c2);
        sll.insertAtEnd(sq1);
        sll.insertAtEnd(sq2);
        sll.insertAtEnd(t1);
        sll.insertAtEnd(t2);

        for (int i = 0; i < sll.length(); i++) {
            System.out.println(sll.print(i));
        }
        System.out.println();
        sll.deleteData(sll.tail().getData());
        for (int i = 0; i < sll.length(); i++) {
            System.out.println(sll.print(i));
        }
        System.out.println();
        sll.deleteData(sq2);
        for (int i = 0; i < sll.length(); i++) {
            System.out.println(sll.print(i));
        }
    }
}
