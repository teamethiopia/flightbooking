package com.ethiopia.flightbooking.service.impl;

import com.ethiopia.flightbooking.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService
{
    @Autowired
    JavaMailSender sender;


    @Override
    public void sendNotification(String from,String to,String body,String subject)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(body);
        sender.send(message);


    }
}
