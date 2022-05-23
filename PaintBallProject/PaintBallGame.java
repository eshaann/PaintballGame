import java.util.Scanner;

public class PaintBallGame {
  private int compBarrel; // which barrel the computer hides
  private int uBarrel; // which barrel the user hides
  private int uHealth; // current # of user's lives
  private int compHealth; // current # of computer's lives
  private int uShot; // which barrel the user shoots at
  private int compShot; // which barrel the computer shoots at
  private boolean userWin;
  private boolean compWin;
  private boolean tie;

  /**PaintBallGame Constructor- sets both health to 3
  */
  public PaintBallGame() {
    uHealth = 3;
    compHealth = 3;
  }


  /** prints out the game's layout
  */
  public static void origScreen() 
  {
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("-----   -----");
    System.out.println("| 1 |   | 2 |");
    System.out.println("-----   -----");
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("-----   -----");
    System.out.println("|   |   |   |");
    System.out.println("-----   -----");
  }

  /** sets where the user wants to shoot
  */
  public void setuShot(int uShot)
  {
    this.uShot = uShot;
  }

/** set what barrel the user wants to hide behind
*/
  public void setuBarrel(int uBarrel)
  {
    this.uBarrel = uBarrel;
  }

 /** randomly set where the computer will shoot from a number 1 to 2
 */
  public void setcompShot() 
  {
    compShot = (int) (Math.random() * 2) + 1;
  }

/** randomly set what barrel the computer will go behind from a number 1 to 2
*/
  public void setcompBarrel() 
  {
    compBarrel = (int) (Math.random() * 2) + 1;
  }



  /** runs the game and prompts the user for two inputs using sets of conditions
  */
  public void game() throws InterruptedException 
  {
    // user shot evaluater
    while (uHealth > 0 && compHealth > 0) 
    {
      origScreen();
      Scanner scan = new Scanner(System.in);
      System.out.println("\nPick which barrel you think your opp is behind.(1, 2)");
      int a = scan.nextInt();
      System.out.println("\nPick which barrel you want to go behind (1, 2)");
      int b = scan.nextInt();
      setAll(a,b);
      whichScreen();
    }
    if (uHealth == 0 && compHealth == 0) 
    {
      tie = true;
    } 
    else if (compHealth == 0)
    {
      userWin = true;
    }
    else
    {
      compWin = true;
    }
    if(tie)
    {
      System.out.println("You tied!");
    }
    else if(userWin)
    {
      System.out.println("You won!");
    }
    else
    {
      System.out.println("You lost!");
    }

  }


  /** uses setters to set uShot and uBarrel using the parameters; it sets
  public void setAll(int uShot, int uBarrel) 
  */
  public void setAll(int uShot, int uBarrel)
                                             /** CompShot and CompBarrel to random values using the Comp setters */
  {
    setuShot(uShot);
    setuBarrel(uBarrel);
    setcompShot();
    setcompBarrel();
  }

  /** clears the Screen to move on to the next frame
  */
  public void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /** toString Method
  * @return string with relevant information about both health updates
  */
  public String toString()
   {
    String str = "Opponent lives: " + compHealth + "\nYour lives: " + uHealth;
    return str.substring(0);
  }

  /**determines which Animation to print out
  */
  public void whichScreen() throws InterruptedException 
  {
    // if both are at barrel 1
    if ((uBarrel == 1 && compBarrel == 1) && (uShot == 1 && compShot == 1)) {
      Animation.oneoneoneone();
      uHealth--;
      compHealth--;
      System.out.println(toString());
    } else if ((uBarrel == 1 && compBarrel == 1) && (uShot == 2 && compShot == 1)) {
      Animation.oneonetwoone();
      uHealth--;
      System.out.println(toString());

    } else if ((uBarrel == 1 && compBarrel == 1) && (uShot == 1 && compShot == 2)) {
      Animation.oneoneonetwo();
      compHealth--;
      System.out.println(toString());
    } else if ((uBarrel == 1 && compBarrel == 1) && (uShot == 2 && compShot == 2)) {
      Animation.oneonetwotwo();

      System.out.println(toString());
    }
    // if user at 1 and comp at 2
    else if ((uBarrel == 1 && compBarrel == 2) && (uShot == 1 && compShot == 1)) {
      Animation.onetwooneone();
      uHealth--;
      System.out.println(toString());
    } else if ((uBarrel == 1 && compBarrel == 2) && (uShot == 2 && compShot == 1)) {
      Animation.onetwotwoone();
      compHealth--;
      uHealth--;
      System.out.println(toString());
    } else if ((uBarrel == 1 && compBarrel == 2) && (uShot == 1 && compShot == 2)) {
      Animation.onetwoonetwo();

      System.out.println(toString());
    } else if ((uBarrel == 1 && compBarrel == 2) && (uShot == 2 && compShot == 2)) {
      Animation.onetwotwotwo();
      compHealth--;
      System.out.println(toString());
    }
    // if user at 2 and comp at 1
    else if ((uBarrel == 2 && compBarrel == 1) && (uShot == 1 && compShot == 1)) {
      Animation.twooneoneone();
      compHealth--;
      System.out.println(toString());
    } else if ((uBarrel == 2 && compBarrel == 1) && (uShot == 2 && compShot == 1)) {
      Animation.twoonetwoone();
      System.out.println(toString());
    } else if ((uBarrel == 2 && compBarrel == 1) && (uShot == 1 && compShot == 2)) {
      Animation.twooneonetwo();
      compHealth--;
      uHealth--;
      System.out.println(toString());
    } else if ((uBarrel == 2 && compBarrel == 1) && (uShot == 2 && compShot == 2)) {
      Animation.twoonetwotwo();
      uHealth--;
      System.out.println(toString());
    }
    // if user 2 and comp at 2
    else if ((uBarrel == 2 && compBarrel == 2) && (uShot == 1 && compShot == 1)) {
      Animation.twotwooneone();

      System.out.println(toString());
    } else if ((uBarrel == 2 && compBarrel == 2) && (uShot == 2 && compShot == 1)) {
      Animation.twotwotwoone();
      compHealth--;
      System.out.println(toString());
    } else if ((uBarrel == 2 && compBarrel == 2) && (uShot == 1 && compShot == 2)) {
      Animation.twotwoonetwo();
      uHealth--;
      System.out.println(toString());
    } else if ((uBarrel == 2 && compBarrel == 2) && (uShot == 2 && compShot == 2)) {
      Animation.twotwotwotwo();
      uHealth--;
      compHealth--;
      System.out.println(toString());
    }
  }

}