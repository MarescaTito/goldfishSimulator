package org.cheeberts.constants;

import org.cheeberts.model.Card;
import org.cheeberts.model.Spells.BuffSpells.DreadmawsIre;
import org.cheeberts.model.Spells.BuffSpells.FeloniousRage;
import org.cheeberts.model.Spells.BuffSpells.MonstrousRage;
import org.cheeberts.model.Spells.BuffSpells.TurnInsideOut;
import org.cheeberts.model.Spells.BurnSpells.Shock;
import org.cheeberts.model.Spells.CreatureSpells.CacophonyScampSpell;
import org.cheeberts.model.Spells.CreatureSpells.HeartfireHeroSpell;
import org.cheeberts.model.Spells.CreatureSpells.MonasterySwiftspearSpell;
import org.cheeberts.model.Spells.CreatureSpells.SlickshotShowoffSpell;
import org.cheeberts.model.Spells.Misc.BurnTogether;
import org.cheeberts.model.Spells.Misc.MightOfTheMeek;
import org.cheeberts.model.Spells.NonCreaturePermanents.LeylineOfResonance;

import java.util.LinkedList;
import java.util.List;

public class DuskmourneLeylineAllInOnTurnTwo {
    public static List<Card> getDeck() {
        List<Card> deck = new LinkedList<>();

        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new HeartfireHeroSpell()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new SlickshotShowoffSpell()));
        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card(new LeylineOfResonance()));
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
            deck.add(new Card(new DreadmawsIre()));
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
