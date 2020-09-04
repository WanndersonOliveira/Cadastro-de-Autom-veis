/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Meyrielle
 */
public class Automovel {
    private String modelo;
    private String placa;
    private String tipo; //carro, moto, quadriciclo
    private String marca;
    
    public Automovel(){
        modelo = "";
        placa = "";
        tipo = "";
        marca = "";
    }
    
    public Automovel(String modelo, String placa, String tipo, String marca){
        this.modelo = modelo;
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public String getPlaca(){
        return this.placa;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
}
