package com.upf.resto.service;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.stereotype.Component;

@Component
public class Server {
	
	public Server() {
		RmiService service = new RmiServiceImpl();
		try {
			Remote stub = UnicastRemoteObject
			  .exportObject(service, 0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("RestoService", stub);
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

}
