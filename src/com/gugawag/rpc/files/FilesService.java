package com.gugawag.rpc.files;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FilesService extends Remote {
    String readdir(String directory) throws IOException;
    boolean rename(String name, String newName) throws IOException;
    boolean create(String name) throws IOException;
    boolean remove(String name) throws IOException;
}
