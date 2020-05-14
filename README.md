# Introduction

Just an exercise to try out reading text data from an instance of ​BufferedReader and performing computations on that data. To practice working inside a small but entirely proper object-oriented framework​, we design an entire class hierarchy that reads in text one line at the time and performs some operation for each line, and having read in all the lines, emits a result in the end. The subclasses can then decide what exactly that operation is by overriding the ​template methods used by this abstract algorithm.
To allow this processing to return a result of arbitrary type that can be freely chosen by the users of this class, the abstract superclass of this little framework is also defined to be ​generic​. Start by creating the class ​public abstract class FileProcessor<R> that defines the following three abstract​ methods:

**protected abstract void startFile();
protected abstract void processLine(String line);
protected abstract R endFile();**


and one concrete ​final method that is therefore guaranteed to be the same for all future subclasses in this entire class hierarchy:

**public final R processFile(BufferedReader in) throws IOException**

This method should first call the method ​startFile​. Next, it reads all the lines of text coming from in one line at the time in some kind of suitable loop, and calls the method ​processLine passing it as argument each line that it reads in. Once all incoming lines have been read and processed, this method should finish up by calling the method ​endFile​, and return whatever the method ​endFile returned.
This abstract superclass defines a template for a class that performs some computation for a text file that is processed one line at the time, returning a result whose type ​R can be freely chosen by the concrete subclasses of this class. Different subclasses can now override the three template methods ​startFile​, ​processLine and ​endFile methods in different ways to implement different computations on text files.
As the first application of this mini-framework (and indeed it is a framework by definition, ​since you will be writing methods for this framework to call, instead of the framework offering methods for you to call​), you will emulate the core functionality of the Unix command line tool ​wc that counts how many characters, words and lines the given file contains. Those of you who have taken the Unix and C programming course CCPS 393 should already recognize this handy little text processing tool, but even if you have not yet taken that course, you can still implement this tool based on the following specification of its behaviour.
Create a class ​WordCount that ​extends FileProcessor<List<Integer>>​. This class should contain three integer fields to keep track of these three counts, and the following methods:

**protected void startFile()**

Initializes the character, word and line counts to zero.

**protected void processLine(String line)**

Increments the character, word and line counts appropriately. In the given ​line​, every character increments the count by one, regardless of whether that character is a whitespace character. To properly count the words in the given line, count the non-whitespace characters for which the previous character on that ​line is a whitespace character. (You can imagine that the first character is preceded by an invisible whitespace character.) You must use the utility method Character.isWhitespace to test whether some character is a whitespace character, since the Unicode standard defines ​quite a lot more whitespace characters​ than most people can even name.
protected List<Integer> endFile()
Creates and returns a new ​List<Integer> instance (you can choose the concrete subtype of this result object for yourself) that contains exactly three elements; the character, word and line counts, in this order.
