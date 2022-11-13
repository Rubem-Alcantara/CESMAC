package Cesmac.Ads.POO.EA;

import javax.swing.*;
import java.util.Scanner;

public class Main extends MenuController{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        MenuController Menu = new MenuController();
        Menu.menu();
        System.out.print("Digite a opção do filme que deseja assistir: ");
        Menu.setMenu(input.nextInt());

        Menu.resumoFilme();

        MenuController Sessao = new MenuController();
        Sessao.sessao();

        System.out.print("\nEscolha a sessão: ");
         Menu.setSessaoEscolhida(input.nextInt());

        Menu.bilheteria();
        Menu.comprovante();
    }
}
