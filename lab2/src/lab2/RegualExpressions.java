package lab2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegualExpressions {
    
    public String Input() {
        System.out.println("Введите строку:");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        return str;
    }
    public Boolean CheckString(String str) {
        String standard = "abcdefghijklmnopqrstuv18340";
        Pattern p1 = Pattern.compile(standard);
        Matcher m1 = p1.matcher(str);
        return m1.matches();
    }
    public void output(boolean matches) {
        if (matches) {
            System.out.println("\nСтрока соответствует шаблону");
        } else {
            System.out.println("\nСтрока не соответствует шаблону");
        }
    }
}
