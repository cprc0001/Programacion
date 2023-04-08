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

public class RegUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;

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

		textField = new JTextField();
		textField.setBounds(20, 49, 127, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Comercial"}));
		comboBox.setBounds(20, 113, 127, 20);
		contentPanel.add(comboBox);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(20, 91, 97, 14);
		contentPanel.add(lblTipo);

		textField_1 = new JTextField();
		textField_1.setBounds(190, 49, 147, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(190, 26, 97, 14);
		contentPanel.add(lblPassword);

		JLabel lblConfirmarPassword = new JLabel("Confirmar Contraseña:");
		lblConfirmarPassword.setBounds(190, 91, 117, 14);
		contentPanel.add(lblConfirmarPassword);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(190, 113, 147, 20);
		contentPanel.add(textField_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						User user = new User(comboBox.getSelectedItem().toString(),textField.getText(),textField_1.getText());
						Tienda.getInstance().regUser(user);
						dispose();
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