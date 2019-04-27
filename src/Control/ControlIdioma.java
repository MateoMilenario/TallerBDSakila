/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Idioma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class ControlIdioma {

    public LinkedList<Idioma> TraerLenguajes() {

        LinkedList<Idioma> idiomasR = new LinkedList<>();

        Idioma idio = new Idioma();
        Idioma idiomaRegistrado = null;
        ResultSet rset = null;

        String LeerSQL = "SELECT * FROM language";

        rset = idio.TraerIdiomas(LeerSQL);

        try {

            while (rset.next()) {

                String PkIdioma = rset.getString("language_id");
                String NombreIdioma = rset.getString("name");

                idiomaRegistrado = new Idioma(PkIdioma, NombreIdioma);

                idiomasR.add(idiomaRegistrado);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return idiomasR;

    }

}
