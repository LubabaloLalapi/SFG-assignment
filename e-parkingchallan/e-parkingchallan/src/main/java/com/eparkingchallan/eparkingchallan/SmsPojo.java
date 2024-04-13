package com.eparkingchallan.eparkingchallan;

public class SmsPojo {
    //Declaring the message and to variables
    private String to;//Number send to
    private String message;//Message

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
