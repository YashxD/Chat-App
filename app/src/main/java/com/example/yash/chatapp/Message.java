package com.example.yash.chatapp;

/**
 * Created by yash on 22/12/17.
 */

public class Message {
    public int[] inout = new int[50];
    public String[] message = new String[50];
    int count;

    public Message(Message m) {
        this.inout = m.inout;
        this.message = m.message;
        this.count = m.count;
    }

    public Message() {
        this.count = 0;
    }

    public void newMesage(String input) {
        count++;
        message[count] = input;
        inout[count] = 1;
    }

    public int returnSize() {
        return count+1;
    }
}
