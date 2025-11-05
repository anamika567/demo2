package InterviewQuestions;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class PrintDuplicatesOnlyWithoutCollection {

	public static void main(String[] args) {

		 int b[] = {2, 5, 3, 1, 8, 7, 5, 3,7};
	        HashMap<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
	  
	         //Traverse an array
	         for(int i = 0; i < b.length; i++) {
	             
	             if(arrMap.containsKey(b[i])) 
	             {
	                 arrMap.put(b[i], arrMap.get(b[i]) + 1);
	             }
	             else
	             {
	                arrMap.put(b[i], 1);
	             }
	       }
	         
	        Set<Entry<Integer, Integer>> entry = arrMap.entrySet();
	         for(Entry<Integer, Integer> ent: entry) {
	  
	           if(ent.getValue() > 1) {
	              System.out.print(ent.getKey()+" ");
	           }
	         }

	}

}
