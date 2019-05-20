package Os;

import java.util.Scanner;

public class FIFO_PageReplacement {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of empty frames");
		int e=sc.nextInt();
		
		
		System.out.println("Enter the String");
		String str=sc.next();
		
		//Length of the String
		int l=str.length();
		
		char frame[]=new char[e];
		
		for(int j=0;j<e;j++)
			frame[j]=str.charAt(j);
		
		int pagefault=e;
		int flag=0;
		int count=0;
		for(int s=e;s<l;s++)
		{
		  flag=0;
		for(int i=0;i<e;i++)
		{
			if(str.charAt(s)==frame[i])
			{
				flag=1;
				System.out.println(frame[i]+" No page Fault");
				break;
			}
		}
		//System.out.println("hi");
		if(flag!=1)
		  {
			//System.out.println();
			System.out.println(str.charAt(s)+" Page fault");
			  frame[count]=str.charAt(s);
			  count++;
			  pagefault++;
		  }
		}
		
		for(int i=0;i<e;i++)
		{
			System.out.println(frame[i]);
		}
		
		System.out.println("Page fault:"+pagefault);
	}

}
