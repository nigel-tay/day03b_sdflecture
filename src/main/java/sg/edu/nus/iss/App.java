package sg.edu.nus.iss;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        File newDirectory = new File(dirPath);
        if (!newDirectory.exists()) {
            newDirectory.mkdir();
        }
        else {
            System.out.println("Path already exists.");
        }

        File newFile = new File(dirPathFileName);
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
        else {
            System.out.println("File exists.");
        }
    }
}
