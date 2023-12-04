package ed2.Hash;

import java.util.Scanner;

public class main {
    Scanner sc = new Scanner (System.in);
    hashtable hash = new hashtable(101);

    while(true) {
        System.out.println("1-Novo carro\n2-Escolher carro para exibir\n3-Mostrar todos os carros\n4-sair");
        int op = sc.nextInt();
        
        while(op>3 && op<1) {
            System.out.println("Nao existe esta opcao..");
            System.out.println("1-Novo carro\n2-Escolher carro para exibir\n3-Mostrar todos os carros\n4-sair");
            op = sc.nextInt();
        }

        String plate, brand, model, color, register;
        boolean out = false;
        switch (op) {
            case 1: // new car
                System.out.println("Insira a placa: ");
                plate = sc.nextLine();
                
                System.out.println("Insira a marca: ");
                brand = sc.nextLine();
                
                System.out.println("Insira o modelo: ");
                model = sc.nextLine();
                
                System.out.println("Insira a cor: ");
                color = sc.nextLine();
                
                System.out.println("Insira o registro: ");
                register = sc.nextLine();
                break;

            case 2:
                System.out.println("Insira a placa: ");
                plate = sc.nextLine();
                //search
                break;

            case 3:
                //show all
                break;

            case 4:
                out = true;
                break;
        }

        if(out) break;
    }

    sc.close();
}