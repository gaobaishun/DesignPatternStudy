package designpatternstart;

/**
 * @Author gaobaishun
 * @Date 2020-03-27 19:56
 * imformation：
 */
public class FlyNoWays implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
