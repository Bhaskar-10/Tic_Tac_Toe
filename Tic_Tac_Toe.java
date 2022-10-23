
import static java.awt.PageAttributes.MediaType.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author _Bhaskar_
 */
public class Tic_Tac_Toe {
    static ArrayList<Integer> playerposition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuposition = new ArrayList<Integer>();
    public static void main(String args[]){
        char[][] gameboard = {{' ','|',' ','|',' '},
                              {'-','+','-','+','-'},
                              {' ','|',' ','|',' '},
                              {'-','+','-','+','-'},
                              {' ','|',' ','|',' '},};
         printGameborad(gameboard);
 
        while(true){
         
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your placement (1-9):");
        int playerpos = sc.nextInt();
        while(playerposition.contains(playerpos) || cpuposition.contains(playerposition)){
        System.out.println("Position taken! Enter the correct position");
        playerpos = sc.nextInt();
        }
        placePiecer(gameboard,playerpos,"player");
        
        String result = chekWinner();
         if(result.length() > 0){
            System.out.println(result);
            break;
        }
         
        Random rand = new Random();
        int cpupos = rand.nextInt(9)+1;
        while(playerposition.contains(cpupos) || cpuposition.contains(cpupos)){
        cpupos = rand.nextInt(9)+1;
        }
        placePiecer(gameboard,cpupos,"CPU");
        
        printGameborad(gameboard);
        
         result = chekWinner();
        if(result.length() > 0){
            System.out.println(result);
            break;
        }
     }
       
    }     
    public static void printGameborad(char [][] gameboard){
        for(char[] row : gameboard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiecer(char [][] gameboard , int pos ,String user){
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
            playerposition.add(pos);
            
        }else if (user.equals("CPU")){
            symbol ='0'; 
            cpuposition.add(pos);
        }
        
        
             switch(pos){
            case 1:
                gameboard[0][0] = symbol;
                break;
                
             case 2:
                gameboard[0][2] = symbol;
                break;
                
             case 3:
                gameboard[0][4] = symbol;
                break;
                
            case 4:
                gameboard[2][0] =symbol;
                break;
                
             case 5:
                gameboard[2][2] = symbol;
                break;
                
              case 6:
                gameboard[2][4] = symbol;
                break;
                
            case 7:
                gameboard[4][0] = symbol;
                break;
                
             case 8:
                gameboard[4][2] = symbol;
                break;
                
              case 9:
                gameboard[4][4] = symbol;
                break;
              default :
                  break;
        }
    }
    public static String chekWinner(){
        
        List toprow = Arrays.asList(1,2,3);
        List midrow = Arrays.asList(4,5,6);
        List botrow = Arrays.asList(7,8,9);
        List leftcol = Arrays.asList(1,4,7);
        List midcol = Arrays.asList(2,5,8);
        List rightcol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);
       
        List<List> Wining = new ArrayList<List>();
        Wining.add(toprow);
        Wining.add(midrow);
        Wining.add(botrow);
        Wining.add(leftcol);
        Wining.add(midcol);
        Wining.add(rightcol);
        Wining.add(cross1);
        Wining.add(cross2);
        
        for(List l : Wining){
            if(playerposition.containsAll(l)){
                return "Congratulations you Won!";
            }else if(cpuposition.containsAll(l)){
                return "CPU Wins! Sorry";
            }else if(playerposition.size() + cpuposition.size() == 9 )
                return "Draw!";
        }
        
        
        return "";
    }
}
