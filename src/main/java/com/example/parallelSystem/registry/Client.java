package com.example.parallelSystem.registry;

import com.example.parallelSystem.exceptions.SynonymPairNotExistException;

import java.util.List;
import java.util.Map;

public class Client {

    public static void main(String[] args) throws SynonymPairNotExistException {
        SynonymPairRegistry pairRegistry = new SynonymPairRegistry();
        pairRegistry.addSynonymPair("isha","gupta");
        pairRegistry.addSynonymPair("isha","shanim");
        pairRegistry.removeSynonymPair("isha","gupta");
        pairRegistry.removeSynonymPair("isha","shanim");
        Map<String, List<String>> synonymPairs = pairRegistry.pairs;
        for(String word1: synonymPairs.keySet()){
            System.out.print(""+ word1 + " : ");
            for(int i=0;i<synonymPairs.get(word1).size();i++){
                System.out.print(synonymPairs.get(word1).get(i)+ ",");
            }
        }
    }

}
