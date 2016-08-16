import jh61b.junit.In;

/** A data structure to represent a Linked List of Integers.
  * Each IntList represents one node in the overall Linked List.
  *
  * @author Maurice Lee and Wan Fung Chui
  */

public class IntList {

    /** The integer stored by this node. */
    private int item;
    /** The next node in this IntList. */
    private IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
      * IntList L = IntList.list(1, 2, 3);
      * System.out.println(L.toString()) // Prints (1 2 3) */
    public static IntList list(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /** Returns the integer stored by this IntList. */
    public int item() {
        return item;
    }

    /** Returns the next node stored by this IntList. */
    public IntList next() {
        return next;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position){
        // YOUR CODE HERE
        if(position >= this.size() || position < 0)
            throw new IllegalArgumentException("Out of bouds!");
            int i = 0;
            IntList point = this;
            while (i < position) {
                point = point.next;
                i++;
            }
            return point.item;
    }

    /**
     * Returns the size of the list.
     *
     * @return The size of the list.
     */
    public int size() {
        // YOUR CODE HERE
        IntList point  = this;
        int count = 0;
        while(point != null){
            point = point.next;
            count++;
        }
        return count;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "( 1 2 3 )".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        // YOUR CODE HERE
        IntList point  = this;
        String s = "( ";
        while(point != null){
            s += point.item()+" ";
            point = point.next;
        }
        s += ")";
        return s;
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        // YOUR CODE HERE
        if(obj.getClass().getName() != "IntList")
            return false;
        IntList list = (IntList) obj;
        if(this.size() != list.size())
            return false;
        IntList point1 = this;
        IntList point2 = list;
        while(point1 != null){
            if(point1.item!=point2.item)
                return false;
            point1 = point1.next;
            point2 = point2.next;
        }
        return true;
    }

    /**
     * Adds the given item at the end of the list.
     *
     * @param item, the int to be added.
     */
    public void add(int item) {
        // YOUR CODE HERE
        IntList point  = this;
        while(point.next != null)
            point = point.next;
        point.next = new IntList(item,null);
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        // YOUR CODE HERE
        IntList point = this;
        int smallest = point.item;
        while(point != null){
            if(smallest > point.item)
                smallest = point.item;
            point = point.next;
        }
        return smallest;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        // YOUR CODE HERE
        IntList point =  this;
        int sum = 0;
        while(point != null){
            sum += point.item * point.item;
            point = point.next;
        }
        return sum;
    }

    /**
     * Returns a new IntList consisting of L1 followed by L2,
     * non-destructively.
     *
     * @param l1 list to be on the front of the new list.
     * @param l2 list to be on the back of the new list.
     * @return new list with L1 followed by L2.
     */
    public static IntList append(IntList l1, IntList l2) {
        // YOUR CODE HERE
        IntList newone = new IntList(0);
        if(l1 != null){
            newone.item = l1.item;
            l1 = l1.next;
            while(l1 != null){
                newone.add(l1.item);
                l1 = l1.next;
            }
        }
        else if(l2 == null){
            return null;
        }
        else if(l2 != null){
            newone.item = l2.item;
            l2 = l2.next;
            while(l2 != null){
                newone.add(l2.item);
                l2 = l2.next;
            }
            return newone;
        }
        while(l2 != null){
            newone.add(l2.item);
            l2 = l2.next;
        }
        return newone;
    }

   public static void main(String[] args){
        IntList list = IntList.list(1,2,3,4);
        System.out.println(list.next().item());
    }
}
