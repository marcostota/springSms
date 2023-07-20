package com.tota.springsms.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tota.springsms.model.Sms;
import com.tota.springsms.service.SmsService;

@RestController
public class SmsControlle {

    SimpMessagingTemplate webSocket;
    SmsService smsService;

    public SmsControlle(SimpMessagingTemplate webSocket, SmsService smsService) {
        this.webSocket = webSocket;
        this.smsService = smsService;
    }

    private static final String TOPIC_NAME = "/topic/sms";

    @RequestMapping(value = "/sms", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendSms(@RequestBody Sms sms) {
        try {

        } catch (Exception e) {
            webSocket.convertAndSend(TOPIC_NAME, getDateAndTime() + "Mesasge has been delivered");
        }
        webSocket.convertAndSend(TOPIC_NAME, getDateAndTime() + "Message has been delivered");
        return "success";
    }

    public String getDateAndTime() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
}
