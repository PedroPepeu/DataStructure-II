package ed2.Hash;

public class HashTable {
    private int size;
    private int synon;
    private BinaryFile bf;

    public HashTable(int size) {
        this.size = size;
        this.synon = 0;
        BinaryFile bf = new BinaryFile();
        inicialize();
    }

    public int Hdesl(String key) {
        int sum = 0, length = key.length();
        for(int i = 0; i < length; i++) {
            sum += ((int)key.charAt(i) << (i % 8));
        }
        return sum % size;
    }

    private void inicialize() {
        bf.openToWrite(bf.getHashing());
        for(int i = 0; i < size; i++) {
            Node newNode = new Node(i);
            bf.writeHashing(newNode);
        }
        bf.closeWriteFile();
    }

    
    public void addHashing(Car car, int position) {
        bf.addCarListData(car);
        bf.replaceHashing(position, new Node(position, 1, -1));
    }

    public void addSynonym(Car car) {
        bf.addCarListData(car);
        bf.addSynonymTable(Node);
    }

    public void insert(Car car) {
        String key = car.getPlate();
        int position = Hdesl(key);
        int searchResult = search(key);
        Node node = getNodeAtPosition(position);

        if(searchResult == -1) {
            if(node.isOccupied()) {
                addSynonym(car);
                while(node.getNext() != -1) {
                    position = node.getNext();
                    node = getNodeAtPosition(node.getNext());
                }
                node.setNext(size + synon);
                bf.replaceHashing(position, node);
                synon++;
            } else {
                addHashing(car, position);
            }
            
            bf.openToWrite(bf.getDbcar());
            bf.writeCarData(car);
            bf.closeReadFile();
            return;
        }
        System.out.println("Este carro ja foi registrado anteriormente.");
    }

    public int search(String key) {
        if(bf.isEmpty()) {
            return -1;
        }

        bf.openToRead(bf.getDbcar());
        Car car = bf.readCarData();
        int i = 0;
        while(car != null) {
            if(key.equals(car.getPlate())) {
                bf.closeReadFile();
                return i;
            }
            car = bf.readCarData();
            i++;
        }
        bf.closeReadFile();

        return -1;
    }

    public void display(String key) {
        System.out.println(bf.getCarList());
    }

    public void list(String plate) {
        if(bf.isEmpty()) {
            System.out.println("There is no car registered");
            return;
        }

        int pos = Hdesl(plate);
        String out = bf.getCarEspecifically(pos);
        if(out == null) System.out.println("This car does not exists");
        else System.out.println(out);
    }

    public Node getNodeAtPosition(int position) {
        bf.openToRead(bf.getHashing());
        Node node = bf.readHashing();
        int i = 0;
        while(node != null) {
            if(i == position) {
                bf.closeReadFile();
                return node;
            }
            node = bf.readHashing();
            i++;
        }
        bf.closeReadFile();
        return null;
    }
}
