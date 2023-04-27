package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registry.SynonymPairRegistry;
import services.ListSentence.SentenceService;

import java.util.List;
@Service("BruteForce")
public class SentenceController {

    @Autowired
    SentenceService sentenceService = new SentenceService();
    public List<String> getSentences(String word, SynonymPairRegistry synonymPairRegistry){
        return sentenceService.getSentences(word, synonymPairRegistry);
    }

}
