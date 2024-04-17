package com.talenthub.AccountManager.service;

import com.talenthub.AccountManager.model.ContactInfo;
import org.springframework.stereotype.Service;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

@Service
public class ContactService {
    public ContactInfo sendMessaage(ContactInfo contactInfo) {
        System.out.println(contactInfo.toString());
        return contactInfo;
    }
}
