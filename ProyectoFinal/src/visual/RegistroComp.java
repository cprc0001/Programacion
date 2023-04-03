package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class RegistroComp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textcodigo;
	private JSpinner spnPrecio;
	private JTextField txtSerie;
	private JRadioButton rdbMotherBoard;
	private JRadioButton rdbMemoriaRam;
	private JRadioButton rdbMicroprocesador;
	private JRadioButton rdbDiscoDuro;
	private JPanel pnlMotherBoard;
	private JPanel pnlMicroprocesador;
	private JPanel pnlMemoriaRam;
	private JPanel pnlDiscoDuro;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroComp dialog = new RegistroComp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroComp() {
		setTitle ("Registro de Componentes");
		setBounds(100, 100, 429, 533);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 394, 152);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(20, 28, 77, 20);
			panel.add(lblCdigo);

			textcodigo = new JTextField();
			textcodigo.setEditable(false);
			textcodigo.setBounds(20, 49, 146, 20);
			panel.add(textcodigo);
			textcodigo.setColumns(10);

			JLabel lblPrecioBase = new JLabel("Costo Unitario:");
			lblPrecioBase.setBounds(20, 82, 125, 14);
			panel.add(lblPrecioBase);

			JLabel lblCostoUnitario = new JLabel("Disp. M\u00EDnima:");
			lblCostoUnitario.setBounds(152, 76, 118, 26);
			panel.add(lblCostoUnitario);

			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnPrecio.setBounds(20, 107, 103, 20);
			panel.add(spnPrecio);
			
			txtSerie = new JTextField();
			txtSerie.setColumns(10);
			txtSerie.setBounds(233, 49, 146, 20);
			panel.add(txtSerie);
			
			JLabel lblNoSerie = new JLabel("No. Serie:");
			lblNoSerie.setBounds(233, 31, 77, 14);
			panel.add(lblNoSerie);
			
			JSpinner spnDispMin = new JSpinner();
			spnDispMin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnDispMin.setBounds(152, 107, 103, 20);
			panel.add(spnDispMin);
			
			JSpinner spnDispReal = new JSpinner();
			spnDispReal.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnDispReal.setBounds(276, 107, 103, 20);
			panel.add(spnDispReal);
			
			JLabel lblDispMxima = new JLabel("Disp. Real:");
			lblDispMxima.setBounds(285, 76, 109, 26);
			panel.add(lblDispMxima);
			
			JSpinner spinner = new JSpinner();
			contentPanel.add(spinner);
		}	
		

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Componente:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(5, 161, 384, 100);

		contentPanel.add(panel);
		panel.setLayout(null);

		rdbDiscoDuro = new JRadioButton("DiscoDuro");
		rdbDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbMotherBoard.setSelected(false);
				rdbMemoriaRam.setSelected(false);
				rdbMicroprocesador.setSelected(false);
				rdbDiscoDuro.setSelected(true);
				pnlMotherBoard.setVisible(false);
				pnlMemoriaRam.setVisible(false);
				pnlMicroprocesador.setVisible (false);
				pnlDiscoDuro.setVisible (true);
				updateCodigo();
			}
		});
	
	
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
		private void updateCodigo() {
			String pre = "";
			
		}
		
	
	
}



