package Servidor;

import java.io.*;
import java.net.*;
import java.util.*;


public class Servidor extends Thread
{

	public static void main (String args[])
	{
		ServerSocket sfd = null;
		try
		{
			sfd = new ServerSocket(8000);
		}
		catch (IOException ioe)
		{
			System.out.println("Comunicacion rechazada."+ioe);
			System.exit(1);
		}

		while (true)
		{
			try
			{
				Socket nsfd = sfd.accept();
				System.out.println("Conexion aceptada de: "+nsfd.getInetAddress());
				DataInputStream hello = new DataInputStream(nsfd.getInputStream());
				DataOutputStream bye = new DataOutputStream(new FileOutputStream(new File ("tienda_respaldo.dat")));

				int unByte;
				try {
					while ((unByte = hello.read()) != -1)
						bye.write(unByte);
						hello.close();
						bye.close();
						System.out.println("Escribiendo...");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			catch(IOException ioe)
			{
				System.out.println("Error: "+ioe);
			}
		}
	}
}
