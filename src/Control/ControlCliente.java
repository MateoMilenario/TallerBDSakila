/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class ControlCliente {

    public LinkedList<Cliente> ConsultarClientesDatos() {

        LinkedList<Cliente> clientesDatos = new LinkedList<>();

        Cliente objCliente = new Cliente();
        Cliente cEnviar = null;

        String TraerSQL = "SELECT CONCAT(c.first_name, ' ', c.last_name) as NombreCliente, c.customer_id FROM customer c";

        ResultSet rset = null;

        rset = objCliente.TraerClientes(TraerSQL);

        try {

            while (rset.next()) {

                String nombreCliente = rset.getString("NombreCliente");
                String Pkcliente = rset.getString("customer_id");

                cEnviar = new Cliente(nombreCliente, Pkcliente);

                clientesDatos.add(cEnviar);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return clientesDatos;

    }//Fin método

    public LinkedList<String> ConsultaRentasPeriodo(String fechaInicial, String fechaFinal) {

        LinkedList<String> RentaTiempo = new LinkedList<>();

        ResultSet rset = null;
        Cliente objcliente = new Cliente();

        String cadenaDato = "";

        String TraerSQL = "call ConsultaRentaTiempo('" + fechaInicial + "', '" + fechaFinal + "')";

        rset = objcliente.TraerRentasTiempo(TraerSQL);

        try {

            while (rset.next()) {

                String NombreCliente = rset.getString("NombreCliente");
                String NombrePelicula = rset.getString("title");
                String FechaRenta = rset.getString("rental_date");

                cadenaDato = FechaRenta + ";" + NombreCliente + ";" + NombrePelicula;

                RentaTiempo.add(cadenaDato);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return RentaTiempo;

    }

}
