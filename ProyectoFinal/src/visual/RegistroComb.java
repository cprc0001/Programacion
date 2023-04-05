package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Combo;
import logico.Componente;
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class RegistroComb extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombreComb;
	private JSpinner spnDesc;
	private JScrollPane scrollPane;
	private DefaultListModel<String> model; 
	private DefaultListModel<String> model2; 
	private JList<String> listDisponibles;
	private JList<String> lst_Compra;
	private JScrollPane scrollPane_1;
	private Componente selected = null;
	private Componente selected2 = null;
	private float totalR=0;
	private float totalD=0;
	private float auxF=0;
	private DecimalFormat df = new DecimalFormat("0.00");
	private String titulo = ("C�digo // Marca // Precio");
	private JTextField textTotalR;
	private JTextField textTotalD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroComb dialog = new RegistroComb();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroComb() {
		setTitle ("Registro de Combos");
		setBounds(100, 100, 568, 553);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 525, 100);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(345, 13, 74, 18);
		panel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(414, 10, 96, 23);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setText("CMB-"+Tienda.getInstance().codComb);

		JLabel lblNombre = new JLabel("Nombre del Combo:");
		lblNombre.setBounds(15, 17, 145, 14);
		panel.add(lblNombre);

		txtNombreComb = new JTextField();
		txtNombreComb.setBounds(164, 12, 145, 23);
		panel.add(txtNombreComb);
		txtNombreComb.setColumns(10);
		
				JLabel lblDescuento = new JLabel("Descuento:");
				lblDescuento.setBounds(67, 68, 82, 18);
				panel.add(lblDescuento);
				
						spnDesc = new JSpinner();
						spnDesc.setBounds(164, 65, 145, 23);
						panel.add(spnDesc);
						spnDesc.setModel(new SpinnerNumberModel(new Float(1), new Float(0), new Float(100), new Float(1)));
						
						JButton btnActualizar = new JButton("Actualizar");
						btnActualizar.setBounds(345, 57, 126, 29);
						panel.add(btnActualizar);
						btnActualizar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
						    auxF = Float.valueOf(spnDesc.getValue().toString());
						    totalD= totalR-((totalR*auxF)/100);
						    textTotalD.setText(""+df.format(totalD));
							}
						});
						btnActualizar.setActionCommand("OK");



		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 125, 525, 219);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 34, 200, 174);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		model = new DefaultListModel<>();
		listDisponibles = new JList <>(model);
		listDisponibles.addMouseListener(new MouseAdapter() {
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
		panel_3.setBounds(310, 34, 200, 174);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);

		model2 = new DefaultListModel<>();
		lst_Compra = new JList<>(model2);
		model2.addElement(titulo);
		lst_Compra.addMouseListener(new MouseAdapter() {
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
				totalR+= selected.getPrecio();
				float auxF = Float.valueOf(spnDesc.getValue().toString());
				totalD= totalR-((totalR*auxF)/100);
				model.remove(listDisponibles.getSelectedIndex());
				textTotalR.setText(""+df.format(totalR));  
				textTotalD.setText(""+df.format(totalD));
				

			}


		});
		btnDerecha.setBounds(221, 84, 74, 25);
		panel_1.add(btnDerecha);

		JButton btnIzquierda = new JButton("<<");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auxF=Float.valueOf(spnDesc.getValue().toString());
				model.addElement(selected2.getCodigo()+" // "+selected2.getMarca()+" // "+"$"+df.format(selected.getPrecio()));
				totalR-= selected2.getPrecio();
				totalD= totalR-((totalR*auxF)/100);
				model2.remove(lst_Compra.getSelectedIndex());
				textTotalR.setText(""+df.format(totalR));
				textTotalD.setText(""+df.format(totalD));
				selected2=null;

			}
		});
		btnIzquierda.setBounds(221, 132, 74, 23);
		panel_1.add(btnIzquierda);

		JLabel lblQuesosDisponibles = new JLabel("Componentes Disponibles:");
		lblQuesosDisponibles.setBounds(15, 6, 189, 25);
		panel_1.add(lblQuesosDisponibles);

		JLabel lblCarritoDeCompra = new JLabel("Componentes Seleccionados:");
		lblCarritoDeCompra.setBounds(310, 11, 211, 14);
		panel_1.add(lblCarritoDeCompra);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel2.setBounds(10, 355, 525, 90);
		contentPanel.add(panel2);
		panel2.setLayout(null);

		JLabel lblTotal = new JLabel("Valor Real:");
		lblTotal.setBounds(317, 16, 78, 20);
		panel2.add(lblTotal);

		textTotalR = new JTextField();
		textTotalR.setEditable(false);
		textTotalR.setBounds(404, 13, 106, 26);
		panel2.add(textTotalR);
		textTotalR.setColumns(10);

		textTotalD = new JTextField();
		textTotalD.setEditable(false);
		textTotalD.setColumns(10);
		textTotalD.setBounds(404, 48, 106, 26);
		panel2.add(textTotalD);

		JLabel lblDesc = new JLabel("Total:");
		lblDesc.setBounds(354, 52, 48, 20);
		panel2.add(lblDesc);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);


			{
				JPanel buttonPane1 = new JPanel();
				buttonPane1.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane1, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("Registrar");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (!(txtNombreComb.getText().equalsIgnoreCase("")) &&!(textTotalD.getText().equalsIgnoreCase("")) && !(textTotalR.getText().equalsIgnoreCase(""))) {
								ArrayList<Componente> aux = new ArrayList <>();
								int j=0;
								for (int i=1; i <model2.size(); i++) {
									String help = model2.elementAt(i);
									String[] parts = help.split(" // ");
									String cod = parts[0];

									aux.add(Tienda.getInstance().EncontrarComponente(cod));

								}

								String codigo = txtCodigo.getText();
								String nombreComb = txtNombreComb.getText();
								float descuento = Float.valueOf(spnDesc.getValue().toString());
								float total = Float.valueOf(textTotalD.getText());
								Combo combo = new Combo (codigo, aux, nombreComb, descuento, total);
								Tienda.getInstance().insertarCombo(combo);
								JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}
							else {
								JOptionPane.showMessageDialog(null, "Rellene todos los campos", "Error", JOptionPane.INFORMATION_MESSAGE);

							}

						}
					});
					okButton.setActionCommand("OK");
					buttonPane1.add(okButton);
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
					buttonPane1.add(cancelButton);
				}
			}
		}
		loadList1();
	}


	protected void clean() {
		txtCodigo.setText("CMB-"+Tienda.getInstance().codComb);
		textTotalD.setText("");
		textTotalR.setText("");
		txtNombreComb.setText("");
		spnDesc.setValue(1);
		selected=null;
		selected2=null;
		totalR=0;
		totalD=0;
		loadList1();
		model2.clear();
		model2.addElement(titulo);
		
	}
	
	private void loadList1() {
		model.removeAllElements();
		model.addElement(titulo);
		for (Componente comp: Tienda.getInstance().getMisComponentes()) {
				model.addElement(comp.getCodigo()+" // "+comp.getMarca()+" // "+"$"+df.format(comp.getPrecio()));
				
		}

	}
}
