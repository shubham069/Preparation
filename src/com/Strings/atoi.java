package com.Strings;

public class atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		atoi ob = new atoi();
		System.out.println(ob.ATOI("-6435D56183011M11   648G1"));
	}

	public int ATOI(String a)
	{
		a=a.trim();
	char ch[] = a.toCharArray();
	
    boolean negative=false;
    int i=0,j=0;
    if(ch[0]=='-'){
    		negative = true;
    		i=1;
    		j=1;
    }
    else if(ch[0]=='+'){
		i=1;
		j=1;
    }
    int num=0;
    for(; i<ch.length;i++){

       if(ch[i]==' ' || ch[i]<'0' || ch[i]>'9')
            break;
       
    }
    String b = a.substring(j,i);
    int size = b.length();
    int k=0;
    double number =0;
    while(size!=0){
        number = (number*10)+(b.charAt(k++)-'0');
        size--;
    }
    if(negative)
        number= -number;
   if(number>Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
   if(number<Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
        
   return (int)number;
}
}
