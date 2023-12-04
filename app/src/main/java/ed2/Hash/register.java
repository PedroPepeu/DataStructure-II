public class register {
    
    public void doRegister(String plate) {
        Scanner sc = new Scanner (System.in);
        String lineToInsert = "", brand, model, color, register;
        lineToInsert+=plate+" ";

        System.out.println("Insert brand:");
        brand = sc.nextLine();
        
        System.out.println("Insert model:");
        model = sc.nextLine();
        
        System.out.println("Insert color:");
        color = sc.nextLine();
        
        System.out.println("Insert register:");
        register = sc.nextLine();

        carro car = new carro(plate, brand, model, color, register);

        String toDB = plate + " " + toString(car) + "\n";
        database.openToWrite(toDB);
    }

    public void search(String plate) {
        // get hash code, check if its in hash table, if true search in db, if false, return that do not exists
    }

    public void deleteCar(String plate) {
        database.deleteLine(plate);
        // delete from hashtable
    }
}
