package designpatternstart;

/**
 * @Author gaobaishun
 * @Date 2020-03-27 20:33
 * imformation：
 */
public class RocktDuck extends Duck{
    public RocktDuck(){
        flyBehavior=new FlywithRocket();
        quackBehavior=new QuackHongHong();
    }
}
