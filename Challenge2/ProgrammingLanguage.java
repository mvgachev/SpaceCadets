import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;


public class Main {
    static Map<String, Integer> Mymap = new HashMap<String, Integer>();
    static Map<Integer, Integer> readyWhiles = new HashMap<>();
    static List<String> code = new ArrayList<>();

    static {
        try {
            code.addAll(Files.readAllLines(getFile().toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getFile() {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else return null;
    }

    private static int while2 (int whileLine, List<String> code)
    {
        int k = 0;
        String whileWords[] = code.get(whileLine).trim().split(" ");

        int result = Integer.parseInt(whileWords[3]);
        if(readyWhiles.containsKey(whileLine) && Mymap.get(whileWords[1]) == result)
            return readyWhiles.get(whileLine);
        else {
            while (Mymap.get(whileWords[1]) != result)                                     //checks until the upper while is right
            {
                int i = whileLine + 1;
                String currentLine = code.get(i).trim();

                while (!(currentLine.startsWith("end"))) {                                        //starts looping till the end of the while
                    if (currentLine.startsWith("while")) {

                        i = while2(i, code);                                            //if there is a while in the while starts the whole process again
                    } else {
                        compile(currentLine);
                    }
                    execute(i);
                    i++;
                    currentLine = code.get(i).trim();              //changes lines
                }
                k = i;
            }
            readyWhiles.put(whileLine,k); return k;
        }
    }

    private static void compile(String i) {
        if(i.endsWith(";")) i = i.substring(0,i.length() - 1);
        String[] line = i.trim().split(" ");
        switch (line[0]) {
            case "clear":
                Mymap.put(line[1], 0);
                break;
            case "incr":
                Mymap.put(line[1], Mymap.get(line[1])+1);
                break;
            case "decr":
                Mymap.put(line[1], Mymap.get(line[1])-1);
                break;
        }
    }
    private static void execute( int i)
    {
        System.out.print("line number: " + i + "  ");
        for (Map.Entry entry : Mymap.entrySet()) {
         System.out.print(entry.getKey() + ":" + entry.getValue() + "  ");
        }System.out.println();
    }
    public static void main(String[] args) throws IOException {

        int k=0,endline=0;
        for(String i: code)
        {

            if(i.startsWith("while"))
            {
               endline= while2(k,code)+1;
            }
             if(endline==0||endline<=k)  compile (i);
            execute(k);
            k++;
        }


    }
}