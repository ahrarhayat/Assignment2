
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
 
 public String StringBreakerForEven(String encrypted)
 {
   
     StringBuilder even = new StringBuilder();
     String  noSpace="";
     for(int i=0;i<encrypted.length();i++)
     {
         char currChar=encrypted.charAt(i);
         
         if(Character.isLetter(currChar))
         {
             if(noSpace.equals(""))
             {
             noSpace=Character.toString(currChar);
         }
         else
         { noSpace=noSpace+Character.toString(currChar);
             
         }
        }
     }
 
     for(int i=0;i<noSpace.length();i++)
     {
         char currChar= noSpace.charAt(i);
         if(i%2==0 && Character.isLetter(currChar))
         {
             even.append(noSpace.charAt(i));
         }
        
     }
     
    
     return even.toString();
 }
 
  public String StringBreakerForOdd(String encrypted)
 {
     
     StringBuilder odd = new StringBuilder();
     String  noSpace="";
     for(int i=0;i<encrypted.length();i++)
     {
         char currChar=encrypted.charAt(i);
         
         if(Character.isLetter(currChar))
         {
             if(noSpace.equals(""))
             {
             noSpace=Character.toString(currChar);
         }
         else
         { noSpace=noSpace+Character.toString(currChar);
             
         }
        }
     }
     for(int i=0;i<noSpace.length();i++)
     {
         char currChar= noSpace.charAt(i);
         if(i%2!=0 && Character.isLetter(currChar))
         {
             odd.append(noSpace.charAt(i));
         }
     }
     
     return odd.toString();
 }
 
 public void TestStringBreaker()
 {
     FileResource fr = new FileResource();
     String message =fr.asString();
     StringBreakerForEven(message);
     StringBreakerForOdd(message);
     
 }
 
 public String decryptTwoKeys(String encrypted)
 {
     caeserCipher cc = new caeserCipher();
     //separate the encrypted string into two parts
     
     System.out.println("Encrypted message: "+encrypted);
     int [] freqsEven=countLetters(StringBreakerForEven(encrypted));
     int [] freqsOdd=countLetters(StringBreakerForOdd(encrypted));
     int maxDexEven=indexOfMax(freqsEven);
     int maxDexOdd=indexOfMax(freqsOdd);
     
     //considering e is the most common word
     int dkey1=maxDexEven-4;
     if(maxDexEven<4)
     {
        dkey1=26-(4-maxDexEven); 
        
     }
     System.out.println("dkey1: "+dkey1);
     int dkey2=maxDexOdd-4;
     if(maxDexOdd<4)
     {
        dkey2=26-(4-maxDexOdd); 
     }
     System.out.println("dkey2: "+dkey2);
     return cc.encryptTwoKeys(encrypted,26-dkey1,26-dkey2);
 }
  
 public void testDecrypt()
 {
     FileResource fr = new FileResource();
     String message =fr.asString();
     System.out.println("Original message: " +message);
     System.out.println("Decrypted message: "+decryptTwoKeys(message));
     
 }
}
