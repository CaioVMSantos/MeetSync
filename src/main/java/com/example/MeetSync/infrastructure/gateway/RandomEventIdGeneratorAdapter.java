package com.example.MeetSync.infrastructure.gateway;

import com.example.MeetSync.core.gateway.EventIdGenerate;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RandomEventIdGeneratorAdapter implements EventIdGenerate {

    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final int LETTERS_SIZE = 4;
    private static final int NUMBERS_SIZE = 2;
    private static final SecureRandom random = new SecureRandom();

    @Override
    public String generateEventId() {
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < LETTERS_SIZE; i++) {
            chars.add(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            chars.add(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }

        Collections.shuffle(chars);

        StringBuilder eventId = new StringBuilder();

        for (Character character : chars) {
            eventId.append(character);
        }

        return eventId.toString();
    }
}
