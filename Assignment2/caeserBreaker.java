
/**
 * Write a description of caeserBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class caeserBreaker {
 public int [] countLetters(String message)
 {
     String alph="abcdefghijklmnopqrstuvwxyz";
     int [] counts = new int [26];
     for(int k=0;k<message.length();k++)
     {
         char ch = Character.toLowerCase(message.charAt(k));
         int dex = alph.indexOf(ch);
         if(dex!=-1)
         {
             counts[dex]+=1;
         }
         
     }
     return counts;
 }
 
 public int indexOfMax(int [] values )
	{ int i=0;
	  int iMax=i;
	  int maxValue=values[i];
	  for( i=0; i < values.length; i++){
	    if(values[i]>maxValue)
	    {
	        maxValue=values[i];
	        iMax=i;
	    }
	    
	}
	    return iMax;
	}
	
 public String decrypt(String encrypted)
 {
     caeserCipher cc = new caeserCipher();
     int [] freqs=countLetters(encrypted);
     int maxDex=indexOfMax(freqs);
     //considering e is the most common alph
     int dkey=maxDex-4;
     if(maxDex<4)
     {
        dkey=26-(4-maxDex); 
     }
     return cc.encrypt(encrypted,26-dkey);
 }
 
 public String StringBreaker(String encrypted)
 {
     caeserCipher cc = new caeserCipher();
     System.out.println(encrypted);
     encrypted=cc.encryptTwoKeys(encrypted,17,21);
     StringBuilder odd = new StringBuilder();
     StringBuilder even = new StringBuilder();
     for(int i=0;i<encrypted.length();i++)
     {
         char currChar= encrypted.charAt(i);
         if(i%2==0 && Character.isLetter(currChar))
         {
             even.append(encrypted.charAt(i));
         }
         if(i%2!=0 && Character.isLetter(currChar))
         {
             odd.append(encrypted.charAt(i));
         }
     }
     System.out.println(encrypted);
     System.out.println(even.toString());
     System.out.println(odd.toString());
     return even.toString();
 }
 
 public void TestStringBreaker()
 {
     FileResource fr = new FileResource();
     String message =fr.asString();
     StringBreaker(message);
 }
 
 public String decryptTwoKeys(String encrypted)
 {
     caeserCipher cc = new caeserCipher();
     //separate the encrypted string into two parts

     int [] freqsEven=countLetters(StringBreaker(encrypted));
     int [] freqsOdd=countLetters(StringBreaker(encrypted));
     int maxDexEven=indexOfMax(freqsEven);
     int maxDexOdd=indexOfMax(freqsOdd);
     
     //considering e is the most common word
     int dkey1=maxDexEven-4;
     if(maxDexEven<4)
     {
        dkey1=26-(4-maxDexEven); 
     }
     int dkey2=maxDexOdd-4;
     if(maxDexOdd<4)
     {
        dkey2=26-(4-maxDexOdd); 
     }
     return cc.encryptTwoKeys(encrypted,26-dkey1,26-dkey2);
 }
  
 public void testDecrypt()
 {
     caeserCipher cc = new caeserCipher();
     FileResource fr = new FileResource();
     String message =fr.asString();
     String encrypted=cc.encryptTwoKeys(message,17,21);
     System.out.println(encrypted);
     System.out.println(decryptTwoKeys(message));
 }
}
