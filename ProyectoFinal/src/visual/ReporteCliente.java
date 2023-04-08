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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logico.Componente;
import logico.Factura;
import logico.Tienda;

public class ReporteCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtCant;
	private JTextField txtTotal;
	private JButton btnBuscar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteCliente dialog = new ReporteCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteCliente() {
		setTitle("Reporte de Clientes");
		setBounds(100, 100, 450, 246);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(94, 33, 174, 26);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
	
			
			JLabel lblNewLabel = new JLabel("C\u00E9dula:");
			lblNewLabel.setBounds(31, 39, 64, 20);
			panel.add(lblNewLabel);
			
			JLabel lblTotalDeCompras = new JLabel("Total en compras:");
			lblTotalDeCompras.setBounds(31, 94, 189, 20);
			panel.add(lblTotalDeCompras);
			
			txtTotal = new JTextField();
			txtTotal.setEditable(false);
			txtTotal.setColumns(10);
			txtTotal.setBounds(169, 91, 208, 26);
			panel.add(txtTotal);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean i=false;
					float totalcompra=0;
					for (Factura fac : Tienda.getInstance().getMisFacturas()) {
						if  (txtCodigo.getText().equalsIgnoreCase(fac.getCliente().getCedula())) {
							totalcompra+=fac.PrecioFactura();
							i=true;
							
						}
					}
					if(i==true) {
					    txtTotal.setText("RD$: "+String.valueOf(totalcompra));;
						btnBuscar.setEnabled(false);
					}
					else if (i==false) {
						
						JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
					
				}
			});
			btnBuscar.setBounds(283, 32, 94, 29);
			panel.add(btnBuscar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cancelar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clean();
					}

				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(okButton);
			}
		
		}
	}
	
	private void clean() {
		txtCodigo.setText("");
		txtTotal.setText("");
		btnBuscar.setEnabled(true);
	}
}