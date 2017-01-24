import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class TestingArrayList {

	public static void main(String[] args) {
		
		String s = "sdfgjk";
		char ch[] = s.toCharArray();
		Arrays.sort(ch);
		String str= new String(ch);
		System.out.println(String.valueOf(ch));
		 boolean[][] visited = new boolean[5][10];
		// TODO Auto-generated method stub
		 HashMap<Integer,Character> map = new HashMap<Integer, Character>();
		    map.put(1,'I');
		    map.put(5,'V');
		    map.put(10,'X');
		    map.put(50,'L');
		    map.put(100,'L');
		    map.put(500,'D');
		    map.put(1000,'M');

		    
		ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();
		list1.add(new ArrayList<Integer>(Arrays.asList(1)));
		list1.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
		list1.get(0).get(0);
		System.out.println(list1.contains(Arrays.asList(1)));
		HashMap<String, List<Integer>> map1 = new HashMap<String,List<Integer>>();
		map1.put("abc", Arrays.asList(2));
		List<Integer> res= new ArrayList<Integer>();
		res= map1.get("abc");
		
		//ArrayList<Integer> res= new ArrayList<Integer>();
		//res.addAll(map.get("abc"), Arrays.asList(3));
		
		list1.remove(Arrays.asList(1));
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(3);
		//System.out.println(list.get(1));
		//list.size();
		
//		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
//		map.put(1, 1);
//		map.put(2, 1);
//		map.put(2, 1);
//		map.put(2, 2);
//		System.out.println(map.size());
		TestingArrayList hj = new TestingArrayList();
		System.out.println(hj.dNums(list, 3));
	}
	
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
	    if(B>A.size())
	        return null;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    
	    int j=0,count=1;
	    for(j=0;j<B;j++){
	        count=1;
	        if(map.containsKey(A.get(j)))
	            count+=map.get(A.get(j));
	        map.put(A.get(j), count);
	    }
	    list.add(map.size());
	    j=0;
	    int del=0;
	    for(int i=B;i<A.size();i++){
	        del = map.get(A.get(j));
	        if(del==1)
	    	map.remove(A.get(j));
	        else
	        	map.put(A.get(j), del-1);
	        count=1;
	        if(map.containsKey(A.get(i)))
	            count+=map.get(A.get(i));
	        map.put(A.get(i), count);
	        list.add(map.size());
	        j++;
	        
	    }
	    return list;
	    }
	    

}
