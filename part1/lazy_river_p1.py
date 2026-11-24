"""
Violet Gonzalez, November 23 2026

Task: Part 1 of the lazy river style using python (okayed during lecture
and iterate over words rather the characters)
"""

import sys, string, operator

def words(filename):
    """ Word-source Generator """
    # Loop over the lines lazily
    with open(filename, "r", encoding="utf-8") as file:
        for line in file:
            lowered = line.lower()
            char_hold = []
            # Go over the lower cased characters
            for char in lowered:
                if char.isalnum():
                    char_hold.append(char)
                else:
                    char_hold.append(" ")
            # Clean up the characters
            cleaned = ''.join(char_hold)
            line_words = cleaned.split()

            # Loop over the line_words for one word at a time
            for word in line_words:
                # Create a generator - each time something is downstream it'll ask for the next work 
                # until it hits yield
                yield word

def non_stop_words(filename):
    """ Non stop word generator, it takes the file and creates
    the word generator """

    # Read over the stop words
    with open("../stop_words.txt", "r", encoding="utf-8") as file:
        content = file.read()
    # Clean up the words
    clean_content = content.strip("\n").split(",")
    # Add the single letters to a list
    letters  = list(string.ascii_lowercase)
    # Combine the two lists
    stop_words = set(clean_content + letters)


    # Filter the words for stop words
    for word in words(filename):
        if word not in stop_words:
            yield word    


def count_and_sort(filename):
    """ Yield snapshots: sorting into a list of pairs for word and count """
    freqs = {}
    counter = 1

    # pull the words and count them
    for word in non_stop_words(filename):
        if word not in freqs:
            freqs[word] = 1
        else:
            freqs[word] += 1
        
        # Snapshot every 5,000 words
        if (counter % 5_000) == 0:
            # Build the sorted snapshot
            yield sorted(freqs.items(), key=operator.itemgetter(1), reverse=True)
            # Add to the counter
        counter += 1
    # Get final snapshot
    yield sorted(freqs.items(), key=operator.itemgetter(1), reverse=True)


# The main function
for snapshot in count_and_sort(sys.argv[1]):
    print("-----------------------------")
    for w,c in snapshot[0:25]:
        print(f"{w}  -  {c}")


