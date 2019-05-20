//@ Author:Shashank soni

package Os;

import java.util.*;
public class SJF {
	
	
    public static void main(String[] args) {
        LinkedHashMap<String, Double> map = new LinkedHashMap<String, Double>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);

        map.put("Process1", 7.0);
        map.put("Process2",17.0 );
        map.put("Process3", 20.0);
        map.put("Process4", 1.0);

        System.out.println("unsorted map: " + map);
        sorted_map.putAll(map);
        System.out.println("results: " + sorted_map);
        
        
        Double total[]=new Double[map.size()+1];
        total[0]=0.0;
        Double burst[]=new Double[map.size()+1];
        burst[0]=1.0;
        System.out.println(map.size());
        int n=map.size();
        
     
        for(int i=0;i<sorted_map.size();i++)
        {
           System.out.println(new Vector(sorted_map.keySet()).get(i));
           System.out.println(new Vector(sorted_map.values()).get(i));
           burst[i+1]=(Double) new Vector(sorted_map.values()).get(i);
        }
        System.out.println();
        for(int i=1;i<=n;i++)
        {
        	total[i]= (total[i-1]+burst[i]);
        	
        	System.out.println(total[i]);
        }
        Double sum=0.0;
        for(Double d:total)
        {
        	sum+=d;
        }
        System.out.println(sum/sorted_map.size());
    }
    
}

class ValueComparator implements Comparator<String> {
    Map<String, Double> base;

    public ValueComparator(Map<String, Double> base) {
        this.base = base;
    }
    
    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(String a, String b) {
        if (base.get(a) <= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}