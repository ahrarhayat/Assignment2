
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {

       public String[] getCommon(){
		FileResource resource = new FileResource("data/common.txt");
		String[] common = new String[20];
		int index = 0;
		for(String s : resource.words()){
			common[index] = s;
			index += 1;
		}
		return common;
	}
	public int indexOf(String[] list, String word) {
	    for (int k=0; k<list.length; k++) {
	        if (list[k].equals(word)) {
	               return k;
	           }
	       }
	    return -1;
	}
	
	public void countWords(FileResource resource, String[] common, int[] counts){
		for(String word : resource.words()){
			word = word.toLowerCase();
			int index = indexOf(common,word);
			if (index != -1) {
				counts[index] += 1;
			}
		}
	}
	void countShakespeare(){
		//String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
			//          "likeit.txt", "macbeth.txt", "romeo.txt"};
	        String[] plays = {"small.txt"};
		String[] common = getCommon();
		int[] counts = new int[common.length];
		for(int k=0; k < plays.length; k++){
			FileResource resource = new FileResource("data/" + plays[k]);
			countWords(resource,common,counts);
			System.out.println("done with " + plays[k]);
		}
		
		for(int k=0; k < common.length; k++){
			System.out.println(common[k] + "\t" + counts[k]);
		}
	}
	public void countWordLengths(FileResource source, int [] counts)
	{
	    int contentsLength=(source.asString()).length();
	    String [] words = new String [contentsLength];
	    //Store all the words in an array
            //Start counting word Lengths
            for(String word: source.words())
            {
                        word = word.toLowerCase();
			int k=1;
			if(k==word.length())
			{
			    counts[k]+=1;
			    if(words[k]==null)
			    {
			        words[k]= word;
			     }
			     else
			     {
			         words[k]= words[k]+" "+word;
			     }
			   
			}
			else
			{
			    k=k+1;
			}

            }
            //print the results
            for(int k=1; k < counts.length; k++){
	        System.out.println(counts[k]+" words of length"+words[k]);
		}
            
	}
	public void testCountWordsLength()
	{
	    FileResource fr= new FileResource();
	    int contentsLength=(fr.asString()).length();
	    String [] words = new String [contentsLength];
	    int counts[]=new int[100];
	    countWordLengths(fr, counts);
	}
	

}
