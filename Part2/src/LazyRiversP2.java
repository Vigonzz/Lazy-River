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
import java.util.stream.Stream;

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

    static Stream<String> lines(String filename) throws IOException {
        // Return the file
        return Files.lines(Path.of(filename));

    }

    // Where the new stream comes in, simmilar to words() in python part 1
    static Stream<String> words(Stream<String> lines) {
        // Compile the program first
        Pattern wordPattern = Pattern.compile("[a-z0-9]+");
        // Using flatMap allows for joining of the stream of words produced through
        // running each line
        return lines.flatMap(line -> wordPattern.matcher(line.toLowerCase()).results().map(MatchResult::group));
    }

    // filter the words
    static Stream<String> nonStopWords(Stream<String> words, Set<String> stops) {
        return words.filter(Predicate.not(stops::contains));
    }

    // Counts and sorts the words
    static List<Map.Entry<String, Long>> countAndSort(Stream<String> words) {
        // Short pause in the lazy river due to needed to collect - simmilar to pythons yield
        Map<String, Long> freqs = words.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Sort through the
        return freqs.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
    }

    public static void main (String[] args) throws IOException {
        Set<String> stops = stopWords();


    }
}
