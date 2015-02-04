import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-3.
 * API:
 * 1. Search(Graph graph, int s)
 * 2. boolean marked(itn v)
 * 3. int count()
 */
public class Search {
    private int s;

    public Search(Graph graph, int s) {
        this.s = s;
    }

    public boolean marked(int v) {
        return false;
    }

    public int count() {
        return 0;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("tinyG.txt"));
            Graph graph = new Graph(scanner);
            Search search = new Search(graph, 0);
            for(int i = 0; i < graph.getV(); ++i) {
                if(search.marked(i))
                    StdOut.print(i + " ");
            }
            StdOut.println();
            if(search.count() != graph.getV())
                StdOut.print("NOT ");
            StdOut.println("connected");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
