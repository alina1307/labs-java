package lab2;

public class Main {
    public static void main(String[] args)
    {
    RegualExpressions searcher = new RegualExpressions();
        String text = searcher.Input();
        Boolean result = searcher.CheckString(text);
        searcher.output(result);
    }
}
