package com.example.parallelSystem.services.ListSentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.parallelSystem.registry.SynonymPairRegistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
@Qualifier("BruteForceSentenceStrategy")
@Primary
public class BruteForceListSentenceStrategy implements ListSentenceStrategy{

    @Autowired
    SynonymPairRegistry synonymPairRegistry;
    public List<String> getSentences(String sentence){

        List<String> sentences = new ArrayList<>();

        List<String> sentenceWords = List.of(sentence.split(" "));
        for(int i=0;i<sentenceWords.size();i++){
            List<String> replacements = synonymPairRegistry.getSynonymPair(sentenceWords.get(i));
            for(int j=0;j<replacements.size();j++) {
                sentences.add(sentence.replaceAll(sentenceWords.get(i),replacements.get(j)));
            }
        }
        //Sort Lexographically all the sentences
        Collections.sort(sentences);

        return sentences;
    };
}
