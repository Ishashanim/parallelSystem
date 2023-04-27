package com.example.parallelSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.parallelSystem.registry.SynonymPairRegistry;
import com.example.parallelSystem.services.ListSentence.SentenceService;

import java.util.List;
@Service
@Qualifier("BruteForceSentenceStrategy")
public class SentenceController {

    @Autowired
    SentenceService sentenceService;

    public List<String> getSentences(String word){
        return sentenceService.getSentences(word);
    }

}
