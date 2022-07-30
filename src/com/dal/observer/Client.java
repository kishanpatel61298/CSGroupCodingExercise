package com.dal.observer;

import com.dal.ClientData;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

public class Client implements IObserver {

    String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void send(String serializedObject) {
        try {
            byte [] data = Base64.getDecoder().decode(serializedObject);
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
            ClientData clientData = (ClientData) objectInputStream.readObject();
            objectInputStream.close();

            if(clientData != null){
                System.out.println("Client: "+name+", Email :"+clientData.getEmail()+", Name: " + clientData.getName());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
