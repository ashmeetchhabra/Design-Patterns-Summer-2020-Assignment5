# CSX42: Assignment 5
**Name:** Ashmeet kaur Chhabra

Used One Slag Day
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [textdecorators/src](./textdecorators/src/) folder.

## Instruction to clean:

```commandline
ant -buildfile src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile src/build.xml run -Dinput="input.txt" -Dmisspelled="misspelled.txt" -Dkeywords="keywords.txt" -Doutput="output.txt" -Ddebug=0
```
Note: Arguments accept the absolute path of the files.


## Description:

Classes:
1. Driver.java
2. KeywordDecorator.java
3. MostFrequentWordDecorator.java
4. SentenceDecorator.java
5. SpellCheckDecorator.java
6. FileProcessor.java
7. MyLogger.java
8. InputDetails.java
9. MyLogger.java

Interfaces:
1. FileDisplayInterface.java
2. StdoutDisplayInterface.java

AbstractClasses:
1. AbstractTextDecorator

Description:
1. In this assignment decorator pattern is implpemented. 
2. There are 4 decorators : KeywordDecorator, MostFrequentWordDecorator, SentenceDecorator, SpellCheckDecorator.
3. The paragraph is given by input.txt file which has to be decorated with the suffix and prefix.
4. First The MostFrequentWordDecorator is applied in which the frequency of the words are calculated and the word with highest number of occurance has the prefix and suffix as MOST_FREQUENT_ &  _MOST_FREQUENT.
5. Secondly, the KeywordDecorator is applied in which keyword.txt file is given which checks if that keywords are present in the paragraph then the suffix and prefix: KEYWORD_ & _KEYWORD is added to that keyword.
6. Third, the SpellCheckDecorator is applied in which misspelled.txt file is given and the words which are misspelled in the paragraph are matched with this file and is decorated by the prefix and suffix as: SPELLCHECK_ and  _SPELLCHECK.
7. Forth, the SentenceDecorator is applied in which the suffix and prefix for every sentence is BEGIN_SENTENCE__ and __END_SENTENCE.
8. The final paragraph is then written into the output.txt file.
9. The Debug level is given by the user and on that level the lines are written into the log.txt file.
10. Boundary checks done
11. Exceptions are handled


## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 05 August 2020


