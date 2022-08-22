/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package yahtzee;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author tiegancozzie
 */
public class Yahtzee {
    public static int myArray[];
    public final static int SIZE=5;
    public static int rolls=0;
    public static float numYahtzee=0;
    public static float numFull=0;
    public static float lStraight=0;
    public static float fKind=0;
    public static float tKind=0;
    public static float losers=0;
    
    public static void generateHand(int num){
        for (int x=0;x<num;x++){
            rolls++;
            Random rand=new Random();
            myArray=new int[SIZE];
            for(int i=0;i<SIZE;i++){
                myArray[i]=rand.nextInt(1,7);
            }
            Arrays.sort(myArray);
            
            if(checkYahtzee(myArray)==true){
                numYahtzee++;
            }else if(checkFHouse(myArray)==true){
                numFull++;
            }else if(checkLStraight(myArray)==true){
                lStraight++;
            }else if(checkFKind(myArray)==true){
                fKind++;
            }else if(checkTKind(myArray)==true){
                tKind++;
            }else{
                losers++;
            }
            
        }
        
        System.out.println("Number of Rolls: "+num);
        System.out.println("----------------------");
        System.out.println("Number of Yahtzees: "+numYahtzee);
        System.out.println("Yahtzee Percent: "+ ((numYahtzee/num)*100)+"%");
        System.out.println();
        System.out.println("Number of Full Houses: "+numFull);
        System.out.println("Full House Percent: "+((numFull/num)*100)+"%");
        System.out.println();
        System.out.println("Number of Large Straights: "+lStraight);
        System.out.println("Large Straight Percent: "+((lStraight/num)*100)+"%");
        System.out.println();
        System.out.println("Number of Four of a Kind: "+fKind);
        System.out.println("Four of a Kind Percent: "+((fKind/num)*100)+"%");
        System.out.println();
        System.out.println("Number of Three of a Kind: "+tKind);
        System.out.println("Three of a Kind Percent: "+((tKind/num)*100)+"%");
        System.out.println();
        System.out.println("Number of Losers: "+losers);
        System.out.println("Losers Percentage: "+((losers/num)*100)+"%");
        
    }
    
    public static boolean checkYahtzee(int[] array){
        boolean test=false;
        int count=0;
        for(int i=0;i<SIZE;i++){
            if(array[i]==array[0]){
                count++;
            }
        }
        if(count==5){
            test=true;
        }
        return test;
    }
    
    public static boolean checkFHouse(int[] array){
        boolean test=false;
        int count1=0;
        int count2=0;
        for(int i=0;i<SIZE;i++){
            if(array[i]==array[0]){
                count1++;
            }
            if(array[i]==array[4]){
                count2++;
            }
        }
        if((count1==3 && count2==2)||(count1==2 && count2==3)){
            test=true;
        }
        return test;
    }
    
    public static boolean checkLStraight(int[] array){
        boolean test=false;
        int finalCount1=0;
        int finalCount2=0;
        int count1=1;
        int count2=2;
        for(int i=0;i<SIZE;i++){
            if(array[i]==count1){
                finalCount1++;
            }
            count1++;
            if(array[i]==count2){
                finalCount2++;
            }
            count2++;
        }
        if(finalCount1==5 || finalCount2==5){
            test=true;
        }
        return test;
    }
    
    public static boolean checkFKind(int[] array){
        boolean test=false;
        int count1=0;
        int count2=0;
        for(int i=0;i<SIZE;i++){
            if(array[i]==array[0]){
                count1++;
            }
            if(array[i]==array[4]){
                count2++;
            }
        }
        if(count1==4 || count2==4){
            test=true;
        }
        return test;
    }
    
    public static boolean checkTKind(int[] array){
        boolean test=false;
        int count1=0;
        int count2=0;
        int count3=0;
        for(int i=0;i<SIZE;i++){
            if(array[i]==array[0]){
                count1++;
            }
            if(array[i]==array[2]){
                count2++;
            }
            if(array[i]==array[4]){
                count3++;
            }
        }
        if(count1==3 || count2==3 ||count3==3){
            test=true;
        }
        return test;
    }
    
    
    
    public static void main(String[] args) {
        Yahtzee game=new Yahtzee();
        game.generateHand(5000);
    }
    
}
