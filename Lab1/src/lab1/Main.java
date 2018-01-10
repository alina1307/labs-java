package lab1;

public class Main {

    public static void main(String[] args) {
        ShortestStringSearcher searcher = new ShortestStringSearcher();
        String[] text = searcher.input();
        String result = searcher.ShortestLine(text);
        searcher.output(result);
    }
}
