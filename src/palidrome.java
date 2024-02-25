
public class palidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 2345;
		 isPalindrome(x);
	//	System.out.println(result);
		
	}
	
	
		public static void isPalindrome(int x) {
	    	
	    	
			 int r,sum=0,temp;    
			  int n=56568;
			  temp=n;    
			  while(n>0){    
			   r=n%10;
			   sum=(sum*10)+r;    
			   n=n/10;    
			  }    
			  if(temp==sum)    
			   System.out.println("palindrome number ");    
			  else    
			   System.out.println("not palindrome");    
			
	    	
		return;
	      
	        
	    }
	

}
