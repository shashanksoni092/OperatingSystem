//@ Author:Shashank soni

package Os;

import java.util.ArrayList;
import java.util.Scanner;

public class RoundRobin {

	public static int processid[];
	public static int ArrivalTime[];
	public static int Burst[];
	public static int Quantum;
	public static ArrayList queue;
	public static int CT[];
	public static int TAT[];
	public static int WT[];
	public static int BT[];
	
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
	
	System.out.println("Enter the  Arrival Time");
	ArrivalTime=new int[n];
	for(int i=0;i<n;i++)
	{
		ArrivalTime[i]=sc.nextInt();
	}
	
	System.out.println("Enter the  Burst");
	Burst=new int[n];
	for(int i=0;i<n;i++)
	{
		Burst[i]=sc.nextInt();
	}
	
	
	System.out.println("Enter the  Quantum");
	Quantum=sc.nextInt();
	
	CT=new int[n];
	WT=new int[n];
	TAT=new int[n];
	BT=new int[n];
	for(int i=0;i<n;i++)
		BT[i]=Burst[i];
	
	System.out.println("Printing:-");
	
	for(int i=0;i<n;i++)
	{
		System.out.print(processid[i]+"  ");
		System.out.print(ArrivalTime[i]+"  ");
		System.out.print(Burst[i]+"  ");
		System.out.println();
	}
	int total=0;
	for(int i=0;i<n;i++)
	{
		total +=Burst[i];
	}
	queue=new ArrayList<>();
	int time=0;
	int elem=-1;
	while(total!=0)
	{
		for(int i=0;i<n;i++)
		{
			if(i==(elem-1))
				continue;
			if(queue.contains(i+1))
				continue;	
			if(Burst[i]>0)
			{
			if(ArrivalTime[i]<=time)
			{
				queue.add(processid[i]);
			}
			}
		}
		
		
		if(elem>(0))
		{
		if(Burst[elem-1]>0)
		{
			if(ArrivalTime[elem-1]<=time)
			{
				queue.add(processid[elem-1]);
			}
			
		}
		}
			System.out.println(queue);
		
			elem=(int) queue.remove(0);
			System.out.println("Process "+elem+" executed with arrival time is "+time );
			System.out.println(queue);
				
			if(Burst[elem-1]>=Quantum)
			{
			Burst[elem-1] -=Quantum;
			time +=Quantum;
			total -=Quantum;
			}
			else{
				time +=Burst[elem-1];
				total -=Burst[elem-1];
				Burst[elem-1]=0;
				
			}
			CT[elem-1]=time;
			
			
		
	}
	System.out.println("Table :-");
	for(int i=0;i<n;i++)
	{
	TAT[i]=CT[i]-ArrivalTime[i];
	WT[i]=TAT[i]-BT[i];
	
	}
	for(int i=0;i<n;i++)
	{
		System.out.print(processid[i]+"   ");
		System.out.print(ArrivalTime[i]+"   ");
		System.out.print(BT[i]+"    ");
		System.out.print(CT[i]+"   ");
		System.out.print(TAT[i]+"   ");
		System.out.print(WT[i]+"   ");
		System.out.println();
	}
	float TAT_Sum=0;
	float WT_Sum=0;
	
	for(int i=0;i<n;i++)
	{
		TAT_Sum +=TAT[i];
		WT_Sum +=WT[i];
	}
	System.out.println("Average TAT:"+TAT_Sum/n);
	System.out.println("Average WT:"+WT_Sum/n);
	
	}

}
