package Cesmac.Ads.POO.EA.Cinema2;

import java.util.Scanner;

public class IngressoVip extends Ingressos implements IticketLanchonete {
    private static int vipInteira= 48;
    private static int vipMeia= 24;

    private static double valorTotalVIP = 0;
    private static double qtdIngressosVip = 0;

    public static void setQtdIngressosVip(double qtdIngressosVip) {
        IngressoVip.qtdIngressosVip = qtdIngressosVip;
    }

    public static double getValorTotalVIP() {
        return valorTotalVIP; }

    public static void setVipInteira() {
        valorTotalVIP = vipInteira * qtdIngressosVip;
    }

    public static void setVipMeia() {
        valorTotalVIP = vipMeia * qtdIngressosVip;
    }

    @Override
    public void ticket_Lanchonete() {
        System.out.println("Com a compra deste ingresso o acesso a lanchonete é liberado.");}
}
