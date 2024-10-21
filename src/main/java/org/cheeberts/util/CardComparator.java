package org.cheeberts.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cheeberts.model.Card;
import org.cheeberts.model.Creatures.Creature;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        ObjectMapper objectMapper = new ObjectMapper();
        String s1 = "";
        String s2 = "";

        try {
            s1 = objectMapper.writeValueAsString(o1);
            s2 = objectMapper.writeValueAsString(o2);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return s1.compareTo(s2);
    }
}
