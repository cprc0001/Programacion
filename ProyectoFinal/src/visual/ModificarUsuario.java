package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.User;
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPassword;
	private JTextField txtConfPassword;
	private User user = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarUsuario dialog = new ModificarUsuario(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarUsuario(User auxU) {
		user = auxU;
		setTitle("Modificar Usuario");
		setBounds(100, 100, 373, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 357, 156);
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblNombre = new JLabel("Nuevo nombre Usuario:");
			lblNombre.setBounds(20, 26, 148, 14);
			panel.add(lblNombre);

			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(20, 49, 127, 20);
			panel.add(txtNombre);
			{
				JLabel lblNuevaPassword = new JLabel(" Nueva Contraseña:");
				lblNuevaPassword.setBounds(190, 26, 117, 14);
				panel.add(lblNuevaPassword);
			}
			{
				txtPassword = new JTextField();
				txtPassword.setColumns(10);
				txtPassword.setBounds(189, 49, 148, 20);
				panel.add(txtPassword);
			}

			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Comercial"}));
			comboBox.setBounds(20, 113, 127, 20);
			panel.add(comboBox);

			JLabel label = new JLabel("Tipo:");
			label.setBounds(20, 91, 97, 14);
			panel.add(label);

			JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña:");
			lblConfirmarContrasea.setBounds(190, 91, 147, 14);
			panel.add(lblConfirmarContrasea);

			txtConfPassword = new JTextField();
			txtConfPassword.setColumns(10);
			txtConfPassword.setBounds(190, 113, 147, 20);
			panel.add(txtConfPassword);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						user.setUserName(txtNombre.getText());
						user.setPass(txtPassword.getText());
						//user.setTipo(comboBox.getText());  //Aun no sé como agregar el combo box para que pueda modificarse
						Tienda.getInstance().ModificarUsuario(user);
						VerUsuarios.loadUsuarios();
						dispose(); 

					}
				});
				buttonPane.add(btnModificar);

				{
					JButton btnCancelar = new JButton("Cancelar");
					btnCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					btnCancelar.setActionCommand("Cancel");
					buttonPane.add(btnCancelar);
				}
			}
			loadUsuario();
		}
	}

	private void loadUsuario() {
		if(user!=null){
			txtNombre.setText(user.getUserName());
			txtPassword.setText(user.getPass());
			//comboBox.setText(user.getTipo()); // mismo problema de arriba
			txtConfPassword.setText(user.getPass());
		}

	}
}
