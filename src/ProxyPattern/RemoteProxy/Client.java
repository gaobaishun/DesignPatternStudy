package ProxyPattern.RemoteProxy;

import ProxyPattern.GumballMonitor;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Author gaobaishun
 * @Date 2020-03-29 19:53
 * imformation：
 */
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
