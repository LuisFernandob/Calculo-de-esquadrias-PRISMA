package guiIncluirAlterar;

import java.awt.Dimension;
import java.awt.Toolkit;

import dao.Cliente;
import dao.Orcamento;
import dao.OrcamentoDAO;
import gui.TelaOrcamentos;

@SuppressWarnings("serial")
public class JTableIncluirAlterarOrcamento extends javax.swing.JFrame {
	
	int idOrcamento = -1;
	int idCliente = -1;
	
	/**
	 * Cria a janela para incluir or�amentos
	 * @param cliente - o cliente que est� fazendo o or�amento
	 */
	public JTableIncluirAlterarOrcamento(Cliente cliente) {
        initComponents(cliente);
    }
    
    /**
	 * Cria a janela para alterar or�amentos
	 * @param orcamento - o or�amento a ser alterado
	 */
    public JTableIncluirAlterarOrcamento(Orcamento orcamento) {
        initComponents(orcamento);
    }

    /**
     * Cria a janela e todos os seus componentes para alterar um produto no or�amento
     * @param orcamento - o or�amento que ser� alterado
     */
    private void initComponents(Orcamento orcamento) {
    	
    	idOrcamento = orcamento.getIdOrcamento();

    	setTitle("Sistema para c�lculo de esquadrias -> Or�amentos -> Alterar");
        jPanel1 = new javax.swing.JPanel();
        lbDescr = new javax.swing.JLabel();
        txtDescr = new javax.swing.JTextField();
        lbExplic = new javax.swing.JLabel();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbExplic2 = new javax.swing.JLabel();
        lbCabecalho = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbDescr.setText(" Descri��o:");
        
        txtDescr.setText(orcamento.getDescricao());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescr, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDescr))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDescr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescr, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );


        btAlterar.setText("ALTERAR");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btCancelar.setText("CANCELAR");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        lbExplic.setText("Altere a descri��o do orcamento");
        lbExplic2.setText("(Para incluir, excluir ou alterar produtos inclusos no or�amento clique em \"Abrir or�amento\" na Tela \"Orcamentos\".");

        lbCabecalho.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbCabecalho.setText("Alterando descri��o do or�amento n� "+idOrcamento+".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCancelar)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCabecalho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbExplic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbExplic2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCabecalho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbExplic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbExplic2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAlterar)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    } 

    /**
     * Cria a janela e todos os seus componentes para incluir um produto no or�amento
     * @param cliente - o cliente que est� fazendo o or�amento
     */
    private void initComponents(Cliente cliente) {
    	
    	idCliente = cliente.getIdCliente();

   	    setTitle("Sistema para c�lculo de esquadrias -> Or�amentos -> Incluir");

        jPanel1 = new javax.swing.JPanel();
        lbDescr = new javax.swing.JLabel();
        txtDescr = new javax.swing.JTextField();
        lbExplic = new javax.swing.JLabel();
        btIncluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbExplic2 = new javax.swing.JLabel();
        lbCabecalho = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbDescr.setText(" Descri��o:");
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescr, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDescr))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDescr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescr, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );


        btIncluir.setText("INCLUIR");
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        btCancelar.setText("CANCELAR");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        
        lbExplic.setText("Inclua uma descri��o para ajudar a identificar o or�amento (opcional),");
        lbExplic2.setText("depois clique em \"INCLUIR\" para incluir o orcamento no banco de dados ou em \"CANCELAR\" para sair.");
        lbCabecalho.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbCabecalho.setText("Incluindo descri��o do novo or�amento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCancelar)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCabecalho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbExplic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbExplic2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCabecalho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbExplic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbExplic2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btIncluir)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    } 
    
    /**
     * Realiza as opera��es necess�rias para incluir um or�amento ao apertar o bot�o
     * @param evt - apertar o bot�o
     */
    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	Orcamento o = new Orcamento(true);
    	OrcamentoDAO odao = new OrcamentoDAO();
   		o.setDescricao(txtDescr.getText());
   		o.setIdCliente(idCliente);
   		odao.criarOrcamento(o);
   		this.dispose();
   		new TelaOrcamentos().setVisible(true);
    }                                        

    /**
     * Realiza as opera��es necess�rias para cancelar e fechar a janela ao apertar o bot�o
     * @param evt - apertar o bot�o
     */
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {    
        this.dispose();
        new TelaOrcamentos().setVisible(true);
    }     
    
    /**
     * Realiza as opera��es necess�rias para alterar um or�amento ao apertar o bot�o
     * @param evt - apertar o bot�o
     */
    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	OrcamentoDAO odao = new OrcamentoDAO();
    	Orcamento o = odao.lerObjOrcamento(idOrcamento);
    	o.setDescricao(txtDescr.getText());
        odao.update(o);
    	this.dispose();
        new TelaOrcamentos().setVisible(true);   
    }     

    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btAlterar;
    private javax.swing.JLabel lbExplic;
    private javax.swing.JLabel lbExplic2;
    private javax.swing.JLabel lbDescr;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDescr;
    private javax.swing.JLabel lbCabecalho;    
}
