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

import logico.Componente;
import logico.Tienda;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

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
		setBounds(100, 100, 429, 530);
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
		panel.setBounds(5, 161, 394, 100);

		contentPanel.add(panel);
		panel.setLayout(null);

		rdbDiscoDuro = new JRadioButton("Disco Duro");
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
	
		rdbDiscoDuro.setSelected (true);
		rdbDiscoDuro.setBounds(22, 34, 118, 23);
		panel.add(rdbDiscoDuro);
		
		rdbMemoriaRam = new JRadioButton("Memoria RAM");
		rdbMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbMotherBoard.setSelected(false);
				rdbMemoriaRam.setSelected(true);
				rdbMicroprocesador.setSelected(false);
				rdbDiscoDuro.setSelected(false);
				pnlMotherBoard.setVisible(false);
				pnlMemoriaRam.setVisible(true);
				pnlMicroprocesador.setVisible (false);
				pnlDiscoDuro.setVisible (false);
				updateCodigo();
			}
		});
		rdbMemoriaRam.setBounds(201, 34, 156, 23);
		rdbMemoriaRam.setSelected (false);
		panel.add(rdbMemoriaRam);
		
		rdbMicroprocesador = new JRadioButton("Microprocesador");
		rdbMicroprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbMotherBoard.setSelected(false);
				rdbMemoriaRam.setSelected(false);
				rdbMicroprocesador.setSelected(true);
				rdbDiscoDuro.setSelected(false);
				pnlMotherBoard.setVisible(false);
				pnlMemoriaRam.setVisible(false);
				pnlMicroprocesador.setVisible (true); 
				pnlDiscoDuro.setVisible (false);
				updateCodigo();
			}
		});
		
		rdbMicroprocesador.setBounds(22, 65, 156, 23);
		rdbMicroprocesador.setSelected (false);
		panel.add(rdbMicroprocesador);
		
		rdbMotherBoard = new JRadioButton("MotherBoard");
		rdbMotherBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbMotherBoard.setSelected(true);
				rdbMemoriaRam.setSelected(false);
				rdbMicroprocesador.setSelected(false);
				rdbDiscoDuro.setSelected(false);
				pnlMotherBoard.setVisible(true);
				pnlMemoriaRam.setVisible(false);
				pnlMicroprocesador.setVisible (false);
				pnlDiscoDuro.setVisible (false);
				updateCodigo();
			}
		});
		rdbMotherBoard.setBounds(201, 65, 156, 23); 
		rdbMotherBoard.setSelected (false);
		panel.add(rdbMotherBoard);
		
		//c
		
		
		pnlMotherBoard = new JPanel();
		pnlMotherBoard.setVisible(false);
		pnlMotherBoard.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMotherBoard.setBounds(5, 275, 394, 150);
		contentPanel.add(pnlMotherBoard);
		pnlMotherBoard.setLayout(null);

		JLabel lblMarcaMo = new JLabel("Marca:");
		lblMarcaMo.setBounds(15, 16, 84, 20);
		pnlMotherBoard.add(lblMarcaMo);
		
		JLabel lblModeloMo = new JLabel("Modelo:");
		lblModeloMo.setBounds(138, 16, 84, 20);
		pnlMotherBoard.add(lblModeloMo);
		
		JLabel lblTipoConector = new JLabel("Tipo de Conector:");
		lblTipoConector.setBounds(15, 80, 140, 20);
		pnlMotherBoard.add(lblTipoConector);
		
		JComboBox cbxMarcaMo = new JComboBox();
		cbxMarcaMo.setBounds(15, 38, 117, 26);
		pnlMotherBoard.add(cbxMarcaMo);
		
		JComboBox cbxTipoMe = new JComboBox();
		cbxTipoMe.setBounds(264, 38, 119, 26);
		pnlMotherBoard.add(cbxTipoMe);
		
		JComboBox cbxModeloMo = new JComboBox();
		cbxModeloMo.setBounds(138, 38, 117, 26);
		pnlMotherBoard.add(cbxModeloMo);
		
		JComboBox cbxTipoConector = new JComboBox();
		cbxTipoConector.setBounds(15, 109, 129, 26);
		pnlMotherBoard.add(cbxTipoConector);
		
		JLabel lblTipoMe = new JLabel("Tipo de Memoria:");
		lblTipoMe.setBounds(259, 16, 149, 20);
		pnlMotherBoard.add(lblTipoMe);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(157, 108, 226, 26);
		pnlMotherBoard.add(textArea);
		
		JLabel lblConexionesAdmitidas = new JLabel("Conexiones admitidas:");
		lblConexionesAdmitidas.setBounds(161, 80, 167, 20);
		pnlMotherBoard.add(lblConexionesAdmitidas);
		
		
		pnlDiscoDuro = new JPanel();
		pnlDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiscoDuro.setBounds(5, 275, 394, 150);
		contentPanel.add(pnlDiscoDuro);
		pnlDiscoDuro.setLayout(null);

		JLabel lblMarcaD = new JLabel("Marca:");
		lblMarcaD.setBounds(15, 16, 84, 20);
		pnlDiscoDuro.add(lblMarcaD);
		
		JLabel lblModeloD = new JLabel("Modelo:");
		lblModeloD.setBounds(212, 16, 84, 20);
		pnlDiscoDuro.add(lblModeloD);
		
		JLabel lblCapacidadD = new JLabel("Capacidad:");
		lblCapacidadD.setBounds(15, 85, 84, 20);
		pnlDiscoDuro.add(lblCapacidadD);
		
		final JComboBox cbxMarcaD = new JComboBox();
		cbxMarcaD.setBounds(15, 38, 167, 26);
		pnlDiscoDuro.add(cbxMarcaD);
		
		final JComboBox cbxConexionD = new JComboBox();
		cbxConexionD.setBounds(207, 108, 167, 26);
		pnlDiscoDuro.add(cbxConexionD);
		
		final JComboBox cbxModeloD = new JComboBox();
		cbxModeloD.setBounds(207, 38, 167, 26);
		pnlDiscoDuro.add(cbxModeloD);
		
		JComboBox cbxCapacidadD = new JComboBox();
		cbxCapacidadD.setBounds(15, 108, 167, 26);
		pnlDiscoDuro.add(cbxCapacidadD);
		
		JLabel lblTipoConexD = new JLabel("Tipo de Conexi\u00F3n:");
		lblTipoConexD.setBounds(212, 85, 149, 20);
		pnlDiscoDuro.add(lblTipoConexD);
		
		
		pnlMemoriaRam = new JPanel();
		pnlMemoriaRam.setVisible(false);
		pnlMemoriaRam.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMemoriaRam.setBounds(5, 275, 394, 150);
		contentPanel.add(pnlMemoriaRam);
		pnlMemoriaRam.setLayout(null);

		JLabel lblMarcaMe = new JLabel("Marca:");
		lblMarcaMe.setBounds(15, 16, 84, 20);
		pnlMemoriaRam.add(lblMarcaMe);
		
		JLabel lblCapacidadMe = new JLabel("Capacidad:");
		lblCapacidadMe.setBounds(15, 85, 84, 20);
		pnlMemoriaRam.add(lblCapacidadMe);
		
		JComboBox cbxMarcaMe = new JComboBox();
		cbxMarcaMe.setBounds(15, 38, 167, 26);
		pnlMemoriaRam.add(cbxMarcaMe);
		
		final JComboBox cbxCapacidad = new JComboBox();
		cbxCapacidad.setBounds(15, 108, 167, 26);
		pnlMemoriaRam.add(cbxCapacidad);
		
		JComboBox cbxTipoMemoria = new JComboBox();
		cbxTipoMemoria.setBounds(207, 108, 167, 26);
		pnlMemoriaRam.add(cbxTipoMemoria);
		
		JLabel lblTipo = new JLabel("Tipo de Memoria:");
		lblTipo.setBounds(212, 85, 149, 20);
		pnlMemoriaRam.add(lblTipo);
		
		
		
		pnlMicroprocesador = new JPanel();
		pnlMicroprocesador.setVisible(false);
		pnlMicroprocesador.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMicroprocesador.setBounds(5, 275, 394, 150);
		contentPanel.add(pnlMicroprocesador);
		pnlMicroprocesador.setLayout(null);

		JLabel lblMarcaMi = new JLabel("Marca:");
		lblMarcaMi.setBounds(15, 16, 84, 20);
		pnlMicroprocesador.add(lblMarcaMi);
		
		JLabel lblModeloMi = new JLabel("Modelo:");
		lblModeloMi.setBounds(212, 16, 84, 20);
		pnlMicroprocesador.add(lblModeloMi);
		
		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setBounds(15, 85, 84, 20);
		pnlMicroprocesador.add(lblVelocidad);
		
		JComboBox cbxMarcaMi = new JComboBox();
		cbxMarcaMi.setBounds(15, 38, 167, 26);
		pnlMicroprocesador.add(cbxMarcaMi);
		
		JComboBox cbxConexionMi = new JComboBox();
		cbxConexionMi.setBounds(207, 108, 167, 26);
		pnlMicroprocesador.add(cbxConexionMi);
		
		JComboBox cbxModeloMi = new JComboBox();
		cbxModeloMi.setBounds(207, 38, 167, 26);
		pnlMicroprocesador.add(cbxModeloMi);
		
		JComboBox cbxVelocidad = new JComboBox();
		cbxVelocidad.setBounds(15, 108, 167, 26);
		pnlMicroprocesador.add(cbxVelocidad);
		
		JLabel lblTipoConexMi = new JLabel("Tipo de Conexi\u00F3n:");
		lblTipoConexMi.setBounds(212, 85, 149, 20);
		pnlMicroprocesador.add(lblTipoConexMi);
		
	
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					Componente aux = null;
					String codigo = textcodigo.getText();
					float precio = Float.valueOf(spnPrecio.getValue().toString());
					String serie = txtSerie.getText();
					if (rdbDiscoDuro.isSelected()) {
						String marca = cbxMarcaD.getSelectedItem().toString();
						String modelo = cbxModeloD.getSelectedItem().toString();
						String capacidad = cbxCapacidad.getSelectedItem().toString();
						String tipoC = cbxConexionD.getSelectedItem().toString();
						//aux = new DiscoDuro (marca, precio,)
					}
						
					}
				});
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
		if(rdbDiscoDuro.isSelected()){
			pre = "DD";
		}
		if(rdbMemoriaRam.isSelected()){
			pre = "MR";	
		}
		if(rdbMicroprocesador.isSelected()){
			pre = "MP";	
		}
		if(rdbMotherBoard.isSelected()){
			pre = "MB";	
		}
		textcodigo.setText(pre+"-"+Tienda.codComb);

	}
	
	private void clean() {
		pnlDiscoDuro.setVisible(true);
		pnlMemoriaRam.setVisible(false);
		pnlMicroprocesador.setVisible(false);
		pnlMotherBoard.setVisible(false);
		rdbDiscoDuro.setSelected(true);
		rdbMemoriaRam.setSelected(false);
		rdbMicroprocesador.setSelected(false);
		rdbMotherBoard.setSelected(false);
		updateCodigo();
		txtSerie.setText("");
		spnPrecio.setValue(new Float(1));
	}
	
}



