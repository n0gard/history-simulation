package org.dreaman.society.common;

import java.util.concurrent.ConcurrentHashMap;

import org.dreaman.society.creature.Creature;

/**
 * 民政局啊 呵呵
 */
public class CivilService {
    public static ConcurrentHashMap<Integer, Creature> CREATURES_RECORDS = new ConcurrentHashMap<Integer, Creature>();
    public static ConcurrentHashMap<Integer, Creature> LIVING_CREATURES = new ConcurrentHashMap<Integer, Creature>();
}
