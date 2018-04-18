------------------------------------------------------------------------
Links
------------------------------------------------------------------------

GitHub repository: https://github.com/c167/Assignment-Project

Youtube video: https://www.youtube.com/watch?v=Wtjmu_PPFtM&feature=youtu.be

dictionary of bad words: https://www.freewebheaders.com/full-list-of-bad-words-banned-by-google/

isAllUpperCase method: http://commons.apache.org/proper/commons-lang/javadocs/api-3.1/src-html/org/apache/commons/lang3/StringUtils.html#line.111 (line 5478)

GUI Layout 
https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
https://www.javacodex.com/Swing/GroupLayout

Explanation for why 12 words: https://books.google.ie/books?id=Xrg8DwAAQBAJ&pg=PA273&lpg=PA273&dq=average+length+of+a+rude+message&source=bl&ots=Muq9-Bt2lt&sig=NyULkQetT-FdpyWj33hg5n_lICY&hl=en&sa=X&ved=0ahUKEwjM7PDysMPaAhWiJ8AKHdDjA9IQ6AEIUjAE#v=onepage&q=average%20length%20of%20a%20rude%20message&f=false

------------------------------------------------------------------------
Description of code
------------------------------------------------------------------------
Control:
-Two static booleans that change when the user ticks a box on the GUI, 
and by extension changes the outcome of the result. Made static so they can 
interact with the actionListeners

-Declaring GUI components

-Once the user puts in a valid file name (path included) and hits search then the program
passes that file over to the filehandler to be searched through for profanity.

-More actionListeners but this time for the tick boxes

-GUI layout that was done with the help of the code from the websites listed in the comment 
above this section

FileHandler:
-Open up the filestreams and scanners for both the text file and the curse word files.

-Do checks to see if the boxes were ticked, if so then goto the corresponding method
to get the output.

-When the lengthOfSentence is greater than 12, 
then it has a higher probability of being abusive content.

-The checkForShouting method will return a true value if the result of the method extending from it finds
a sufficient amount of words that are completely upper case letters.

-The profanityCheck method adds the list of curse words from the file to 
a list, this is done because the other method of having two strings = theScanner.next()
didn't seem to work as well. Once the list is done the fileScanner searches through the file
and stops as soon as it finds a major expletive. It then prints out that word and
returns it.

