package ProxyPattern;

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
