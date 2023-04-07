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
import logico.Factura;
import logico.Tienda;
import javax.swing.ListModel;
import javax.swing.JRadioButton;
import java.awt.Font;

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
	private Componente selectedComp = null;
	private Combo selectedComb = null;
	private Componente selectedComp2 = null;
	private Combo selectedComb2= null;
	private float total=0;
	private Cliente client= null;
	private DecimalFormat df = new DecimalFormat("0.00");
	private String titulo = ("Codigo // Especificacion // Precio");
	private JTextField txtCodigoF;
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
		setBounds(100, 100, 522, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 50, 486, 122);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 11, 46, 14);
		panel.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setBounds(70, 8, 110, 23);
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
		btnBuscar.setBounds(195, 7, 89, 23);
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
		panel_1.setBounds(10, 183, 486, 219);
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
					selectedComp = Tienda.getInstance().EncontrarComponente(cod);
					if (selectedComp==null) {
						selectedComb= Tienda.getInstance().EncontrarCombo(cod);
					}
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
					selectedComp2 = Tienda.getInstance().EncontrarComponente(cod);
					if (selectedComp2==null) {
						selectedComb2= Tienda.getInstance().EncontrarCombo(cod);
					}

				}
			}
		});
		scrollPane_1.setViewportView(lst_Compra); 


		JButton btnDerecha = new JButton(">>");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedComp!=null) {
					model2.addElement(selectedComp.getCodigo()+" // "+selectedComp.getMarca()+" // "+"$"+df.format(selectedComp.getPrecio()));
					total+= selectedComp.getPrecio();
					selectedComp.setDisponibles(selectedComp.getDisponibles()-1);
					if (selectedComp.getDisponibles()<=selectedComp.getDispMin() && selectedComp.getDisponibles()> 0) {
						selectedComp.setEstado('P');
					} else if (selectedComp.getDisponibles()== 0) {
						selectedComp.setEstado('N');
					}
					txtTotal.setText(""+df.format(total));     
				} else if ( selectedComb !=null){
					model2.addElement(selectedComb.getCodigo()+" // "+"Combo:"+selectedComb.getNombreComb()+" // "+"$"+df.format(selectedComb.getTotalD()));
					total+= selectedComb.getTotalD();
					for (Componente comp : selectedComb.getMisComponentes()) {
						comp.setDisponibles(comp.getDisponibles()-1);
						if (comp.getDisponibles()<=comp.getDispMin()& comp.getDisponibles()> 0) {
							comp.setEstado('P');
						} else if (comp.getDisponibles()== 0) {
							comp.setEstado('N');
						}
					}
					//model.remove(listDisponibles.getSelectedIndex());
					txtTotal.setText(""+df.format(total));     
				}
				loadList1();
			}


		});
		btnDerecha.setBounds(200, 83, 89, 25);
		panel_1.add(btnDerecha);

		JButton btnIzquierda = new JButton("<<");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedComp2!=null) {
					total-= selectedComp2.getPrecio();
					txtTotal.setText(""+df.format(total));
					selectedComp2.setDisponibles(selectedComp2.getDisponibles()+1);
					model2.remove(lst_Compra.getSelectedIndex());
					if (selectedComp2.getDisponibles()>selectedComp2.getDispMin()) {
						selectedComp2.setEstado('D');
					} else if (selectedComp2.getDisponibles()<= selectedComp2.getDispMin() && selectedComp2.getDisponibles()>0) {
						selectedComp2.setEstado('P');
					}
				} else if (selectedComb2!=null) {
					total-= selectedComb2.getTotalD();
					model2.remove(lst_Compra.getSelectedIndex());
					for (Componente comp : selectedComb2.getMisComponentes()) {
						comp.setDisponibles(comp.getDisponibles()+1);
						if (comp.getDisponibles()>comp.getDispMin()) {
							comp.setEstado('D');
						} else if (comp.getDisponibles()<= comp.getDispMin() && comp.getDisponibles()>0) {
							comp.setEstado('P');
						}
					}
					
					txtTotal.setText(""+df.format(total));

				}
				
				loadList1();
				selectedComp2=null;
				selectedComb2=null;

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
		lblTotal.setBounds(309, 416, 46, 14);
		contentPanel.add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(355, 413, 130, 20);
		contentPanel.add(txtTotal);
		txtTotal.setColumns(10);

		JLabel lblNombreEmpresa = new JLabel("CHEYLETECH CORPORATION SRL");
		lblNombreEmpresa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreEmpresa.setBounds(10, 15, 247, 24);
		contentPanel.add(lblNombreEmpresa);

		txtCodigoF = new JTextField();
		txtCodigoF.setBounds(375, 18, 110, 23);
		txtCodigoF.setText("FACT-"+Tienda.codF);
		contentPanel.add(txtCodigoF);
		txtCodigoF.setEditable(false);
		txtCodigoF.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo unico:");
		lblCodigo.setBounds(293, 19, 86, 20);
		contentPanel.add(lblCodigo);


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
						if (!(txtNombre.getText().equalsIgnoreCase("")) && !(txtCedula.getText().equalsIgnoreCase("")) && !(txtDireccion.getText().equalsIgnoreCase("")) && !(txtTelefono.getText().equalsIgnoreCase("")) && !(txtTotal.getText().equalsIgnoreCase("")) && total!=0) {
							ArrayList<Componente> auxComp = new ArrayList <>();
							ArrayList<Combo> auxComb = new ArrayList <>();
							float t= total;
							String codF = txtCodigoF.getText();
							int j=0;
							for (int i=1; i <model2.size(); i++) {
								String help = model2.elementAt(i);
								String[] parts = help.split(" // ");
								String cod = parts[0];

								Componente myComp=Tienda.getInstance().EncontrarComponente(cod);
								if(myComp!=null) {
									auxComp.add(myComp);
								} else {
									Combo myComb=Tienda.getInstance().EncontrarCombo(cod);
									if(myComb!=null) {
										auxComb.add(myComb);
									}
								}

							}
							if (client ==null) {
								String cedula = txtCedula.getText();
								String nombre = txtNombre.getText();
								String dir= txtDireccion.getText();
								String tel = txtTelefono.getText();
								Cliente c = new Cliente (cedula, nombre, dir, tel);
								Tienda.getInstance().insertarCliente(c);
								Factura factura = new Factura (codF, c, auxComb, auxComp);
								Tienda.getInstance().insertarFactura(factura);

							} else {
								Factura factura2 = new Factura (codF, client, auxComb, auxComp);
								Tienda.getInstance().insertarFactura(factura2);

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
		char a = 'N';
		for (Componente comp: Tienda.getInstance().getMisComponentes()) {
			if (Character.compare(comp.getEstado(), a)!=0  ) {
				model.addElement(comp.getCodigo()+" // "+comp.getMarca()+" // "+"$"+df.format(comp.getPrecio()));
			}
		}
        int y= 0;
		for (Combo comb: Tienda.getInstance().getMisCombos()) {
			for (Componente comp : comb.getMisComponentes()) {
				if (Character.compare(comp.getEstado(), a)==0) {
					y++;
					}
			}
			if (y==0) {
			model.addElement(comb.getCodigo()+" // "+"Combo: "+comb.getNombreComb()+" // "+"$"+df.format(comb.getTotalD()));
			}
		} 

	}



	private void clean() {
		txtNombre.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtTotal.setText("");
		txtCodigoF.setText("FACT-"+Tienda.getInstance().codF);
		selectedComp=null;
		selectedComb=null;
		selectedComp2=null;
		selectedComb2=null;
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
