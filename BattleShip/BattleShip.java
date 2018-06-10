/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Home
 */import java.util.*;
public class BattleShip {
    public static void main(String[]args)
    {
       Scanner s =new Scanner(System.in);
       Random rand=new Random();
       String[][] map=new String[10][10];
       int x,y;
       initialize(map);     
       System.out.println("**** Welcome to Battle Ships game ****");
       System.out.println("Right now, the sea is empty.\n");
       printMap(map);
       System.out.println();
       System.out.println("Deploy your Ships:");
       int i=1;
       while(true){
            System.out.println("Enter X co-ordinate for you Ship No================================>"+i);
            x=s.nextInt();   
            System.out.println("Enter Y co-ordinate for you Ship No you idiot:"+i);
            y=s.nextInt();
            if(x<10&&y<10){
                if(map[x][y]==" "){
                    map[x][y]="1";
                }else{
                    System.out.println("You have already place a ship at this location.........please choose another location!");
                    continue;
                }
            }else{
                System.out.println("Invalid location!Please enter co-ordinates once more");
                continue;
            }
            if(i==5)
                break;
            else
                i++;
           }
       printMap(map);
       System.out.println();
       System.out.println("Computer is deploying Ships!Get ready!");
       i=1;
       while(true){
           x=Math.abs(rand.nextInt()%10);
           y=Math.abs(rand.nextInt()%10);
            if(" ".equals(map[x][y])||!("1".equals(map[x][y]))){
                    map[x][y]="2";
            }else{
                    continue;}
            if(i==6)
                break;
            else{
                System.out.println("Ship No:"+i+" is deployed!");
                i++;   
            }
           }
       System.out.println();
       System.out.println("****Let the Battle Begin!****");
       int userships=5;
       int computerships=5;
       while(true){
           System.out.println("Your Turn:");
           System.out.println("Enter X Co-ordinate:");
           x=s.nextInt();
           System.out.println("Enter Y Co-ordinate:");
           y=s.nextInt();
           if(x<10&&y<10){
           if(map[x][y].equals("!")||map[x][y].equals("x")||map[x][y].equals("-")){
               continue;
           }else{
               if(map[x][y].equals("2")){
               System.out.println("Boom! You sunk the ship!");
               map[x][y]="!";
               computerships--;
           }else if(map[x][y].equals("1")){
               System.out.println("Oh no, you sunk your own ship :(");
               map[x][y]="x";
               userships--;
           }else if(map[x][y].equals(" ")){
               System.out.println("Sorry, you missed!");
               map[x][y]="-";
           }
               System.out.println("Your Ships:"+userships+"| Computer ships:"+computerships);
               System.out.println("------------------------------------------------------");
           }                      
           }else{
               System.out.println("Invalid location!Please enter coordinates within the ocean....");
               continue;
           }
           System.out.println();
           System.out.println("Computer's Turn");
           x=Math.abs(rand.nextInt()%10);
           y=Math.abs(rand.nextInt()%10);
           if(map[x][y].equals("!")||map[x][y].equals("x")||map[x][y].equals("3")){
               continue;
           }else{
               if(map[x][y].equals("1")){
               System.out.println("The Computer sunk one of your ships!");
               map[x][y]="x";
               userships--;
           }else if(map[x][y].equals("2")){
               System.out.println("LOL!The Computer sunk one of its own ships!");
               map[x][y]="!";
               computerships--;
           }else if(map[x][y].equals(" ")){
               System.out.println("Computer missed!");
               map[x][y]="3";
           }
               printMap(map);
               System.out.println();
               System.out.println("Your Ships:"+userships+"| Computer ships:"+computerships);
               System.out.println("------------------------------------------------------");
           }
           System.out.println();
           if(userships==0){
               System.out.println("Computer Wins! :(");
               break;
           }else if(computerships==0){
               System.out.println("Hurray! You won the Battle!");
               break;
           }
    }
    }
    public static void col(){
        System.out.print("   ");
       for(int i=0;i<10;i++){
           System.out.print(i);
       }
}
    public static void ocean(String[][] map){
        System.out.println();
       for(int i=0;i<map.length;i++){
           System.out.print(i+" |");
           for(int j=0;j<map[0].length;j++){
               if(map[i][j]=="1"){
                   System.out.print("@");
               }else if(map[i][j]=="3"||map[i][j]=="2"){
                   System.out.print(" ");
               }else
                   System.out.print(map[i][j]);
           }
           System.out.println("| "+i);
       }
    }
    public static void initialize(String[][] map){
        for(int i=0;i<map.length;i++){
           for(int j=0;j<map[0].length;j++){
               map[i][j]=" ";
           }
       }
    }
    public static void printMap(String[][] map){
       col();
       ocean(map);
       col();
    }
}
    
    

