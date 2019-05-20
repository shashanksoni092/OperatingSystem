//@ Author:Shashank soni

package Os;

import java.util.Scanner;

public class BankersAlgo {

	public static int Allocation[][];
	public static int Max[][];
	public static int Need[][];
	public static int Available_A;
	public static int Available_B;
	public static int Available_C;
	
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of process");
		int n=sc.nextInt();
		
		System.out.println("Enter the number of Resources");
		int m=sc.nextInt();
		
		
		//Allocation
		Allocation=new int[n][m];
		System.out.println("Enter the Allocation data");
		for(int i=0;i<n;i++)
		{
			
			for(int j=0;j<m;j++)
			{
				Allocation[i][j]=sc.nextInt();
			}
		}
		
		//Max
		Max=new int[n][m];
		System.out.println("Enter the Max data");
		for(int i=0;i<n;i++)
		{
			
			for(int j=0;j<m;j++)
			{
				Max[i][j]=sc.nextInt();
			}
		}
		
		//Need
		Need=new int[n][m];
		//System.out.println("Enter the Need data");
		for(int i=0;i<n;i++)
		{
			
			for(int j=0;j<m;j++)
			{
				Need[i][j]=Max[i][j]-Allocation[i][j];
			}
		}
		
		System.out.println("Allocation is:-");
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(Allocation[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Max is:-");
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(Max[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Need is");
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(Need[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("Enter the available value for A");
		Available_A=sc.nextInt();
		
		System.out.println("Enter the available value for B");
		Available_B=sc.nextInt();
		
		System.out.println("Enter the available value for C");
		Available_C=sc.nextInt();
		
		
		//Track
		int flag[]=new int[n];
		for(int k=0;k<3;k++)
		{
		for(int i=0;i<n;i++)
		{
			if((flag[i]!=1 && Need[i][0]<=Available_A) && (Need[i][1]<=Available_B) && (Need[i][2]<=Available_C))
			{
				flag[i]=1;
				System.out.println("Process P["+i+"] execution is successful");
				Available_A +=Allocation[i][0];
				Available_B +=Allocation[i][1];
				Available_C +=Allocation[i][2];
				
			}
			else 
				continue;
			
		}
		}
		
		System.out.println("The New Available Resource is:-");
		System.out.println("AvailableA:"+Available_A);
		System.out.println("AvailableB:"+Available_B);
		System.out.println("AvailableC:"+Available_C);
		
	}

	
}
