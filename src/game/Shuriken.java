package game;

import city.cs.engine.*;

public class Shuriken extends DynamicBody {

    private static final Shape shurikenShape = new BoxShape(0.6f,0.6f);
    private static final BodyImage image = new BodyImage("data/shuriken.png",1.2f);

    private int damage;
    private int time;

    public Shuriken(World w){
        super(w, shurikenShape);
        addImage(image);
        this.damage = 5;
        this.time = 10;
        //setAlwaysOutline(true);
    }

    public int getDamage(){return this.damage;}
    public int getTime(){return this.time;}

    public void setDamage(int damage){this.damage = damage;}
    public void setTime(int time){this.time = time;}

    public void checkTime(){
        for(int i=0; i<time+1; i++){
            if (i == time){
                this.destroy();
            }
        }
    }
}
