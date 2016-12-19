package com.verizon.api.websocks;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.verizon.models.Message;
import com.verizon.models.PushMessage;

@Controller
public class PushMessageController {

    private static Logger LOGGER = LoggerFactory.getLogger(PushMessageController.class);

//    private TokenStorageService tokenStorageService;

    private SimpMessagingTemplate simpMessagingTemplate;

//    private final static String headerName = "X-Auth";

    @Autowired
    public PushMessageController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
//        this.tokenStorageService = tokenStorageService;
    }

    @MessageMapping("/push-to/{channel}")
    public void sendPushMessageToReceiverByToken(@DestinationVariable String channel, Message message) {
        // Sender sender = getSenderFromToken(senderToken);
//        String tokenInRedis = tokenStorageService.findTokenBySenderCompany(sender.getCompany());
//        boolean tokenActive = tokenInRedis.equals(senderToken);
//        Map<String, Boolean> messageHeaders = new HashMap<>();
//        if (tokenActive) {
            LOGGER.info("Valid token, sending message to channel...");
//            messageHeaders.put("alive", true);
            sendMessage(channel, new PushMessage(message));
//        } else {
//            LOGGER.debug("Token expired for channel..." + sender.getChannel());
//            messageHeaders.put("alive", false);
//            sendMessage(sender.getChannel(), new PushMessage(null, null), messageHeaders);
//        }
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
