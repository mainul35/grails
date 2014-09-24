package com.miaisoft.longprocess;

import java.util.UUID;

/**
 * Created by Touhid Mia on 24/09/2014.
 */
public class RunnableTesting implements Runnable {

    private String index;

    public RunnableTesting(){
        index = UUID.randomUUID().toString();
        GlobalInformation.currentStatus.put(index,"Processed Initiated");
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main Thread  = " + i  + " Array Index = " + GlobalInformation.currentStatus.size());
            GlobalInformation.currentStatus.put(index, "Number Of Loop = " + i);
        }
        GlobalInformation.currentStatus.remove(index);
    }

    public String getMessageIndex(){
        return index;
    }
}
