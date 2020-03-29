package ProxyPattern.RemoteProxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author gaobaishun
 * @Date 2020-03-29 16:11
 * imformation：糖果机
 */
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
