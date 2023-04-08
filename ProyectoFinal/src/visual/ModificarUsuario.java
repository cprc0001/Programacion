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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ModificarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private User user = null;
	private JTextField txtTipo;
	private JPasswordField pswActual;
	private JPasswordField pswNueva;

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
		setBounds(100, 100, 373, 244);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 357, 156);
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblNombre = new JLabel("Usuario:");
			lblNombre.setBounds(20, 26, 148, 14);
			panel.add(lblNombre);

			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(20, 49, 127, 20);
			panel.add(txtNombre);
			{
				JLabel lblNuevaPassword = new JLabel("Nueva Contrasena:");
				lblNuevaPassword.setBounds(183, 90, 117, 14);
				panel.add(lblNuevaPassword);
			}

			JLabel label = new JLabel("Tipo:");
			label.setBounds(183, 26, 97, 14);
			panel.add(label);

			JLabel lblConfirmarContrasea = new JLabel("Contrasena actual:");
			lblConfirmarContrasea.setBounds(20, 90, 147, 14);
			panel.add(lblConfirmarContrasea);
			
			txtTipo = new JTextField();
			txtTipo.setColumns(10);
			txtTipo.setBounds(183, 46, 127, 20);
			panel.add(txtTipo);
			
			pswActual = new JPasswordField();
			pswActual.setBounds(20, 114, 127, 20);
			panel.add(pswActual);
			
			pswNueva = new JPasswordField();
			pswNueva.setBounds(183, 111, 127, 20);
			panel.add(pswNueva);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnModificar = new JButton("Actualizar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

				        if (String.valueOf(pswActual.getPassword()).equals(user.getPass())) {
						user.setPass(String.valueOf(pswNueva.getPassword()));
						Tienda.getInstance().ModificarUsuario(user);
						VerUsuarios.loadUsuarios();
						dispose(); 
				        } else {
				        	JOptionPane.showMessageDialog(null, "Contrasena actual incorrecta", "Error", JOptionPane.INFORMATION_MESSAGE);
				        }
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
			txtTipo.setText(user.getTipo());
			
		}

	}
}
