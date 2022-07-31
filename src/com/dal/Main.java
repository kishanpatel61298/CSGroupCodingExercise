package com.dal;

import com.dal.observable.IObservable;
import com.dal.observable.Server;
import com.dal.observer.Client;
import com.dal.observer.IObserver;
import com.dal.validator.InputProcessor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputProcessor inputProcessor = new InputProcessor();
        ClientData clientData;

        boolean hasError = false;
        String email = null;
        String name = null;

        do {
            if(hasError){
                System.out.println("Invalid Email or Name.");
            }
            System.out.println("Enter Email: ");
            email = scanner.nextLine();

            System.out.println("Enter Name: ");
            name = scanner.nextLine();

            clientData = new ClientData(name, email);

        }while (hasError = !inputProcessor.validateAll(clientData));

        clientData.setName(inputProcessor.nameTransformer(clientData.getName()));

        IObservable server = new Server(clientData);

        IObserver client1 = new Client("client1");
        IObserver client2 = new Client("client2");

        server.connect(client1);
        server.connect(client2);

        server.notifyall();
    }
}
