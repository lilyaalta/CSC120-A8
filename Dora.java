import java.util.ArrayList;
public class Dora implements Contract {

ArrayList<String> backPack = new ArrayList<>();
ArrayList<String> stuff = new ArrayList<>();
ArrayList<String> history = new ArrayList<>();

public Dora(){
    stuff.add("wings");
    stuff.add("shrink juice");
    stuff.add("grow juice");
    stuff.add("hairtie");
}

public void grab(String item){
    if(backPack.size() > 3){
        System.out.println("Sorry, su bulto ya esta lleno!");
    }
    else{
        history.add(item + "grabbed");
        backPack.add(item);
        System.out.println("You have added " + item + " to your backpack!");
        }
    }
public String drop(String item){
    if(backPack.size() == 0){
        System.out.println("No puedes dejar nada si no tienes nada en tu bulto cabron!");
        }
    else if(backPack.contains(item)){
        System.out.println("You already have " + item + " en tu bulto!");
    }
    else{
        history.add(item + "dropped");
        backPack.remove(item);
    }
    return "Nice, " + item + " has been removed!";

}

public void examine(String item){
if(!backPack.contains(item)){
    System.out.println("Lo siento, you cannot examine the " + item + " if you do not have it!");
}
else{
    history.add(item + "examined");
    System.out.println("This/these " + item + " is very cool! You should use it.");
}
}

public void use(String item){
if(!backPack.contains(item)){
    System.out.println("You don't have that item to use!");
}
else{
    history.add(item + "used");
    System.out.println("You are using this item!");
}
}

public boolean walk(String direction){
    int finds = 0;
    if(!direction.equals("forward")){
        System.out.println("please just say forward");
    }
    if(direction.equals("forward")){
        while(true){
            stuff.get(finds++);
            if(finds < 2){
                System.out.println("Sorry, you have walked too much. Try another direction.");
            }
            history.add("walked " + direction);
        }
    }
    else if(direction.equals("backward")){
        while(true){ // this too 
            stuff.get(finds--);
            if(finds < 0){
                System.out.println("Sorry, you have walked too much. Try another direction.");
            }
        history.add("walked " + direction);
        System.out.println("You have found a(n) " + finds + " !!");
    }
}    
    return false;
}
public boolean fly(int x, int y){
    if(!backPack.contains("wings")){
        System.out.println("Sorry, you cannot fly if you dont have wings!");
    }
    if(x < 2){
        System.out.println("Woah, tan lejos! You cannot go that far!");
    }
    history.add("flew " + x + "far and " + y + " high");
    // System.out.println("Ay dios mio, you went " + x + "feet high and " + y + "feet long!");
    return true;
}

public Number shrink(){
    if(!backPack.contains("shrink juice")){
        System.out.println("You can't shrink without shrink juice!");
    }
    else{
        backPack.remove("shrink juice");
        history.add("shrunk!");
    }
    return 1;
}

public Number grow(){
    if(!backPack.contains("growing juice")){
        System.out.println("You can't shrink without shrink juice!");
    }
    else{
        backPack.remove("growing juice");
        history.add("grew!");
        }
    return 0;
}

public void rest(){
    history.add("slept");
    System.out.println("You went mimir! :(");
}

public void undo(){
System.out.println("Let's undo the last thing you did!");
for(int i = 0; i< history.size() - 1; i++){
    System.out.println("Move " + i + ": " + history.get(i));
}
}
public static void main(String[] args) {
Dora dora = new Dora();
dora.grab("wings");
dora.examine("wings");
dora.grab("hairtie");
dora.drop("hairtie");
dora.grab("shrink juice");
dora.grab("growing juice");
dora.fly(2, 4);
dora.shrink();
dora.grow();
dora.drop("wings");
dora.rest();
dora.undo();
}

}
