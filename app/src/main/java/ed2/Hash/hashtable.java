public class hashtable {
   
    private int N = 12;
    private int h(String key) {
        int soma = 0, tam = key.length();
        for(int i = 0; i < tam; i++) {
            soma+=(((int) key.charAt(i)) << (i%8));
        }
        return Math.abs(soma) % N;
    }

    public addInHash(carro car) {

    } 
}
