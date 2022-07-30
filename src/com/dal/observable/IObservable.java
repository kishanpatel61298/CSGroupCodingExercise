package com.dal.observable;

import com.dal.observer.IObserver;

public interface IObservable {
    public void connect(IObserver client);
    public void disconnect(IObserver client);
    public void notifyall();
}
