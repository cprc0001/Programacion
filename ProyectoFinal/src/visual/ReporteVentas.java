package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTotalVentas;

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
		setTitle("Reporte de Ventas");
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
				txtTotalVentas = new JTextField();
				txtTotalVentas.setHorizontalAlignment(SwingConstants.CENTER);
				txtTotalVentas.setText("120"); //Puse ese número fijo para probar el clean
				txtTotalVentas.setEditable(false);
				txtTotalVentas.setBounds(87, 55, 86, 20);
				panel.add(txtTotalVentas);
				txtTotalVentas.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clean();
					}
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose ();
					}
				});
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void clean() {
		txtTotalVentas.setText("");
	}

}
