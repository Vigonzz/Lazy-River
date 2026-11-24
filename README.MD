## Lazy Rivers: Style 28
This style follow two parts the first being in python which implements iterators through (generators: yield). Therefore the expected output of this part should be 12 blocks that iterates through each for 5,000 non stop words. It takes snapshots which comprises the blocks. The last block is the final output of part 2

Part two is done in Java and uses stream similar to golf style. In order to not be completely similar to golf we followed more streaming with 29.1. 


#### How to run:
For this assignment, I suggest having one main folder and two separate folder. So the structure should follow:

- WeekEight(Main folder):
    - part1 (subfolder):
        - lazy_river_p1.py
    - part2 (subfolder):
        - src(subfolder):
            - LazyRiversP2.java
    - pride-and-prejudice.txt
    - stop_words.txt

**Part One:**
1. cd all_the_way/to/part1/folder
2. Once in the part1 folder type (use python or python3): 
    - python3 lazy_river_p1.py ../pride-and-prejudice.txt
3. Admire the snapshots and look at the last block to see part2's expected output
4. If you want to have a clean file to view part1 output use:
    - python3 lazy_river_p1.py ../pride-and-prejudice.txt > output.txt


**Part Two:**
1. cd all_the_way/to/part2/folder
2. cd one more time to the src folder
3. Still in the terminal, type:
    - java LazyRiverP2.java ../pride-and-prejudice.txt
4. View the output which shows the last block from p1. It's the top 25 words used in the book Pride and Prejudice

