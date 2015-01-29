import java.io.*;
import java.util.ArrayList;

/**
 * Created by lyz on 15-1-26.
 *
 */
public class Utils {

    public static int[] readInts(String file_name) {
        try {
            FileInputStream input_stream = new FileInputStream(new File("E:\\algs4-projects\\" + file_name));
            InputStreamReader input_stream_reader = new InputStreamReader(input_stream);
            BufferedReader buffered_reader = new BufferedReader(input_stream_reader);
            String line;
            ArrayList<Integer> int_array = new ArrayList<Integer>();
            while((line = buffered_reader.readLine()) != null) {
                int_array.add(Integer.parseInt(line.trim()));
            }
            buffered_reader.close();
            input_stream_reader.close();
            input_stream.close();
            if(int_array.size() == 0)
                return null;
            int[] ret_array = new int[int_array.size()];
            for(int i = 0; i < int_array.size(); ++i) {
                ret_array[i] = int_array.get(i);
            }
            return ret_array;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int[] genericRandomInts(int N) {
        int[] a = new int[N];
        for(int i = 0; i < N; ++i) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }
        return a;
    }
}
