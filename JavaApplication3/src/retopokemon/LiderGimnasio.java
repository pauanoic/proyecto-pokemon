/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retopokemon;

import java.util.Objects;

/**
 *
 * @author hca
 */
public class LiderGimnasio {
    private String nombre;
    private String pokeespecialidad;
    private Pokemon[] pokes;
    private int ocupados;        
    private final int MAX=20;
    
    public LiderGimnasio() {
        pokes= new Pokemon[MAX];
        ocupados=0;
    }

    public LiderGimnasio(String nombre, String pokeespecialidad) {
        this();
        this.nombre = nombre;
        this.pokeespecialidad = pokeespecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPokeespecialidad() {
        return pokeespecialidad;
    }

    public void setPokeespecialidad(String pokeespecialidad) {
        this.pokeespecialidad = pokeespecialidad;
    }

    public int getOcupados() {
        return ocupados;
    }

    public int getMAX() {
        return MAX;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LiderGimnasio other = (LiderGimnasio) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    public int compareTo(LiderGimnasio otro){
        return nombre.compareTo(otro.getNombre());
    }
    
    //Agregar toString();
    
    public boolean altaPokemon(String unNombre, char unTipo, String unaEspecie, int unValorDeAtaque, int unValorDeDefensa, int unNumeroDeAtaques, String unaEvolucion1, String unaEvolucion2){
        Pokemon unPokemon;
        int i;
        boolean resp;
        if(ocupados<MAX){
            i=0;
            while(i<ocupados && !pokes[i].getNombre().equals(unNombre))
                i++;
            if(i<ocupados)
                resp=false;
            else{
                unPokemon= new Pokemon(unNombre, unTipo, unaEspecie, unValorDeAtaque, unValorDeDefensa, unNumeroDeAtaques, unaEvolucion1, unaEvolucion2);
                pokes[ocupados]= unPokemon;
                ocupados=ocupados+1;
                resp=true;
            }
        }
        else
            resp=false;
        return resp;
    }
    
    public int buscaClaves(int clave){
        int i, pos;
        i=0;
        while(i<ocupados && clave!=pokes[i].getClave())
            i++;
        if(i<ocupados)
            pos=i;
        else
            pos=-1;
        return pos;
    }
        
    public String getNombrePokemon(int clave){
        String nomPokemon;
        int pos;
        pos=buscaClaves(clave);
        if(pos!=-1)
            nomPokemon=pokes[pos].getNombre();
        else
            nomPokemon="No existe dicho Pokemon";
        return nomPokemon;         
    }
    
    public String getDatos(int clave){
        String datos;
        int pos;
        pos=buscaClaves(clave);
        if(pos!=-1)
            datos=pokes[pos].toString();
        else
            datos="No existe dicho Pokemon";
        return datos;    
    }
    
    public String calculaGanador(int punat,int pundef){
        String resp;
        if(punat>=pundef)
            resp="ganaAtacante";
        else
            resp="ganaDefensor";
        return resp;
    }
    

    public void incrementaAtaque(Pokemon poke1, int incataq){
        poke1.setValorDeAtaque(incataq);
    }
    
    public String atacaPokemon(int clave1, int clave2){
        int punataq, pundef, i, pos1, pos2;
        String resp, resultataq;
        
        pos1=buscaClaves(clave1);
        pos2=buscaClaves(clave2);
        
        if(pos1!=-1 && pos2!=-1){
            if(pokes[pos1].getTipo()==pokes[pos2].getTipo()){
                punataq=pokes[pos1].getvalorDeAtaque()*pokes[pos1].getNumeroDeAtaques();
                pundef=pokes[pos2].getvalorDeDefensa()*pokes[pos2].getNumeroDeAtaques();
            }
            else
                if(pokes[pos1].getTipo()=='A')
                    if(pokes[pos2].getTipo()=='F'){
                        punataq=pokes[pos1].getvalorDeAtaque()*pokes[pos1].getNumeroDeAtaques()*5;
                        pundef=pokes[pos2].getvalorDeDefensa()*pokes[pos2].getNumeroDeAtaques();
                    }
                    else{
                        punataq=pokes[pos1].getvalorDeAtaque()*pokes[pos1].getNumeroDeAtaques()*2;
                        pundef=pokes[pos2].getvalorDeDefensa()*pokes[pos2].getNumeroDeAtaques();
                    }
                else
                    if(pokes[pos1].getTipo()=='F')
                        if(pokes[pos2].getTipo()=='A'){
                            punataq=pokes[pos1].getvalorDeAtaque()*pokes[pos1].getNumeroDeAtaques();
                            pundef=pokes[pos2].getvalorDeDefensa()*pokes[pos2].getNumeroDeAtaques();
                        }
                        else{
                           punataq=pokes[pos1].getvalorDeAtaque()*pokes[pos1].getNumeroDeAtaques()*5;
                           pundef=pokes[pos2].getvalorDeDefensa()*pokes[pos2].getNumeroDeAtaques();
                        }
                    else
                        if(pokes[pos2].getTipo()=='A'){
                            punataq=pokes[pos1].getvalorDeAtaque()*pokes[pos1].getNumeroDeAtaques();
                            pundef=pokes[pos2].getvalorDeDefensa()*pokes[pos2].getNumeroDeAtaques()*2;
                        }
                        else{
                            punataq=pokes[pos1].getvalorDeAtaque()*pokes[pos1].getNumeroDeAtaques();
                            pundef=pokes[pos2].getvalorDeDefensa()*pokes[pos2].getNumeroDeAtaques()*5;
                        }
            resp=calculaGanador(punataq, pundef);
            if(resp.equals("ganaAtacante")){
                incrementaAtaque(pokes[pos1],2);
                resultataq=pokes[pos1].getNombre();
            }
            else{
                incrementaAtaque(pokes[pos2],5);
                resultataq=pokes[pos2].getNombre();
            }
        }
        else
            resultataq="No existen dichos Pokemones";
        return resultataq;     
    }
    

    public boolean evoluciona(int clave, String otroNombre, String otraEspecie){
        int pos1;
        boolean resp;
        pos1=buscaClaves(clave);
        if(pos1!=-1){
            pokes[pos1].setNombre(otroNombre);
            pokes[pos1].setEspecie(otraEspecie);
            resp=true;
        }
        else
            resp=false;
        return resp;
    }
    
    public int entrena(int clave, int horasEntrenamiento){
        int otronumAtaq;
        int pos1;
        pos1=buscaClaves(clave);
        
        if(pos1!=-1){
            otronumAtaq=pokes[pos1].getNumeroDeAtaques()+(horasEntrenamiento/2);
            pokes[pos1].setNumeroDeAtaques(otronumAtaq);
        }
        else
            otronumAtaq=-1;
        return otronumAtaq;
    }


    
}

