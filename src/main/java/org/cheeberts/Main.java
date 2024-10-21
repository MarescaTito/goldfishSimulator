package org.cheeberts;

import org.cheeberts.constants.TwentySwiftspearsTwentyShocks;
import org.cheeberts.service.GoldfishSimulator;

public class Main {
    public static void main(String[] args) {
        GoldfishSimulator fortySpears = new GoldfishSimulator(TwentySwiftspearsTwentyShocks.getDeck());
        System.out.println(fortySpears.turnsToWin());
    }
}