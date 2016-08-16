/**
 * Created by 强 on 2016/6/24.
 */
public class ModNCounter extends Counter {
    private int divisor;
    public ModNCounter(int n){
        super();
        divisor = n;
    }
    public int value(){
        return super.value() % divisor;
    }
    public static void main(String[] args){
        ModNCounter modCounter = new ModNCounter(3);
        modCounter.increment();
        modCounter.increment();
        modCounter.increment();
        //modCounter.increment();
        System.out.println(modCounter.value()); // prints 1
    }
}
