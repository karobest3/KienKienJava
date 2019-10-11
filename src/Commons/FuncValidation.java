package Commons;

public class FuncValidation {
    private static String regex = "";
    public static boolean checkNameServices(String str){
        regex = "^([\\p{Lu}]|([\\p{Lu}][\\p{Ll}]{1,}))([\\s]([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,6}$";
        return str.matches(regex);
    }
}
