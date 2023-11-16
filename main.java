import java.util.Scanner;

public class main {

   public static void clearConsole() {
      System.out.print("\033[H\033[2J"); // очищ€ет консоль 
  }

   public static void ref(String[][] game) {
      for(int i = 0; i < 3; i++){ // цикл for перебирает каждый элемент 0, 1, 2 и выводит красиво
         System.out.println(game[i][0] + "_|_" + game[i][1] + "_|_" + game[i][2]);
      } 
   }

   public static int question(int side, String[][] game, String[][] game1) {
      Scanner scan = new Scanner(System.in);
      int x;
      ref(game1);
      System.out.println();
      if (side == 1) {
         System.out.println("Where X? 1 - 9");
         x = scan.nextInt();
         if (x == 1 || x == 2 || x == 3) {
            x = x - 1;
            if (game[0][x] == " ") {
               game[0][x] = "X";
            }
         }
         if (x == 4 || x == 5 || x == 6) {
            x = x - 4;
            if (game[1][x] == " ") {
               game[1][x] = "X";
            }
         }
         if (x == 7 || x == 8 || x == 9) {
            x = x - 7;
            if (game[2][x] == " ") {
               game[2][x] = "X";
            }
         }
         return 2;
      }
      
      if (side == 2) {
         System.out.println("Where O? 1 - 9");
         x = scan.nextInt();
         if (x == 1 || x == 2 || x == 3 ) {
            x = x - 1;
            if (game[0][x] == " ") {
               game[0][x] = "O";
            }
         }
         if (x == 4 || x == 5 || x == 6) {
            x = x - 4;
            if (game[1][x] == " ") {
               game[1][x] = "O";
            }
         }
         if (x == 7 || x == 8 || x == 9) {
            x = x - 7;
            if (game[2][x] == " ") {
               game[2][x] = "O";
            }
         }
         return 1;
      } 
      return 1;
   }

   public static int win(int side, String[][] game) {
      int w = 0;
      if (side == 2) {
         if (game[0][0] == "X" && game[0][1] == "X" && game[0][2] == "X") {
            winsout(side);
            w = 1;
         }
         if (game[1][0] == "X" && game[1][1] == "X" && game[1][2] == "X") {
            winsout(side);
            w = 1;
         }
         if (game[2][0] == "X" && game[2][1] == "X" && game[2][2] == "X") {
            winsout(side);
            w = 1;
         }
         if (game[0][0] == "X" && game[1][0] == "X" && game[2][0] == "X") {
            winsout(side);
            w = 1;
         }
         if (game[0][1] == "X" && game[1][1] == "X" && game[2][1] == "X") {
            winsout(side);
            w = 1;
         }
         if (game[0][2] == "X" && game[1][2] == "X" && game[2][2] == "X") {
            winsout(side);
            w = 1;
         }
         if (game[0][0] == "X" && game[1][1] == "X" && game[2][2] == "X") {
            winsout(side);
            w = 1;
         }
         if (game[2][0] == "X" && game[1][1] == "X" && game[0][2] == "X") {
            winsout(side);
            w = 1;
         }
      }
      if (side == 1) {
         if (game[0][0] == "O" && game[0][1] == "O" && game[0][2] == "O") {
            winsout(side);
            w = 1;
         }
         if (game[1][0] == "O" && game[1][1] == "O" && game[1][2] == "O") {
            winsout(side);
            w = 1;
         }
         if (game[2][0] == "O" && game[2][1] == "O" && game[2][2] == "O") {
            winsout(side);
            w = 1;
         }
         if (game[0][0] == "O" && game[1][0] == "O" && game[2][0] == "O") {
            winsout(side);
            w = 1;
         }
         if (game[0][1] == "O" && game[1][1] == "O" && game[2][1] == "O") {
            winsout(side);
            w = 1;
         }
         if (game[0][2] == "O" && game[1][2] == "O" && game[2][2] == "O") {
            winsout(side);
            w = 1;
         }
         if (game[0][0] == "O" && game[1][1] == "O" && game[2][2] == "O") {
            winsout(side);
            w = 1;
         }
         if (game[2][0] == "O" && game[1][1] == "O" && game[0][2] == "O") {
            winsout(side);
            w = 1;
         }
      }
      return w;
   }

   public static int winsout(int side) {
      if (side == 2) {
         System.out.println("Win " + "X");
      }
      if (side == 1) {
         System.out.println("Win " + "O");
      }
      return 0;
   }
   
   public static void main(String[] args) {
      
      Scanner scan = new Scanner(System.in);
      clearConsole();
      int side = 1; // 1 - X; 2 - O
      int winq = 0;
      String[][] game = {{" "," "," "},{" "," "," "},{" "," "," "}}; // massive game
      String[][] game1 = {
      {"1","2","3"},
      {"4","5","6"},
      {"7","8","9"}};
      while (winq == 0) {
         clearConsole();
         ref(game);
         System.out.println();
         side = question(side, game, game1);
         clearConsole();
         ref(game);
         System.out.println();
         winq = win(side, game);
      }
   } 
}