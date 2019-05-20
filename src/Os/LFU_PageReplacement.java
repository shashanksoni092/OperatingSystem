package Os;

import java.util.Scanner;

public class LFU_PageReplacement {

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
		for(int i=e;i<l;i++)
		{
			
				int pos=Check(i,frame,str);
				if(pos==-1)
				{
					System.out.println(str.charAt(i)+" No page fault");
				}
				else {
					
					frame[pos]=str.charAt(i);
					pagefault++;
				}
			
		}
		
		for(int i=0;i<e;i++)
		{
			System.out.println(frame[i]);
		}
		System.out.println("PageFault:"+pagefault);
		
	}

	
private static int Check(int i, char[] frame, String str) {
		
		if(PresentInFrame(i,frame,str))
		{
			return -1;
		}
		
		else {
			int arr[]=new int[frame.length];
			
			for(int b=0;b<arr.length;b++)
				arr[b]=0;
			
			for(int k=0;k<frame.length;k++)
			{
				
				for(int m=i-1;m>=0;m--)
				{
					if(str.charAt(m)==frame[k])
					{
						arr[k]++;
						
					}
				}
			}
			int min=999;
			int index=-1;
			for(int a=0;a<frame.length;a++)
			{
				if(min>arr[a]) {
					index=a;
					min=arr[a];
				}
			}
			return index;
		}
		
	}

private static boolean PresentInFrame(int i, char[] frame, String str) {
	
		
		for(int j=0;j<frame.length;j++)
		{
			if(str.charAt(i)==frame[j])
				return true;
		}
		
		return false;
	}
}
