public class Reminder {

    public void remind(Trading trade, String msg){
        System.out.println("For trade"+trade.name);
        System.out.println(msg);
    }
}
