package org.example.parcial1.service;

public class ChatGPTStrategy implements ChatStrategy {
    private final ChatClientFacade client = new ChatClientFacade();

    @Override
    public String getResponse(String prompt) throws Exception {
        return client.sendPrompt(prompt);
    }
}
