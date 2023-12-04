package ed2.Hash;

public class hashtable {
   
    private int N;
    arqBin arqbin;

    public hashtable(int N) {
        this.N = N;
    }

    private int h(String key) {
        int soma = 0, tam = key.length();
        for(int i = 0; i < tam; i++) {
            soma+=(((int) key.charAt(i)) << (i%8));
        }
        return Math.abs(soma) % N;
    }

    public void insert(Carro car) {
        String plate = car.getPlate();

        if(exists) {
            if() {
                
            }
        }
        System.out.println("Este carro ja foi cadastrado anteriormente.");
        return;
    }

    public int hDesl(String chv){
        int i, soma = 0, tam = chv.length();
        for(i = 0; i < tam; i++)
        {
            soma += ((int)chv.charAt(i) << (i % 8));
        }
        return soma % N;
    }


}
