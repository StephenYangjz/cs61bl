/**
 * Created by 强 on 2016/6/23.
 */
public class TriangleDrawer2 {
    public static void main(String[] args){
        int SIZE = 10;
        System.out.println();
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j<i+1;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
