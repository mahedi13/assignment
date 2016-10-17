import java.io.PrintWriter; 
import java.util.Scanner;
import java.io.File;
import java.io.*;

//* @author (Mahedi Hasan) 
//* @version (16/10/2016)

public class Student {
    Scanner input = new Scanner(System.in);
    
    int id;
    String name;
    String Dept ;
    String Versity ;
    double[] GPA = new double[8];
    double[][] CreAndGra = new double[10][2];//Credit & Grade
    //String sub1,sub2,sub3,sub4,sub5,sub6;
    double CGPA;
 
    
    public Student(int Id,String Name,String dept,String versity)
    {
        id = Id;
        name = Name;
        Dept = dept;
        Versity = versity ;
    }
    
    
    // Method to set Credit and Corresponding Grades
    public void set()
    {
        
            for(int j=0;j<3;j++)
            {
              
                System.out.print("Enter Credit : ");
                CreAndGra[j][0]=input.nextDouble();
                System.out.print("Enter Grade : ");
                CreAndGra[j][1]=input.nextDouble();
            }
                
    }
    
    
    
    // Define a method to compute the GPA from the given Credits and Grades of all the subjects
     public double computeGPAById()
    {
        //write yor code here
        double gpa =0;
        double total = 0;
        
            for(int j=0;j<3;j++)
            {
                gpa+=CreAndGra[j][0]*CreAndGra[j][1];
                total += CreAndGra[j][0];
            }
        gpa = gpa / total;
        return gpa;
    }
    
    // CGPA
    public double computeCGPAByID(int x)
    {
        // Write your code here
        double cgpa = 0;
        //int count = 0;
        for(int i=0;i<x;i++)
        {   
            cgpa+=GPA[i];
        }
        cgpa=cgpa*1.0/x*1.0;
        CGPA = cgpa;
        return cgpa;
    }
    
    
    //Define a method to print the students details.
    public void studentDetailsById()
    {
        //write your code here
        System.out.println("Name  : "+name);
        System.out.println("ID  : " + id);
        System.out.println("Dept  : " + Dept);
        System.out.println("Versity  : " + Versity);
        System.out.println("1st sem GPA  : " + GPA[0]);     
        System.out.println("2nd sem GPA  : " + GPA[1]);     
        System.out.println("Current CGPA  : " + CGPA);  
    }
    
    
    //method to update information of students
    public void updateStudentById()
    {
        //Write your code here
         set();
          
         GPA[2]= computeGPAById();
         computeCGPAByID(3);
         System.out.println("3rd sem GPA  : " + GPA[2]); 
         System.out.println("Current CGPA  : " + CGPA); 
         
    }
    
    
    public void saveStudent() 
    {
        try{
            File outputFile = new File("result.txt");
            PrintWriter writer = new PrintWriter(outputFile);
            
            writer.println("Name  : "+name);
            writer.println("ID  : " + id);
            writer.println("Dept  : " + Dept);
            writer.println("Versity  : " + Versity);
            writer.println("Current CGPA  : " + CGPA);  
            
            writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }
   
   
    public static void main(String[] args)
    {   
        Student[] students = new Student[10];
        students[0] = new Student(1407005,"Mahedi","CSE","KUET");
         System.out.println("input credit and grade of 3 sub of 1st semister");
        students[0].set();
        students[0].GPA[0]= students[0].computeGPAById();
        double b;
         System.out.println("input credit and grade of 3 sub of 2nd semister");
        students[0].set();
        students[0].GPA[1]= students[0].computeGPAById();
        //System.out.println(a);
         students[0].computeCGPAByID(2);
        students[0].studentDetailsById();
        students[0].saveStudent();
        Scanner in = new Scanner(System.in);
        System.out.println("update ? yes=1 no=0");
        b=in.nextDouble();
        if(b==1.0){
            students[0].updateStudentById();
         
         
    }
    }
}