/**
 * 
 * @author shubham
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be 
 * expressed as A^P where P > 1 and A > 0. A and P both should be integers.
 * Example
 * 	Input : 4
	Output : True  
	as 2^2 = 4.
 */
public class PowerOf2Integers {
	public static void main (String [] args){
		PowerOf2Integers power = new PowerOf2Integers();
		System.out.println(power.isPower(4));
	}
	    public boolean isPower(int a) {
	        boolean flag= false;
	        int P;
	        if(a==1)
	        return true;
	        for(int A=2;A<a;A++){
	            P=2;
	            while(Math.pow(A,P)<=a){
	                if(Math.pow(A,P)==a)
	                    {
	                        flag=true;
	                        break;
	                    }
	                P++;
	            }
	            
	        }
	        return flag;
	    }
	
}
