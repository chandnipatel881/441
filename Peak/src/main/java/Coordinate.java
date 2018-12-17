import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Coordinate {

    public int i;
    public int j;
    public int value;

    public Coordinate(){

    }

    public Coordinate(int x, int y, int cost){
        this.i = x;
        this.j = y;
        this.value = cost;
    }


    public String toString(){
        return "(" + this.i + ", " + this.j + "," + this.value + ")";
    }
}
