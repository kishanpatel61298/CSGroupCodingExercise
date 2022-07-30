package com.dal;

import com.dal.observable.IObservable;
import com.dal.observable.Server;
import com.dal.observer.Client;
import com.dal.observer.IObserver;
import com.dal.validator.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputValidator inputValidator = new InputValidator();
        ClientData clientData;

        boolean hasError = false;
        boolean emailValidate = false;
        boolean nameValidate = false;
        String email = null;
        String name = null;

        do {
            if(hasError){
                System.out.println("Invalid Email or Name.");
            }
            System.out.println("Enter Email: ");
            email = scanner.nextLine();
            emailValidate = inputValidator.emailValidator(email);

            System.out.println("Enter Name: ");
            name = scanner.nextLine();
            nameValidate = inputValidator.nameValidator(name);

        }while (hasError = !(emailValidate && nameValidate));

        name = inputValidator.nameTransformer(name);
        clientData = new ClientData(name, email);

        IObservable server = new Server(clientData);

        IObserver client1 = new Client("client1");
        IObserver client2 = new Client("client2");

        server.connect(client1);
        server.connect(client2);

        server.notifyall();
    }
}
