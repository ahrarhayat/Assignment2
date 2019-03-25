
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
 
 public int indexOfMaxEven(int [] values )
	{ int i=0;
	  int iMaxEven=i;
	  
	  int maxValueEven=values[i];
	 
	  for( i=0; i < values.length; i+=2){
	    if(values[i]>maxValueEven)
	    {
	        maxValueEven=values[i];
	        iMaxEven=i;
	    }
	 
}
	    return iMaxEven;
	   }
	  public int indexOfMaxOdd(int [] values )
	   {
	       int i=0;
	       int iMaxOdd=i+1;
	        int maxValueOdd=values[i+1];
	           for( i=1; i < values.length; i+=2){
	    if(values[i]>maxValueOdd)
	    {
	        maxValueOdd=values[i];
	        iMaxOdd=i;
	    }
	    
	}
	return iMaxOdd;
	   }

	
 public String decryptTwoKeys(String encrypted)
 {
     caeserCipher cc = new caeserCipher();
     //separate the encrypted string into two parts
     int [] freqs=countLetters(encrypted);
     int maxDexEven=indexOfMaxEven(freqs);
     int maxDexOdd=indexOfMaxOdd(freqs);
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
