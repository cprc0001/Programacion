package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Combo;
import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.MotherBoard;
import logico.Tienda;

public class ListadoComb extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];
	private DecimalFormat df = new DecimalFormat("0.00");
	private JButton btnEliminar;
	private JButton btnVer;
	private Combo selected = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoComb dialog = new ListadoComb();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoComb() {
		setTitle("Listado de Combos");
		setBounds(100, 100, 581, 345);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));

		}

		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String[] headers = {"Codigo","Nombre de Combo", "Precio"};

					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int index = table.getSelectedRow();
							if(index>=0){
								btnEliminar.setEnabled(true);
								btnVer.setEnabled(true);
								String codigo = table.getValueAt(index, 0).toString();
								selected =  Tienda.getInstance().EncontrarCombo(codigo);
							}

						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);

					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected!=null) {
							int option = JOptionPane.showConfirmDialog(null, "Est� seguro que desea eliminar el Componente con c�digo: "+selected.getCodigo(), "Eliminar Componente", JOptionPane.OK_CANCEL_OPTION);
							if(option == JOptionPane.OK_OPTION){
								Tienda.getInstance().EliminarCombo(selected);
								loadComponentes();
								btnEliminar.setEnabled(false);

							}

						}

					}
				});
				{
					btnVer = new JButton("Ver Detalles");
					btnVer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (selected!=null) {

							}
						}
					});
					btnVer.setEnabled(false);
					buttonPane.add(btnVer);
				}
				buttonPane.add(btnEliminar);
			}
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
		loadComponentes();
	}

	protected void loadComponentes() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Combo aux : Tienda.getInstance().getMisCombos()) {
			rows[0] = aux.getCodigo();
			rows[1] = aux.getNombreComb();
			rows[2] = df.format(aux.getTotalD());
			
			model.addRow(rows);
		}


	}
}

