package es.rf.tienda.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import es.rf.tienda.controllers.CategoriaController;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.util.RutinasSwing;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrCategoria extends JFrame implements PantallaFrame<Categoria> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static FrCategoria instancia;
	private static CategoriaController controller;
	
	
	private JLabel jTitulo;

	private JTextField idText;
	private JTextField nombreText;
	private JTextArea descripcionText;

	private Categoria reg;
	private String opcion;
	private String boton;
	private String titulo;
	private boolean readonly;
	

	private FrCategoria() {
		montarPantalla();
	}

	public static FrCategoria getInstance() {
		if (instancia == null)
			instancia = new FrCategoria();
		return instancia;
	}

	public int getIdText() {
		return Integer.parseInt(idText.getText());
	}

	public void setIdText(int idTextn) {
		this.idText.setText(idTextn + "");
	}

	public String getNombreText() {
		return nombreText.getText();
	}

	public void setNombreText(String nombreText) {
		this.nombreText.setText(nombreText);
	}

	public String getDescripcionText() {
		return descripcionText.getText();
	}

	public void setDescripcionText(String descripcionText) {
		this.descripcionText.setText(descripcionText);
	}

	public String getTitulo() {
		return titulo;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrCategoria objPantalla = FrCategoria.getInstance();

					objPantalla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame montarPantalla() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 660, 298);
		getContentPane().setLayout(new BorderLayout());

		GridBagLayout gridBagLayout0 = new GridBagLayout();
		gridBagLayout0.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout0.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout0.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout0.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		JPanel gridBagLayout = new JPanel(gridBagLayout0);

		JLabel lblNewLabel = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		gridBagLayout.add(lblNewLabel, gbc_lblNewLabel);

		idText = new JTextField();
		GridBagConstraints gbc_idText = new GridBagConstraints();
		gbc_idText.gridwidth = 5;
		gbc_idText.insets = new Insets(0, 0, 5, 0);
		gbc_idText.fill = GridBagConstraints.HORIZONTAL;
		gbc_idText.gridx = 1;
		gbc_idText.gridy = 1;
		gridBagLayout.add(idText, gbc_idText);
		idText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		gridBagLayout.add(lblNewLabel_1, gbc_lblNewLabel_1);

		nombreText = new JTextField();
		GridBagConstraints gbc_nombreText = new GridBagConstraints();
		gbc_nombreText.gridwidth = 5;
		gbc_nombreText.insets = new Insets(0, 0, 5, 0);
		gbc_nombreText.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreText.gridx = 1;
		gbc_nombreText.gridy = 2;
		gridBagLayout.add(nombreText, gbc_nombreText);
		nombreText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gridBagLayout.add(lblNewLabel_2, gbc_lblNewLabel_2);

		descripcionText = new JTextArea();
		descripcionText.setColumns(50);
		descripcionText.setRows(5);
		GridBagConstraints gbc_descripcionText = new GridBagConstraints();
		gbc_descripcionText.anchor = GridBagConstraints.NORTH;
		gbc_descripcionText.gridwidth = 5;
		gbc_descripcionText.insets = new Insets(0, 0, 5, 0);
		gbc_descripcionText.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcionText.gridx = 1;
		gbc_descripcionText.gridy = 3;
		gridBagLayout.add(descripcionText, gbc_descripcionText);

		JButton btnNewButton_1 = new JButton(boton);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 10, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 4;
		gridBagLayout.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (reg.isValid())
						FrCategoria.controller.grabar(reg);
					else {
						JOptionPane.showMessageDialog(null,
				                "Faltan datos obligatorios",
				                "Errores en entrada",
				                JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 10, 0);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 4;
		gridBagLayout.add(btnNewButton, gbc_btnNewButton);

		getContentPane().add(gridBagLayout, BorderLayout.CENTER);

		jTitulo = new JLabel();
		jTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		jTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		getContentPane().add(jTitulo, BorderLayout.NORTH);

		getContentPane().add(new JLabel("    "), BorderLayout.EAST);

		getContentPane().add(new JLabel("    "), BorderLayout.WEST);

		return this;
	}

	public void montaDatos() {
		jTitulo.setText(getTitulo());
		idText.setEditable(false);
		setIdText(reg.getId_categoria());
		nombreText.setEditable(!readonly);
		setNombreText(reg.getCat_nombre());
		setDescripcionText(reg.getCat_descripcion());
		descripcionText.setEditable(!readonly);
		setVisible(true);
	}

	@Override
	public void setRecord(Categoria record, String opcion) {
		reg = record;
		this.opcion = opcion;
		String[] op = RutinasSwing.textos("Categoria", this.opcion);
		boton = op[0];
		titulo = op[1];
		readonly = op[2].equals("si");
		montaDatos();
	}

	@Override
	public void setDatos(List<Categoria> lista) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setController(Object obj) {
		FrCategoria.controller = (CategoriaController) obj;

	}

}
