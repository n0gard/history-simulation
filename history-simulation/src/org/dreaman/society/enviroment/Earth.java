package org.dreaman.society.enviroment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Earth {
    private Landform[][] land;
    private int mapSize;
    private static Earth earth = null;

    public Earth(Landform[][] land, int mapSize) {
        super();
        this.land = land;
        this.mapSize = mapSize;
    }

    public static Earth getInstance(int mapSize) {
        if (null == earth) {
            earth = new Earth(randomMap(mapSize), mapSize);
        }
        return earth;
    }

    private static Landform[][] randomMap(int size) {
        Landform[][] landforms = new Landform[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                landforms[i][j] = randomFull();
            }
        }
        return landforms;
    }

    private static Landform randomFull() {
        return Landform.values()[(int) (Math.random() * Landform.values().length)];
    }

    private static Landform randomLandform(List<Landform> surrounds) {
        int[] counts = new int[Landform.values().length];
        for (Landform landform : surrounds) {
            counts[landform.ordinal()] = counts[landform.ordinal()] + 1;
        }
        int max = 0;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                indexMap.put(max, i);
            } else if (counts[i] == max) {
                if (Math.random() > 0.5) {
                    indexMap.put(max, i);
                }
            }
        }
        return Landform.values()[indexMap.get(max)];
    }

    private static Landform[][] fix(Landform[][] landforms) {
        Landform[][] fixed = new Landform[landforms.length][landforms[0].length];
        // 修正
        for (int i = 0; i < landforms.length; i++) {
            for (int j = 0; j < landforms[0].length; j++) {
                fixed[i][j] = randomLandform(surroundLandforms(i, j, landforms));
            }
        }
        return fixed;
    }

    private static List<Landform> surroundLandforms(int i, int j, Landform[][] landforms) {
        List<Landform> surroundLandforms = new ArrayList<Landform>();
        for (Direction direction : Direction.values()) {
            surroundLandforms.add(nearbyLandform(i, j, landforms, direction));
        }
        return surroundLandforms;
    }

    private static Landform nearbyLandform(int i, int j, Landform[][] landforms, Direction direction) {
        int nearbyI = i;
        int nearbyJ = j;
        switch (direction) {
        case 北:
            if (i > 0) {
                nearbyI = i - 1;
            }
            break;
        case 西北:
            if (i > 0 && j > 0) {
                nearbyI = i - 1;
                nearbyJ = j - 1;
            }
            break;
        case 西:
            if (j > 0) {
                nearbyJ = j - 1;
            }
            break;
        case 西南:
            if (i < landforms.length - 1 && j > 0) {
                nearbyI = i + 1;
                nearbyJ = j - 1;
            }
            break;
        case 南:
            if (i < landforms.length - 1) {
                nearbyI = i + 1;
            }
            break;
        case 东南:
            if (i < landforms.length - 1 && j < landforms[0].length - 1) {
                nearbyI = i + 1;
                nearbyJ = j + 1;
            }
            break;
        case 东:
            if (j < landforms[0].length - 1) {
                nearbyJ = j + 1;
            }
            break;
        case 东北:
            if (i > 0 && j < landforms[0].length - 1) {
                nearbyI = i - 1;
                nearbyJ = j + 1;
            }
            break;
        default:
            break;
        }
        return landforms[nearbyI][nearbyJ];
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public Landform[][] getLand() {
        return land;
    }

    public void setLand(Landform[][] land) {
        this.land = land;
    }

    private int countNumberLen(int value) {
        int count = 0;
        int target = value;
        int tmp = 0;
        while (true) {
            tmp = target / 10;
            if (tmp > 0) {
                count++;
                target = tmp;
            } else {
                break;
            }
        }
        return count + 1;
    }

    @Override
    public String toString() {
        int maxLen = countNumberLen(mapSize);
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < mapSize; i++) {
            if (i == 0) {
                buff.append("   ");
                for (int k = 0; k < mapSize; k++) {
                    buff.append(String.format("%0" + maxLen + "d", k)).append(" ");
                }
                buff.append("\n");
            }
            for (int j = 0; j < mapSize; j++) {
                if (j == 0) {
                    buff.append(String.format("%0" + maxLen + "d", i)).append(" ");
                }
                buff.append(land[i][j]).append(" ");
            }
            buff.append("\n");
        }
        return buff.toString();
    }

    public static boolean compare(Landform[][] landforms1, Landform[][] landforms2) {
        int landform1SizeI = landforms1.length;
        int landform1SizeJ = landforms1[0].length;
        int landform2SizeI = landforms2.length;
        int landform2SizeJ = landforms2[0].length;
        if (landform1SizeI != landform2SizeI || landform1SizeJ != landform2SizeJ) {
            return false;
        }
        for (int i = 0; i < landform1SizeI; i++) {
            for (int j = 0; j < landform1SizeJ; j++) {
                if (landforms1[i][j] != landforms2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Earth e = Earth.getInstance(20);
        System.out.println("修正前");
        System.out.println(e);
        int count = 0;
        while (true) {
            Landform[][] old = e.getLand();
            e.setLand(fix(e.getLand()));
            System.out.println("修正" + ++count + "次后");
            System.out.println(e);
            if (compare(e.getLand(), old) || count > 10) {
                break;
            }
        }
    }
}
