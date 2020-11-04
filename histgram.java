package histogram;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Histogram {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Double> mainArray = new ArrayList<Double>();
        double markedStudent;
        boolean isRunning = true;
        int catOne = 0; //0-29 
        int catTwo = 0; //30-39 1
        int catThree = 0; //40-69 
        int catFour = 0; //70-100
        
        String catOneStars="";
        String catTwoStars="";
        String catThreeStars="";
        String catFourStars="";
        int col1Count=1,col2Count=1,col3Count=1,col4Count=1;
        int row, col;
        int highestCat = 0;
        
        int totalStudents = 0;
        int passedStudents = 0;
        double averageMarks = 0;
        double averagetmp = 0;
        double highestMark = 0;
        double lowestMark = 0;
        
        //INPUT
        System.out.println(" - HISTOGRAM - ");
        System.out.println("Enter in the marking for EACH student");
        System.out.println("Any input that's not within the marking range will end the program!...");
        System.out.println("Marking Range: 0 - 100");
        
            
                
        while(isRunning){    
            try{
                System.out.println("Enter in the marking for EACH student");
                markedStudent = sc.nextDouble();
            } catch(InputMismatchException ex){
                System.out.println("[-] Only whole NUMBERS with no special character or letters!");
                return;
            }
            if (markedStudent < 0){ System.out.println("[-] Only NUMBERS from 0 to 100!"); return;  
            }
            if(markedStudent<=100){
                mainArray.add(markedStudent);
                if(markedStudent>=0 && markedStudent<=29){
                    catOne++;
                    totalStudents++;
                }
                if(markedStudent>=30 && markedStudent<=39){
                    catTwo++;
                    totalStudents++;
                }
                if(markedStudent>=40 && markedStudent<=69){
                    catThree++;
                    totalStudents++;
                }
                if(markedStudent>=70 && markedStudent<=100){
                    catFour++;
                    totalStudents++;
                }
                //Passed Students
                if(markedStudent>=40){
                    passedStudents++;
                }
            }else{ 
                //Average Mark
                for(Double i : mainArray){
                    averagetmp+=i;
                }
                averageMarks = averagetmp/totalStudents;
                
                //Highest and Lowest number
                highestMark = mainArray.get(0);
                lowestMark = mainArray.get(0);
                for(int i=1; i < mainArray.size(); i++){
                    if(mainArray.get(i) > highestMark){
                       highestMark = mainArray.get(i);
                    }else if(mainArray.get(i) < lowestMark){
                        lowestMark = mainArray.get(i);
                    }
                }
                
                //Highest Cat
                highestCat = catOne;   
                for(int i=1; i < 4; i++){
                    if(catOne > highestCat){
                       highestCat = catOne;
                    }else if(catTwo > highestCat){
                       highestCat = catTwo;
                    }else if(catThree > highestCat){
                       highestCat = catThree;
                    }else if(catFour > highestCat){
                       highestCat = catFour;
                    }
                }
                isRunning = false;
                break;
            }
        }
        //DISPLAY
        System.out.println("\nHow would you like your HISTOGRAM displayed?");
        System.out.println("Horizontal - 0 / Vertical - 1:");
        int displayOpt = sc.nextInt();
        if(displayOpt == 0){
            //Horizontal graph
            System.out.println("--- Horizontal Histogram ---\n");
                        
            for(int h1=1; h1 <= catOne ; h1++){ catOneStars+=" *"; }
            for(int h2=1; h2 <= catTwo ; h2++){ catTwoStars+=" *"; }
            for(int h3=1; h3 <= catThree ; h3++){ catThreeStars+=" *"; }
            for(int h4=1; h4 <= catOne ; h4++){ catFourStars+=" *"; }
            
            System.out.println("0-29: "+catOneStars);
            System.out.println("30-39: "+catTwoStars);
            System.out.println("40-69: "+catThreeStars);
            System.out.println("70-100: "+catFourStars);
        }else if(displayOpt == 1){
            //Vertical graph
            System.out.println("--- Vertical Histogram ---\n");
            
            System.out.println("|0-29|30-39|40-69|70-100|\n");
            for(row = 1; row <= highestCat; row++){
                for(col = 1; col <= 1; col++){
                   if(col1Count<=catOne){ System.out.print("   *  "); }else{ System.out.print("      "); }
                }
                for(col = 1; col <= 1; col++){
                   if(col2Count<=catTwo){ System.out.print("   *  "); }else{ System.out.print("      "); }
                }
                for(col = 1; col <= 1; col++){
                   if(col3Count<=catThree){ System.out.print("   *  "); }else{ System.out.print("      "); }
                }
                for(col = 1; col <= 1; col++){
                   if(col4Count<=catFour){ System.out.print("   *  "); }else{ System.out.print("      "); }
                }
                System.out.print("\n");
                col1Count+=1;
                col2Count+=1;
                col3Count+=1;
                col4Count+=1;
            }
        }
        
        System.out.println("\nTotal students overall: "+totalStudents);
        System.out.println("The overall average is: "+averageMarks);
        System.out.println("Students that PASSED the 40 mark: "+passedStudents);
        System.out.println("Lowest Mark: "+lowestMark+"/ Highest Mark: "+highestMark);
    }
}
