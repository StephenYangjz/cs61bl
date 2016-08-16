/**
 * Created by 强 on 2016/7/7.
 */
public class Dog extends Canine{
    int a = 10;
    @Override
    public void makeSound() {
        System.out.println("a = " + this.a);
    }
}
