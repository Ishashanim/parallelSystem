package services.ListSentence;

import org.springframework.stereotype.Service;
import registry.SynonymPairRegistry;

import java.util.List;
@Service
public class OptimisedListSentenceStrategy implements ListSentenceStrategy{
    public List<String> getSentences(String sentence, SynonymPairRegistry synonymPairRegistry){
        return null;
    };
}
