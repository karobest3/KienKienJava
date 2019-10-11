package Commons;

import java.util.Scanner;

public class FuncValidation {
    private static String regex = "";
    private static Scanner sc;
    public static boolean checkNameServices(String str){
        regex = "^([\\p{Lu}]|([\\p{Lu}][\\p{Ll}]{1,}))([\\s]([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,6}$";
        return str.matches(regex);
    }
    public static double checkValidNumberDouble(String content,String errMes){
        boolean err =false;
        while (!err){
            try {
                sc = new Scanner(System.in);
                System.out.println(content);
                err=true;
                return sc.nextDouble();
            }catch (Exception ex){
                err = false;
                System.out.println(errMes);
            }
        }
        return 0;
    }
    public static Integer checkValidNumberInteger(String content,String errMes){
        boolean err =false;
        while (!err){
            try {
                sc = new Scanner(System.in);
                System.out.println(content);
                err=true;
                return sc.nextInt();
            }catch (Exception ex){
                err = false;
                System.out.println(errMes);
            }
        }
        return 0;
    }
}
