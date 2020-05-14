/**
 * Lab 6
 * Brandon Singh
 * 500779667
 */
import java.util.ArrayList;
import java.util.List;

public class WordCount extends FileProcessor<List<Integer>> 
{

    private int charCount, wordCount, lineCount;
    List<Integer> resultList = new ArrayList<Integer>();

    protected void startFile() 
    {
        charCount = 0;
        wordCount = 0;
        lineCount = 0; //setting the line counter to 0, trivial.
    }

    protected void processLine(String line) 
    {
        charCount += line.length();
        wordCount += counterWords(line);
        lineCount++;
    }

    private int counterWords(String line) 
    {

        int counter = 0;
        boolean lastSpace = true;

        for (char c : line.toCharArray()) 
        {
            if (Character.isWhitespace(c)) 
            {
                lastSpace = true;
            } 
            else 
            {
                if (lastSpace)
                    counter++;
                lastSpace = Character.isWhitespace(c);
            }
        }
        return counter;
    }

    protected List<Integer> endFile() 
    {
        resultList.add(charCount);
        resultList.add(wordCount);
        resultList.add(lineCount); //PLACEOHOLDER, WILL FIX***
        return resultList;
    }
}