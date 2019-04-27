/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Pelicula;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class ControlPelicula {

    public boolean InsertarPelicula(String pkIdioma, Pelicula p) {

        boolean t = false;

        Pelicula objPeli = new Pelicula();

        String InsertarSQL = "call InsertarDatosPelicula(?,?,?,?,?,?,?,?,?,?,?)";

        t = objPeli.InsertarDatosPelicula(pkIdioma, p, InsertarSQL);

        return t;

    }//Fin método

    public LinkedList<Pelicula> TraerPeliculas() {

        LinkedList<Pelicula> datosPeliculas = new LinkedList<>();

        ResultSet rset = null;
        Pelicula pel = new Pelicula();
        Pelicula peliEnviar = null;

        //Solo trae los datos que se han insertado por medio de la aplicación
        String TraerSQL = "SELECT * FROM film WHERE film_id > 1000";

        rset = pel.TraerPeliculasBD(TraerSQL);

        try {

            while (rset.next()) {

                String pkFilm = rset.getString("film_id");
                String NombrePelicula = rset.getString("title");
                String DescripcionPelicula = rset.getString("description");
                String AñoRealizacion = rset.getString("release_year").substring(0, 4);
                String pkLenguaje = rset.getString("language_id");
                String DuracionRenta = rset.getString("rental_duration");
                String precioRenta = rset.getString("rental_rate");
                String Duracion = rset.getString("length");
                String CostoReemplazo = rset.getString("replacement_cost");
                String Clasificacion = rset.getString("rating");
                String Caracteristicas = rset.getString("special_features");
                String Fecha = rset.getString("last_update");

                peliEnviar = new Pelicula(NombrePelicula, DescripcionPelicula, AñoRealizacion, DuracionRenta, precioRenta, Duracion, CostoReemplazo, Clasificacion, Caracteristicas, Fecha, pkFilm, pkLenguaje);

                datosPeliculas.add(peliEnviar);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos" + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return datosPeliculas;

    }//Fin método

    public boolean ModificarDatosPelicula(String PkPelicula, Pelicula pelActualizar) {

        boolean t = false;

        Pelicula objPelicula = new Pelicula();

        String ActualizarSQL = "call ActualizarDatosPelicula(?,?,?,?,?,?,?,?,?,?,?)";

        t = objPelicula.ActualizarDatosPelicula(PkPelicula, pelActualizar, ActualizarSQL);

        return t;

    }//Fin método

    public LinkedList<Pelicula> ConsultaPeliculasCliente(String codigoCliente) {

        LinkedList<Pelicula> peliculasCliente = new LinkedList<>();

        ResultSet rset = null;
        Pelicula pel = new Pelicula();
        Pelicula peliClienteEnviar = null;

        String TraerSQL = "call PeliculasRentaCliente('" + codigoCliente + "')";

        rset = pel.TraerPeliculasCliente(TraerSQL);

        try {

            while (rset.next()) {

                String NombrePelicula = rset.getString("title");
                String AñoRealizacion = rset.getString("release_year").substring(0, 4);
                String PrecioRenta = rset.getString("rental_rate");
                String clasificacion = rset.getString("rating");
                String FechaRenta = rset.getString("rental_date");

                peliClienteEnviar = new Pelicula(NombrePelicula, AñoRealizacion, PrecioRenta, clasificacion, FechaRenta);

                peliculasCliente.add(peliClienteEnviar);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return peliculasCliente;

    }

    public LinkedList<Pelicula> ConsultaPeliculasActor(String codigoA) {

        LinkedList<Pelicula> peliculasActor = new LinkedList<>();

        ResultSet rset = null;
        Pelicula pel = new Pelicula();
        Pelicula peliActorEnviar = null;

        String TraerSQL = "call PeliculasActores('" + codigoA + "')";

        rset = pel.TraerPeliculasActor(TraerSQL);

        try {

            while (rset.next()) {

                String NombrePelicula = rset.getString("title");
                String AñoRealizacion = rset.getString("release_year").substring(0, 4);

                peliActorEnviar = new Pelicula(NombrePelicula, AñoRealizacion);

                peliculasActor.add(peliActorEnviar);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return peliculasActor;

    }//Fin método

    public LinkedList<String> ConsultaPeliculasTerror() {

        LinkedList<String> peliculasTerror = new LinkedList<>();

        ResultSet rset = null;
        Pelicula pel = new Pelicula();
        
        String cadenaDato = "";


        String TraerSQL = "call ConsultaPeliculasTerror()";

        rset = pel.TraerPeliculasTerror(TraerSQL);

        try {

            while (rset.next()) {

                String NombrePelicula = rset.getString("title");
                String clasificacion = rset.getString("rating");

                cadenaDato = NombrePelicula + ";" + clasificacion;

                peliculasTerror.add(cadenaDato);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return peliculasTerror;

    }//Fin método

}
