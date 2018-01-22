package br.com.lizze.ferramentas;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * @author Diego Massaneiro
 */
public class ValidaCampoNumero1 extends PlainDocument {

    private int quantidadeMax;

    public ValidaCampoNumero1(int maxLen) {
        super();
        if (maxLen <= 0) {
            throw new IllegalArgumentException("Especifique a Quantidade");

        }
        quantidadeMax = maxLen;
    }

    public ValidaCampoNumero1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
        throws BadLocationException {
            if (str == null || getLength() == quantidadeMax) 
                return;
                int totalquantia = (getLength()+str.length());
                if (totalquantia <= quantidadeMax) {
                    super.insertString(offset, str.replaceAll("[^0-9|^.^,]", ""), attr);
                    return;
                }
                String nova = str.substring(0, getLength() - quantidadeMax);
                super.insertString(offset, nova, attr);

            }

        }

//Campol.setDocument (new LimiteDigitos(5))
