/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lizze.Visao;

import br.com.lizze.Dao.VendaDao;
import br.com.lizze.Dao.VendaProdutoDao;
import br.com.lizze.ferramentas.Impressao;
import br.com.lizze.ferramentas.MinhasDatas;
import br.com.lizze.ferramentas.RetornaDescricao;
import br.com.lizze.ferramentas.ValidaCampoNumero1;
import br.com.lizze.modelo.Produto;
import br.com.lizze.modelo.Venda;
import br.com.lizze.modelo.VendaProduto;
import br.com.lizze.modelo.Vendedor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizze
 */
public class Vendas extends javax.swing.JFrame {

    RetornaDescricao retorna = new RetornaDescricao();
    Venda vendas = new Venda();
    VendaProduto vendaProduto = new VendaProduto();
    Produto pr = new Produto();

    VendaDao vendaDao = new VendaDao();
    VendaProdutoDao vendaProdutoDao = new VendaProdutoDao();

    MinhasDatas datas = new MinhasDatas();

    DecimalFormat df = new DecimalFormat("#,###.00"); 

    Date data = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");

    public Vendas() {
        initComponents();
        txtIdVendedora.requestFocus();

        txtHora.setText(hora.format(data));
        txtDataVenda.setText(formatador.format(data));

        int numerinho = 0;
        txtCheque.setText(Integer.toString(numerinho));
        txtDebito.setText(Integer.toString(numerinho));
        txtDebito.setText(Integer.toString(numerinho));

        //bloqueia campos
        txtNomeCaixa.setEditable(false);
        txtIdFeira.setEditable(false);
        txtNomeFeira.setEditable(false);
        txtNomeVendedora.setEditable(false);
        txtTotal.setEditable(false);
        txtNomeProduto.setEditable(false);
        txtTroco.setEditable(false);
        txtHora.setEditable(false);

        //valida os campo
        txtCodigoVenda.setDocument(new ValidaCampoNumero1(5));
        txtIdProduto.setDocument(new ValidaCampoNumero1(5));
        txtIdVendedora.setDocument(new ValidaCampoNumero1(5));
        txtNovoValor.setDocument(new ValidaCampoNumero1(15));
        txtDebito.setDocument(new ValidaCampoNumero1(15));
        //txtCartao.setDocument(new ValidaCampoNumero1(15));
        txtCheque.setDocument(new ValidaCampoNumero1(15));
        txtDesconto.setDocument(new ValidaCampoNumero1(15));
        txtDescontoPorcento.setDocument(new ValidaCampoNumero1(15));
        txtQuantidade.setDocument(new ValidaCampoNumero1(8));
        txtValor.setDocument(new ValidaCampoNumero1(10));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Cadastro = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtCodigoVenda = new javax.swing.JTextField();
        txtDataVenda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIdCaixa = new javax.swing.JTextField();
        txtNomeCaixa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdFeira = new javax.swing.JTextField();
        txtNomeFeira = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdVendedora = new javax.swing.JTextField();
        txtNomeVendedora = new javax.swing.JTextField();
        ComboSituacao = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();
        txtNomeProduto = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        Adicionar = new javax.swing.JButton();
        remover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaVenda = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtDesconto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescontoPorcento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNovoValor = new javax.swing.JTextField();
        radio2 = new javax.swing.JRadioButton();
        radio = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtTroco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtTotal = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtDebito = new javax.swing.JTextField();
        txtDinheiro = new javax.swing.JTextField();
        txtCheque = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Vendas");

        Cadastro.setToolTipText("");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        txtCodigoVenda.setBackground(new java.awt.Color(204, 204, 204));
        txtCodigoVenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));

        txtDataVenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));

        jLabel1.setText("Caixa");

        txtIdCaixa.setBackground(new java.awt.Color(204, 204, 204));
        txtIdCaixa.setText("2");

        txtNomeCaixa.setBackground(new java.awt.Color(204, 204, 204));
        txtNomeCaixa.setText("GUILHERME");
        txtNomeCaixa.setToolTipText("");
        txtNomeCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCaixaActionPerformed(evt);
            }
        });

        jLabel2.setText("Feira");

        txtIdFeira.setBackground(new java.awt.Color(153, 255, 255));
        txtIdFeira.setText("1");
        txtIdFeira.setName("id"); // NOI18N
        txtIdFeira.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFeiraFocusLost(evt);
            }
        });

        txtNomeFeira.setText("HAIR BRASIL 2017");
        txtNomeFeira.setName("nome"); // NOI18N

        jLabel3.setText("Vendedor");

        txtIdVendedora.setBackground(new java.awt.Color(153, 255, 255));
        txtIdVendedora.setName("id"); // NOI18N
        txtIdVendedora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdVendedoraFocusLost(evt);
            }
        });
        txtIdVendedora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdVendedoraMouseClicked(evt);
            }
        });
        txtIdVendedora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdVendedoraActionPerformed(evt);
            }
        });

        txtNomeVendedora.setName("nome"); // NOI18N

        ComboSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONCLUIDA", "CANCELADA" }));

        jLabel10.setText("Status");

        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora"));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(15, 15, 15)
                                .addComponent(txtIdVendedora, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeVendedora, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdFeira, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeFeira, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(ComboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomeFeira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdFeira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdVendedora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeVendedora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        jLabel5.setText("Codigo");

        txtIdProduto.setBackground(new java.awt.Color(153, 255, 255));
        txtIdProduto.setName("id"); // NOI18N
        txtIdProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdProdutoFocusLost(evt);
            }
        });
        txtIdProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdProdutoMouseClicked(evt);
            }
        });

        txtNomeProduto.setName("nome"); // NOI18N

        txtQuantidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Qtde"));
        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });

        Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/inserir.png"))); // NOI18N
        Adicionar.setText("Adicionar");
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });

        remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remover.png"))); // NOI18N
        remover.setText("Remover");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        TabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sel", "Cod.Produto", "Descrição", "Vl.Unit", "Qtde.", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaVenda);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar_1.png"))); // NOI18N
        jButton3.setText("Gravar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        jButton4.setText("Novo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jButton5.setText("Sair");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir.png"))); // NOI18N
        jButton6.setText("Imprimir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtDesconto.setText("0");
        txtDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescontoFocusLost(evt);
            }
        });

        jLabel7.setText("Total da Venda");

        txtDescontoPorcento.setText("0");
        txtDescontoPorcento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescontoPorcentoFocusLost(evt);
            }
        });
        txtDescontoPorcento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDescontoPorcentoMouseClicked(evt);
            }
        });
        txtDescontoPorcento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescontoPorcentoActionPerformed(evt);
            }
        });

        jLabel9.setText("Tipo Pagamento");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Total a Pagar");

        txtNovoValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        radio2.setText("Desconto em %");
        radio2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio2MouseClicked(evt);
            }
        });

        radio.setText("Desconto em R$");
        radio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setText("Troco");

        txtTroco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jButton1.setText("Editar Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        txtValor.setBorder(javax.swing.BorderFactory.createTitledBorder("Vl.Unit"));

        jButton2.setText("Somar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtDebito.setBackground(new java.awt.Color(255, 255, 153));
        txtDebito.setText("0");
        txtDebito.setName("id"); // NOI18N
        txtDebito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDebitoFocusLost(evt);
            }
        });
        txtDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDebitoActionPerformed(evt);
            }
        });

        txtDinheiro.setBackground(new java.awt.Color(255, 255, 153));
        txtDinheiro.setText("0");
        txtDinheiro.setName("id"); // NOI18N
        txtDinheiro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDinheiroFocusLost(evt);
            }
        });
        txtDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDinheiroActionPerformed(evt);
            }
        });

        txtCheque.setBackground(new java.awt.Color(255, 255, 153));
        txtCheque.setText("0");
        txtCheque.setName("id"); // NOI18N
        txtCheque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtChequeFocusLost(evt);
            }
        });
        txtCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChequeActionPerformed(evt);
            }
        });

        jLabel8.setText("Dinheiro");

        jLabel11.setText("Debito");

        jLabel12.setText("Credito");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(Adicionar)
                        .addGap(18, 18, 18)
                        .addComponent(remover)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radio2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescontoPorcento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNovoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radio2)
                    .addComponent(txtDescontoPorcento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNovoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(jButton1)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout CadastroLayout = new javax.swing.GroupLayout(Cadastro);
        Cadastro.setLayout(CadastroLayout);
        CadastroLayout.setHorizontalGroup(
            CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        CadastroLayout.setVerticalGroup(
            CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastrar Venda", Cadastro);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdVendedoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdVendedoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdVendedoraActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtIdProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdProdutoFocusLost
        txtNomeProduto.setText(retorna.retornadados(txtIdProduto, "produtos", "nome"));
        txtValor.setText(retorna.retornadados(txtIdProduto, "produtos", "valor"));
        //txtQuantidade.requestFocus();


    }//GEN-LAST:event_txtIdProdutoFocusLost

    private void txtIdFeiraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFeiraFocusLost
        txtNomeFeira.setText(retorna.retornadados(txtIdFeira, "feira", "nome"));
    }//GEN-LAST:event_txtIdFeiraFocusLost

    private void txtIdVendedoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdVendedoraFocusLost
        txtNomeVendedora.setText(retorna.retornadados(txtIdVendedora, "vendedor", "nome"));

        txtIdProduto.grabFocus();


    }//GEN-LAST:event_txtIdVendedoraFocusLost

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed

        if (txtQuantidade.getText().equals("") || txtValor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Os campos quantidade e valor devem ser preenchidos!");
            txtQuantidade.grabFocus();
        }
        double tot = 0;

        incluir_produtos();
     
       // df.format(1234.36);

        txtTotal.setText(calculaTotalProdutos());
        txtNovoValor.setText(calculaTotalProdutos());


    }//GEN-LAST:event_AdicionarActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) TabelaVenda.getModel();
        int totlinha = TabelaVenda.getRowCount();
        int i = 0;
        Boolean sel = false;

        int opcao = JOptionPane.showConfirmDialog(null,
                "Deseja remover os produtos selecionadas ? ", "Remover",
                JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            for (i = totlinha - 1; i >= 0; i--) {
                Boolean selecionado = (Boolean) TabelaVenda.getValueAt(i, 0);
                if (selecionado == true) {
                    sel = true;

                    tabela.removeRow(i);
                    txtTotal.setText(calculaTotalProdutos());
                    txtNovoValor.setText(calculaTotalProdutos());
                }
            }
            if (!sel == true) {
                JOptionPane.showMessageDialog(null, "Nao ha nenhum registro selecionado !");
            }
        }

    }//GEN-LAST:event_removerActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String datacom = txtDataVenda.getText();
        String idvend = txtIdVendedora.getText();

//        if (idvend.equals("")) {
//
//            JOptionPane.showMessageDialog(null, "O Campo Vendedora dever ser selecionado\n"
//                    + "Não foi Possivel Gravar");
//        }
        if (radio.isSelected() == false && radio2.isSelected() == false) {

            JOptionPane.showMessageDialog(null, "O Campo Tipo de Desconte dever ser selecionado\n"
                    + "Não foi Possivel Gravar");
            radio.setSelected(true);
            txtDescontoPorcento.setEditable(false);
            txtDesconto.setText("0");
            txtDinheiro.setText("0");
            txtDebito.setText("0");
            txtCheque.setText("0");
            txtDesconto.setEditable(true);

            radio2.setSelected(false);

            if (txtIdVendedora.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O Campo Vendedor dever ser selecionado\n"
                        + "Não foi Possivel Gravar");
            }
        } else {

            try {
                vendas.setData(datas.formataDataRetornaBD(datacom));
            } catch (ParseException ex) {
                Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
            }
            vendas.setValor(Double.parseDouble(txtTotal.getText()));
            vendas.setTotal(Double.parseDouble(txtNovoValor.getText()));
            vendas.getUsuario().setId(Integer.parseInt(txtIdCaixa.getText()));
            vendas.getVendedor().setId(Integer.parseInt(txtIdVendedora.getText()));
            vendas.getFeira().setId(Integer.parseInt(txtIdFeira.getText()));
            vendas.setDinheiro(txtDinheiro.getText());
            vendas.setDebito(txtDebito.getText());
            vendas.setCredito(txtCheque.getText());

            if (radio.isSelected()) {
                vendas.setDesconto(Double.parseDouble(txtDesconto.getText()));

            } else {
                vendas.setDesconto(Double.parseDouble(txtDescontoPorcento.getText()));
            }

            if (ComboSituacao.getSelectedIndex() != 0) {
                vendas.setStatus("CANCELADO");
            } else {
                vendas.setStatus("CONCLUIDO");
            }

            vendaDao.SalvarVenda(vendas);
            try {
                txtCodigoVenda.setText(vendaDao.ultimasequencia("venda", "id"));
                //gravaiProduto();
            } catch (SQLException ex) {
                Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
            }

            gravaiProduto();
            int sair = JOptionPane.showConfirmDialog(null, "Deseja Imprimir Cupom ?");
            if (sair == JOptionPane.YES_OPTION) {
                capturaProduto();
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtCodigoVenda.setText("");
        txtIdVendedora.setText("");
        txtNomeVendedora.setText("");
        txtIdProduto.setText("");
        txtNomeProduto.setText("");
        txtQuantidade.setText("");
        txtTotal.setText("");
        txtValor.setText("");

        txtDesconto.setText("");
        txtNovoValor.setText("");
        txtDescontoPorcento.setText("");
        txtCodigoVenda.setText("");

        txtDebito.setText("");
        txtDebito.setText("");
        txtCheque.setText("");

        txtTroco.setText("");
        txtHora.setText("");

        limpaTabela();

        Vendas nomeVariavel = new Vendas();
        nomeVariavel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtIdProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdProdutoMouseClicked

        Produto v = new Produto();
        if (evt.getClickCount() == 2) {
            final ConsultaProdutos consultaprod = new ConsultaProdutos(this, true, v);
            consultaprod.setVisible(true);

            consultaprod.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    txtIdProduto.setText(Integer.toString(v.getId()));
                    txtNomeProduto.setText(v.getNome());
                }
            });
        }


    }//GEN-LAST:event_txtIdProdutoMouseClicked

    private void txtIdVendedoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdVendedoraMouseClicked

        Vendedor v = new Vendedor();
        if (evt.getClickCount() == 2) {
            final ConsultaVendedora consultaforma = new ConsultaVendedora(this, true, v);
            consultaforma.setVisible(true);

            consultaforma.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    txtIdVendedora.setText(Integer.toString(v.getId()));
                    txtNomeVendedora.setText(v.getNome());
                }
            });
        }

    }//GEN-LAST:event_txtIdVendedoraMouseClicked

    private void txtDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescontoFocusLost

        double desconto = Double.parseDouble(txtDesconto.getText());
        double total = Double.parseDouble(txtNovoValor.getText());

        txtNovoValor.setText(Double.toString(total - desconto));

    }//GEN-LAST:event_txtDescontoFocusLost

    private void txtDescontoPorcentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescontoPorcentoMouseClicked


    }//GEN-LAST:event_txtDescontoPorcentoMouseClicked

    private void radioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioMouseClicked
        if (evt.getClickCount() == 1) {

            radio.setSelected(true);
            txtDescontoPorcento.setEditable(false);
            txtDesconto.setText("0");
            txtDinheiro.setText("0");
            txtDebito.setText("0");
            txtCheque.setText("0");
            txtDesconto.setEditable(true);

            radio2.setSelected(false);

        }


    }//GEN-LAST:event_radioMouseClicked

    private void radio2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio2MouseClicked
        if (evt.getClickCount() == 1) {

            radio2.setSelected(true);
            txtDesconto.setEditable(false);
            txtDescontoPorcento.setText("0");
            txtDinheiro.setText("0");
            txtDebito.setText("0");
            txtCheque.setText("0");
            txtDescontoPorcento.setEditable(true);

            radio.setSelected(false);

        }
    }//GEN-LAST:event_radio2MouseClicked

    private void txtDescontoPorcentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescontoPorcentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescontoPorcentoActionPerformed

    private void txtDescontoPorcentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescontoPorcentoFocusLost
        double desconto = Double.parseDouble(txtDescontoPorcento.getText());
        double total = Double.parseDouble(txtNovoValor.getText());

        txtNovoValor.setText(Double.toString(total - ((total * desconto) / 100)));
        txtDesconto.setText("");

    }//GEN-LAST:event_txtDescontoPorcentoFocusLost

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        capturaProduto();


    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtNomeCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCaixaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtCodigoVenda.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Codigo da Venda Deve ser Preenchido!");
            txtCodigoVenda.grabFocus();
        }

        vendas.setId(Integer.parseInt(txtCodigoVenda.getText()));
        if (ComboSituacao.getSelectedIndex() != 0) {
            vendas.setStatus("CANCELADO");
        } else {
            vendas.setStatus("CONCLUIDO");
        }

        vendaDao.update(vendas);

        Vendas nomeVariavel = new Vendas();
        nomeVariavel.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        double total = Double.parseDouble(txtNovoValor.getText());

        double dinheiro = Double.parseDouble(txtDinheiro.getText());
        double debito = Double.parseDouble(txtDebito.getText());
        double credito = Double.parseDouble(txtCheque.getText());

        txtTroco.setText(Double.toString(dinheiro + debito + credito - total));

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDebitoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDebitoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDebitoFocusLost

    private void txtDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDebitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDebitoActionPerformed

    private void txtChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChequeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChequeActionPerformed

    private void txtChequeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtChequeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChequeFocusLost

    private void txtDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDinheiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDinheiroActionPerformed

    private void txtDinheiroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDinheiroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDinheiroFocusLost

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost
        Adicionar.grabFocus();

    }//GEN-LAST:event_txtQuantidadeFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JPanel Cadastro;
    private javax.swing.JComboBox<String> ComboSituacao;
    private javax.swing.JTable TabelaVenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton radio;
    private javax.swing.JRadioButton radio2;
    private javax.swing.JButton remover;
    private javax.swing.JTextField txtCheque;
    private javax.swing.JTextField txtCodigoVenda;
    private javax.swing.JTextField txtDataVenda;
    private javax.swing.JTextField txtDebito;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtDescontoPorcento;
    private javax.swing.JTextField txtDinheiro;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIdCaixa;
    private javax.swing.JTextField txtIdFeira;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtIdVendedora;
    public static javax.swing.JTextField txtNomeCaixa;
    private javax.swing.JTextField txtNomeFeira;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtNomeVendedora;
    private javax.swing.JTextField txtNovoValor;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JFormattedTextField txtTotal;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
public void incluir_produtos() {

        DefaultTableModel TabelaServico = (DefaultTableModel) TabelaVenda.getModel();
        double soma = 0;
        int totalLinha = TabelaVenda.getRowCount();
        int situacao = 0;
        int conta = 0;
        int index = 0;

        for (int i = 1; i <= totalLinha; i++) {
            String cd_servico = (String) TabelaVenda.getValueAt(conta, 1);
            if (txtIdProduto.getText().equals(cd_servico)) {
                int opcao_escolhida = JOptionPane.showConfirmDialog(null, "Produto ja Cadastrado, "
                        + "deseja alterar "
                        + "Quantidade e valor?",
                        "Alteração ", JOptionPane.YES_NO_OPTION);
                if (opcao_escolhida == JOptionPane.YES_OPTION) {
                    situacao = 1;
                    index = conta;
                } else {
                    return;
                }
            }
            conta = conta + 1;
        }

        int x = TabelaVenda.getRowCount();
        double soma2 = 0;
        if (situacao == 0) {
            // inclusao incluir os dados na tabela servicos
            TabelaServico.setNumRows(x + 1);
            TabelaServico.setValueAt((false), x, 0);

            TabelaServico.setValueAt(txtIdProduto.getText(), x, 1);
            TabelaServico.setValueAt(txtNomeProduto.getText(), x, 2);
            TabelaServico.setValueAt(txtValor.getText(), x, 3);
            TabelaServico.setValueAt(txtQuantidade.getText(), x, 4);

            soma = Double.parseDouble(txtValor.getText().replaceAll(",", "."))
                    * Double.parseDouble(txtQuantidade.getText().replaceAll(",", "."));
            soma2 = soma + soma2;
            // jTFtotalProduto.setText(Double.toString(soma));
            TabelaServico.setValueAt(soma, x, 5);

            //depois disso limpa campos
            txtIdProduto.setText("");
            txtNomeProduto.setText("");
            txtQuantidade.setText("");
            txtValor.setText("");

        } else if (situacao == 1) {
            // altera os dados da tabela se tiver os mesmo dado adcionado
            TabelaServico.setValueAt(txtQuantidade.getText(), index, 4);
            TabelaServico.setValueAt(txtValor.getText(), index, 5);

            soma = Double.parseDouble(txtValor.getText().replaceAll(",", "."))
                    * Double.parseDouble(txtQuantidade.getText());
            TabelaServico.setValueAt(soma, index, 6);

            soma2 = soma + soma2;
            //depois disso limpa campos
            txtIdProduto.setText("");
            txtNomeProduto.setText("");
            txtQuantidade.setText("");
            txtValor.setText("");

        }
        // txtTotal.setText(Double.toString(soma2));

    }

    //grava os itens da tabela produto
    public void gravaiProduto() {
        int conta = TabelaVenda.getRowCount();
        for (int i = 0; i < conta; i++) {
            String produto = (String) TabelaVenda.getValueAt(i, 1);
            String qtd = (String) TabelaVenda.getValueAt(i, 4);
            Double valor = (Double) TabelaVenda.getValueAt(i, 5);

            String data = txtDataVenda.getText();

            vendaProduto.getVenda().setId(Integer.parseInt(txtCodigoVenda.getText()));
            vendaProduto.getProduto().setId(Integer.parseInt(produto));
            vendaProduto.setQtd(Integer.parseInt(qtd));
            vendaProduto.setValor((valor));

            try {
                vendaProduto.setData(datas.formataDataRetornaBD(data));
            } catch (ParseException ex) {
                Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
            }

            vendaProdutoDao.SalvarVendaProduto(vendaProduto);

        }
    }

    //metodo para imprimir
    private String calculaTotalProdutos() {
        Double Orcamento = 0.0;
        for (int i = 0; i < TabelaVenda.getRowCount(); i++) {
            Orcamento += Double.parseDouble(TabelaVenda.getValueAt(i, 5).toString());
        }
        return Orcamento.toString();

    }

    Impressao imp = new Impressao();

    public void capturaProduto() {

        //nome
        ArrayList lp = new ArrayList();
        //qtd
        ArrayList qtd = new ArrayList();
        //total
        ArrayList total = new ArrayList();
        //valor unitario
        ArrayList valor = new ArrayList();

        for (int i = 0; i < TabelaVenda.getRowCount(); i++) {

            lp.add(TabelaVenda.getValueAt(i, 2).toString());

        }
        for (int i = 0; i < TabelaVenda.getRowCount(); i++) {

            qtd.add(TabelaVenda.getValueAt(i, 4).toString());

        }
        for (int i = 0; i < TabelaVenda.getRowCount(); i++) {

            total.add(TabelaVenda.getValueAt(i, 5).toString());

        }
        for (int i = 0; i < TabelaVenda.getRowCount(); i++) {

            valor.add(TabelaVenda.getValueAt(i, 3).toString());

        }

        imprimirBalcao(lp, qtd, total, valor);
    }

//modelo do cupom
    public void imprimirBalcao(List lista, List qtd, List toal, List valor) {
        Frame f = new Frame("Frame temporário");
        f.pack();
        Toolkit tk = f.getToolkit();
        PrintJob pj = tk.getPrintJob(f, "MP4200", null);

        if (pj != null) {
            Graphics g = pj.getGraphics();
            int y = 135;
            int q = 135;
            int t = 135;
            int v = 135;

            g.setFont(new Font("Arial", Font.PLAIN, 8));

            g.drawString("LIZZE EQUIPAMENTOS", 55, 10);
            //g.drawString("CNPJ: 09.356.580/0001-29", 50, 20);
            g.drawString("FONE/FAX: (44) 3016-4603", 49, 20);
            g.setFont(new Font("Arial", Font.PLAIN, 7));
            g.drawString("ESTE CUPOM É VALIDO PARA", 50, 60);
            g.drawString("A GARANTIA DO PRODUTO", 55, 70);

//            SimpleDateFormat hora = new SimpleDateFormat("h:mm - a");
//            String h;
//            h = hora.format(hora);
            g.drawString("EMISSÃO:", 3, 90);
            g.drawString("" + txtDataVenda.getText(), 40, 90);
            g.drawString("HORA:", 100, 90);
            g.drawString("" + txtHora.getText(), 125, 90);

            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("--------------------------------------------------------------", 3, 100);
            g.setFont(new Font("Arial", Font.PLAIN, 8));
            g.drawString("FATURAMENTO:", 3, 110);
            g.drawString("" + txtCodigoVenda.getText(), 68, 110);
            g.drawString("CAIXA:", 118, 110);
            g.drawString("" + txtNomeCaixa.getText(), 150, 110);
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
            for (int i = 0; i < valor.size(); i++) {

                g.drawString("" + valor.get(i), 145, v);
                v += 10;
            }

            int c = t;

            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("--------------------------------------------------------------", 3, c + 5);
            g.setFont(new Font("Arial", Font.PLAIN, 7));
            g.drawString("TOTAL: ", 145, c + 10);
            g.drawString("" + txtNovoValor.getText(), 180, c + 10);

            g.setFont(new Font("Arial", Font.PLAIN, 8));
            g.drawString("VENDEDOR: ", 5, c + 30);
            g.drawString("" + txtNomeVendedora.getText(), 55, c + 30);

            g.drawString("FORMA PGMT:", 5, c + 45);
            g.drawString("Dinheiro:" + txtDinheiro.getText() + " Debito:" + txtDebito.getText() + " Credito:" + txtCheque.getText(), 65, c + 45);

            g.drawString("DOCUMENTO NÃO FISCAL", 48, c + 70);

            g.setFont(new Font("Arial", Font.PLAIN, 7));
            g.drawString("OBRIGADO PELA PREFERENCIA", 45, c + 100);
            g.drawString("PARA MAIS INFORMAÇÕES ACESSE:", 40, c + 120);
            g.drawString("WWW.LIZZE.COM.BR", 65, c + 130);

            g.dispose();

            pj.end();
        }

    }

    public void limpaTabela() {
        while (TabelaVenda.getModel().getRowCount() > 0) {
            ((DefaultTableModel) TabelaVenda.getModel()).removeRow(0);
        }
    }

}
