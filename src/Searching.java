import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Searching {
	
	public static void main(String [] args){
		Searching bs = new Searching();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int a[] ={1, 2, 2,3, 4};
		list.add(1);
		//list.sort(c);
		list.add(-1);
		list.add(0);
		list.add(-3);
		list.add(0);
		
		//System.out.println(bs.findCount(list, 1));
		System.out.println(bs.threeSumClosest(list, -1));
		
	}
	

	public int threeSumClosest(ArrayList<Integer> a, int b) {
	    
	    int positive=Integer.MAX_VALUE, negative=Integer.MIN_VALUE,temp;
	    Collections.sort(a);
	    for(int i=0;i<a.size();i++){
	        for(int j=i+1, k=a.size()-1;j<k;){
	            temp =a.get(i)+a.get(j)+a.get(k);
	            if(temp==b){
	                return b;
	            }
	            else if(temp>b)
	                {
	                    if(temp<positive)
	                        positive = temp;
	                    k--;
	                }
	               else{
	                   if(temp>negative)
	                        negative =  temp;
	                   j++;
	               }
	           
	        }
	    }
	    
	        return (Math.abs(negative)>positive?positive:negative);
	}
	

		public int findCount(final List<Integer> a, int b) {
			if(a.size()==0)
					return 0;
			if(a.size()==1)
			{
				if(a.get(0)!=b)
					return 0;
				else
					return 1;
			}
		    int start =0, end=a.size();
		    int mid=0; 
		    while(start<=end){
		        mid= (start+end)/2;
		        if(( b== a.get(mid)&& start==mid)||(b==a.get(mid)&& a.get(mid-1)<b) ) 
		            break;
		       else if(a.get(mid)>=b){
		           end= mid-1;
		       }
		       else
		        start= mid+1;
		    }
		    System.out.println(mid);
		    int count=0;
		            while(a.get(mid++)==b)
		                count++;
		        return count;
		}
	
}
