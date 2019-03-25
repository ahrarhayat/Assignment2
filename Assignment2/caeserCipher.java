
/**
 * Write a description of caeserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class caeserCipher {
public String encrypt(String input,int key)
    {
        StringBuilder encrypted= new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String loAlphabet="abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet= alphabet.substring(key)+alphabet.substring(0,key);
        String loShifted=loAlphabet.substring(key)+loAlphabet.substring(0,key);
        for(int i=0; i<encrypted.length();i++)
        {
            char currChar= encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            int loIdx=loAlphabet.indexOf(currChar);
            
            if(idx!=-1 || loIdx!=-1 )
            {
                if(idx!=-1){
                char newChar= shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i,newChar); }
                else
                {
                char newLoChar=loShifted.charAt(loIdx);
                encrypted.setCharAt(i,newLoChar);
                }
            }
           }
            return encrypted.toString();
        
        
    }
    public void testCaeser()
    {
        int key=15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    public String encryptTwoKeys(String input, int key1, int key2)
    {
        StringBuilder str = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String loAlphabet="abcdefghijklmnopqrstuvwxyz";
        String shiftedWithKey1=alphabet.substring(key1)+alphabet.substring(0,key1);
        String LoShiftedWithKey1=loAlphabet.substring(key1)+loAlphabet.substring(0,key1);
        String shiftedWithKey2=alphabet.substring(key2)+alphabet.substring(0,key2);
        String LoShiftedWithKey2=loAlphabet.substring(key2)+loAlphabet.substring(0,key2);
        for(int i=0; i<str.length();i++)
        {
            char currChar= input.charAt(i);
            int idx=alphabet.indexOf(currChar);
            int loIdx=loAlphabet.indexOf(currChar);
            if(idx!=-1 || loIdx!=-1 )
            {
                if(idx!=-1){
                if(i%2==0)
                {
                char newChar= shiftedWithKey1.charAt(idx);
                str.setCharAt(i,newChar);
                }
                else
                {
                char newChar= shiftedWithKey2.charAt(idx);
                str.setCharAt(i,newChar); 
                }
            }
            else
            {
                if(i%2==0)
                {
                char newChar= LoShiftedWithKey1.charAt(loIdx);
                str.setCharAt(i,newChar);
                }
                else
                {
                char newChar= LoShiftedWithKey2.charAt(loIdx);
                str.setCharAt(i,newChar); 
                }
                
            }
            }
        }
        return str.toString();
    }
    public void testEncryptTwoKeys()
    {
        int key1=8;
        int key2=21;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String result= encryptTwoKeys(message,key1,key2);
        System.out.println(result);
}
}
