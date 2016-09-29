package com.example.event;

import java.io.Serializable;

/**
 * @author victorzagnitko
 */
public class EventMessage implements Serializable {

    private String message;

    public EventMessage() {
        super();
    }

    public EventMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
