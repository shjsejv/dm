package prabhu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
class Records_Csv{
    double attr1;
    double attr2;
    Records_Csv(){ }
};
public class K_Means {
     static Records_Csv[] rc = new Records_Csv[10];
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
       
        BufferedReader CSV =
            new BufferedReader(new FileReader("C:/Users/NIVEDITHA D M/Desktop/ni2.csv"));
      String data = CSV.readLine();
      data = CSV.readLine();
      int i=0;
      while((data != null))
      {
          rc[i]= new Records_Csv();
          String[] dataArray = data.split(",");
          rc[i].attr1=Double.parseDouble(dataArray[0]);
          rc[i].attr2=Double.parseDouble(dataArray[1]);
           System.out.println("   "+rc[i].attr1+"   "+rc[i].attr2);
          data = CSV.readLine();
          i++;
            }
    
      Records_Csv[] cent = new Records_Csv[3];
      for(int j=0;j<3;j++)
      cent[j] = new Records_Csv();
  
       cent[0].attr1=rc[0].attr1;
       cent[0].attr2 = rc[0].attr2;
       cent[1].attr1=rc[3].attr1;
       cent[1].attr2 = rc[3].attr2;
       cent[2].attr1=rc[6].attr1;
       cent[2].attr2 = rc[6].attr2;
      double[][] dist_mat = new double[i][4];
   
      double C01 = 0,C02=0,C11=0,C12=0,C21=0,C22=0;
      while((C01!=cent[0].attr1) || (C02 != cent[0].attr2) || (C11!= cent[1].attr1) || (C12!=cent[1].attr2) || 
(C21 != cent[2].attr1) || (C22 != cent[2].attr2)){
      for(int j=0;j<i;j++)
          for(int k=0;k<3;k++)
              dist_mat[j][k]=Math.sqrt(Math.pow(rc[j].attr1-cent[k].attr1, 2)+Math.pow(rc[j].attr1-
cent[k].attr1, 2));

      double small=0;
      double index=0;
      for(int j=0;j<i;j++)
      {small=dist_mat[j][0];
          for(int k=1;k<3;k++)
            if(dist_mat[j][k]<small)
            { small=dist_mat[j][k];
              index =k;
            }
          dist_mat[j][3]=index;
      }
      for(int j=0;j<i;j++)
      {for(int k=0;k<4;k++)
              System.out.print(dist_mat[j][k]+"  ");
       System.out.println();
      }
         C01 = cent[0].attr1;
         C02 = cent[0].attr2;
         C11 = cent[1].attr1;
         C12 = cent[1].attr2;
         C21 = cent[2].attr1;
         C22 = cent[2].attr2;
   
      int count1=0,count2=0,count3=0;
      cent[0].attr1=0;
      cent[0].attr2 = 0;
      cent[1].attr1=0;
      cent[1].attr2 = 0;
      cent[2].attr1=0;
      cent[2].attr2 = 0;
      for(int j=0;j<i;j++)
      {
          if(dist_mat[j][3]==0)
          {cent[0].attr1+=rc[j].attr1;
          cent[0].attr2+=rc[j].attr2;
          count1++;
          }
          if(dist_mat[j][3]==1)
          {cent[1].attr1+=rc[j].attr1;
          cent[1].attr2+=rc[j].attr2;
          count2++;
          }
          if(dist_mat[j][3]==2)
          {cent[2].attr1+=rc[j].attr1;
          cent[2].attr2+=rc[j].attr2;
          count3++;
          }
      }
      System.out.println("Counts are "+count1+"  "+count2+"  "+count3);
         cent[0].attr1=cent[0].attr1/count1;
         cent[0].attr2=cent[0].attr2/count1;
         cent[1].attr1=cent[1].attr1/count2;
         cent[1].attr2=cent[1].attr2/count2;
         cent[2].attr1=cent[2].attr1/count3;
         cent[2].attr2=cent[2].attr2/count3;
         System.out.println("Updated Centroids are");
         for(int k=0;k<3;k++)
         {
             System.out.println(cent[k].attr1+" and "+cent[k].attr2);
         }
        
        }
}
}
