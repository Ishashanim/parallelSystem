package services.ListSentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registry.SynonymPairRegistry;

import java.util.List;
@Service("BruteForce")
public class SentenceService {
    @Autowired
    ListSentenceStrategy listSentenceStrategy = new BruteForceListSentenceStrategy();
    public List<String> getSentences(String word, SynonymPairRegistry synonymPairRegistry){
        return listSentenceStrategy.getSentences(word,synonymPairRegistry);
    }
}
