import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class FetchID {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your ID: ");
        String id = br.readLine();
        br.close();

        URL source = new URL("https://www.ecs.soton.ac.uk/people/" +id);

        BufferedReader reader = new BufferedReader(new InputStreamReader(source.openStream()));
        String line;
        String flag = "property=\"name\">";
        String end = "<em property=";
        while((line = reader.readLine()) != null)
        {
            if(line.contains(flag)) System.out.println(line.substring(line.indexOf(flag)+flag.length(),line.indexOf(end)));
        }


    }
}