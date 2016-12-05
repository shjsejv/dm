package fifth;
import java.util.*;

public class frequent_subset {
	public static void main(String[] args){
		String [] rules=new String[20];
		String [] frequent=new String[4];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the items in frequent itemset");
		for (int i=0;i<4;i++){
			frequent[i]=sc.next();
		}
		int n=frequent.length;
		int k=0;
		System.out.println("Frequent SUbset");
		for(int i=0;i<n;i++){
			rules[k]=frequent[i];
			rules[k]+="-->";
			for(int j=0;j<n;j++){
				if(i!=j) rules[k]+=frequent[j]+",";
			}
			System.out.println(rules[k]);
			//k++;
		}
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
			rules[k]=frequent[i]+","+frequent[j];
			rules[k]+="-->";
			for(int l=0;l<n;l++){
				if(l!=i && l!=j){
					rules[k]+=frequent[l]+",";
				}
			}
			System.out.println(rules[k]);
			k++;
		}
			
		}
		
		for(int i=0;i<n;i++){
			rules[k]="";
			for(int j=0;j<n;j++){
				if(i!=j){
					rules[k]+=frequent[j]+",";
				}
			}
			rules[k]+="-->"+frequent[i];
			System.out.println(rules[k]);
			k++;
		}
}

}
