package designpatternstart;

/**
 * @Author gaobaishun
 * @Date 2020-03-27 20:33
 * imformation：
 */
public class FlywithRocket implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("有火箭推进器的飞行");
    }
}
