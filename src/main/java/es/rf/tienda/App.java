package es.rf.tienda;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.rf.tienda.controllers.CategoriaController;
import es.rf.tienda.util.MenuPral;

public class App extends JFrame {

		private JPanel contentPane;
		

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MenuPral frame = new MenuPral();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public App() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(new GridLayout(4, 2, 5, 5));
			
			JButton btnCategorias = new JButton("Categorias");
			btnCategorias.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								CategoriaController controller = new CategoriaController();
								controller.setOption(new String[]{CategoriaController.LIST});
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			contentPane.add(btnCategorias);
			
			JButton btnNewButton = new JButton("New button");
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_2 = new JButton("New button");
			contentPane.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("New button");
			contentPane.add(btnNewButton_3);
		}

	}