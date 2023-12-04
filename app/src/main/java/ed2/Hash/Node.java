package ed2.Hash;

public class Node {
    private String plate;
    private int pos;
    private int status;
    private int next;

    public Node(int pos){
        this.pos = pos;
        this.status = 0;
        this.next = -1;
    }

    

    public Node(int posicao, int status, int next){
        this.posicao = posicao;
        this.status = 1;
        this.next = -1;
    }

    public void setNext(int next){
        this.next = next;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getPos(){
        return posicao;
    }

    public int getNext(){
        return next;
    }

    public boolean isOccupied(){
        return status == 1;
    }

    @Override
    public String toString(){
        return "Ocupado: " + String.valueOf(isOccupied());
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
