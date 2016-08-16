/**
 * Created by 强 on 2016/7/7.
 */
public class ResizableList extends FixedSizeList {

    public ResizableList() {
        super(1);
    }

    @Override
    public void add(int k) {
        if (count < values.length) {
            super.add(k);
        } else {
            int[] tmp = new int[values.length * 2];
            for (int j = 0; j < count; j++) {
                tmp[j] = values[j];
            }
            values = tmp;
            add(k);
        }
    }

    @Override
    public void add(int i, int k) {
        if (count < values.length) {
            super.add(i, k);
        } else {
            int[] tmp = new int[values.length * 2];
            for (int j = 0; j < count; j++) {
                tmp[j] = values[j];
            }
            values = tmp;
            add(i,k);
        }
    }

    public static void main(String[] args) {
        ResizableList a = new ResizableList();
        a.add(0, 1);
        System.out.println(a.get(0));
        a.add(1, 2);
        System.out.println(a.get(1));
    }
}
