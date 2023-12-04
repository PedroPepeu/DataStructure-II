package ed2.Hash;

import java.io.*;

import java.util.Scanner;

public class BinaryFile {
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private String hashing = "hashtable.dat";
    private String dbcar = "cartable.dat";
    private int sizeDbCar;
    private int sizeHashTable;

    public BinaryFile() {
        File tableFile = new File(getHashing());
        File carListFile = new File(getDbcar());

        createFileIfNotExists(tableFile);
        createFileIfNotExists(carListFile);

        this.sizeDbCar = 0;
        this.sizeHashTable = 0;
    }

    private void createFileIfNotExists(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void openToWrite(String fileName) {
        try {
            File file = new File(fileName);
            FileOutputStream fileOut = new FileOutputStream(file);
            output = new ObjectOutputStream(fileOut);
            System.out.println("File created");
        } catch (IOException ioException) {
            System.err.println("Error creating file for writing");
            System.exit(1);
        }
    }

    public boolean openToRead(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                return false;
            } else {
                FileInputStream fileIn = new FileInputStream(file);
                input = new ObjectInputStream(fileIn);
                return true;
            }
        } catch (IOException ioException) {
            System.err.println("Error opening file for reading");
            return false;
        }
    }

    public void closeWriteFile() {
        try {
            if (output != null) {
                output.flush();
                output.close();
                output = null;
                System.out.println("File closed after writing");
            }
        } catch (IOException ioException) {
            System.err.println("Error closing file after writing");
            System.exit(1);
        }
    }

    public void closeReadFile() {
        try {
            if (input != null) {
                input.close();
                input = null;
                System.out.println("File closed after reading");
            }
        } catch (IOException ioException) {
            System.err.println("Error closing file after reading");
            System.exit(1);
        }
    }

    public void writeCarData(Car car) {
        try {
            output.writeObject(car);
        } catch (IOException ioException) {
            System.err.println("Write error");
            System.exit(1);
        }
    }

    public Car readCarData() {
        Car car;

        try {
            car = (Car) input.readObject();
            return car;
        } catch (EOFException endOfFileException) {
            return null; // end of file
        } catch (ClassNotFoundException classNotFoundException) {
            return null;
        } catch (IOException ioException) {
            return null;
        }
    }

    public String getCarList() {
        try {
            File File = new File(getDbcar());
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

    public String getCarEspecifically(int pos) {
        try {
            File File = new File(getDbcar());
            Scanner sc = new Scanner (File);

            String outing = "";
            int i = 0;
            while(sc.hasNextLine()) {
                if(i == pos) return sc.nextLine()+"\n";
                outing+=sc.nextLine();
            }
            sc.close();
            
            return null;
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public void writeHashing(Node node) {
        try {
            output.writeObject(node);
        } catch (IOException ioException) {
            System.err.println("Write error");
            System.exit(1);
        }
    }

    public void writeHashing(String str) {
        try {
            output.writeObject(str);
        } catch (IOException ioException) {
            System.err.println("Write error");
            System.exit(1);
        }
    }

    public Node readHashing() {
        Node node;

        try {
            node = (Node) input.readObject();
            return node;
        } catch (EOFException endOfFileException) {
            return null; // end of file
        } catch (ClassNotFoundException classNotFoundException) {
            return null;
        } catch (IOException ioException) {
            return null;
        }
    }

    public String getNodeList() {
        try {
            File File = new File(getHashing());
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

    public void replaceHashing(int pos, Node node) {
        try {
            File File = new File(getHashing());
            Scanner sc = new Scanner (File);

            String outing = "";
            int i = 0;
            while(sc.hasNextLine()) {
                if(i == pos) {
                    outing+=node.toString()+"\n";
                }
                outing+=sc.nextLine();
                outing+="\n";
                i++;
            }
            outing+=node.toString();
            outing+="\n";
            sc.close();
            
            openToWrite(getHashing());
            writeHashing(outing);
            closeWriteFile();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addCarListData(Car car) {
        try {
            File File = new File(getDbcar());
            Scanner sc = new Scanner (File);

            String outing = "";
            while(sc.hasNextLine()) {
                outing+=sc.nextLine();
                outing+="\n";
            }
            outing+=car.toString();
            outing+="\n";
            sc.close();
            
            outing+=car.toString()+"\n";

            openToWrite(getDbcar());
            writeHashing(outing);
            closeWriteFile();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addSynHashing(Node node) {
        try {
            File File = new File(getHashing());
            Scanner sc = new Scanner (File);

            String outing = "";
            while(sc.hasNextLine()) {
                outing+=sc.nextLine();
                outing+="\n";
            }
            outing+=node.toString();
            outing+="\n";
            sc.close();
            
            openToWrite(getHashing());
            writeHashing(outing);
            closeWriteFile();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean isEmpty() {
        if(getSizeDbCar() == 0) return true;
        else return false;
    }

    public String getHashing() {
        return hashing;
    }

    public void setHashing(String hashing) {
        this.hashing = hashing;
    }

    public String getDbcar() {
        return dbcar;
    }

    public void setDbcar(String dbcar) {
        this.dbcar = dbcar;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }

    public int getSizeDbCar() {
        return sizeDbCar;
    }

    public void setSizeDbCar(int sizeDbCar) {
        this.sizeDbCar = sizeDbCar;
    }

    public int getSizeHashTable() {
        return sizeHashTable;
    }

    public void setSizeHashTable(int sizeHashTable) {
        this.sizeHashTable = sizeHashTable;
    }
    
}
