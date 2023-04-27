package com.example.parallelSystem.services.ListSentence;

import com.example.parallelSystem.registry.SynonymPairRegistry;

import java.util.List;

public interface ListSentenceStrategy {

    public List<String> getSentences(String sentence);
}
