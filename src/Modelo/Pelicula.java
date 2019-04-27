/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.ConnectBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class Pelicula {

    private String NombrePelicula;
    private String Descripcion;
    private String AñoCreacion;
    private String DuracionRenta;
    private String PrecioRenta;
    private String DuracionPelicula;
    private String CostoReemplazo;
    private String Clasificacion;
    private String Caracteristicas;
    private String FechaActualizacion;

    private String PkPelicula;
    private String FkIdioma;
    private String fechaRenta;

    public Pelicula() {
    }

    public Pelicula(String NombrePelicula, String Descripcion, String AñoCreacion, String DuracionRenta, String PrecioRenta, String DuracionPelicula, String CostoReemplazo, String Clasificacion, String Caracteristicas, String FechaActualizacion) {
        this.NombrePelicula = NombrePelicula;
        this.Descripcion = Descripcion;
        this.AñoCreacion = AñoCreacion;
        this.DuracionRenta = DuracionRenta;
        this.PrecioRenta = PrecioRenta;
        this.DuracionPelicula = DuracionPelicula;
        this.CostoReemplazo = CostoReemplazo;
        this.Clasificacion = Clasificacion;
        this.Caracteristicas = Caracteristicas;
        this.FechaActualizacion = FechaActualizacion;
    }

    public Pelicula(String NombrePelicula, String Descripcion, String AñoCreacion, String DuracionRenta, String PrecioRenta, String DuracionPelicula, String CostoReemplazo, String Clasificacion, String Caracteristicas, String FechaActualizacion, String PkPelicula, String FkIdioma) {
        this.NombrePelicula = NombrePelicula;
        this.Descripcion = Descripcion;
        this.AñoCreacion = AñoCreacion;
        this.DuracionRenta = DuracionRenta;
        this.PrecioRenta = PrecioRenta;
        this.DuracionPelicula = DuracionPelicula;
        this.CostoReemplazo = CostoReemplazo;
        this.Clasificacion = Clasificacion;
        this.Caracteristicas = Caracteristicas;
        this.FechaActualizacion = FechaActualizacion;
        this.PkPelicula = PkPelicula;
        this.FkIdioma = FkIdioma;
    }

    public Pelicula(String NombrePelicula, String AñoCreacion, String PrecioRenta, String Clasificacion, String fechaRenta) {
        this.NombrePelicula = NombrePelicula;
        this.AñoCreacion = AñoCreacion;
        this.PrecioRenta = PrecioRenta;
        this.Clasificacion = Clasificacion;
        this.fechaRenta = fechaRenta;
    }

    public Pelicula(String NombrePelicula, String AñoCreacion) {
        this.NombrePelicula = NombrePelicula;
        this.AñoCreacion = AñoCreacion;
    }

    public String getNombrePelicula() {
        return NombrePelicula;
    }

    public void setNombrePelicula(String NombrePelicula) {
        this.NombrePelicula = NombrePelicula;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getAñoCreacion() {
        return AñoCreacion;
    }

    public void setAñoCreacion(String AñoCreacion) {
        this.AñoCreacion = AñoCreacion;
    }

    public String getDuracionRenta() {
        return DuracionRenta;
    }

    public void setDuracionRenta(String DuracionRenta) {
        this.DuracionRenta = DuracionRenta;
    }

    public String getPrecioRenta() {
        return PrecioRenta;
    }

    public void setPrecioRenta(String PrecioRenta) {
        this.PrecioRenta = PrecioRenta;
    }

    public String getDuracionPelicula() {
        return DuracionPelicula;
    }

    public void setDuracionPelicula(String DuracionPelicula) {
        this.DuracionPelicula = DuracionPelicula;
    }

    public String getCostoReemplazo() {
        return CostoReemplazo;
    }

    public void setCostoReemplazo(String CostoReemplazo) {
        this.CostoReemplazo = CostoReemplazo;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String Caracteristicas) {
        this.Caracteristicas = Caracteristicas;
    }

    public String getFechaActualizacion() {
        return FechaActualizacion;
    }

    public void setFechaActualizacion(String FechaActualizacion) {
        this.FechaActualizacion = FechaActualizacion;
    }

    public String getPkPelicula() {
        return PkPelicula;
    }

    public void setPkPelicula(String PkPelicula) {
        this.PkPelicula = PkPelicula;
    }

    public String getFkIdioma() {
        return FkIdioma;
    }

    public void setFkIdioma(String FkIdioma) {
        this.FkIdioma = FkIdioma;
    }

    public String getFechaRenta() {
        return fechaRenta;
    }

    public void setFechaRenta(String fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    //*****************************************************************************************************************
    public boolean InsertarDatosPelicula(String pkIdioma, Pelicula p, String InsertarSQL) {

        ConnectBD CBD = new ConnectBD();
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);

                ps = CBD.getConexion().prepareStatement(InsertarSQL);

                ps.setString(1, p.getNombrePelicula());

                if (p.getDescripcion().equals("")) {

                    ps.setString(2, null);

                } else {

                    ps.setString(2, p.getDescripcion());

                }//Fin if

                if (p.getAñoCreacion().equals("")) {

                    ps.setString(3, null);

                } else {

                    ps.setString(3, p.getAñoCreacion());

                }//Fin if

                ps.setString(4, pkIdioma);
                ps.setString(5, p.getDuracionRenta());
                ps.setString(6, p.getPrecioRenta());

                if (p.getDuracionPelicula().equals("")) {

                    ps.setString(7, null);

                } else {

                    ps.setString(7, p.getDuracionPelicula());

                }//Fin if

                ps.setString(8, p.getCostoReemplazo());

                if (p.getClasificacion().equals("")) {

                    ps.setString(9, null);

                } else {

                    ps.setString(9, p.getClasificacion());

                }//Fin if

                if (p.getCaracteristicas().equals("Características")) {

                    ps.setString(10, null);

                } else {

                    ps.setString(10, p.getCaracteristicas());

                }//Fin if

                ps.setString(11, p.getFechaActualizacion());

                ps.executeUpdate();

                CBD.getConexion().commit();

                f = true;

            }//Fin if

        } catch (Exception ex) {

            f = false;
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {

            try {

                ps.close();

            } catch (Exception e) {

                f = false;
                JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);

            }//Fin catch2

        }//Fin finally

        return f;

    }//Fin método

    public ResultSet TraerPeliculasBD(String TraerSQL) {

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

    public boolean ActualizarDatosPelicula(String PkPelicula, Pelicula pelActualizar, String ActualizarSQL) {

        ConnectBD CBD = new ConnectBD();
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);

                ps = CBD.getConexion().prepareStatement(ActualizarSQL);

                ps.setString(1, pelActualizar.getNombrePelicula());
                ps.setString(2, pelActualizar.getDescripcion());
                ps.setString(3, pelActualizar.getAñoCreacion());
                ps.setString(4, pelActualizar.getFkIdioma());
                ps.setString(5, pelActualizar.getDuracionRenta());
                ps.setString(6, pelActualizar.getPrecioRenta());
                ps.setString(7, pelActualizar.getDuracionPelicula());
                ps.setString(8, pelActualizar.getCostoReemplazo());
                ps.setString(9, pelActualizar.getClasificacion());
                ps.setString(10, pelActualizar.getCaracteristicas());
                ps.setString(11, PkPelicula);

                ps.executeUpdate();

                CBD.getConexion().commit();

                f = true;

            }//Fin if

        } catch (Exception ex) {

            f = false;
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {

            try {

                ps.close();

            } catch (Exception e) {

                f = false;
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);

            }//Fin catch2

        }//Fin finally

        return f;

    }//Fin método

    public ResultSet TraerPeliculasCliente(String TraerSQL) {

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

    public ResultSet TraerPeliculasActor(String TraerSQL) {

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

    public ResultSet TraerPeliculasTerror(String TraerSQL) {

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
