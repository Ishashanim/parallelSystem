package com.example.parallelSystem;

import com.example.parallelSystem.controllers.SentenceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.parallelSystem.registry.SynonymPairRegistry;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ParallelSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParallelSystemApplication.class, args);
	}

	@Autowired
	SynonymPairRegistry pairRegistry;

	@Autowired
	SentenceController sentenceController;

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			pairRegistry.addSynonymPair("hello", "hey");
			pairRegistry.addSynonymPair("world", "earth");
			pairRegistry.addSynonymPair("planet", "earth");
			pairRegistry.addSynonymPair("planet","planet");

			Map<String, List<String>> synonymPairs = pairRegistry.getPairs();
			for (String word1 : synonymPairs.keySet()) {
				System.out.print("" + word1 + " : ");
				for (int i = 0; i < synonymPairs.get(word1).size(); i++) {
					System.out.print(synonymPairs.get(word1).get(i) + ",");
				}
			}

			List<String> sentences = sentenceController.getSentences("hello world");
			System.out.println("Sentence for hello world are");
			for (int i = 0; i < sentences.size(); i++) {
				System.out.println(sentences.get(i));
			}

			try {
				pairRegistry.removeSynonymPair("planet", "earth");
			} catch (Exception e) {
				System.out.println("Error was there");
			}

			sentenceController.getSentences("hello world");
		};
	}


}