package org.dreaman.society.civilization;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.dreaman.society.creature.Human;

public class ClanManager {
    private static ConcurrentHashMap<Integer, Clan> allClans = new ConcurrentHashMap<Integer, Clan>(2000);

    public static boolean isSameClan(Human h1, Human h2) {
        for (Clan clan : allClans.values()) {
            List<Human> clansman = clan.getClansman();
            if (clansman.contains(h1) && clansman.contains(h2)) {
                return true;
            }
        }
        return false;
    }
}
