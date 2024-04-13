package com.eparkingchallan.eparkingchallan.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.eparkingchallan.eparkingchallan.SmsPojo;
import com.eparkingchallan.eparkingchallan.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    @Autowired
    SmsService service;

    @Autowired
    private SimpMessagingTemplate webSocket;//Injecting the object of the SimpMessaging Template

    private final String  TOPIC_DESTINATION = "/lesson/sms";

    //Send message
    @RequestMapping(value = "/sms", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsSubmit(@RequestBody SmsPojo sms) {
        try{
            service.send(sms);
        }
        catch(Exception e){

            webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Error sending the SMS: "+e.getMessage());
            throw e;
        }
        webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: "+sms.getTo());

    }

    //Gets timestamp of message sent
    private String getTimeStamp() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
}


