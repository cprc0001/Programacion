package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import logico.Tienda;
import logico.User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */

	/*public static void main(String[] args) {
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
	} */

	/**
	 * Create the frame.
	 */
	public Principal() {

		addWindowListener(new WindowAdapter() {
			@Override

			public void windowClosing(WindowEvent e) {
				FileOutputStream tienda2;
				ObjectOutputStream tiendaWrite;
				try {
					tienda2 = new FileOutputStream("tienda.dat");
					tiendaWrite = new ObjectOutputStream(tienda2);
					tiendaWrite.writeObject(Tienda.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}


		});


		setTitle("Sistema de CheyleTech Corporation - Menu Principal");
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

		JMenuItem mntmPedirComp = new JMenuItem("Lista Pedir Componentes");
		mntmPedirComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPedidos listP = new ListPedidos();
				listP.setModal(true);
				listP.setVisible(true);
			}
		});
		mnComponentes.add(mntmPedirComp);

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
		mntmListadoDeFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListaFacturas listFacturas = new ListaFacturas();
				listFacturas.setModal(true);
				listFacturas.setVisible(true);

			}
		});
		mnVentas.add(mntmListadoDeFacturas);

		JMenu mnAdministrativo = new JMenu("Administracion");
		if(Tienda.getLoginUser().getTipo().equalsIgnoreCase("Administrador")) {
		mnAdministrativo.setEnabled(false);	
		}
		menuBar.add(mnAdministrativo);

		JMenu mnNewMenu = new JMenu("Usuarios");
		mnAdministrativo.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar Usuarios");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegUser registrarUser = new RegUser();
				registrarUser.setModal(true);
				registrarUser.setVisible(true);
				 
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Ver Usuarios");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VerUsuarios verUser = new VerUsuarios();
				verUser.setModal(true);
				verUser.setVisible(true); 
				 
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmReporteDeClientes = new JMenuItem("Reporte de Clientes");
		mntmReporteDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReporteCliente repC = new ReporteCliente();
				repC.setModal(true);
				repC.setVisible(true);

			}
		});
		mnAdministrativo.add(mntmReporteDeClientes);

		JMenuItem mntmReporteDeVentas = new JMenuItem("Reporte de Ventas");
		mntmReporteDeVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReporteVentas repV = new ReporteVentas();
				repV.setModal(true);
				repV.setVisible(true); 
				
			}
		});
		mnAdministrativo.add(mntmReporteDeVentas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
