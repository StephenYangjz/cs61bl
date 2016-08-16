/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 * Encapsulated version.
 */
public class IntList {
    /** The head of the list is the first node in the list. If the list is empty, head is null **/
    private IntListNode head;
    private int size;

    /** IntListNode is a nested class. It can be instantiated when associated with an instance of
     *  IntList.
     *  **/
    public class IntListNode {
        int item;
        IntListNode next;

        public IntListNode(int item, IntListNode next) {
            this.item = item;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }

    public IntList() {}

    public IntList(int[] initial) {
        for (int i = initial.length - 1; i >= 0; i--) {
            head = new IntListNode(initial[i], head);
        }
        size = initial.length;
    }

    /**
     * Get the value at position pos. If the position does not exist, throw an
     * IndexOutOfBoundsException.
     * @param position to get from
     * @return the int at the position in the list.
     */
    public int get(int position) {
        if (position >= size) throw new IndexOutOfBoundsException("Position larger than size of list.");
        IntListNode curr = head;
        while (position > 0) {
            curr = curr.next;
            position--;
        }
        return curr.item;
    }

    /* Fill in below! */

    /**
     * Insert a new node into the IntList.
     * @param x value to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *            the end of the list.
     */
    public void insert(int x, int position) {
        // Fill me in!
        if(this.size == 0){
            head = new IntListNode(x, head);
            size++;
        }
        else if(position == 0) {
            IntListNode newone = new IntListNode(x, head);
            head = newone;
            size++;
        }
        else {
            IntListNode point = head;
            while (position > 1 && point.next != null) {
                point = point.next;
                position--;
            }
            IntListNode newone = new IntListNode(x, point.next);
            point.next = newone;
            size++;
        }
    }

    /**
     * Merge two sorted IntLists a and b into one sorted IntList containing all of their elements.
     * @return a new IntList without modifying either parameter
     */
    public static IntList merge(IntList a, IntList b) {
        // Fill me in!
        IntList x = new IntList();
        /*if(a != null){
            for (int i = 0; i< a.size; i++)
                x.insert(a.get(i), i );
        }
        else if(b == null) return a;
        else if(a == null) return null;
        for (int i = 0; i< b.size; i++)
            x.insert(b.get(i), i);*/
        IntListNode point1 = a.size<=b.size? a.head:b.head;
        IntListNode point2 = a.size>=b.size? a.head:b.head;
        while(point1!= null){
                if(point1.item >= point2.item){
                    x.insert(point2.item,x.size);
                    point2 = point2.next;
                }
                else{
                    x.insert(point1.item,x.size);
                    point1 = point1.next;
                }
            }
        while(point2!= null){
            x.insert(point2.item,x.size);
            point2 = point2.next;
        }
        return x;
    }

    /**
     * Reverse the current list recursively, using a helper method.
     */
    public void reverse() {
        // Fill me in!
        IntListNode point  = head;
        IntListNode l  = head;
        IntListNode s  = head.next;
        while(s.next != null){
            IntListNode p = s.next;
            s.next = l;
            l = s;
            s = p;
        }
        s.next = l;
        head = s;
        point.next = null;
    }


    /* Optional! */

    /**
     * Remove the node at position from this list.
     * @param position int representing the index of the node to remove. If greater than the size
     *                 of this list, throw an IndexOutOfBoundsException.
     */
    public void remove(int position) {
        if (position >= size) throw new IndexOutOfBoundsException();
        // fill me in
    }
}
