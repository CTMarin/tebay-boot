package es.uma.tebayboot.dto;

import java.util.List;
import java.util.StringJoiner;
/**
 * author:
 *  - Carmen González Ortega 33%
 *  - Carlos Marín Corbera 33%
 *  - Álvaro Jesús Tapia Muñoz 33%
 */
public class Domicilio
{
    private Integer idDomicilio;
    private String pais;
    private String ciudad;
    private String calle;
    private int numero;
    private int codigoPostal;
    private String bloque;
    private String piso;
    private String puerta;
    //private List<Usuario> usuarioList;


    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    @Override
    public String toString() {
        //calle, numero, piso, bloque, puerta, ciudad, pais, codigo postal
        StringJoiner s = new StringJoiner(", ");
        s.add("Calle " + getCalle());
        s.add("Nº " + Integer.toString(getNumero()));

        if(getPiso()!= null && !getPiso().isEmpty())
        {
            s.add("piso " + getPiso());
        }

        if(getBloque()!= null && !getBloque().isEmpty())
        {
            s.add("bloque " + getBloque());
        }
        if(getPuerta()!= null && !getPuerta().isEmpty())
        {
            s.add("puerta " + getPuerta());
        }

        s.add(getCiudad());
        s.add(getPais());
        s.add(Integer.toString(getCodigoPostal()));

        return s.toString();
    }
}
