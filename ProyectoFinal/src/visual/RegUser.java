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

public class RegUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JComboBox comboBox;
	private JPasswordField pswContr;
	private JPasswordField pswConf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUser dialog = new RegUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUser() {
		setTitle("Registrar nuevo usuario");
		setBounds(100, 100, 373, 228);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setBounds(20, 26, 97, 14);
		contentPanel.add(lblNombreUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(20, 49, 127, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Comercial"}));
		comboBox.setBounds(20, 113, 127, 20);
		contentPanel.add(comboBox);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(20, 91, 97, 14);
		contentPanel.add(lblTipo);

		JLabel lblPassword = new JLabel("Contrasena:");
		lblPassword.setBounds(190, 26, 97, 14);
		contentPanel.add(lblPassword);

		JLabel lblConfirmarPassword = new JLabel("Confirmar Contrasena:");
		lblConfirmarPassword.setBounds(190, 91, 147, 14);
		contentPanel.add(lblConfirmarPassword);

		pswContr = new JPasswordField();
		pswContr.setBounds(190, 48, 127, 20);
		contentPanel.add(pswContr);

		pswConf = new JPasswordField();
		pswConf.setBounds(190, 110, 127, 20);
		contentPanel.add(pswConf);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (comboBox.getSelectedIndex()>0) {
							if (String.valueOf(pswContr.getPassword()).equals(String.valueOf(pswConf.getPassword()))){
								User user = new User(comboBox.getSelectedItem().toString(),txtUsuario.getText(),String.valueOf(pswContr.getPassword()));
								Tienda.getInstance().regUser(user);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Las contraseñas deben de coincidir", "Error", JOptionPane.INFORMATION_MESSAGE);

							}
						} else {
							JOptionPane.showMessageDialog(null, "Seleccione un tipo de usuario", "Error", JOptionPane.INFORMATION_MESSAGE);

						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}