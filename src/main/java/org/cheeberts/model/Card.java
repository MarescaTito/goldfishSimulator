package org.cheeberts.model;

import org.cheeberts.model.spells.Spell;

public class Card {
    //A card without a spell is treated as a basic mountain
    public Spell spell;

    public String cardName;
    public boolean impulsed=false;
    public Card(Spell spell) {
        this.spell = spell;
        if(this.spell == null) {
            cardName = "Mountain";
        } else {
            cardName = spell.getClass().toString();
        }
    }

    public Card deepCopy() {
        Spell spellCopy = spell.deepCopy();
        Card toReturn = new Card(spellCopy);
        toReturn.impulsed = impulsed;

        return toReturn;
    }
}
