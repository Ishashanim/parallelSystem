package com.example.parallelSystem.services.ListSentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parallelSystem.registry.SynonymPairRegistry;

import java.util.List;
@Service
public class SentenceService {
    @Autowired
    ListSentenceStrategy listSentenceStrategy;
    public List<String> getSentences(String word){
        return listSentenceStrategy.getSentences(word);
    }
}
