package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;
import logico.Cliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private Cliente cliente = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarCliente dialog = new ModificarCliente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarCliente(Cliente auxC) {
		cliente= auxC;
		setTitle("Modificar Cliente");
		setBounds(100, 100, 510, 218);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 472, 126);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCedula = new JLabel("Cédula:");
		lblCedula.setBounds(10, 15, 45, 14);
		panel.add(lblCedula);

		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setColumns(10);
		txtCedula.setBounds(65, 11, 216, 23);
		panel.add(txtCedula);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 57, 52, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(65, 53, 216, 23);
		panel.add(txtNombre);

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(289, 57, 52, 14);
		panel.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(343, 53, 118, 23);
		panel.add(txtTelefono);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(10, 96, 52, 14);
		panel.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(65, 92, 396, 23);
		panel.add(txtDireccion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cliente.setNombre(txtNombre.getText());
					cliente.setDireccion(txtDireccion.getText());
					cliente.setTelefono(txtTelefono.getText());
					Tienda.getInstance().ModificarCliente(cliente);
					ListaClientes.loadClientes();
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
		loadCliente();
	}

	private void loadCliente() {
		if(cliente!=null){
			txtCedula.setText(cliente.getCedula());
			txtNombre.setText(cliente.getNombre());
			txtTelefono.setText(cliente.getTelefono());
			txtDireccion.setText(cliente.getDireccion());
		}
	}
}
