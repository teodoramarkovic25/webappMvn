package com.akademija.webappmvn.visitor;

import java.io.Serializable;

public class Counter implements Serializable {
    private int count = 0;
    public synchronized void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
