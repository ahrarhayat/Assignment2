
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {


	public void countWordLengths(FileResource source, int [] counts)
	{
	    int contentsLength=(source.asString()).length();
	    String [] words = new String [31];
	    //Store all the words in an array
            //Start counting word Lengths
            int k=1;
            for(String word: source.words())
            {
                          word = word.toLowerCase();
			  System.out.println(word);
			
			  counts[word.length()]+=1;
			   if(words[word.length()]==null)
			    {
			        words[word.length()]= word;
			        
			    }
			     else 
			     {
			         words[word.length()]= words[word.length()]+" "+word;
			         
			     }
			   
			}

            //print the results
            for(int i=1; i < counts.length; i++){
	        System.out.println(counts[i]+" words of length "+i+" : "+words[i]);
		}
            
	}
	public int indexOfMax(int [] values )
	{ int i=1;
	  int iMax=i;
	  int maxValue=values[i];
	  for( i=2; i < values.length; i++){
	    if(values[i]>maxValue)
	    {
	        maxValue=values[i];
	        iMax=i;
	    }
	    
	}
	    return iMax;
	}
	public void testCountWordsLengths()
	{
	    FileResource fr= new FileResource();
	    int counts[]=new int[31];
	    countWordLengths(fr, counts);
	    System.out.println(indexOfMax(counts));
	}
	
	

}
