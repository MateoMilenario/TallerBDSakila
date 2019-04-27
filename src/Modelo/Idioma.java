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
public class Idioma {

    private String pkIdioma;
    private String NombreIdioma;

    public Idioma() {
    }

    public Idioma(String pkIdioma, String NombreIdioma) {
        this.pkIdioma = pkIdioma;
        this.NombreIdioma = NombreIdioma;
    }

    public String getPkIdioma() {
        return pkIdioma;
    }

    public void setPkIdioma(String pkIdioma) {
        this.pkIdioma = pkIdioma;
    }

    public String getNombreIdioma() {
        return NombreIdioma;
    }

    public void setNombreIdioma(String NombreIdioma) {
        this.NombreIdioma = NombreIdioma;
    }

    public ResultSet TraerIdiomas(String LeerSQL) {

        ResultSet rset = null;

        ConnectBD CBD = new ConnectBD();

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                rset = CBD.getSt().executeQuery(LeerSQL);

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        }//Fin if

        return rset;

    }//Fin método

}
