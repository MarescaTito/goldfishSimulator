package org.cheeberts.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cheeberts.model.creatures.Creature;

import java.util.Comparator;

public class CreatureComparator implements Comparator<Creature> {
    @Override
    public int compare(Creature o1, Creature o2) {
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
