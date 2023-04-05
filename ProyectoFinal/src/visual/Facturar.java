package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.Tienda;
import javax.swing.ListModel;
import javax.swing.JRadioButton;

public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JButton btnBuscar;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JScrollPane scrollPane;
	private DefaultListModel<String> model; 
	private DefaultListModel<String> model2; 
	private JTextField txtTotal;
	private JList<String> listDisponibles;
	private JList<String> lst_Compra;
	private JScrollPane scrollPane_1;
	private Componente selected = null;
	private Componente selected2 = null;
	private float total=0;
	private Cliente client= null;
	private DecimalFormat df = new DecimalFormat("0.00");
	private String titulo = ("Código // Especificacion // Precio");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturar() {
		setTitle("Generar Factura");
		setBounds(100, 100, 522, 503);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 486, 122);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 11, 46, 14);
		panel.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setBounds(70, 8, 216, 23);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				if (Tienda.getInstance().EncontrarCliente(cedula)!=null) {
					client = Tienda.getInstance().EncontrarCliente(cedula);
					txtNombre.setText(client.getNombre());
					txtTelefono.setText(client.getTelefono());
					txtDireccion.setText(client.getDireccion());

				} else if (Tienda.getInstance().EncontrarCliente(cedula)==null) {
					txtNombre.setEditable(true);
					txtTelefono.setEditable(true);
					txtDireccion.setEditable(true);		
				}

			}
		});
		btnBuscar.setBounds(298, 7, 89, 23);
		panel.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 45, 52, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(70, 42, 216, 23);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(298, 45, 61, 14);
		panel.add(lblTelfono);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(361, 42, 115, 23);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 82, 61, 14);
		panel.add(lblDireccin);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(70, 79, 406, 23);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 139, 486, 219);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 34, 177, 174);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		 model = new DefaultListModel<>();
			listDisponibles = new JList <>(model);
			listDisponibles.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = listDisponibles.getSelectedIndex();
					if(index>=0) {
						String aux = listDisponibles.getSelectedValue();
						String[] parts = aux.split(" // ");
						String cod = parts[0];
						selected = Tienda.getInstance().EncontrarComponente(cod);
					}
				}
			});
			listDisponibles.setVisibleRowCount(2);
			listDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(listDisponibles);

			JPanel panel_3 = new JPanel();
			panel_3.setBounds(299, 34, 177, 174);
			panel_1.add(panel_3);
			panel_3.setLayout(new BorderLayout(0, 0));

			scrollPane_1 = new JScrollPane();
			panel_3.add(scrollPane_1, BorderLayout.CENTER);

			model2 = new DefaultListModel<>();
			lst_Compra = new JList<>(model2);
		    model2.addElement(titulo);
			lst_Compra.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = lst_Compra.getSelectedIndex();
						if(index>=1) {
							String aux = lst_Compra.getSelectedValue();
							String[] parts = aux.split(" // ");
							String cod = parts[0];
							selected2 = Tienda.getInstance().EncontrarComponente(cod);
							
						}
					}
				});
			scrollPane_1.setViewportView(lst_Compra); 


		JButton btnDerecha = new JButton(">>");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model2.addElement(selected.getCodigo()+" // "+selected.getMarca()+" // "+"$"+df.format(selected.getPrecio()));
				total+= selected.getPrecio();
				model.remove(listDisponibles.getSelectedIndex());
				txtTotal.setText(""+df.format(total));     

			}


		});
		btnDerecha.setBounds(200, 83, 89, 25);
		panel_1.add(btnDerecha);

		JButton btnIzquierda = new JButton("<<");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(selected2.getCodigo()+" // "+selected.getMarca()+" // "+"$"+df.format(selected.getPrecio()));
				total-= selected2.getPrecio();
				model2.remove(lst_Compra.getSelectedIndex());
				txtTotal.setText(""+df.format(total));
				selected2=null;

			}
		});
		btnIzquierda.setBounds(200, 119, 89, 23);
		panel_1.add(btnIzquierda);

		JLabel lblQuesosDisponibles = new JLabel("Disponibles:");
		lblQuesosDisponibles.setBounds(10, 11, 177, 14);
		panel_1.add(lblQuesosDisponibles);

		JLabel lblCarritoDeCompra = new JLabel("Carrito de Compra:");
		lblCarritoDeCompra.setBounds(299, 9, 177, 14);
		panel_1.add(lblCarritoDeCompra);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(311, 369, 46, 14);
		contentPanel.add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(354, 366, 130, 20);
		contentPanel.add(txtTotal);
		txtTotal.setColumns(10);
		

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnFacturar = new JButton("Facturar");
				btnFacturar.setEnabled(true);

				btnFacturar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!(txtNombre.getText().equalsIgnoreCase("")) && !(txtCedula.getText().equalsIgnoreCase("")) && !(txtDireccion.getText().equalsIgnoreCase("")) && !(txtTelefono.getText().equalsIgnoreCase("")) && !(txtTotal.getText().equalsIgnoreCase(""))) {
							ArrayList<Componente> aux = new ArrayList <>();
							int j=0;
							for (int i=1; i <model2.size(); i++) {
								String help = model2.elementAt(i);
								String[] parts = help.split(" // ");
								String cod = parts[0];

								aux.add(Tienda.getInstance().EncontrarComponente(cod));

							}
							if (client ==null) {
								String cedula = txtCedula.getText();
								String nombre = txtNombre.getText();
								String dir= txtDireccion.getText();
								String tel = txtTelefono.getText();
								Cliente c = new Cliente (cedula, nombre, dir, tel);
								Tienda.getInstance().insertarCliente(c);
								//Factura factura = new Factura (TiendaQueso.codF, aux, c);
								//TiendaQueso.getInstance().insertarFactura(factura);

							} else {
								//Factura factura2 = new Factura (TiendaQueso.codF, aux, client);
								//TiendaQueso.getInstance().insertarFactura(factura2);

							}
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						else {
							JOptionPane.showMessageDialog(null, "Rellene todos los campos", "Error", JOptionPane.INFORMATION_MESSAGE);

						}
					}


				});

				btnFacturar.setActionCommand("OK");
				buttonPane.add(btnFacturar);
				getRootPane().setDefaultButton(btnFacturar);
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


		loadList1();
	}

	private void loadList1() {
		model.removeAllElements();
		model.addElement(titulo);
		for (Componente comp: Tienda.getInstance().getMisComponentes()) {
			model.addElement(comp.getCodigo()+" // "+comp.getMarca()+" // "+"$"+df.format(comp.getPrecio()));

		}
		
		for (Combo comb: Tienda.getInstance().getMisCombos()) {
			model.addElement(comb.getCodigo()+" // "+comb.getNombreComb()+" // "+"$"+df.format(comb.getTotalD()));

		}

	}



	private void clean() {
		txtNombre.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtTotal.setText("");
		selected=null;
		selected2=null;
		total=0;
		client=null;
		loadList1();
		model2.clear();
		model2.addElement(titulo);
		txtNombre.setEditable(false);
		txtTelefono.setEditable(false);
		txtDireccion.setEditable(false);


	}
}
