package com.botline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Random;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@LineMessageHandler
public class BotLineApplication extends SpringBootServletInitializer {
    @autowired
    private LineMessagingClient LineMessagingClient;
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BotLineApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BotLineApplication.class, args);
    }

}
    @EventMapping
    public void handleTextEvent(MessageEvent<TextMessageContent> messageEvent){
    if (pesanSplit[0].equals("Neechan")){
        String jawaban = getRandomJawaban();
        String replyToken = messageEvent.getReplyToken();
        balasChatDenganRandomJawaban(replyToken, jawaban);
    }
    }
    private String getRandomJawaban(){
    String jawaban = " ";
    int random = new Random().nextInt();
    if (random%2==0){
        jawaban="ya kakak!";
    } else {
        jawaban = "Gatauu";
    }
    return jawaban;
    }
    private void balasChatDenganRandomJawaban(String replyToken, String jawaban){
    TextMessage jawabanDalamBentukTextMessage = new TextMessage(jawaban);
    try {
        lineMessagingClient
                .replyMessage(new replyMessage(replyToken, jawabanDalamBentukTextMessage))
                .get();
    } catch (InterruptedException | ExecutionException e){
        System.out.println(" Ada Error OniChan ");
    }
    }
}
