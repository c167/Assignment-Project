package com.Project;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;

/**
 * The FileHandler class will do most of jobs required of this assignment. It will parse through the data in the text file
 * and using a dictionary of swear words will output a message stating if the text file has abusive content or not.
 * It will also check text segments for length and look for upper case letter words to try and further determine if theres
 * any abusive content.
 *
 * Author: Colin Doyle
 * 
 */
public class FileHandler
{
    public String parser(String fileName, boolean checkSentence, boolean checkShouting)
    {
        File fileStream = new File(fileName);
        //list of bad words file based of the one Google uses to filter out absuvive content from their search engine. Link to download in document.
        File curseFile = new File("C:\\Users\\Colin-Study\\Documents\\Java Programming\\Random_File\\com\\Project\\full-list-of-bad-words-text-file_2018_03_26.txt");
        
        try 
        {
            Scanner fileScanner = new Scanner(fileStream);
            Scanner profanityScanner = new Scanner(curseFile);
            String word = profanityCheck(fileScanner, profanityScanner);

            
            if (checkSentence == true)
            {
                int lengthOfSentence = sentenceCount(fileScanner);
                if (lengthOfSentence > 12)//The number 12 is the average length of a abusive message according to the book Digital Libraries: Data, Information, and Knowledge for Digital Lives (link in document)
                {
                    System.out.println("The amount of words in this text is " + lengthOfSentence + " and as such is less likely to be formal and more likely to have abusive content");
                }
                else if (lengthOfSentence < 12)
                {
                    System.out.println("The amount of words in this text is " + lengthOfSentence + " and is less likely to be abusive content");
                }
            }
            
            if (checkShouting == true)
            {
                boolean isShouting = checkForShouting(fileScanner);
                
                if (isShouting == true)
                {
                    System.out.println("There is an abnormal amount of caps lock words");
                }
                else
                {
                    System.out.println("There doesnt seem to be any unneccessary caps lock words");
                }
            }
            fileScanner.close();
            return word;
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "error";
    }
    
    //Method to find if theres any curse words in the file
    public String profanityCheck(Scanner fileScanner, Scanner profanityScanner)
    {
        String word;
        String curseWord;
        List<String> profanityList = new ArrayList<String>();
        
        while (profanityScanner.hasNextLine())
        {
            profanityList.add(profanityScanner.nextLine());
        }
        // Add the list of curse words to a list to iterate through it more easily
        
        while (fileScanner.hasNext())
        {
            word = fileScanner.next();
            
            for (int i = 0; i < profanityList.size(); i++)
            {
                if (word.equals(profanityList.get(i)))
                {
                    System.out.println("Curse word found.");
                    System.out.println("Found curse word was " + word);
                    return word;
                }
            }
            
        }
        profanityScanner.close();
        
        return "no curse words found";
    }
    
    //Method to count the length of a text segment
    public int sentenceCount(Scanner fileScanner)
    {
        int wordCount = 0;
        while (fileScanner.hasNext())
        {
            String word = fileScanner.next();
            wordCount++;
            if (word.contains(".") == true)
            {
                break;
            }
            
        }
        
        return wordCount+3;   
    }
    
    //Method to count up the amount of words that are in upper case
    public boolean checkForShouting(Scanner fileScanner)
    {
        int amountOfUpperCaseWords = 0;
        while (fileScanner.hasNext())
        {
            String word = fileScanner.next();

            if (isAllUpperCase(word) == true)
            {
                amountOfUpperCaseWords++;
            }
        }
        System.out.println("There is " + amountOfUpperCaseWords + " uppercase words");
        
        
        if (amountOfUpperCaseWords >= 1)
        {
            return true;
        }
        
        return false;
    }
    
    //Method to check if a word is in all uppercase or not.
    public static boolean isAllUpperCase(String word)
    {
        if (word == null || word.length() == 0) 
        {
            return false;
        }
        for (int i = 0; i < word.length(); i++) 
        {
            if (Character.isUpperCase(word.charAt(i)) == false || word.equals("I")) 
            {
                return false;
            }
        }
        return true;
    }

}
