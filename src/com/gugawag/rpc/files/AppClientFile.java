package com.gugawag.rpc.files;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClientFile {

    public static void main(String[] args) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        FilesService directory = (FilesService) registry.lookup("FileService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o nome do diretório:");
                    String arquivo = entrada.next();
                    if (directory.readdir(arquivo).isEmpty())
                        System.out.println("List: diretório vazio");
                    System.out.println("List: " + directory.readdir(arquivo));
                    break;
                }
                case 2: {
                    System.out.println("Digite o nome do arquivo e seu novo nome:");
                    if (entrada.hasNext()) {
                        entrada.next();
                    }
                    String mensagem = entrada.nextLine();
                    String[] msnSplit = mensagem.split(" ");
                    boolean ok = directory.rename(msnSplit[0], msnSplit[1]);
                    if(ok)
                        System.out.println("Arquivo renomeado");
                    else
                        System.out.println("Algo de errado aconteceu");
                    break;
                }
                case 3: {
                    System.out.println("Digite o nome do arquivo:");
                    String fileName = entrada.next();
                    boolean ok = directory.remove(fileName);
                    if(ok)
                        System.out.println("Arquivo removido");
                    else
                        System.out.println("Algo de errado aconteceu");
                    break;
                }
                case 4: {
                    System.out.println("Digite o nome do arquivo:");
                    String fileName = entrada.next();
                    boolean ok = directory.create(fileName);
                    if(ok)
                        System.out.println("Arquivo criado");
                    else
                        System.out.println("Algo de errado aconteceu");
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== DIRETORIO RMI (ou FMI?!) ===");
        System.out.println("1 - Listar arquivos");
        System.out.println("2 - Renomear arquivo");
        System.out.println("3 - Remover arquivo");
        System.out.println("4 - Criar arquivo");
        System.out.println("9 - Sair");
    }

}

