package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.ContactInfo;
import com.talenthub.AccountManager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/form")
public class ContactController {

    @Autowired
    ContactService contactService;

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200", "https://canelaapigatewayback-production.up.railway.app"})
    @PostMapping("/send")
    public ContactInfo sendMessage(@RequestBody ContactInfo contactInfo) {
        System.out.println(contactInfo.toString());
        return contactService.sendMessaage(contactInfo);
    }
}
