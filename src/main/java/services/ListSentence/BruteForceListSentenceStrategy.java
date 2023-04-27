package services.ListSentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registry.SynonymPairRegistry;

import java.util.ArrayList;
import java.util.List;
@Service("BruteForce")
public class BruteForceListSentenceStrategy implements ListSentenceStrategy{

//    @Autowired
//    SynonymPairRegistry synonymPairRegistry;
    public List<String> getSentences(String sentence, SynonymPairRegistry synonymPairRegistry){

        List<String> sentences = new ArrayList<>();

        List<String> sentenceWords = List.of(sentence.split(" "));
        for(int i=0;i<sentenceWords.size();i++){
            List<String> replacements = synonymPairRegistry.getSynonymPair(sentenceWords.get(i));
            for(int j=0;j<replacements.size();j++) {
                sentences.add(sentence.replaceAll(sentenceWords.get(i),replacements.get(j)));
            }
        }
        return sentences;
    };
}
