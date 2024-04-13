package com.eparkingchallan.eparkingchallan.service;
import com.eparkingchallan.eparkingchallan.SmsPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SmsService {

    private final String ACCOUNT_SID ="ACc09d2acee4ddeee07e00f79f1f55b826";//SID ID from Twilio

    private final String AUTH_TOKEN = "9fc8ecf96f387677acbfab4e2255f3c4";//Auth token from Twilio account

    private final String FROM_NUMBER = "+12058462863";//Phone number generated from Twilio
    //Sends message to contact phone number
    public void send(SmsPojo sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }

}



