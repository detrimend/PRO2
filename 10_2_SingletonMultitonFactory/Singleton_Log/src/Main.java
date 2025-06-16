import model.Log;

public class Main {
    public static void main(String[] args) {
        Log log = Log.getInstance("testlog1");

        log.addLog("First log entry");
        log.addLog("Second log entry");
        log.addLog("Third log entry");

        System.out.println("Log contents:");
        System.out.println(log.toString());
    }
}