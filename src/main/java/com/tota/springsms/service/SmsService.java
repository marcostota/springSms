package com.tota.springsms.service;

import org.springframework.stereotype.Service;

import com.tota.springsms.model.Sms;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

    private String SID;
    private String authToken;
    private String fromPhoneNumber;
    private String toPhoneNumber;

    public void sendSms(Sms sms) {
        Twilio.init(SID, authToken);

        Message message = Message
                .creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(fromPhoneNumber), sms.getMessage())
                .create();
    }
}
