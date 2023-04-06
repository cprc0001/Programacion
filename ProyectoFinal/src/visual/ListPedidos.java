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

import logico.Componente;
import logico.Tienda;

public class ListPedidos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private static DecimalFormat df = new DecimalFormat("0.00");
	private JButton btnPedir;
	private Componente selected = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListPedidos dialog = new ListPedidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListPedidos() {
		setTitle("Listado de Componentes");
		setBounds(100, 100, 581, 345);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));


		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String[] headers = {"Codigo","Tipo", "Disponibles", "Estado"};

					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int index = table.getSelectedRow();
							if(index>=0){
								btnPedir.setEnabled(true);
								String codigo = table.getValueAt(index, 0).toString();
								selected =  Tienda.getInstance().EncontrarComponente(codigo);
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
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnPedir = new JButton("Pedir");
			btnPedir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					PedirComp P = new PedirComp(selected); 
					P.setModal(true);
					P.setVisible(true);
					btnPedir.setEnabled(false);
				}
			});
			btnPedir.setEnabled(false);
			buttonPane.add(btnPedir);
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

	public static void loadComponentes() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		char a='D';
		for (Componente aux : Tienda.getInstance().getMisComponentes()) {
			if (Character.compare(aux.getEstado(), a)!=0  ) {
				rows[0] = aux.getCodigo();	
				rows[1] = df.format(aux.getPrecio());
				rows[2] = aux.getDisponibles();
				rows[3] = aux.getEstado();
				model.addRow(rows);
			}
		}	

	}

}


