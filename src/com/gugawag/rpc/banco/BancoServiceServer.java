package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta>contas = new ArrayList<Conta>();

    public BancoServiceServer() throws RemoteException {
        Conta conta = new Conta("1", 100.0);
        contas.add(conta);
        conta = new Conta("2", 156.0);
        contas.add(conta);
        conta = new Conta("3", 95.0);
        contas.add(conta);
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        for(Conta c: contas){
            if(c.getNumero().equals(conta))
                return c.getSaldo();
        }
        return 0;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void criarConta(String numero, Double valor)throws RemoteException {
        Conta conta = new Conta(numero, valor);
        contas.add(conta);
    }

    @Override
    public void removerConta(String numero)throws RemoteException {
        Conta c = pesquisaConta(numero);
        contas.remove(c);

    }

    @Override
    public Conta pesquisaConta(String numero) throws RemoteException {
        for(Conta c: contas){
            if(c.getNumero().equals(numero))
                return c;
        }
        return null;
    }


}
