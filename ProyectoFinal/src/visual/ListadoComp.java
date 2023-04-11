package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

import logico.Combo;
import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.MotherBoard;
import logico.Tienda;

public class ListadoComp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];
	private JComboBox comboBox;
	private DecimalFormat df = new DecimalFormat("0.00");
	private JButton btnEliminar;
	private JButton btnVer;
	private Componente selected = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoComp dialog = new ListadoComp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoComp() {
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
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));
			{
				JLabel lblTipoComp = new JLabel("Tipo de Componentes:");
				lblTipoComp.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(lblTipoComp);
			}
			{
				comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadComponentes(comboBox.getSelectedIndex());
					}
				});
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Disco Duro", "Memoria RAM", "Microprocesador", "Mother Board"}));
				panel.add(comboBox);
			}
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
					String[] headers = {"Codigo","Tipo", "Precio", "Disponibles", "Estado"};

					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int index = table.getSelectedRow();
							if(index>=0){
								btnEliminar.setEnabled(true);
								btnVer.setEnabled(true);
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
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected!=null) {
							int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el Componente con codigo: "+selected.getCodigo(), "Eliminar Componente", JOptionPane.OK_CANCEL_OPTION);
							if(option == JOptionPane.OK_OPTION){
								Tienda.getInstance().EliminarComponente(selected);
								loadComponentes(0);

								for (Combo comb : Tienda.getInstance().getMisCombos()){
									int	i=0;
									boolean encontrado = false;
									while (!encontrado && i< comb.getMisComponentes().size()){
										if (comb.getMisComponentes().get(i).getCodigo() == selected.getCodigo()){
											Tienda.getInstance().EliminarCombo(comb);
											encontrado = true;
										}
										i++;

									}

								}
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
								VerComponente verComp = new VerComponente(selected);
								verComp.setModal(true);
								verComp.setVisible(true);
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
		loadComponentes(0);
	}

	protected void loadComponentes(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if(index == 0){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				rows[0] = aux.getCodigo();
				rows[2] = df.format(aux.getPrecio());
				rows[3] = aux.getDisponibles();
				rows[4] = aux.getEstado();
				if(aux instanceof DiscoDuro){
					rows[1] = "Disco Duro";	
				}
				if(aux instanceof MemoriaRam){
					rows[1] = "Memoria RAM";	
				}
				if(aux instanceof Microprocesador){
					rows[1] = "Microprocesador";
				}
				if(aux instanceof MotherBoard){
					rows[1] = "Mother Board";
				}
				model.addRow(rows);
			}
		}


		if(index == 1){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if(aux instanceof DiscoDuro){
					rows[0] = aux.getCodigo();
					rows[1] = "Disco Duro";	
					rows[2] = df.format(aux.getPrecio());
					rows[3] = aux.getDisponibles();
					rows[4] = aux.getEstado();
					model.addRow(rows);
				}
			}	
		}
		if(index == 2){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if(aux instanceof MemoriaRam){
					rows[0] = aux.getCodigo();
					rows[1] = "Memoria RAM";
					rows[2] = df.format(aux.getPrecio());
					rows[3] = aux.getDisponibles();
					rows[4] = aux.getEstado();
					model.addRow(rows);
				}
			}	
		}
		if(index == 3){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if(aux instanceof Microprocesador){
					rows[0] = aux.getCodigo();
					rows[1] = "Microprocesador";
					rows[2] = df.format(aux.getPrecio());
					rows[3] = aux.getDisponibles();
					rows[4] = aux.getEstado();
					model.addRow(rows);
				}
			}	
		}

		if(index == 4){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if(aux instanceof MotherBoard){
					rows[0] = aux.getCodigo();
					rows[1] = "Mother Board";
					rows[2] = df.format(aux.getPrecio());
					rows[3] = aux.getDisponibles();
					rows[4] = aux.getEstado();
					model.addRow(rows);
				}
			}	
		}

	}
}


