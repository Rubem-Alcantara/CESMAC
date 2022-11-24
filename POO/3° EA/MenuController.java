package Cesmac.Ads.POO.EA.Cinema2;

import java.util.Scanner;

public class MenuController {
    static Scanner input = new Scanner(System.in);
    static Ingressos ingresso = new Ingressos();
    static IngressoVip ingressovip = new IngressoVip();
    public static void menu() {
        System.out.println("------------------------------");
        System.out.println("         CIRIUS CINE"         );
        System.out.println("------------------------------");
        System.out.println("Seja bem vindo ao menu do Cirius Cine.\nO que vamos fazer hoje?\n");
        System.out.println("[1] Ver filmes em cartaz");
        System.out.println("[2] Comprar ingressos");
        System.out.println("[3] Sair");
    }
    public static void telaFilmes() {
        System.out.println("\nEscolha o tipo de filme que você quer assistir: ");
        System.out.println("[1] Filmes 2D");
        System.out.println("[2] Filmes 3D");
        System.out.print("Digite a opção do tipo de filme: ");
        int tipoDeFilme = input.nextInt();

        if (tipoDeFilme == 1) {
            System.out.println("");
            System.out.println("Estes são os filmes 2D's em cartaz");
            Filmes.getfilmes(false);
            try {Thread.currentThread().sleep(6000);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("\nEstaremos retornando para o menu inicial.\n");
            try {Thread.currentThread().sleep(4000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }else{
            System.out.println("");
            System.out.println("Estes são os filmes 3D's em cartaz");
            Filmes.getfilmes(true);
            try {Thread.currentThread().sleep(6000);}catch(InterruptedException e){throw new RuntimeException(e);}
            System.out.println("\nEstaremos retornando para o menu inicial.\n");
            try {Thread.currentThread().sleep(4000);}catch(InterruptedException e){throw new RuntimeException(e);}
        }
    }
    private static void compraIngresso(){
        System.out.println("----------------------");
        System.out.println("   Ingresso *Comum*   ");
        System.out.println("----------------------");
        ingresso.ticket_Lanchonete();
        System.out.print("\nInforme a quantidade de ingressos: ");
        ingresso.setQtdIngressos(input.nextInt());

        System.out.print("\nDigite o tipo de ingresso: \n[1] Inteira - R$ 24,00\n[2] Meia - R$ 12,00 ");
        int tipodeingresso = input.nextInt();
            if (tipodeingresso == 1){
                ingresso.setInteira();
            }else{
                ingresso.setMeia();
            }
        System.out.println("\nEstes são os filmes 2D's em cartaz");
        Filmes.getfilmes(false);
        System.out.print("Qual o filme que você deseja assistir?");
        Filmes.setFilmeEscolhido(input.nextInt());

        System.out.println("\nEstas são as sessões disponíveis:");
        Filmes.getsessoes();
        System.out.print("Digite a sessão que deseja assistir: ");
        Filmes.setSessaoEscolhida(input.nextInt());

    }
    public static void compraIngressoVip() {
        System.out.println("--------------------");
        System.out.println("   Ingresso *VIP*   ");
        System.out.println("--------------------");
        System.out.println("Ingressos vip's te permitem assistir todos os filmes que estão em cartaz.");
        ingressovip.ticket_Lanchonete();
        System.out.print("\nInforme a quantidade de ingressos vips que deseja comprar: ");
        ingressovip.setQtdIngressosVip(input.nextInt());

        System.out.print("\nDigite o tipo de ingresso: \n[1] Inteira - R$ 48,00\n[2] Meia - R$ 24,00 ");
        int tipodeingresso = input.nextInt();
        if (tipodeingresso == 1){
            ingressovip.setVipInteira();
        }else{
            ingressovip.setVipMeia();
        }
        System.out.println("\nEstes são os filmes em cartaz");
        Filmes.filmesVip();
        System.out.print("Digite a opção do filme que deseja assistir: ");
        Filmes.setFilmeEscolhido(input.nextInt());

        System.out.println("\nEstas são as sessões disponíveis:");
        Filmes.getsessoes();
        System.out.print("Digite a sessão que deseja assistir: ");
        Filmes.setSessaoEscolhida(input.nextInt());

    }
    public static void comprovante(){
        System.out.println("\nAqui esta um resumo do seu pedido: ");
        System.out.print("Filme escolhido\n");
        Filmes.resumoFilme();
        System.out.println("Sessão escolhida: "+ Filmes.getSessaoEscolhida());
        System.out.println("Valor total: R$ "+(ingresso.getValorTotal()+ingressovip.getValorTotalVIP()));

    }
    public static void caixa() {

        System.out.println("\nSelecione o tipo de ingresso:\n[1] Comum \n[2] Vip");
        System.out.print("Digite a opção: ");
        int tipodeingresso = input.nextInt();

        if (tipodeingresso == 1){
            compraIngresso();
            comprovante();
        }else {
            compraIngressoVip();}
            comprovante();
    }

    public static void main (String[]args){
        int opcao = 0;
        do {
            menu();
            System.out.print("Digite a opção do que deseja fazer: ");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    telaFilmes();
                    break;
                case 2:
                    caixa();
                    opcao = 3;
                    break;
                case 3:
                    break;
                default:
                    System.err.println("A opção escolhida não existe!");
            }
        } while (opcao != 3);
    }
}

