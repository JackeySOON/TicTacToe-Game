import java.util.*; 

public class GameTicTacToe { 
    
    static String[] board; 
    static String turn; 
    
   public static void main(String[] args){ 
        Scanner in = new Scanner(System.in); 
        board = new String[9]; 
        turn = "X"; 
        String winner = null; 

        for (int i = 0; i < 9; i++) { 
               board[i] = String.valueOf(i + 1); 
         } 

         System.out.println("Welcome to TicTacToe!\n" + "  Board"); 
          drawBoard(); 

         System.out.println( 
              "X will play first. Enter a position:"); 

     while (winner == null) { 
               int position; 
         
               try { 
                   position = in.nextInt(); 
                         if (!(position > 0 && position <= 9)) { 
                System.out.println("Invalid. re-enter slot number:"); 
                continue; 
                               } 
                } 
               catch (Exception e) { 
                     System.out.println( "Invalid. re-enter slot number:"); 
                     continue; 
                 } 
          
          if (board[position - 1].equals(String.valueOf(position))) { 
               board[position - 1] = turn; 

                      if (turn.equals("X")) { 
                            turn = "O"; 
                         } 
                      else { 
                          turn = "X"; 
                          } 
                   drawBoard(); 
                   winner = checkWinner(); 
                 } 
            else { 
                     System.out.println("Slot already taken; re-enter slot number:"); 
             } 
          } 
    
       if (winner.equalsIgnoreCase("draw")) { 
            System.out.println("It's a draw!"); 
          } 
    
        else { 
        System.out.println("Congratulations!\n " + winner + " have won!"); 
    	} 
 }
    
    public static void drawBoard() { 
        System.out.println(board[0] + " | "+ board[1] + " | " + board[2] ); 
         System.out.println("---------"); 
         System.out.println(board[3] + " | "+ board[4] + " | " + board[5] ); 
         System.out.println("---------"); 
         System.out.println( board[6] + " | "+ board[7] + " | " + board[8] ); 
    }
    
    public static String checkWinner(){ 
        for (int i = 0; i < 8; i++) { 
            String line = null; 
  
            switch (i) { 
            case 0: 
                line = board[0] + board[1] + board[2]; 
                break; 
            case 1: 
                line = board[3] + board[4] + board[5]; 
                break; 
            case 2: 
                line = board[6] + board[7] + board[8]; 
                break; 
            case 3: 
                line = board[0] + board[3] + board[6]; 
                break; 
            case 4: 
                line = board[1] + board[4] + board[7]; 
                break; 
            case 5: 
                line = board[2] + board[5] + board[8]; 
                break; 
            case 6: 
                line = board[0] + board[4] + board[8]; 
                break; 
            case 7: 
                line = board[2] + board[4] + board[6]; 
                break; 
             default:
                    break;
            } 
            if (line.equals("XXX")) { 
                return "X"; 
            } 
            else if (line.equals("OOO")) { 
                return "O"; 
            } 
        } 
          
        for (int i = 0; i < 9; i++) { 
            if (Arrays.asList(board).contains( 
                    String.valueOf(i + 1))) { 
                break; 
            } 
            else if (i == 8) { 
                return "draw"; 
            } 
        } 
  
        System.out.println(turn + "'s turn; enter a position "); 
        return null; 
    }         
}