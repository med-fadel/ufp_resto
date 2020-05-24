package com.upf.resto.service;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	
	public static void main(String[] args) {
		RmiService service = new RmiServiceImpl();
		try {
			Remote stub = UnicastRemoteObject
			  .exportObject((RmiService) service, 0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("CommandeService", stub);
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

}
