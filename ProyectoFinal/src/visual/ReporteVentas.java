package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteVentas dialog = new ReporteVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteVentas() {
		setTitle("Reporte Total de Ventas");
		setBounds(100, 100, 300, 190);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblTotalVentas = new JLabel("Se ha vendido un total de:");
				lblTotalVentas.setHorizontalAlignment(SwingConstants.CENTER);
				lblTotalVentas.setBounds(34, 30, 196, 14);
				panel.add(lblTotalVentas);
			}
			{
				txtVenta = new JTextField();
				txtVenta.setHorizontalAlignment(SwingConstants.CENTER);
				txtVenta.setText(""); 
				txtVenta.setEditable(false);
				txtVenta.setBounds(87, 55, 86, 20);
				panel.add(txtVenta);
				txtVenta.setColumns(10);
				
				//SENTENCIA A TOMAR EN CUENTA
				//txtVenta.setText(String.valueOf(Tienda.getInstance().TotalVendido()));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose ();
					}
				});
				buttonPane.add(btnAceptar);
			}
		}
	}
	
	

}
