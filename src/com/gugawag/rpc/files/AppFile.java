package com.gugawag.rpc.files;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppFile {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        FilesService fileService = new FilesServiceServer();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("FileService", fileService);

        System.out.println("Service de arquivos registrado ....");
    }
}
