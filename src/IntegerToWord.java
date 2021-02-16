package starbrosgame;
public class IntegerToWord 
{
    /**
         * Converts and returns a number into words. (eg. "1" becomes "one")
     * @param number the number (between 0 and 10) that 
     * will be changed into words.
     * <p>
     * @return the string representing the word for the integer specified.
         */
    public static String toWords(int number)
    {
        String word = "";
        
        
        switch (number)
        {
            case 0: word = "Zero";
            break;
            case 1: word = "One";
            break;
            case 2: word = "Two";
            break;
            case 3: word = "Three";
            break;
            case 4: word = "Four";
            break;
            case 5: word = "Five";
            break;
            case 6: word = "Six";
            break;
            case 7: word = "Seven";
            break;
            case 8: word = "Eight";
            break;
            case 9: word = "Nine";
            break;
            case 10: word = "Ten";
            break;
        }
        return word;
    }
    
    
}
