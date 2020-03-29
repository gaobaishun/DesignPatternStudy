package ProxyPattern.RemoteProxy;

import ProxyPattern.GumballMachine;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author gaobaishun
 * @Date 2020-03-29 18:08
 * imformation：
 */
public interface GumballMachineRemote extends Remote {
    String getCurrentGumballMachingLocation() throws RemoteException;
}
