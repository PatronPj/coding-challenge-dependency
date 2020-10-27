package com.mhp.coding.challenges.dependency.inquiry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InquiryService {

    private static final Logger LOG = LoggerFactory.getLogger(InquiryService.class);

    private final InquiryHandler emailHandler;
    private final InquiryHandler pushNotificationHandler;

    public InquiryService(InquiryHandler emailHandler, InquiryHandler pushNotificationHandler) {
        this.emailHandler = emailHandler;
        this.pushNotificationHandler = pushNotificationHandler;
    }

    public void create(final Inquiry inquiry) {
        LOG.info("User sent inquiry: {}", inquiry);
        emailHandler.handle(inquiry);
        pushNotificationHandler.handle(inquiry);
    }
}