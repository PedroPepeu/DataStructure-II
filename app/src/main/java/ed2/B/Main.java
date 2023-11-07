package ed2.B;

import java.util.Scanner;

public class Main {

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o grau:");
        int grau = sc.nextInt();
        while(!isPofTwo(grau)) {
            grau = sc.nextInt();
        }

        Btree<Integer> bt = new Btree<>(null, grau);
        while(true) {
            System.out.println("1 para parar, 2 para inserir, 3 para deletar, 4 para ...");
            int des = sc.nextInt();
            switch (des) {
                case 1:
                    
                    break;
                
                case 2:

                    break;

                case 3:

                    break;
            

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                
                default:
                    break;
            }
        }
    }
    
    private boolean isPofTwo(long x) {
        x = x-1;
        long l = 2;
        for(int i = 0; i < 60; i++) {
            if(l == x) {
                return true;
            }
            l*=2;
        }
        return false;
    }
}
