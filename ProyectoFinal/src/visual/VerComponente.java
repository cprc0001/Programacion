package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sun.prism.paint.Color;

import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.MotherBoard;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Componente auxComp;
	private JTextField textcodigo;
	private JTextField txtPrecio;
	private JTextField txtSerie;
	private JPanel pnlMotherBoard;
	private JPanel pnlMicroprocesador;
	private JPanel pnlMemoriaRam;
	private JPanel pnlDiscoDuro;
	private JTextField txtMarcaD;
	private JTextField txtConexionD;
	private JTextField txtModeloD;
	private JTextField txtCapacidadD;
	private JTextField txtMarcaMe;
	private JTextField txtCapacidad;
	private JTextField txtTipoMemoria;
	private JTextField txtMarcaMi;
	private JTextField txtConexionMi;
	private JTextField txtModeloMi;
	private JTextField txtVelocidad;
	private JTextField txtMarcaMo;
	private JTextField txtTipoMe;
	private JTextField txtModeloMo;
	private JTextField txtTipoConector;
	private JTextArea txtConexAd;
	private JTextField textTipo;
	private DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerComponente dialog = new VerComponente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerComponente(Componente comp) {
		setTitle("Detalles del componente seleccionado");
		auxComp = comp;
		setBounds(100, 100, 423, 410);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 394, 152);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General:", TitledBorder.LEADING, TitledBorder.TOP, null));
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
			lblPrecioBase.setBounds(232, 85, 125, 14);
			panel.add(lblPrecioBase);

			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(232, 103, 146, 20);
			panel.add(txtPrecio);
			txtPrecio.setColumns(10);

			txtSerie = new JTextField();
			txtSerie.setEditable(false);
			txtSerie.setColumns(10);
			txtSerie.setBounds(233, 49, 146, 20);
			panel.add(txtSerie);

			JLabel lblNoSerie = new JLabel("No. Serie:");
			lblNoSerie.setBounds(233, 31, 77, 14);
			panel.add(lblNoSerie);

			JLabel labelTipo = new JLabel("Tipo de Componente:");
			labelTipo.setBounds(15, 85, 162, 14);
			panel.add(labelTipo);

			textTipo = new JTextField();
			textTipo.setEditable(false);
			textTipo.setColumns(10);
			textTipo.setBounds(20, 103, 146, 20);
			panel.add(textTipo);

		}	



		pnlDiscoDuro = new JPanel();
		pnlDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiscoDuro.setBounds(5, 165, 394, 150);
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

		txtMarcaD = new JTextField();
		txtMarcaD.setEditable(false);
		txtMarcaD.setColumns(10);
		txtMarcaD.setBounds(15, 38, 167, 26);
		pnlDiscoDuro.add(txtMarcaD);

		txtConexionD = new JTextField();
		txtConexionD.setEditable(false);
		txtConexionD.setColumns(10);
		txtConexionD.setBounds(207, 108, 167, 26);
		pnlDiscoDuro.add(txtConexionD);

		txtModeloD = new JTextField();
		txtModeloD.setEditable(false);
		txtModeloD.setColumns(10);
		txtModeloD.setBounds(207, 38, 167, 26);
		pnlDiscoDuro.add(txtModeloD);


		txtCapacidadD = new JTextField();
		txtCapacidadD.setEditable(false);
		txtCapacidadD.setColumns(10);
		txtCapacidadD.setBounds(15, 108, 167, 26);
		pnlDiscoDuro.add(txtCapacidadD);

		JLabel lblTipoConexD = new JLabel("Tipo de Conexion:");
		lblTipoConexD.setBounds(212, 85, 149, 20);
		pnlDiscoDuro.add(lblTipoConexD);


		pnlMemoriaRam = new JPanel();
		pnlMemoriaRam.setVisible(false);
		pnlMemoriaRam.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMemoriaRam.setBounds(5, 165, 394, 150);
		contentPanel.add(pnlMemoriaRam);
		pnlMemoriaRam.setLayout(null);

		JLabel lblMarcaMe = new JLabel("Marca:");
		lblMarcaMe.setBounds(15, 16, 84, 20);
		pnlMemoriaRam.add(lblMarcaMe);

		JLabel lblCapacidadMe = new JLabel("Capacidad:");
		lblCapacidadMe.setBounds(15, 85, 84, 20);
		pnlMemoriaRam.add(lblCapacidadMe);

		txtMarcaMe = new JTextField();
		txtMarcaMe.setEditable(false);
		txtMarcaMe.setColumns(10);
		txtMarcaMe.setBounds(15, 38, 167, 26);
		pnlMemoriaRam.add(txtMarcaMe);

		txtCapacidad = new JTextField();
		txtCapacidad.setEditable(false);
		txtCapacidad.setColumns(10);
		txtCapacidad.setBounds(15, 108, 167, 26);
		pnlMemoriaRam.add(txtCapacidad);

		txtTipoMemoria = new JTextField();
		txtTipoMemoria.setEditable(false);
		txtTipoMemoria.setColumns(10);;
		txtTipoMemoria.setBounds(207, 108, 167, 26);
		pnlMemoriaRam.add(txtTipoMemoria);

		JLabel lblTipo = new JLabel("Tipo de Memoria:");
		lblTipo.setBounds(212, 85, 149, 20);
		pnlMemoriaRam.add(lblTipo);



		pnlMicroprocesador = new JPanel();
		pnlMicroprocesador.setVisible(false);
		pnlMicroprocesador.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMicroprocesador.setBounds(5, 165, 394, 150);
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

		txtMarcaMi = new JTextField();
		txtMarcaMi.setEditable(false);
		txtMarcaMi.setColumns(10);
		txtMarcaMi.setBounds(15, 38, 167, 26);
		pnlMicroprocesador.add(txtMarcaMi);

		txtConexionMi = new JTextField();
		txtConexionMi.setEditable(false);
		txtConexionMi.setColumns(10);
		txtConexionMi.setBounds(207, 108, 167, 26);
		pnlMicroprocesador.add(txtConexionMi);

		txtModeloMi = new JTextField();
		txtModeloMi.setEditable(false);
		txtModeloMi.setColumns(10);
		txtModeloMi.setBounds(207, 38, 167, 26);
		pnlMicroprocesador.add(txtModeloMi);

		txtVelocidad = new JTextField();
		txtVelocidad.setEditable(false);
		txtVelocidad.setColumns(10);
		txtVelocidad.setBounds(15, 108, 167, 26);
		pnlMicroprocesador.add(txtVelocidad);

		JLabel lblTipoConexMi = new JLabel("Tipo de Conexi\u00F3n:");
		lblTipoConexMi.setBounds(212, 85, 149, 20);
		pnlMicroprocesador.add(lblTipoConexMi);


		pnlMotherBoard = new JPanel();
		pnlMotherBoard.setVisible(false);
		pnlMotherBoard.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMotherBoard.setBounds(5, 165, 394, 150);
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

		txtMarcaMo = new JTextField();
		txtMarcaMo.setEditable(false);
		txtMarcaMo.setColumns(10);
		txtMarcaMo.setBounds(15, 38, 117, 26);
		pnlMotherBoard.add(txtMarcaMo);

		txtTipoMe = new JTextField();
		txtTipoMe.setEditable(false);
		txtTipoMe.setColumns(10);
		txtTipoMe.setBounds(264, 38, 119, 26);
		pnlMotherBoard.add(txtTipoMe);

		txtModeloMo = new JTextField();
		txtModeloMo.setEditable(false);
		txtModeloMo.setColumns(10);
		txtModeloMo.setBounds(138, 38, 117, 26);
		pnlMotherBoard.add(txtModeloMo);

		txtTipoConector = new JTextField();
		txtTipoConector.setEditable(false);
		txtTipoConector.setColumns(10);
		txtTipoConector.setBounds(15, 109, 129, 26);
		pnlMotherBoard.add(txtTipoConector);

		JLabel lblTipoMe = new JLabel("Tipo de Memoria:");
		lblTipoMe.setBounds(259, 16, 149, 20);
		pnlMotherBoard.add(lblTipoMe);

		txtConexAd = new JTextArea();
		txtConexAd.setEditable(false);
		txtConexAd.setColumns(10);
		txtConexAd.setBounds(157, 108, 226, 26);
		pnlMotherBoard.add(txtConexAd);

		JLabel lblConexionesAdmitidas = new JLabel("Conexiones admitidas:");
		lblConexionesAdmitidas.setBounds(161, 80, 167, 20);
		pnlMotherBoard.add(lblConexionesAdmitidas);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadPanel(auxComp);
		updateCodigo(auxComp);
	}

	private void updateCodigo(Componente auxComp) {
		if (auxComp!=null) {
			textcodigo.setText(auxComp.getCodigo());
			txtPrecio.setText(""+df.format(auxComp.getPrecio()));
			txtSerie.setText(auxComp.getSerie());

			if (auxComp instanceof DiscoDuro) {
				txtMarcaD.setText(auxComp.getMarca());
				txtConexionD.setText(((DiscoDuro) auxComp).getTipoConexion());
				txtModeloD.setText(((DiscoDuro) auxComp).getModelo());
				txtCapacidadD.setText(((DiscoDuro) auxComp).getCapacidad());
				textTipo.setText("Disco Duro");
			}

			if (auxComp instanceof MemoriaRam) {
				txtMarcaMe.setText(auxComp.getMarca());
				txtCapacidad.setText(((MemoriaRam) auxComp).getMemoria());
				txtTipoMemoria.setText(((MemoriaRam) auxComp).getTipo());
				textTipo.setText("Memoria RAM");
			}

			if (auxComp instanceof Microprocesador) {
				txtMarcaMi.setText(auxComp.getMarca());
				txtConexionMi.setText(((Microprocesador) auxComp).getTipoConexion());
				txtModeloMi.setText(((Microprocesador) auxComp).getModelo());
				txtVelocidad.setText(((Microprocesador) auxComp).getVelocidad());
				textTipo.setText("Microprocesador");
			}

			if (auxComp instanceof MotherBoard) {
				txtMarcaMo.setText(auxComp.getMarca());
				txtTipoMe.setText(((MotherBoard) auxComp).getTipoMemoria());
				txtModeloMo.setText(((MotherBoard) auxComp).getModelo());
				txtTipoConector.setText(((MotherBoard) auxComp).getTipoConector());
				txtConexAd.setText(((MotherBoard) auxComp).getConexionesDisco());
				textTipo.setText("Mother Board");
			}
		}
		if (auxComp==null) {
			textcodigo.setText("");
			txtPrecio.setText("");
			txtSerie.setText("");
			txtMarcaMe.setText("");
			txtCapacidad.setText("");
			txtTipoMemoria.setText("");
			txtMarcaMe.setText("");
			txtCapacidad.setText("");
			txtTipoMemoria.setText("");
			txtMarcaMi.setText("");
			txtConexionMi.setText("");
			txtModeloMi.setText("");
			txtVelocidad.setText("");
			txtMarcaMo.setText("");
			txtTipoMe.setText("");
			txtModeloMo.setText("");
			txtTipoConector.setText("");
			txtConexAd.setText("");
			textTipo.setText("");
		
		
		}
	}

	private void loadPanel(Componente auxComp) {
		if (auxComp!=null) {
			if (auxComp instanceof DiscoDuro) {
				pnlMotherBoard.setVisible(false);
				pnlMicroprocesador.setVisible(false);
				pnlMemoriaRam.setVisible(false);
				pnlDiscoDuro.setVisible(true);
			}

			if (auxComp instanceof MemoriaRam) {
				pnlMotherBoard.setVisible(false);
				pnlMicroprocesador.setVisible(false);
				pnlMemoriaRam.setVisible(true);
				pnlDiscoDuro.setVisible(false);
			}

			if (auxComp instanceof Microprocesador) {
				pnlMotherBoard.setVisible(false);
				pnlMicroprocesador.setVisible(true);
				pnlMemoriaRam.setVisible(false);
				pnlDiscoDuro.setVisible(false);
			}

			if (auxComp instanceof MotherBoard) {
				pnlMotherBoard.setVisible(true);
				pnlMicroprocesador.setVisible(false);
				pnlMemoriaRam.setVisible(false);
				pnlDiscoDuro.setVisible(false);
			}

		}
		else if (auxComp==null) {
			pnlMotherBoard.setVisible(false);
			pnlMicroprocesador.setVisible(false);
			pnlMemoriaRam.setVisible(false);
			pnlDiscoDuro.setVisible(true);
		}


	}


}
