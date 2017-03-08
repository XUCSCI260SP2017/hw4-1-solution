package edu.xavier.csci260.dentinger.platin;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PLatinImpl implements PLatin {
  private static List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");

  @Override public String convert(String word) {

    Optional<Integer> vowelIsFirst = vowels.stream().map(vowel -> word.indexOf(vowel))
        .filter(x -> x == 0)
        .findFirst();

    Optional<Integer> minVowel = vowels.stream().map(vowel -> word.indexOf(vowel))
        .filter(x -> x > 0).min(Integer::compare);

    if (vowelIsFirst.isPresent()) {
      return word + " way";
    }
    //Now we know that a consonant must be first. Assuming no spaces or numbers of course.
    String s = word.substring(minVowel.get(), word.length()) + " " + word
        .substring(0, minVowel.get()) + "ay";
    return s;
  }

  @Override public String revert(String latin) {
    String[] words = latin.split(" ");
    String[] ays = words[1].split("ay");

    if("way".equals(words[1]))
      return words[0];
    return ays[0]+words[0];
  }
  @Override public String process(String string) {
    String[] strings = string.split(" ");
    return Arrays.asList(strings).stream().map(word -> convert(word))
        .collect(Collectors.joining(" "));

  }
}
