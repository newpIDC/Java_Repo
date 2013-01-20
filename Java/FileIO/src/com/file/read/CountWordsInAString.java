package com.file.read;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class CountWordsInAString {

	public static void countWordsInAString(){
		 
        StreamTokenizer streamTokenizer = null;

        String stringToBeParsed = "The quick brown fox jumped over the lazy dog";
        StringReader reader = new StringReader(stringToBeParsed);
        
        int wordCount = 0;
        
        try {            
            streamTokenizer = new StreamTokenizer(reader);            
            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {                
                if (streamTokenizer.ttype == StreamTokenizer.TT_WORD)
                    wordCount++;
            }
            
            System.out.println("Number of words in file: " + wordCount);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}
