package Cesmac.Ads.POO.EA.Cinema2;

public class Filmes {
    private static int filmeEscolhido;
    private static boolean filmes3D;
    private static int sessaoEscolhida;
    static String[][] filmes = {{"Nome: Pantera Negra: Wakanda Para Sempre", "Diretor: Ryan Coogler", "Descrição: 2° Filme do UCM contando a historia do Pantera Negra", "Gênero: Ação/Aventura", "Duração: 2h 41m"},
            {"Nome: A Mulher Rei", "Diretor: Gina Prince-Bythewood", "Descrição: Um grupo de mulheres guerreiras para proteger o reino africano", "Gênero: Ação/Drama", "Duração: 2h 14m"},
            {"Nome: One Piece film - Red", "Diretor: Diretor: Gorō Taniguchi", "Descrição: Filme do menino que estica", "Gênero: Aventura/Ação", "Duração: 1h 55m"},
            {"Nome: Adão Negro [3D]", "Diretor: Jaume Collet-Serra", "Descrição: O poderoso Adão Negro é libertado de sua tumba para lançar sua justiça cruel sobre a Terra.", "Gênero: Ação/Aventura", "Duração: 2h 5m"},
            {"Nome: Força Bruta [3D]", "Diretor: Sang-yong Lee", "Descrição: Ao cumprir uma extradição de um suspeito em outro país, o detetive MA e o Capitão Jeon Il-Man tomam ciência de Hae-Sang, um assassino que aterroriza turistas há vários anos.", "Gênero: Ação", "Duração: 106m"}};
    static String[] sessoes = {"", "Sala 01 - 18:30", "Sala 02 - 19:30", "Sala 03 - 20:30", "Sala 04 - 21:30"};
    public static void getfilmes(boolean filme3D) {
        filmes3D = filme3D;
        if (filmes3D == false) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 0)
                        System.out.println("["+(j + 1)+"]"+ " " + filmes[j][0].substring(6));
                }
            }
        } else {
            for (int i = 0; i < 5; i++) {
                for (int j = 3; j < 5; j++) {
                    if (i == 0)
                        System.out.println("["+(j - 2)+"]"+ " " + filmes[j][0].substring(6));
                }
            }
        }
    }
    public static void getsessoes() {
        for (int i = 1; i < sessoes.length; i++) {
            System.out.println(sessoes[i]);
        }
    }

    public static void setFilmeEscolhido(int filmeEscolhido) {
        Filmes.filmeEscolhido = filmeEscolhido;
    }

    public static String getSessaoEscolhida() {
        return sessoes[sessaoEscolhida];
    }

    public static void setSessaoEscolhida(int sessaoEscolhida) {
        Filmes.sessaoEscolhida = sessaoEscolhida;
    }

    public static void resumoFilme() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {
                    if (filmes3D == false)
                        System.out.println(filmes[filmeEscolhido - 1][j]);
                    else
                        System.out.println(filmes[filmeEscolhido + 2][j]);
                }
            }
        }
    }

    public static void filmesVip() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0)
                    System.out.println("["+(j + 1)+"]" + " " + filmes[j][0].substring(6));
            }
        }
    }
}

