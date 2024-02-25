
public class palidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 2345;
		 isPalindrome(x);
	//	System.out.println(result);
		
	}
	
	
		public static void isPalindrome(int x) {
	    	
	    	
	    	int value = x;
	    	int[] a = {};
	    	int j=0;
	    	int i=value;;
	    	boolean b = false;
	    	while(i>10)
	    	{
	    		int remainder = i%10;
	    		value=value/10;
	    		
	    		a[j]=remainder;
	    		j++;
	    		
	    		
	    		i=value;
	    	}
	    	int l= a.length;
	    	int m=l;
	    	
	    	for(int arr=0;arr<l;arr++)
	    	{
	    		
	    			if(a[arr]==a[m-1])
	    			{
	    				
	    				
	    				if(arr==m)
	    				{
	    					System.out.println("Palindrome");
	    					b= true;
	    					
	    				break;
	    					
	    				}
	    				m=m-1;
	    				continue;
	    			}
	    			else {
	    				
	    				System.out.println("not a palindrome");
	    				b=false;
	    				
	    				break;
	    			}
	    		
	    	}
	    
	    	
		return;
	      
	        
	    }
	

}
