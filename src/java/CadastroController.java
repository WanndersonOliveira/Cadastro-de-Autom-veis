/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Meyrielle
 */
@ManagedBean(name="cadastroController")
@SessionScoped
public class CadastroController {
    private Automovel automovel;
    private DataModel<Automovel> lista_automovel; 
    private String msg;
    
    @PostConstruct
    public void init(){
        
        String[] marcas = {"Ford", "Fiat", "Volkswagen", "Ford", "Shineray"};
        String[] modelos = {"Ka", "Fiorino", "Fusca", "Focus", "50inha"};
        String[] tipos = {"Carro", "Carro", "Carro", "Carro", "Moto"};
        String[] placas = {"XZ125", "XE446", "ZZY123", "TTY446", "OLP999"};
        List<Automovel> automoveis = new ArrayList<Automovel>();
        
        for(int i = 0; i < 5; i++){
            automovel = new Automovel(modelos[i], placas[i], tipos[i], marcas[i]);
            
            automoveis.add(automovel);
        }
        
        lista_automovel = new ListDataModel<Automovel>(automoveis);
        
        System.out.println("Hello from init()");
        this.msg = "";
    }
    
    public Automovel getAutomovel(){
        return this.automovel;
    }
   
    public void setMsg(String msg){
        this.msg = msg;
    }
    
    public String getMsg(){
        return this.msg;
    }
    
    public String deletar_Automovel(){
        Automovel carro = (Automovel) (this.lista_automovel.getRowData());
        
        System.out.println("Registro: "+carro.getPlaca()+" - "+carro.getMarca()+" - "+carro.getModelo()+
                ": "+carro.getTipo());
        
        List<Automovel> automoveis = new ArrayList<Automovel>();
        
       Iterator<Automovel> iter = lista_automovel.iterator();
       
       while(iter.hasNext()){
           automoveis.add(iter.next());
       }
       
       for(Automovel auto : automoveis){
           if(auto.getPlaca().equals(carro.getPlaca())){
               automoveis.remove(auto);
           }
       }
       
       lista_automovel = new ListDataModel<Automovel>(automoveis);
        
       this.msg = "Registro deletado com sucesso";
        return "listacarros";
    }
    
    public String cadastrar_Form(){
        return "cadastrar";
    }
    
    public String cadastrar_Automovel(){
        automovel = new Automovel();
        
        List<Automovel> automoveis = new ArrayList<Automovel>();
        
        
        //if(lista_automovel != null){
            Iterator<Automovel> iter = lista_automovel.iterator();
       
            while(iter.hasNext()){
                automoveis.add(iter.next());
            }
        //}
       
       this.msg = "Automóvel cadastrado com sucesso";
       automoveis.add(automovel);
       
       lista_automovel = new ListDataModel<Automovel>(automoveis);
        
       return "cadastrar";
    }
    
    public DataModel<Automovel> getListaAutomovel(){
        return lista_automovel;
    }
    
    public String listar_carros(){
        return "listacarros";
    }
    
    public String index(){
        return "index";
    }
}
