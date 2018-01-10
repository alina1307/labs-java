package lab3.pkg1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;


public class ReverseString {
  
    public Stack<String> Input() throws FileNotFoundException, IOException {
       String line; 
       Stack<String> stack = new Stack<>(); 
       try { 
       BufferedReader reader = new BufferedReader(new FileReader("\\D:123.txt")); 
       while ((line = reader.readLine()) != null) 
       stack.push(line); 
       } 
       catch(FileNotFoundException exp){ 
       System.out.println("File not found..."); 
       System.exit(0); 
       } 
       return stack;
    }
    public void ReverseStrings (Stack <String> stack){
        while (!stack.empty())
        System.out.println(new StringBuffer (stack.pop()).reverse());
    }
            
    public void Output (Stack <String> stack) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("\\D:123.txt"));
        while (!stack.empty())
                writer.println(new StringBuffer (stack.pop()).reverse()); 
            writer.flush();
    }
}

