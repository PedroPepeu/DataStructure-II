package ed2.Hash;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class database {

    public void createFile() {
        try {
            File File = new File("db.txt");
            if(File.createNewFile()) {
                System.out.println("File created: "+File.getName());
            } else {
                System.out.println("File "+File.getName()+" has already been created");
            }
        } catch (Exception e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    public void openToWrite(String toWrite) {
        try {
            FileWriter File = new FileWriter("db.txt");
            File.write(toWrite);
            File.close();
            System.out.println("Successefully wrote in the file:\n"+toWrite);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

            createNewFile();
            openToWrite(toWrite);
        }
    }

    public String printingFileDB() {
        try {
            File File = new File("db.txt");
            Scanner sc = new Scanner (File);

            String outing = "";
            while(sc.hasNextLine()) {
                outing+=sc.nextLine();
                outing+="\n";
            }
            sc.close();
            return outing;
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public void deleteLine(String plate) {
        try {
            File File = new File("db.txt");
            Scanner sc = new Scanner (File);

            String outing = "";
            String line = "";
            boolean found;

            while(sc.hasNextLine()) {
                line+=sc.nextline();
                found = line.contains(plate);
                if(found) continue;

                outing+=line;
                outing+="\n";
                line="";
            }
            sc.close();
            deleteFile();
            createFile(); 
            openToWrite(outing);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void deleteFile() {
        File File = new File("db.txt");
        if(File.delete()) {
            System.out.println("Deleted the file: "+File.getName());
        } else {
            System.out.println("Failed to delete");
        }
    }
}
