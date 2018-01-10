package lab3.pkg1;

import java.io.IOException;
import java.util.Stack;

public class main {

    public static void main(String[] args) throws IOException {
        ReverseString searcher = new ReverseString(); 
        ReverseString se = new ReverseString(); 
        Stack<String> text = searcher.Input();
        Stack<String> t = searcher.Input();
        se.ReverseStrings(t);
        searcher.Output(text);
        
    }
}
