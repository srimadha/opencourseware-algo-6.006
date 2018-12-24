package com.mit.opencourseware.algo.lecture2;

import java.util.HashMap;

/**
 * Created by Sri on 12/22/2018.
 */
public class DocumentDistance {

    public static double findDistance( String doc1, String doc2 ){

        String words1[] = doc1.split(" ");
        String words2[] = doc2.split(" ");

        HashMap<String, Integer> wordsDict1 = getFrequency(words1);
        HashMap<String, Integer> wordsDict2 = getFrequency(words2);

        double dotproduct = getDotProduct( wordsDict1, wordsDict2);

        double sam1 = getDotProduct(wordsDict1 , wordsDict1);
        double sam2 = getDotProduct(wordsDict2 , wordsDict2);

        double denominator = Math.sqrt( sam1 * sam2);
        double closeness = dotproduct / denominator;

        return closeness;
    }

    public static double getDotProduct( HashMap<String, Integer> dict1, HashMap<String, Integer> dict2){
        double dotproduct = 0;
        for (String key: dict1.keySet()) {
            dotproduct += dict1.getOrDefault(key, 0) * dict2.getOrDefault(key, 0);
        }
        return dotproduct;
    }

    public static HashMap<String, Integer> getFrequency( String words[]){
        HashMap<String, Integer> wordsDict = new HashMap<>();
        for (String word : words) {
            if( wordsDict.containsKey( word )){
                wordsDict.put( word , wordsDict.get(word) + 1);
            }else{
                wordsDict.put( word , 1);
            }
        }
        return wordsDict;
    }

    public static void main( String [] args){

        String doc1 = "This cat is cat";
        String doc2 = "This cat is cat";

        System.out.println( findDistance( doc1, doc2 ) );
    }
}

