package Os;

import java.util.ArrayList;
import java.util.Scanner;

public class SJF2 {

	public static int processid[];
	public static int Burst[];
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of Processes");
		int n=sc.nextInt();
		
		System.out.println("Enter the  Process id's");
		processid=new int[n];
		for(int i=0;i<n;i++)
		{
			processid[i]=sc.nextInt();
		}
		
	
		
		System.out.println("Enter the  Burst");
		Burst=new int[n];
		for(int i=0;i<n;i++)
		{
			Burst[i]=sc.nextInt();
		}
		
		
		int flag[]=new int[n];
		for(int i=0;i<n;i++)
			flag[i]=0;
		ArrayList<Integer> queue=new ArrayList<Integer>();
		
		for(int k=0;k<n;k++)
		{
			int min=1000;
			int index=-1;
			
		for(int i=0;i<n;i++)
		{
			if(flag[i]!=1)
			if(min>Burst[i])
			{
				
				min=Burst[i];
				index=i;
			}
			
			
		}
		flag[index]=1;
		queue.add(index);
		}
		System.out.println(queue);
	
		int time=0;
		int WT[]=new int[n];
		int TAT[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
		int item=queue.remove(0);
		System.out.println("Process"+processid[item]+" executes successfully");	
		
		WT[item]=time;
		time +=Burst[item];
		if(i>0)
			TAT[i]=TAT[i-1]+Burst[i];
				
		}
		
		TAT[0]=Burst[0];
		for(int i=0;i<n;i++)
		{
			
		System.out.print("Process"+processid[i]+"  ");
		System.out.print(WT[i]+"  ");
		System.out.print(TAT[i]+"  ");
		System.out.println();
		}
	}

}
