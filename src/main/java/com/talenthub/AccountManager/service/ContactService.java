package com.talenthub.AccountManager.service;

import com.talenthub.AccountManager.model.ContactInfo;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    public ContactInfo sendMessaage(ContactInfo contactInfo) {
        System.out.println(contactInfo.toString());
        return contactInfo;
    }
}
