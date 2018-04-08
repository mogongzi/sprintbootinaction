package demo.springboot2.websocket.web;

import demo.springboot2.websocket.domain.DemoMessage;
import demo.springboot2.websocket.domain.DemoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public DemoResponse say(DemoMessage message) throws Exception {
        Thread.sleep(3000);
        return new DemoResponse("Welcome, " + message.getName() + "!");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("wyf")) {
            messagingTemplate.convertAndSendToUser("ryan", "/queue/notifications", principal.getName() + "-send:" + msg);
        } else {
            messagingTemplate.convertAndSendToUser("wyf", "/queue/notifications", principal.getName() + "-send:" + msg);
        }
    }
}
