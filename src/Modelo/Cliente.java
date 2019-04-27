/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.ConnectBD;
import java.sql.ResultSet;

/**
 *
 * @author Mateo
 */
public class Cliente {

    private String NombreCliente;
    private String PkCliente;

    public Cliente() {
    }

    public Cliente(String NombreCliente, String PkCliente) {
        this.NombreCliente = NombreCliente;
        this.PkCliente = PkCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getPkCliente() {
        return PkCliente;
    }

    public void setPkCliente(String PkCliente) {
        this.PkCliente = PkCliente;
    }

    public ResultSet TraerClientes(String TraerSQL) {

        ResultSet rset = null;

        ConnectBD CBD = new ConnectBD();

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                rset = CBD.getSt().executeQuery(TraerSQL);

            } catch (Exception ex) {

                ex.printStackTrace();

            }//Fin try

        }//Fin if

        return rset;

    }//Fin método

    public ResultSet TraerRentasTiempo(String TraerSQL) {

        ResultSet rset = null;

        ConnectBD CBD = new ConnectBD();

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                rset = CBD.getSt().executeQuery(TraerSQL);

            } catch (Exception ex) {

                ex.printStackTrace();

            }//Fin try

        }//Fin if

        return rset;

    }//Fin método

}
