package designpatternstart;

/**
 * @Author gaobaishun
 * @Date 2020-03-27 16:23
 * imformation：鸭子，描述了鸭子的基本行为
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior=new Quackdefault();
    //由于之前已经实现的鸭子类都会叫，于是这里默认一个
    //叫的行为

    public Duck(){
    }
    public void Fly(){
        flyBehavior.fly();
    }

     /**
     * @Author: gaobaishun
     * @Description:描述叫的行为
     * @Date: 2020-03-27  16:32
     * @Param null:
     * @Param null:
     **/
     void quack(){
         quackBehavior.quack();
     }

     /**
     * @Author: gaobaishun
     * @Description:描述游泳行为
     * @Date: 2020-03-27  16:33
     * @Param null:
     * @Param null:
     **/
     void swim(){
         System.out.println("鸭子一般游泳");
     }

     /**
     * @Author: gaobaishun
     * @Description:描述显示外观
     * @Date: 2020-03-27  16:33
     * @Param null:
     * @Param null:
     **/
     void display(){
         System.out.println("鸭子一般外观");
     }

}
