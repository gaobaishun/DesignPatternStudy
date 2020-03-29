# DesignPatternStudy
设计模式学习<br>
##1，设计模式的开始（策略模式）
 

    
    public class Duck {
         /**
         * @Author: gaobaishun
         * @Description:描述叫的行为
         * @Date: 2020-03-27  16:32
         * @Param null:
         * @Param null:
         **/
         void quack(){
             System.out.println("鸭子一般叫");
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


----------
这是一个鸭子类定义了鸭子的基本行为。以下是两个鸭子具体类：

    public class MDuck implements Duck{
        
    }
    


----------


        public class RDuck implements Duck {
        
    }

这样这两种鸭子都具有了鸭子类的基本行为，当接口中**添加**一个

     void  fly(){
     }

时看似也合乎鸭子的特征。但是如果实现塑料鸭子和木头鸭子，就不合乎逻辑，塑料鸭子和木头鸭子不会飞。当然，你可以覆盖fly方法，而里面不做任何动作，那这样很多不会飞的鸭子多出了没有意义的方法。当然，如果以后有需要添加新的需求，对Duck类进行改动，会对所有子类造成影响，这是个不太好的方法。也就是说这个时为了实现代码的复用而实现接口或者继承结局并不好。在父类中添加行为，会牵一发而动全身。每当一个新类的实现时还要检查是否覆盖掉哪些方法。
    
**有一种解决方法：将fly行为抽离出来，创建包含fly行为的Flyable接口并实现，让能飞的鸭子自己实现这个接口。同理，将quack行为抽离出来。。。**

这或许是个好主意。但是，如果已经有上百上千个具体的鸭子类实现了旧的的Duck类，如果这么做，后果不堪设想，工作量非常大。而且不能实现代码复用。我们的目的是尽可能让现有的代码改动少。
     **设计原则：找出应用中可能需要的变化，把他们独立出来，不要和那些不需要变化的代码混合在一起。**
     **设计原则：针对接口编程，而不是针对实现编程。**
     
     首先我们知道变化只会fly和quack方法变化，因此我们只需要将这两个剥离出来：
 

    public interface QuackBehavior {
    void quack();
    }

 

    public interface FlyBehavior {
        void fly();
    }
     
然后定义一些飞的行为和叫的行为：

    public class FlyNoWays implements FlyBehavior{
        @Override
        public void fly() {
            System.out.println("不会飞");
        }
    }
    public class FlyWithWings implements FlyBehavior {
        @Override
        public void fly() {
            System.out.println("fei");
        }
    }
    public class Quackdefault implements QuackBehavior {
        @Override
        public void quack() {
    
        }
    }
这样每当有种新的鸭子种类叫法不一样，或者飞行方式不一样。直接实现新的行为。
现在将Duck类改成这样：

   

     public abstract class Duck {
            FlyBehavior flyBehavior=;
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
原有的子类不需要做任何改动，而且还可以实现新的需求fly。
当添加新的类的时候只需要在新的类构造函数中添加
flyBehavior和quackBehavior的实现。

例如，我们要实现一个鸭子，飞行的时候有火箭推进器，叫起来轰轰轰的叫。
首先这个飞行行为是新的，而且叫的行为也是新的。于是我们实现一个飞的行为，和叫的行为。

    public class QuackHongHong implements QuackBehavior{
        @Override
        public void quack() {
            System.out.println("轰轰轰的叫");
        }
    }
    
    public class FlywithRocket implements FlyBehavior{
    
        @Override
        public void fly() {
            System.out.println("有火箭推进器的飞行");
        }
    }
然后实现新的鸭子类。

    public class RocktDuck extends Duck{
        public RocktDuck(){
            flyBehavior=new FlywithRocket();
            quackBehavior=new QuackHongHong();
        }
    }
    
上述改变就应用了这两个原则，关注改变，针对接口编程。
关注改变：把改变的部分剥离出来。
针对接口编程：动态绑定，在运行时决定到底是哪个实现。

现在介绍一个新的**设计原则：多用组合，少用继承。**
这样可以运行时动态的改变行为。

上面用到了一个设计模式：**策略模式（StrategyPattern） ，定义了算法族，分别封装起来，让他们之间可以相互替换，此模式让算法的变化独立于使用算法的客户。**

上面的一个决定某个鸭子具体实现怎样的飞行，以及叫的行为就是典型的策略模式。

 ##**2，代理模式**
 现在有个需求，有遍布城市各地糖果机零售机，boss想要一个功能打印出糖果零售机的信息，以便boss在家管理。
 
 这个是糖果机，为了方便学习假设，这个糖果机只有位置信息。

    public class GumballMachine {
        String location;
        public GumballMachine(String location){
            this.location=location;
        }
        public String getLocation(){
            return location;
        }
    }

 

    /**
     * @Author gaobaishun
     * @Date 2020-03-29 16:12
     * imformation：糖果机监视器，boss端使用
     */
    public class GumballMonitor {
        GumballMachine machine;
        public GumballMonitor(GumballMachine gumballMachine){
            this.machine=gumballMachine;
        }
    public void report(){
            System.out.println("Gumball Location:"+machine.getLocation());
        }
    }
    
    
    现在boss可以这样获取糖果的机的打印信息。
    

    /**
     * @Author gaobaishun
     * @Date 2020-03-29 16:23
     * imformation：
     */
    public class GumballMonitorTest {
        public static void main(String[] args) {
            GumballMachine gumballMachine=new GumballMachine("天安门门口");
            
            
            GumballMonitor gumballMonitor=new GumballMonitor(gumballMachine);
            gumballMonitor.report();
        }
    }

看上去没问题。但是实际上boss的意思是远程监控糖果机的信息。这里引入一个概念，远程代理（remote proxy）。上述例子，糖果机和监视器必须在一个JVM中，但实际上要求在两个JVM上实现监控。这里就需要用到代理。一个糖果机代理，就是一个中间对象，对于boss来说可以这个代理看成糖果机。而实际上是这个代理通过网络与远程的真正糖果机沟通。

boss---》糖果监视器-----》糖果代理----------》网络----》糖果机


这里介绍一个java内置的工具-RMI（Remote Method Invocation）远程方法调用。
[RMIdemo][1]


  [1]: https://github.com/gaobaishun/TechnologyTest/tree/master/src/RMITest
  
首先创建一个接口：一定要抛出异常以及扩展Remote

    public interface GumballMachineRemote extends Remote {
        String getCurrentGumballMachingLocation() throws RemoteException;
    }

  一定要扩展UnicastRemoteObject

    public class GumballMachine2 extends UnicastRemoteObject implements GumballMachineRemote{
        public String location;
        public GumballMachine2(String location) throws RemoteException {
            this.location=location;
        }
        public String getLocation(){
            return location;
        }
    
        @Override
        public String getCurrentGumballMachingLocation() throws RemoteException{
            return location;
        }
    }

  这里是注册

    public class RMIRegistry {
        public static void main(String[] args) {
            try {
                //GumballMachine2 gumballMachine2 = new GumballMachine2("北京的");
                GumballMachineRemote gumballMachineRemote=new GumballMachine2("beijing");
                Registry registry= LocateRegistry.createRegistry(1098);
                registry.bind("a",gumballMachineRemote);
                //Naming.rebind("//localhost/gumballMachine2",gumballMachineRemote );
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    以上服务端已经建立完成。
    
    现在来客户端
    
        public class Client {
        public static void main(String[] args) {
            try {
            Registry registry= LocateRegistry.getRegistry(1098);
            GumballMachineRemote remote=(GumballMachineRemote)registry.lookup("a");
            //System.out.println(remote.getCurrentGumballMachingLocation());
            GumballMonitor2 gumballMonitor=new GumballMonitor2(remote);
            gumballMonitor.report();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    
        }
    }
    
    
        public class GumballMonitor2 {
        GumballMachineRemote machine;
        public GumballMonitor2(GumballMachineRemote gumballMachine){
            this.machine=gumballMachine;
        }
    
        public void report(){
            try {
                System.out.println("Gumball Location:"+machine.getCurrentGumballMachingLocation());
            }catch (Exception e){
                e.printStackTrace();
            }
    
        }
    }
    上面就是一个远程代理的例子，客户无需关心是哪个糖果机，交给主函数中的代码来做。主函数底层通过网络，自动完成监视。