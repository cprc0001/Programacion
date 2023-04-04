package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Menú Principal - CheyleTech Corporation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnComponentes = new JMenu("Componentes");
		menuBar.add(mnComponentes);
		
		JMenuItem mntmListadoDeComponentes = new JMenuItem("Componentes disponibles");
		mnComponentes.add(mntmListadoDeComponentes);
		
		JMenu mnCombos = new JMenu("Combos");
		menuBar.add(mnCombos);
		
		JMenuItem mntListaDeCombos = new JMenuItem("Combos disponibles");
		mnCombos.add(mntListaDeCombos);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmListadoDeClientes = new JMenuItem("Listado de Clientes");
		mnClientes.add(mntmListadoDeClientes);
		
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mnVentas.add(mntmFacturar);
		
		JMenuItem mntmListadoDeFacturas = new JMenuItem("Listado de Facturas");
		mnVentas.add(mntmListadoDeFacturas);
		
		JMenu mnAdministrativo = new JMenu("Administración");
		menuBar.add(mnAdministrativo);
		
		JMenuItem mntmReporteDeClientes = new JMenuItem("Reporte de Clientes");
		mnAdministrativo.add(mntmReporteDeClientes);
		
		JMenuItem mntmReporteDeComponentes = new JMenuItem("Reporte de Componentes");
		mnAdministrativo.add(mntmReporteDeComponentes);
		
		JMenuItem mntmReporteDeVentas = new JMenuItem("Reporte de Ventas");
		mnAdministrativo.add(mntmReporteDeVentas);
		
		JMenuItem mntmRegistrarComponentes = new JMenuItem("Registrar Componentes");
		mnAdministrativo.add(mntmRegistrarComponentes);
		
		JMenuItem mntmRegistrarCombos = new JMenuItem("Registrar Combos");
		mnAdministrativo.add(mntmRegistrarCombos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
