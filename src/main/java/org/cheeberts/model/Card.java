package org.cheeberts.model;

import org.cheeberts.model.Spells.Spell;

import java.util.Optional;

public class Card {
    //A card without a spell is treated as a basic mountain
    public Spell spell;

    public String cardName;

    public Card(Spell spell) {
        this.spell = spell;
        if(this.spell == null) {
            cardName = "Mountain";
        } else {
            cardName = spell.getClass().toString();
        }
    }
}
