package eighth;
import java.io.*;
import java.util.*;

public class Bayseian_classifier {

	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new FileReader("/home/pushpa/Documents/7thsem/data mining/eighth.csv"));
		ArrayList<String[]> data0=new ArrayList<String[]>();
		ArrayList<String[]> data1=new ArrayList<String[]>();
		String s=null;
		while((s=in.readLine())!=null){
			String[] str=s.split(",");
			if(str[2].equals("0")) data0.add(str);
			else data1.add(str);
		}
		float mean0=0,mean1=0,total0 = 0,total1=0,n1,n0  ;
		double var1;
		double var0;
		float s0=0,l0=0,m0=0,s1=0,m1=0,l1=0;
		n0=data0.size();
		n1=data1.size();
		float sum0=0,sum1=0;
		for(String[] str:data0){
			total0+=Integer.parseInt(str[0]);
			if(str[1].equals("S")) s0++;
			else if(str[1].equals("L")) l0++;
			else if (str[1].equals("M")) m0++;
		}
		for(String[] str:data1){
			total1+=Integer.parseInt(str[0]);
			if(str[1].equals("S")) s1++;
			else if(str[1].equals("L")) l1++;
			else if (str[1].equals("M")) m1++;
		}
		System.out.println(s1+" "+m1+" "+l1+" "+n1);
		
		mean0=total0/n0;
		mean1=total1/n1;
		
		for(String []str :data0){
			sum0+=Math.pow(Integer.parseInt(str[0])-mean0, 2);
		}
		for(String []str :data1){
			sum1+=Math.pow(Integer.parseInt(str[0])-mean1, 2);
		}
		//var0=Math.sqrt(sum0/(n0-1));
		//var1=Math.sqrt(sum1/(n1-1));
		var0=sum0/(n0-1);
		var1=sum1/(n1-1);
		System.out.println("Mean for class 0 and class 1 "+mean0+" "+mean1);
		System.out.println("Variance for class 0 and class 1 "+var0+" "+var1);
		System.out.println("Probability of S and class 0"+s0/n0);
		System.out.println("Probability of S and class 1 "+s1/n1);
		System.out.println("Probability of M and class 0 "+m0/n0);
		System.out.println("Probability of M and class 1 "+m1/n1);
		System.out.println("Probability of L and class 0 "+l0/n0);
		System.out.println("Probability of L and class 1 "+l1/n1);
		System.out.println("Enter the new value for attr1 and attr2");
		Scanner sc=new Scanner(System.in);
		float attr1=sc.nextFloat();
		String attr2=sc.next();
		double prob0;
		double prob1;
		if(attr2.equals("S")) {prob0=s0/n0;prob1=s1/n1;}
		else if(attr2.equals("M")){prob0=m0/n0;prob1=m1/n1;}
		else {prob0=l0/n0;prob1=l1/n1;}
		
		double gauss0=(Math.exp((-1*Math.pow(attr1-mean0, 2))/(2*var0)))/(Math.sqrt(2*3.14*var0));
		double gauss1=(Math.exp(-1*Math.pow(attr1-mean1, 2)/(2*var1)))/(Math.sqrt(2*3.14*var1));
		prob0=prob0*gauss0;
		prob1=prob1*gauss1;
		System.out.println("Class 0 prbability "+prob0);
		System.out.println("Class 1 probability "+prob1 );
		if(prob0>prob1) System.out.println("The point belongs to class 0");
		else System.out.println("The point belongs to class 1");
		
	}
	
	

}
