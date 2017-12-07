package com.csg.app.models;

import com.csg.app.MainActivity;

public class Mediator {

    private static Mediator mediator = null;
    private MainActivity mainActivityContext = null;

    public static Mediator getInstance() {
        if(mediator == null) {
            mediator = new Mediator();
        }
        return mediator;
    }

    public MainActivity getMainActivityContext() {
        return mainActivityContext;
    }

    public void setMainActivityContext(MainActivity mainActivityContext) {
        this.mainActivityContext = mainActivityContext;
    }
}
