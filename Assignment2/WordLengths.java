
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
            int x=0;
            int length=0;
            for(String word: source.words()){
                        
            {          for(x=0;x<word.length();x++){
			  char currChar=word.charAt(x);
			  if(Character.isLetter(currChar)==true && currChar!=','&&currChar!='.')
			  {
			      length=length+1;
			  }
			  
			 }
			  counts[length]+=1;
			   if(words[length]==null)
			    {
			        words[length]= word;
			        
			    }
			     else 
			     {
			         words[length]= words[length]+" "+word;
			         
			     }
			   length=0;
			}
}
            //print the results
            for(int i=1; i < counts.length; i++){
                if(words[i]!=null){
                    if(counts[i]>1)
                    {
	        System.out.println(counts[i]+" words of length "+i+" : "+words[i]);
		}
		else
		{
		 System.out.println(counts[i]+" word of length "+i+" : "+words[i]);
		  }
}
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
	    System.out.println("The maximum of words are of length "+indexOfMax(counts));
	}
	
	

}
