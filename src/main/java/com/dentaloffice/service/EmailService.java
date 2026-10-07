package com.dentaloffice.service;

import com.dentaloffice.model.EmailDetails;

public interface EmailService {

    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);

}
