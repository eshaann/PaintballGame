class Main {
  public static void main(String[] args) {
    int i = 0;
    while(i<100){
    try{
      PaintBallGame pb = new PaintBallGame();
      pb.game();
      i++;
    } catch(InterruptedException ix){
      ix.printStackTrace();
    }
    }
  }
}