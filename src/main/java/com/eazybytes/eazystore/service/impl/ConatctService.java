package com.eazybytes.eazystore.service.impl;

import com.eazybytes.eazystore.dto.ContactRequestDto;
import com.eazybytes.eazystore.entities.Contact;
import com.eazybytes.eazystore.repository.ContactRepository;
import com.eazybytes.eazystore.service.IContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service

public class ConatctService implements IContactService {
    private final ContactRepository contactRepository;

    @Autowired
    ConatctService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
        try {
            Contact contact = transformToEntity(contactRequestDto);
            contactRepository.save(contact);
            return true;

        }catch(Exception exception) {
            return false;
        }
    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        return contact;
    }
}
