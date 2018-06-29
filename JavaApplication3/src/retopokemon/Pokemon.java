/*
 * Clase para modelar un Pokemon
 */
package retopokemon;




/**
 *
 * @author hca
 */
public class Pokemon {
    private String nombre;
    private char tipo;
    private String especie;
    private int valorDeAtaque;
    private int valorDeDefensa;
    private int numeroDeAtaques;
    private static int folio=000;
    private int clave;
    private String evolucion1;
    private String evolucion2;
    
    //Constructor
    public Pokemon(String unNombre, char unTipo, String unaEspecie, int unValorDeAtaque, int unValorDeDefensa, int unNumeroDeAtaques, String unaEvolucion1, String unaEvolucion2){
        folio++;
        clave=folio;
        nombre=unNombre;
        tipo=unTipo;
        especie=unaEspecie;
        valorDeAtaque=unValorDeAtaque;
        valorDeDefensa=unValorDeDefensa;
        numeroDeAtaques=unNumeroDeAtaques;  
        evolucion1=unaEvolucion1;
        evolucion2=unaEvolucion2;
        System.out.println("------------- \nA wild " + this.nombre.toUpperCase() + " has appeared!\n----------------------\n"); 
    }
    
    //get´s y set´s
    
    public String getNombre(){
        return nombre;
    }
    
    public char getTipo(){
        return tipo;
    }
    
    public String getEspecie(){
        return especie;
    }
    
    public int getvalorDeAtaque(){
        return valorDeAtaque;
    }
    
    public int getvalorDeDefensa(){
        return valorDeDefensa;
    }
    
    public int getNumeroDeAtaques(){
        return numeroDeAtaques;
    }
    
    public int getClave(){
        return clave;
    }
    
    public String getEvolucion1(){
        return evolucion1;
    }
    
    public String getEvolucion2(){
        return evolucion2;
    }
    
    public void setNumeroDeAtaques(int otroNumeroDeAtaques){
        numeroDeAtaques=otroNumeroDeAtaques;
    }
    
    //EQUALS
    public boolean equals(Pokemon otro){
        boolean resp;
        if(clave==otro.getClave())
            resp=true;
        else
            resp=false;
        return resp;
    }

    //COMPARE TO
    public int compareTo(Pokemon otro){
        int resp;
        if(clave==otro.getClave())
            resp=0;
        else
            if(clave<otro.getClave())
                resp=-1;
            else
                resp=1;
        return resp;
    }
    
    //TO STRING
    public String toString(){
        StringBuilder sb;
        sb=new StringBuilder();
        sb.append("    Pokemon   \n");
        sb.append("Nombre:   "+nombre+" \n");
        sb.append("Tipo:     "+tipo+" \n");
        sb.append("especie:  "+especie+" \n");
        sb.append("Ataque:   "+valorDeAtaque+" \n");
        sb.append("Defensa:  "+valorDeDefensa+" \n");
        sb.append("#Ataques: "+numeroDeAtaques+" \n");
        sb.append("Clave:    "+clave+" \n");
        return sb.toString();
    }
    
    /**
     * Funcion Calcula Ganador. Recibe como parametro los puntos de Ataque y 
     * puntos de Defensa que se calculan en las batallas Pokemon y regresa en 
     * forma de String el ganador a traves de una desigualdad. 
     * @param punat Puntos Atacante
     * @param pundef Puntos Defensor
     * @return 
     */
    public String calculaGanador(int punat,int pundef){
        String resp;
        if(punat>=pundef)
            resp="ganaAtacante";
        else
            resp="ganaDefensor";
        return resp;
    }
    
    /**
     * Metodo incrementa Ataque. este metodo se utiliza para incrementar el 
     * valor de ataque del pokemon ganador.
     * @param incataq Cuanto incrementa de ataque
     */
    public void incrementaAtaque(int incataq){
        valorDeAtaque=valorDeAtaque+incataq;
    }
    
    /**
     * Funcion Ataca Pokemon. Esta funcion se utiliza para calcular los valores 
     * de Puntos de Ataque y Puntos de Defensa que cadan los pokemones al 
     * enfrentarse. A su vez, la funcion llama a las funciones calcularGanador 
     * e Incrementa Ataque para regresar el nombre del pokemon ganador. 
     * @param otro Pokemon defensor
     * @return 
     */
    public String atacaPokemon(Pokemon otro){
        int punataq, pundef;
        String resp, resultataq;
        
        if(tipo==otro.getTipo()){
            punataq=valorDeAtaque*numeroDeAtaques;
            pundef=otro.getvalorDeDefensa()*otro.getNumeroDeAtaques();
        }
        else
            if(tipo=='A')
                if(otro.getTipo()=='F'){
                    punataq=valorDeAtaque*numeroDeAtaques*5;
                    pundef=otro.getvalorDeDefensa()*otro.getNumeroDeAtaques();
                }
                else{
                    punataq=valorDeAtaque*numeroDeAtaques*2;
                    pundef=otro.getvalorDeDefensa()*otro.getNumeroDeAtaques();
                }
            else
                if(tipo=='F')
                    if(otro.getTipo()=='A'){
                        punataq=valorDeAtaque*numeroDeAtaques;
                        pundef=otro.getvalorDeDefensa()*otro.getNumeroDeAtaques()*5;
                    }
                    else{
                        punataq=valorDeAtaque*numeroDeAtaques*5;
                        pundef=otro.getvalorDeDefensa()*otro.getNumeroDeAtaques();
                    }
                else
                    if(otro.getTipo()=='A'){
                        punataq=valorDeAtaque*numeroDeAtaques;
                        pundef=otro.getvalorDeDefensa()*otro.getNumeroDeAtaques()*2;
                    }
                    else{
                        punataq=valorDeAtaque*numeroDeAtaques;
                        pundef=otro.getvalorDeDefensa()*otro.getNumeroDeAtaques()*5;
                    }
        resp=calculaGanador(punataq, pundef);
        if(resp.equals("ganaAtacante")){
            incrementaAtaque(2);
            resultataq=nombre;
        }
        else{
            otro.incrementaAtaque(5);
            resultataq=otro.getNombre();
        }    
        return resultataq;     
    }
    
    /**
     * Evoluciona. Esta funcion se encarga de evolucionar a los Pokemones. 
     * @param otroNombre
     * @param otraEspecie 
     */
    public void evoluciona(String otroNombre, String otraEspecie){
        nombre=otroNombre;
        especie=otraEspecie;
    }
    
    /**
     * Entrena. Esta funciona tiene por objetivo subir el numero de Ataques de 
     * cada Pokemon. aumentando sus posibilidades de ganar en las batallas. 
     * @param horasEntrenamiento
     * @return 
     */
    public int entrena(int horasEntrenamiento){
        int otronumAtaq;
        otronumAtaq=getNumeroDeAtaques()+(horasEntrenamiento/2);
        return otronumAtaq;
    }
}



