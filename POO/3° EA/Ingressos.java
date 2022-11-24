package Cesmac.Ads.POO.EA.Cinema2;

import java.util.Scanner;
public class Ingressos implements IticketLanchonete{
    private static int inteira = 24;
    private static int meia = 12;
    private static int qtdIngressos = 0;
    private static double valorTotal = 0;
    public static void setInteira() {
         valorTotal = inteira*qtdIngressos ;
    }
    public static void setMeia() {
        valorTotal = meia * qtdIngressos;
    }
    public static void setQtdIngressos(int qtdIngressos) {
        Ingressos.qtdIngressos = qtdIngressos;
    }
    public static double getValorTotal() {
        return valorTotal;
    }
    @Override
    public void ticket_Lanchonete() {
        System.out.println("O ingresso do tipo comum, não permite acesso a lanchonete. Para ter acesso liberado, adquira o ingresso vip.");
    }
}
