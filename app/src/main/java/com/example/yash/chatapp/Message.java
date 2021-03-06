package com.example.yash.chatapp;

import java.util.ArrayList;

/**
 * Created by yash on 22/12/17.
 */

public class Message {
    public ArrayList<Integer> inout = new ArrayList<Integer>();
    public ArrayList<String> message = new ArrayList<String>();
    int count;

    public Message(Message m) {
        this.inout = m.inout;
        this.message = m.message;
        this.count = m.count;
    }

    public Message() {
        this.count = 0;
        this.inout.add(-1);
        this.message.add("");
    }

    public void newMesage(String input) {
        count++;
        message.add(input);
        inout.add(1);
    }

    public int returnSize() {
        return count+1;
    }
}
