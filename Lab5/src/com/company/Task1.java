package com.company;

import javax.swing.text.html.parser.Parser;
import java.io.*;

public class Task1 {
    public static void Method1(int[] arr)
    {

    }

    public static int[] ReadFile(String path)
    {
        StringBuilder stringArr = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            String line;
            while ((line = reader.readLine())!= null){
                stringArr.append(line);
            }

            int[] arr = new int[stringArr.length()];
            String qwe = stringArr.toString();
            for (int i = 0; i < stringArr.length(); i++)
            {
                arr[i] = Integer.parseInt();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }


}
