package com.gugawag.rpc.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesServiceServer extends UnicastRemoteObject implements FilesService {
    private static String HOME = "/home/kamila/";

    protected FilesServiceServer() throws RemoteException {
    }

    @Override
    public String readdir(String directory) throws IOException {
        Path path = Paths.get(HOME + directory);
        if (Files.exists(path)){
            Stream<Path> list = Files.list(path);
            return list.map(Path::getFileName).map(Objects::toString).collect(Collectors.joining(", "));
        }else{
            return null;
        }
    }

    @Override
    public boolean rename(String name, String newName) throws IOException {
        Path file = Paths.get(HOME + name);
        Path newFile = Paths.get(HOME + newName);
        if(Files.exists(file)){
            Files.move(file, newFile);
            return true;
        }
        return false;
    }

    @Override
    public boolean create(String name) throws IOException {
        Path file = Paths.get(HOME + name);
        if (!Files.exists(file)){
            Files.createFile(file);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String name) throws IOException {
        Path file = Paths.get(HOME + name);
        if(Files.exists(file)){
            Files.delete(file);
            return true;
        }
        return false;
    }

}
