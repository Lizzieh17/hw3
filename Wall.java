/*
 * Lizzie Howell
 * 2/21/2024
 * Assignment 3 - Map Editor
 */
public class Wall {
    private int x, y, w, h;

    public Wall(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    //
    /*
     * public boolean amIClickingOnYou(int mouseX, int mouseY){
     *  if(mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y+h)
     *      return true;
     *
     * }
     */
    //unmarshaling contructor
    // Wall(Json ob){
    //     h = (int)ob.getLong("h");
    //     y = (int)ob.getLong("y");
    //     w = (int)ob.getLong("w");
    //     x = (int)ob.getLong("x");
    // }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getW(){
        return w;
    }
    public int getH(){
        return h;
    }
}
