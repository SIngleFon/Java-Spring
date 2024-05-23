package com.example.Seminar_6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel textInputChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWritterChannel(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChannel", outputChannel = "fileWritterChannel")
    public GenericTransformer<String, String> myTransformer(){
        return text -> text.toUpperCase().trim();
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWritterChannel")
    public FileWritingMessageHandler messageHandler(){
        FileWritingMessageHandler handler
                = new FileWritingMessageHandler(new File("Seminar_6/src/main/java/com/example/Seminar_6/config/fileIntegration"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }
}
