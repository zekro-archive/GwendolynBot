package util;

public class ConsoleUtils {

    public static String Reset = (char)27 + "[0m";
    public static String Red = (char)27 + "[31m";
    public static String Green = (char)27 + "[32m";
    public static String Yellow = (char)27 + "[33m";
    public static String Blue = (char)27 + "[34m";
    public static String Magenta = (char)27 + "[35m";
    public static String Cyan = (char)27 + "[36m";
    public static String Bold = (char)27 + "[1m";
    public static String StopBold = (char)27 + "[21m";
    public static String Underline = (char)27 + "[4m";
    public static String StopUnderline = (char)27 + "[24m";

    public static void sendError(String message) { System.out.println(Red + message + Reset); }
    public static void sendDebug(String message) { System.out.println(Cyan + message + Reset); }
    public static void sendSuccess(String message) { System.out.println(Green + message + Reset); }

}
