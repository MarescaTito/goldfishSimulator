package org.cheeberts.constants.deckList;

import org.cheeberts.model.Card;
import org.cheeberts.model.spells.buffSpells.FeloniousRage;
import org.cheeberts.model.spells.buffSpells.MonstrousRage;
import org.cheeberts.model.spells.buffSpells.TurnInsideOut;
import org.cheeberts.model.spells.burnSpells.LightningStrike;
import org.cheeberts.model.spells.burnSpells.Shock;
import org.cheeberts.model.spells.creatureSpells.CacophonyScampSpell;
import org.cheeberts.model.spells.creatureSpells.HeartfireHeroSpell;
import org.cheeberts.model.spells.creatureSpells.MonasterySwiftspearSpell;
import org.cheeberts.model.spells.creatureSpells.SlickshotShowoffSpell;
import org.cheeberts.model.spells.misc.BurnTogether;
import org.cheeberts.model.spells.misc.MightOfTheMeek;

import java.util.LinkedList;
import java.util.List;

public class DuskmourneLeylineSubEmberheart {
    public static List<Card> getDeck() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new HeartfireHeroSpell()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new SlickshotShowoffSpell()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new LightningStrike()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new BurnTogether()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new TurnInsideOut()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new MonstrousRage()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new MightOfTheMeek()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new FeloniousRage()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new CacophonyScampSpell()));
        }
        for(int i = 0; i < 3; i++) {
            deck.add(new Card(new MonasterySwiftspearSpell()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new Shock()));
        }
        for(int i = 0; i < 17; i++) {
            deck.add(new Card(null));
        }

        return deck;
    }

    public static double landRatio() {
        return 17.0/60.0;
    }
}
