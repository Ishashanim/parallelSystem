package services.ListSentence;

import registry.SynonymPairRegistry;

import java.util.List;

public interface ListSentenceStrategy {

    public List<String> getSentences(String sentence, SynonymPairRegistry synonymPairRegistry);
}
