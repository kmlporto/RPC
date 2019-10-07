package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {
    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    void criarConta(String numero, Double valor) throws RemoteException;
    void removerConta(String numero) throws RemoteException;
    Conta pesquisaConta(String numero) throws RemoteException;
}
