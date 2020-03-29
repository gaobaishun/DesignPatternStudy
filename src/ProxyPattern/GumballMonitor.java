package ProxyPattern;

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
