package com.verizon.api.websocks;

import com.verizon.models.Message;
import com.verizon.models.PushMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Controller
public class PushMessageController {

    private static Logger LOGGER = LoggerFactory.getLogger(PushMessageController.class);

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public PushMessageController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping("/notification/push-to/{channel}")
    public ResponseEntity<PushMessage> sendPushMessageToReceiverByToken(@PathVariable String channel, @RequestBody Message message) {
        LOGGER.info("Valid token, sending message to channel...");
        PushMessage pushMessage = new PushMessage(message);
        sendMessage(channel, pushMessage);
        return ResponseEntity.ok(pushMessage);
    }


    private void sendMessage(String toChannel, Object message) {
        this.simpMessagingTemplate.convertAndSend("/receiver/push-client/".concat(toChannel), message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionhandler(Exception e) {
        LOGGER.error("Exception occured when validating token :", e);
        return new ResponseEntity(BAD_REQUEST);
    }

}
