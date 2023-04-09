package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream tienda;
				FileOutputStream tienda2;
				ObjectInputStream tiendaRead;
				ObjectOutputStream tiendaWrite;
				try {
					tienda = new FileInputStream ("tienda.dat");
					tiendaRead = new ObjectInputStream(tienda);
					Tienda temp = (Tienda)tiendaRead.readObject();
					Tienda.setTienda(temp);
					tienda.close();
					tiendaRead.close();
				} catch (FileNotFoundException e) {
					try {
						tienda2 = new  FileOutputStream("tienda.dat");
						tiendaWrite = new ObjectOutputStream(tienda2);
						User aux = new User("Administrador", "Admin", "Admin");
						Tienda.getInstance().regUser(aux);
						tiendaWrite.writeObject(Tienda.getInstance());
						tienda2.close();
						tiendaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 21, 69, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 68, 105, 14);
		panel.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(10, 37, 174, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(10, 93, 174, 20);
		panel.add(textField_1);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tienda.getInstance().confirmLogin(textField.getText(),String.valueOf(textField_1.getPassword()))){
				   JOptionPane.showMessageDialog(null, "Usted esta accediendo como: "+Tienda.getLoginUser().getTipo(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
				} else {
					 JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrecta", "Error", JOptionPane.INFORMATION_MESSAGE);
						
				}
				
			}
		});
		btnLogin.setBounds(198, 124, 89, 23);
		panel.add(btnLogin);
		
		
	}
}