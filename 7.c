package prabhu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
class Recordt_Csv{
    int attr1;
    int attr2;
    int attr3;
    int attr4;
    int attr5;
    int attr6;
    int attr7;
    int Class;
    Recordt_Csv(){ }
};
public class Ginigain
    {
        static Recordt_Csv[] rc = new Recordt_Csv[10];
        public static void main(String args[])throws FileNotFoundException, IOException
    {
             BufferedReader CSV =
            new BufferedReader(new FileReader("C:/Users/NIVEDITHA D M/Desktop/gaingini.csv"));
      String data = CSV.readLine();
      data = CSV.readLine();
      int i=0;
     // int giniintermediate=0;
      //  int giniintermediate2=0,giniintermediate3=0,giniintermediate4=0,giniintermediate5=0,giniintermediate6=0,giniintermediate7=0;
      while((data != null))
      {
          rc[i]= new Recordt_Csv();
          String[] dataArray = data.split(",");
          rc[i].attr1=Integer.parseInt(dataArray[0]);
            rc[i].attr2=Integer.parseInt(dataArray[1]);
            rc[i].attr3=Integer.parseInt(dataArray[2]);
            rc[i].attr4=Integer.parseInt(dataArray[3]);
            rc[i].attr5=Integer.parseInt(dataArray[4]);
            rc[i].attr6=Integer.parseInt(dataArray[5]);
            rc[i].attr7=Integer.parseInt(dataArray[6]);
            rc[i].Class=Integer.parseInt(dataArray[7]);
            System.out.println(" "+rc[i].attr1+" "+rc[i].attr2+" "+" "+rc[i].attr3+" "+rc[i].attr4+" "+rc[i].attr5+" "+rc[i].attr6+" "+rc[i].attr7+" "+rc[i].Class);
            data=CSV.readLine();
            i++;;
    }
      double total1=0;
      double total2=0;
      double total3=0;
      double total4=0;
      double total5=0;
      double total6=0;
      double total7=0;
      double g1=0;
      double g2=0;
      double g3=0;
      double g4=0;
      double g5=0;
      double g6=0;
      double g7=0;
      double class1[]=new double[2];
      int k = 0;
   //   double class2;
      for(int j=0;j<i;j++)
     {
          class1[k]=rc[j].attr1+rc[j].attr2+ rc[j].attr3+rc[j].attr4+rc[j].attr5+rc[j].attr6+rc[j].attr7;
          //class1+=rc[j].attr1+rc[j].attr2+rc[j].attr3+rc[j].attr4+rc[j].attr5+rc[j].attr6+rc[j].attr7+;
      total1+=rc[j].attr1;
      total2+=rc[j].attr2;
      total3+=rc[j].attr3;
      total4+=rc[j].attr4;
      total5+=rc[j].attr5;
      total6+=rc[j].attr6;
      total7+=rc[j].attr7;
      k++;
      }
double parent_gini=1-(Math.pow(class1[0]/(class1[0]+class1[1]),2 ))-Math.pow(class1[1]/(class1[0]+class1[1]),2 );
      for(int j=0;j<i;j++)
      {
      g1+=Math.pow((rc[j].attr1)/total1,2);
      g2+=Math.pow((rc[j].attr2)/total2,2);
      g3+=Math.pow((rc[j].attr3)/total3,2);
      g4+=Math.pow((rc[j].attr4)/total4,2);
      g5+=Math.pow((rc[j].attr5)/total5,2);
      g6+=Math.pow((rc[j].attr6)/total6,2);
      g7+=Math.pow((rc[j].attr7)/total7,2);
      }
      double gini1=1-g1;
      double gini2=1-g2;
      double gini3=1-g3;
      double gini4=1-g4;
      double gini5=1-g5;
      double gini6=1-g6;
      double gini7=1-g7;
      double wtgini1=((total1)/(total1+total2))*gini1+((total2)/(total1+total2))*gini2;
      double wtgini2=((total3)/(total3+total4))*gini3+((total4)/(total3+total4))*gini4;
      double wtgini3=((total5)/(total5+total6+total7))*gini5+((total6)/(total5+total6+total7))*gini6+((total7)/(total5+total6+total7))*gini7;
      System.out.println("Parent gini:"+parent_gini);  
     System.out.println("Weighted gini index of numerical attributes:"+wtgini1+"and gain"+(parent_gini-wtgini1));
      System.out.println("Weighted gini index of binomial attributes:"+wtgini2+"and gain"+(parent_gini-wtgini2));
      System.out.println("Weighted gini index of multi way split:"+wtgini3+"and gain"+(parent_gini-wtgini3));
      System.out.println("Best attribute to split:");
      if(wtgini1<wtgini2 && wtgini1<wtgini3){
         System.out.println("Numerical attribute");
      }else if(wtgini2<wtgini3 && wtgini2<wtgini1){
          System.out.println("Binomial attribute");
      }else{
          System.out.println("Multiway split attribute");
      }
}
    }
