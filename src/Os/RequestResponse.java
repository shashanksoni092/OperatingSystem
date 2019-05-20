//@ Author:Shashank soni

package Os;

import java.util.Scanner;

public class RequestResponse {

	public static int Allocation[][];
	public static int Max[][];
	public static int Need[][];
	public static int Available_A;
	public static int Available_B;
	public static int Available_C;
	public static int Request_A;
	public static int Request_B;
	public static int Request_C;
	
	
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
		
		System.out.println("Enter the process requesting the resource");
		int process_request=sc.nextInt();
		
		System.out.println("Enter the available value for A");
		Request_A=sc.nextInt();
		
		System.out.println("Enter the available value for B");
		Request_B=sc.nextInt();
		
		System.out.println("Enter the available value for C");
		Request_C=sc.nextInt();
		
		//Check Request for process[i] which requested for resource
		
		if((Request_A<=Need[process_request][0]) && (Request_B<=Need[process_request][1]) && (Request_C<=Need[process_request][2]))
		{
			if((Request_A<=Available_A) && (Request_B<=Available_B) && (Request_C<=Available_C))
			{
				//Decrement the Available value
				Available_A -=Request_A;
				Available_B -=Request_B;
				Available_C -=Request_C;
				
				//increment the Allocation value 
				Allocation[process_request][0] +=Request_A;
				Allocation[process_request][1] +=Request_B;
				Allocation[process_request][2] +=Request_C;
				
				//Decrement the Request value
				Need[process_request][0]-=Request_A;
				Need[process_request][1]-=Request_B;
				Need[process_request][2]-=Request_C;
				
			}
				
		}
		
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
