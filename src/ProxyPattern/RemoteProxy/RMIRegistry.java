package ProxyPattern.RemoteProxy;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Author gaobaishun
 * @Date 2020-03-29 19:34
 * imformation：
 */
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
