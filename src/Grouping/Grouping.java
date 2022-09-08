package Grouping;

import java.util.*;

public class Grouping {
    static HashMap<Integer, List<String>> scoreDict;

    public static void main(String args[]){
        scoreDict = new HashMap<Integer, List<String>>();
        groupScores(2, "George");
        groupScores(100, "George");
        groupScores(50, "Susan");
        groupScores(50, "Adam");
        groupScores(50, "Helen");
        groupScores(10, "Mike");
        groupScores(30, "Susan");
        groupScores(20, "Adam");
        groupScores(50, "Helen");
        groupScores(10, "Mike");

        TreeMap<Integer, List<String>> sort = sortScore();
        printScore(sort);
    }

    public static void groupScores(int score, String name) {
        if (scoreDict.containsKey(score)) {
            List<String> names = scoreDict.get(score);
            names.add(name);
            Collections.sort(names);
            scoreDict.put(score, names);
        } else {
            List<String> names = new ArrayList<String>();
            names.add(name);
            scoreDict.put(score, names);
        }
    }

    public static void printScore(TreeMap<Integer, List<String>> treeMap){
        for (Integer key : treeMap.descendingKeySet()) {
            for (String name : treeMap.get(key)) {
                System.out.println(key + " " + name);
            }
        }
    }

    public static TreeMap<Integer, List<String>> sortScore(){
        TreeMap<Integer, List<String>> sorted = new TreeMap<>(scoreDict);
        return sorted;
    }
}