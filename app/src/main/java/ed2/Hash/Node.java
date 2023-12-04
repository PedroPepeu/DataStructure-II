package ed2.Hash;

public class Node {

    private String plate;
    private int pos;
    private int status;
    private int next;

    public Node(String plate, int pos, int status, int next){
        this.plate = plate;
        this.pos = pos;
        this.status = 1;
        this.next = -1;
    }

    public Node(int pos){
        this.plate = null;
        this.pos = pos;
        this.status = 0;
        this.next = -1;
    }

    public void setNext(int next){
        this.next = next;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getPos(){
        return pos;
    }

    public int getNext(){
        return next;
    }

    public boolean isOccupied(){
        return status == 1;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getStatus() {
        return status;
    }
}
