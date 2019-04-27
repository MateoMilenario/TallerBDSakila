/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Actor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class ControlActor {

    public LinkedList<Actor> ConsultaDatosActor() {

        LinkedList<Actor> actoresDatos = new LinkedList<>();

        Actor objActor = new Actor();
        Actor aEnviar = null;

        String TraerSQL = "SELECT CONCAT(a.first_name, ' ', a.last_name) as NombreActor, a.actor_id FROM actor a";

        ResultSet rset = null;

        rset = objActor.TraerActores(TraerSQL);

        try {

            while (rset.next()) {

                String nombreActor = rset.getString("NombreActor");
                String PkActor = rset.getString("actor_id");

                aEnviar = new Actor(nombreActor, PkActor);

                actoresDatos.add(aEnviar);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return actoresDatos;

    }//Fin método

}
