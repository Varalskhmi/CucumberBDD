package stepDefinitions;

public class va {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="Peddaram varalakshmi";
		
		
		/*String rev="";
		for(int i=s1.length()-1;i>=0;i--)
		{
			rev=rev+s1.charAt(i);
		}
		System.out.println(rev); */
		
		
		
		//Using StringBuffer
		
		StringBuffer sb=new StringBuffer(s1);
		System.out.println(sb.reverse());
	}

}
