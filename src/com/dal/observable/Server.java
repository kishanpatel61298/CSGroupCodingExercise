package com.dal.observable;

import com.dal.ClientData;
import com.dal.observer.IObserver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Server implements IObservable {
    Set<IObserver> connectedClients = new HashSet<>();
    ClientData clientData;

    public Server(ClientData clientData) {
        this.clientData = clientData;
    }

    @Override
    public void connect(IObserver client) {
        connectedClients.add(client);
    }

    @Override
    public void disconnect(IObserver client) {
        connectedClients.remove(client);
    }

    @Override
    public void notifyall() {
        String serializedClientData = "";
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            os.writeObject(clientData);
            serializedClientData = Base64.getEncoder().encodeToString(bos.toByteArray());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(IObserver IObserver : connectedClients){
            IObserver.send(serializedClientData);
        }
    }
}
