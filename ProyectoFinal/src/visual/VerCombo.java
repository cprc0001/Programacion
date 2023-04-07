package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Combo;
import logico.Componente;
import logico.Tienda;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private DefaultListModel<Object> model;
	private JList<Object> listComp;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTotal;
	private String titulo = ("Codigo // Marca // Precio");
	private DecimalFormat df = new DecimalFormat("0.00");
	private Combo auxComb= null;
	private JTextField txtDesc;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerCombo dialog = new VerCombo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerCombo(Combo comb) {
		auxComb= comb;
		setTitle("Ver Componente");
		setBounds(100, 100, 496, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 20, 452, 228);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 34, 177, 174);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		model = new DefaultListModel<>();
		listComp = new JList <>(model);
		listComp.setVisibleRowCount(2);
		listComp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listComp);

		JLabel lblComp = new JLabel("Componentes del Combo:");
		lblComp.setBounds(13, 9, 197, 20);
		panel_1.add(lblComp);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(224, 92, 71, 20);
		panel_1.add(lblNombre);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(230, 177, 71, 20);
		panel_1.add(lblPrecio);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(291, 86, 146, 26);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(291, 174, 146, 26);
		panel_1.add(txtTotal);
		txtTotal.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(291, 43, 146, 26);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(230, 46, 71, 20);
		panel_1.add(lblCodigo);

		JLabel lblDesc = new JLabel("Descuento:");
		lblDesc.setBounds(207, 136, 79, 20);
		panel_1.add(lblDesc);

		txtDesc = new JTextField();
		txtDesc.setEditable(false);
		txtDesc.setColumns(10);
		txtDesc.setBounds(291, 131, 146, 26);
		panel_1.add(txtDesc);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnListo = new JButton("Listo");
				btnListo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnListo.setActionCommand("Cancel");
				buttonPane.add(btnListo);
			}
		}

		loadList1(auxComb);
	}

	private void loadList1(Combo auxComb) {
		model.addElement(titulo);
		if (auxComb != null) {
			txtNombre.setText(auxComb.getNombreComb());
			txtCodigo.setText(auxComb.getCodigo());
			txtTotal.setText("RD$:"+auxComb.getTotalD());
			txtDesc.setText(auxComb.getDes()+" %");

			for (Componente comp : auxComb.getMisComponentes()) {
				model.addElement(comp.getCodigo()+" // "+"Marca: "+comp.getMarca());
			}
		} 

		if (auxComb == null) {
			txtNombre.setText("");
			txtCodigo.setText("");
			txtTotal.setText("");
			txtDesc.setText("");
		}
	}

}
