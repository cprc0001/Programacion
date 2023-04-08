package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Tienda;
import logico.User;

import java.awt.Panel;
import javax.swing.JTable;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class VerUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model1;
	private static Object rows[];
	private User selected = null;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerUsuarios dialog = new VerUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerUsuarios() {
		setTitle("Listado de Usuarios Registrados");
		setBounds(100, 100, 399, 272);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 363, 178);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 363, 178);
				panel.add(scrollPane, BorderLayout.CENTER);
				{

					String[] headers = {"Usuario","Contraseña", "Tipo"};
					table = new JTable();


					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int index = table.getSelectedRow();
							if(index>=0){
								btnModificar.setEnabled(true);
								//En la clase ListaClientes hay dos lineas de codigo mas que en este caso, creo que no son necesarias, lo menciono por si acaso
							}
						}

					});

					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);

					model1 = new DefaultTableModel();
					model1.setColumnIdentifiers(headers);
					table.setModel(model1);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						ModificarUsuario modUsuario = new ModificarUsuario(selected); //Tengo problemas con el selected
						modUsuario.setModal(true);
						modUsuario.setVisible(true);
						btnModificar.setEnabled(false);
					}
				});

				btnModificar.setEnabled(false);
				buttonPane.add(btnModificar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnCancelar);
			}
		}
		loadUsuarios();
	}

	public static void loadUsuarios () {
		model1.setRowCount(0);
		rows = new Object[model1.getColumnCount()];
		for (User aux : Tienda.getInstance().getMisUsers()){
			rows[0] = aux.getUserName();
			rows[1] = aux.getPass();
			rows[2] = aux.getTipo();
			model1.addRow(rows); 


		}
	}
}
