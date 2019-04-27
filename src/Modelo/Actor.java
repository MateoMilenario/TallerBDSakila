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
public class Actor {

    private String NombreActor;
    private String pkActor;

    public Actor() {
    }

    public Actor(String NombreActor, String pkActor) {
        this.NombreActor = NombreActor;
        this.pkActor = pkActor;
    }

    public String getNombreActor() {
        return NombreActor;
    }

    public void setNombreActor(String NombreActor) {
        this.NombreActor = NombreActor;
    }

    public String getPkActor() {
        return pkActor;
    }

    public void setPkActor(String pkActor) {
        this.pkActor = pkActor;
    }

    public ResultSet TraerActores(String TraerSQL) {

        ResultSet rset = null;

        ConnectBD CBD = new ConnectBD();

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                rset = CBD.getSt().executeQuery(TraerSQL);

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        }//Fin if

        return rset;

    }//Fin método

}
