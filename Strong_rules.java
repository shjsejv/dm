package sixth;
import java.util.*;

public class Strong_rules {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of rules");
		int n=sc.nextInt();
		System.out.println("Enter the support and confidence threshold");
		double minsup=sc.nextDouble();
		double mincon=sc.nextDouble();
		System.out.println("Enter the rules with support and confidence");
		String[] rules=new String[10];
		double []conf=new double[10];
		double [] support=new double[10];
		for(int i=0;i<n;i++){
			rules[i]=sc.next();
			conf[i]=sc.nextDouble();
			support[i]=sc.nextDouble();
		}
		for(int j=0;j<n;j++){
			if(support[j]>=minsup && conf[j]>=mincon){
				System.out.println(rules[j]+" is a strong rule");
			}else System.out.println(rules[j]+" is not a strong rule");
		}

	}

}
