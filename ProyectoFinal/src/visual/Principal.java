package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

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
		setTitle("Sistema de CheyleTech Corporation - Men� Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnComponentes = new JMenu("Componentes");
		menuBar.add(mnComponentes);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Componentes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroComp regComp = new RegistroComp();
				regComp.setModal(true);
				regComp.setVisible(true);
			}
		});
		mnComponentes.add(mntmNewMenuItem);
		
		JMenuItem mntmListadoDeComponentes = new JMenuItem("Listado de Componentes");
		mntmListadoDeComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoComp listComp = new ListadoComp();
				listComp.setModal(true);
				listComp.setVisible(true);
			}
		});
		mnComponentes.add(mntmListadoDeComponentes);
		
		JMenu mnCombos = new JMenu("Combos");
		menuBar.add(mnCombos);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar Combo");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroComb regComb = new RegistroComb();
				regComb.setModal(true);
				regComb.setVisible(true);
			}
		});
		mnCombos.add(mntmNewMenuItem_1);
		
		JMenuItem mntListaDeCombos = new JMenuItem("Combos disponibles");
		mntListaDeCombos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListadoComb listComb = new ListadoComb();
				listComb.setModal(true);
				listComb.setVisible(true);
			}
		});
		mnCombos.add(mntListaDeCombos);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmListadoDeClientes = new JMenuItem("Listado de Clientes");
		mntmListadoDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListaClientes listClientes = new ListaClientes();
				listClientes.setModal(true);
				listClientes.setVisible(true);
				 
			}
		});
		mnClientes.add(mntmListadoDeClientes);
		
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar fac = new Facturar();
				fac.setModal(true);
				fac.setVisible(true);
			}
		});
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
