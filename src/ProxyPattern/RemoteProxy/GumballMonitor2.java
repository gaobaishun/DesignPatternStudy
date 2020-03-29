package ProxyPattern.RemoteProxy;

import ProxyPattern.GumballMachine;

/**
 * @Author gaobaishun
 * @Date 2020-03-29 16:12
 * imformation：糖果机监视器，boss端使用
 */
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
