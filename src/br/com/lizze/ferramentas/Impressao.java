package br.com.lizze.ferramentas;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.util.List;

/**
 *
 * @author lizze
 */
public class Impressao {

    public void imprimirBalcao(List lista, List qtd, List toal) {
        Frame f = new Frame("Frame temporário");
        f.pack();
        Toolkit tk = f.getToolkit();
        PrintJob pj = tk.getPrintJob(f, "MP4200", null);

        if (pj != null) {
            Graphics g = pj.getGraphics();
            int y = 135;
            int q = 135;
            int t = 135;

            g.setFont(new Font("Arial", Font.PLAIN, 8));

            g.drawString("LIZZE EQUIPAMENTOS", 55, 10);
            g.drawString("CNPJ: 09.356.580/0001-29", 50, 20);
            g.drawString("FONE/FAX: (44) 3016-4603", 49, 30);
            g.drawString("DOCUMENTO NÃO FISCAL", 48, 60);
            g.drawString("EMISSÃO", 3, 90);
            g.drawString("HORA", 100, 90);

            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("--------------------------------------------------------------", 3, 100);
            g.setFont(new Font("Arial", Font.PLAIN, 8));
            g.drawString("FATURAMENTO", 3, 110);
            g.drawString("CAIXA", 120, 110);
            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("--------------------------------------------------------------", 3, 120);

            g.setFont(new Font("Arial", Font.PLAIN, 7));
            g.drawString("ITENS", 3, 125);
            g.drawString("QTDE", 115, 125);
            g.drawString("VL.UN", 145, 125);
            g.drawString("TOTAL", 180, 125);

            g.setFont(new Font("Arial", Font.PLAIN, 7));

            for (int i = 0; i < lista.size(); i++) {

                g.drawString("" + lista.get(i), 3, y);
                y += 10;
            }
            for (int i = 0; i < qtd.size(); i++) {

                g.drawString("" + qtd.get(i), 115, q);
                q += 10;
            }
            for (int i = 0; i < toal.size(); i++) {

                g.drawString("" + toal.get(i), 180, t);
                t += 10;
            }
            
            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("--------------------------------------------------------------", 3, 300);
            g.setFont(new Font("Arial", Font.PLAIN, 7));
            g.drawString("TOTAL ", 145, 305);

            g.setFont(new Font("Arial", Font.PLAIN, 8));
            g.drawString("VENDEDOR ", 5, 320);
            g.drawString("CAIXA ", 5, 330);
            g.drawString("FORMA PGMT ", 5, 340);

            g.setFont(new Font("Arial", Font.PLAIN, 7));
            g.drawString("ESTE CUPOM É VALIDO PARA", 50, 360);
            g.drawString("A GARANTIA DO PRODUTO", 55, 370);

            g.drawString("OBRIGADO PELA PREFERENCIA", 45, 390);
            g.drawString("PARA MAIS INFORMAÇÕES ACESSE:", 40, 420);
            g.drawString("WWW.LIZZE.COM.BR", 65, 410);

            g.dispose();

            pj.end();
        }

      


    }
}
