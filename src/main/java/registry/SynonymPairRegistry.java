package registry;

import exceptions.SynonymPairNotExistException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SynonymPairRegistry {

    Map<String, List<String>> pairs = new HashMap<>();

    public List<String> getSynonymPair(String word){
        if(!pairs.containsKey(word)){
            return new ArrayList<>();
        }
        return this.pairs.get(word);
    }
    public void addSynonymPair(String word1,String word2){
        List<String> values= this.getSynonymPair(word1);
        values.add(word2);
        this.pairs.put(word1,values);
    }

    public void removeSynonymPair(String word1,String word2) throws SynonymPairNotExistException{
        List<String> synonymPair = this.getSynonymPair(word1);
        if(synonymPair.isEmpty()){
            throw(new SynonymPairNotExistException());
        }
        else{
            synonymPair.remove(word2);
            if(synonymPair.isEmpty()){
                pairs.remove(word1);
            }
        }

    }
    public Map<String, List<String>> getPairs(){
        return this.pairs;
    }

}
