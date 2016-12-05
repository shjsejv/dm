package ninth;
import java.io.*;
import java.util.*;


public class kclustering {

	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new FileReader("/home/pushpa/Documents/7thsem/data mining/ninth.csv"));
		ArrayList<String[]> data=new ArrayList<String[]>();
		String s=null;
		while((s=in.readLine())!=null){
			String str[]=s.split(",");
			data.add(str);
		}
		double cent00=0,cent01=0,cent10=0,cent11=0,cent20=0,cent21=0;
		double centroid[][]=new double[3][2];
		int k=0;
		for(String [] str:data){
			if(k==0){
				centroid[0][0]=Double.parseDouble(str[0]);
				centroid[0][1]=Double.parseDouble(str[1]);
			}
			else if(k==3){
				centroid[1][0]=Double.parseDouble(str[0]);
				centroid[1][1]=Double.parseDouble(str[1]);
			}
			else if(k==6){
				centroid[2][0]=Double.parseDouble(str[0]);
				centroid[2][1]=Double.parseDouble(str[1]);
			}
			k++;
		}
		int n=data.size();
		double dist[][]=new double[10][4];
		while(cent00!=centroid[0][0]||cent01!=centroid[0][1]||cent10!=centroid[1][0]||cent11!=centroid[1][1]||cent20!=centroid[2][0]||centroid[2][1]!=cent21){
			
				for(int i=0;i<n;i++){
					for(int j=0;j<3;j++){
						dist[i][j]=Math.sqrt((Math.pow(Double.parseDouble(data.get(i)[0])-centroid[j][0], 2))+(Math.pow(Double.parseDouble(data.get(i)[1])-centroid[j][1],2)));
						
						
					}
				}
				double small=0;
				double index=0;
				for(int i=0;i<n;i++){
					small=dist[i][0];
					for(int j=0;j<3;j++){
						if(dist[i][j]<small){
							small=dist[i][j];
							index=j;
						}
						dist[i][3]=index;
					}
				}
				System.out.println("Distance matrix");
				for(int i=0;i<n;i++){
					for(int j=0;j<4;j++){
						System.out.print(dist[i][j]+" ");
					}
					System.out.println();
				}
				cent00=centroid[0][0];
				cent01=centroid[0][1];
				cent10=centroid[1][0];
				cent11=centroid[1][1];
				cent20=centroid[2][0];
				cent21=centroid[2][1];
				
				for(int i=0;i<3;i++){
					centroid[i][0]=0;
					centroid[i][1]=0;
				}
				
				int count0=0,count1=0,count2=0;
				
				for(int i=0;i<n;i++){
					if(dist[i][3]==0){
						count0++;
						centroid[0][0]+=Double.parseDouble(data.get(i)[0]);
						centroid[0][1]+=Double.parseDouble(data.get(i)[1]);
					}
					else if(dist[i][3]==1){
						count1++;
						centroid[1][0]+=Double.parseDouble(data.get(i)[0]);
						centroid[1][1]+=Double.parseDouble(data.get(i)[1]);
					}
					else if(dist[i][3]==2){
						count2++;
						centroid[2][0]+=Double.parseDouble(data.get(i)[0]);
						centroid[2][1]+=Double.parseDouble(data.get(i)[1]);
					}
				}
				System.out.println("The counts are "+count0+" "+count1+" "+count2);
				centroid[0][0]/=count0;
				centroid[0][1]/=count0;
				centroid[1][0]/=count1;
				centroid[1][1]/=count1;
				centroid[2][0]/=count2;
				centroid[2][1]/=count2;
				
				System.out.println("Updated centroid are ");
				System.out.println(centroid[0][0]+" "+centroid[0][1]);
				System.out.println(centroid[1][0]+" "+centroid[1][1]);
				System.out.println(centroid[2][0]+" "+centroid[2][1]);
			
		}
		
		
	}

}
