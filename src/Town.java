

public class Town {
    
    public static void main(String[] args) {
        String input =  "50;"+
        "22,22,22;" +
        "50,60,70;" +
        "30,2;19,1;15,1;" +
        "300,5,7,3,20;" +
        "500,8,6,3,40;";
        TownState townState = TownState.fromString(input);
        Action TownStateActions = new Action(townState);
        TownStateActions.RequestFood();
        TownStateActions.WAIT();
    }
}
