// Violet Gonzalez Oct 16, 2026
// Part 2 of lazy rivers: done with Java stream API

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LazyRiversP2 {
    static Set<String> stopWords() throws IOException {
        // Read the stop file and clean it up a bit
        String content = Files.readString(Path.of("../stop_words.txt"));
        Set<String> stops = new HashSet<>(Arrays.asList(content.strip().split(",")));
        for (char character = 'a'; character <= 'z'; character++) {
            stops.add(String.valueOf(character));
        }
        return stops;
    }
    

    public static void main (String[] args) throws IOException {
        Set<String> stops = stopWords();
        System.out.println(stops.size());
        System.out.println(stops.contains("the"));
        System.out.println(stops.contains("a"));
        System.out.println(stops.contains("z"));
        System.out.println(stops.contains("your"));
    }
}
