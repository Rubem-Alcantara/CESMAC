import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        //Vetores
        String[] filmes = {"", "Pantera Negra: Wakanda Para Sempre", "Mulher Rei", "One Piece Film: Red", "Adão Negro"};
        String[] sessoes = {"", "Sala 01 - 18:30", "Sala 02 - 19:30", "Sala 03 - 20:30", "Sala 04 - 21:30"};

        //Menu
        System.out.println("----------------Em Cartaz----------------");
        for (int i = 1; i < filmes.length; i++) {
            System.out.println(i+" "+filmes[i]);
        }
        System.out.println("-----------------------------------------");
        System.out.print("Digite a opção do filme que deseja assistir: ");
        Integer filme = input.nextInt();

        System.out.println("\nSessões disponíveis: ");
        for (int i = 1; i < sessoes.length; i++) {
            System.out.println(i + " " + sessoes[i]);
        }
        System.out.print("\nEscolha a sessão: ");
        int sessao = input.nextInt();

        double inteiro = 32.00;
        double Meia = 16.00;
        System.out.println("\nSelecione o tipos de ingresso:\nInteira - R$ 32,00\nMeia - R$ 16,00");
        System.out.print("\nQuantidade de ingressos inteiro: ");
        int QtdInteiro = input.nextInt();
        System.out.print("Quantidade de ingressos meia: ");
        int QtdMeia = input.nextInt();

        double total = (QtdInteiro * inteiro)+(QtdMeia * Meia);

        System.out.println("\nResumo do pedido: ");
        System.out.println("Filmes escolhido: "+filmes[filme]);
        System.out.println("Sessão escolhida: "+sessoes[sessao]);
        System.out.println("Valor total a ser pago: R$ "+String.format("%.2f",total));


    }
}