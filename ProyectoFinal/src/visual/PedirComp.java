package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Componente;
import logico.Tienda;
import logico.Combo;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PedirComp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Componente auxC= null;
	private JTextField txtCodigo;
	private JTextField txtDisponible;
	private JTextField txtMin;
	private JSpinner spinner;
	private int cant=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PedirComp dialog = new PedirComp(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PedirComp(Componente comp) {
		auxC= comp;
		setTitle("Pedir Componente");
		setBounds(100, 100, 466, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 428, 87);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(10, 14, 45, 14);
		panel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(83, 10, 114, 23);
		panel.add(txtCodigo);

		JLabel lblDisponible = new JLabel("Disponibles:");
		lblDisponible.setBounds(10, 56, 71, 14);
		panel.add(lblDisponible);

		txtDisponible = new JTextField();
		txtDisponible.setEditable(false);
		txtDisponible.setColumns(10);
		txtDisponible.setBounds(83, 52, 114, 23);

		panel.add(txtDisponible);

		JLabel lblDispMinima = new JLabel("Disp. Min.");
		lblDispMinima.setBounds(239, 15, 71, 14);
		panel.add(lblDispMinima);

		txtMin = new JTextField();
		txtMin.setEditable(false);
		txtMin.setColumns(10);
		txtMin.setBounds(299, 10, 114, 23);

		panel.add(txtMin);

		JLabel lblPedir = new JLabel("Pedir:");
		lblPedir.setBounds(263, 57, 45, 14);
		panel.add(lblPedir);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(299, 51, 114, 26);
		panel.add(spinner);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton btnPedir = new JButton("Pedir");
			btnPedir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					cant= Integer.valueOf(spinner.getValue().toString());
					auxC.setDisponibles(auxC.getDisponibles()+cant);
					auxC.setCant(auxC.getDisponibles());
					if (auxC.getDisponibles()>auxC.getDispMin()) {
						auxC.setEstado('D');
					} else if (auxC.getDisponibles()< auxC.getDispMin() && auxC.getDisponibles()!=0) {
						auxC.setEstado('P');
					}

					for(Combo comb : Tienda.getInstance().getMisCombos()){
						for (Componente comp : Tienda.getInstance().getMisComponentes()) {
							if (comp.getCodigo().equalsIgnoreCase(auxC.getCodigo())) {
								comp.setDisponibles(auxC.getDisponibles());
								comp.setCant(auxC.getDisponibles());
								if (comp.getDisponibles()>comp.getDispMin()) {
									comp.setEstado('D');
								} else if (auxC.getDisponibles()< auxC.getDispMin() && auxC.getDisponibles()!=0) {
									comp.setEstado('P');
								}
							}
						}
					}

					ListPedidos.loadComponentes();
					JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			});
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
		loadComp();
	}

	private void loadComp() {
		if(auxC!=null){
			txtCodigo.setText(auxC.getCodigo());
			txtDisponible.setText(""+auxC.getDisponibles());
			txtMin.setText(""+auxC.getDispMin());
		}
	}
}
