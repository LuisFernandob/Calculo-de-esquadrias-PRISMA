package guiIncluirAlterar;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

import dao.Produto;
import dao.ProdutoDAO;
import gui.TelaProdutos;

@SuppressWarnings("serial")
public class JTableIncluirAlterarProduto extends javax.swing.JFrame {
	
	int idProdutoAlterar = -1;
	String descricaoProduto= new String();
	String tipoProdutoAlterar = new String("");
	int indexTipoInicial = -1;
	
	String novoIdProduto= null;

    /**
     * Cria a janela para incluir produtos
     */
    public JTableIncluirAlterarProduto() {
        initComponents();
    }
    
    /**
     * Cria a janela para alterar produto
     * @param prod - o produto a ser alterado
     */
    public JTableIncluirAlterarProduto(Produto prod) {
        initComponents(prod);
    }

    /**
     * Cria a janela e todos os seus componentes para inserir um produto
     */
    private void initComponents() {

       	setTitle("Sistema para cálculo de esquadrias -> Produtos -> Incluir");

        jPanel1 = new javax.swing.JPanel();
        lbTipo = new javax.swing.JLabel();
        lbDescr = new javax.swing.JLabel();
        lbFolhas = new javax.swing.JLabel();
        lbObs = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtFolhas = new javax.swing.JTextField();
        txtObservacoes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btIncluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbObrigatorio = new javax.swing.JLabel();
        lbCabecalho = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbTipo.setText("Tipo:");
        lbDescr.setText("Descrição:");
        lbFolhas.setText("Folhas:");
        lbObs.setText("Observações:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbObs)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtObservacoes, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDescr)
                                    .addComponent(lbTipo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbFolhas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFolhas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtDescricao))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFolhas)
                    .addComponent(txtFolhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescr)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtObservacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
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

        lbObrigatorio.setText("Os campos com * são obrigatórios.");

        lbCabecalho.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbCabecalho.setText("Novo cadastro de produto.");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
                        .addComponent(btCancelar)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbObrigatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCabecalho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbObrigatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIncluir)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }// </editor-fold> 
    
    /**
     * Cria a janela e todos os seus componentes para alterar um produto
     * @param prod - o produto a ser alterado
     */
    private void initComponents(Produto prod) {

    	idProdutoAlterar = prod.getIdProduto();
    	tipoProdutoAlterar = prod.getTipo();
    	descricaoProduto = prod.getDescricao();
    	
       	setTitle("Sistema para cálculo de esquadrias -> Produtos -> Alterar");

        jPanel1 = new javax.swing.JPanel();
        lbTipo = new javax.swing.JLabel();
        lbDescr = new javax.swing.JLabel();
        lbFolhas = new javax.swing.JLabel();
        lbObs = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtFolhas = new javax.swing.JTextField();
        txtObservacoes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbObrigatorio = new javax.swing.JLabel();
        lbCabecalho = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbTipo.setText("Tipo:");
        lbDescr.setText("Descrição:");
        lbFolhas.setText("Folhas:");
        lbObs.setText("Observações:");
        
        txtDescricao.setText(prod.getDescricao());
   		txtFolhas.setText(prod.getFolhas()+"");
   		txtObservacoes.setText(prod.getObservacoes());
   		txtTipo.setText(prod.getTipo()+"");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbObs)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtObservacoes, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDescr)
                                    .addComponent(lbTipo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbFolhas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFolhas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtDescricao))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFolhas)
                    .addComponent(txtFolhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescr)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtObservacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
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

        lbObrigatorio.setText("Os campos com * são obrigatórios.");

        lbCabecalho.setFont(new java.awt.Font("Arial", 0, 18));
        
        lbCabecalho.setText("Alterando produto Cod.: "+idProdutoAlterar+" - "+descricaoProduto);
        
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
                        .addComponent(btCancelar)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbObrigatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCabecalho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbObrigatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    /**
     * Realiza as operações necessárias para incluir um produto ao apertar o botão
     * @param evt - apertar o botão
     */
    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	
    	Produto p = new Produto();
    	ProdutoDAO dao = new ProdutoDAO();
        
   		p.setDescricao(txtDescricao.getText());
   		p.setTipo(txtTipo.getText());
   		p.setFolhas(txtFolhas.getText());
   		p.setObservacoes(txtObservacoes.getText());
   		
   		if(p.getDescricao() != "" && p.getTipo() != "") {  
   		
	   		dao.criarProduto(p);
	           
	   		txtDescricao.setText("");
	   		
	   		this.dispose();
	   		new TelaProdutos().setVisible(true);
    	} 
   		else {
   			JOptionPane.showMessageDialog(null, "Preencha os campos 'tipo' e 'descrição'!");
   		}    
   	}                                        
         
    /**
     * Realiza as operações necessárias para cancelar e fechar a janela ao apertar o botão
     * @param evt - apertar o botão
     */
	private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	this.dispose();
    	new TelaProdutos().setVisible(true);
    }      
    
	/**
	 * Realiza as operações necessárias para alterar um produto ao apertar o botão
	 * @param evt - apertar o botão
	 */
    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	 
    	Produto p = new Produto();
    	ProdutoDAO dao = new ProdutoDAO();
    	
        p.setIdProduto(idProdutoAlterar);
 		p.setDescricao(txtDescricao.getText());
 		p.setTipo(txtTipo.getText());
 		p.setFolhas(txtFolhas.getText());
 		p.setObservacoes(txtObservacoes.getText());

        dao.update(p);
         		
    	this.dispose();
        new TelaProdutos().setVisible(true);   
        
    }      

    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btAlterar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbObrigatorio;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbDescr;
    private javax.swing.JLabel lbFolhas;
    private javax.swing.JLabel lbObs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCabecalho;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFolhas;
    private javax.swing.JTextField txtObservacoes;
    private javax.swing.JTextField txtTipo;        
}
