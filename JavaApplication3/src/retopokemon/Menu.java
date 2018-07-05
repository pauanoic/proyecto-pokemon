/*
 * Clase para modelar los menus que se usan repetidamente en el main
 */
package retopokemon;

/**
 *
 * @author hca
 */
public class Menu {
    
    public Menu(){
        
    }
    
    public String colocaMenuBienvenida(){
        StringBuilder sb;
        sb=new StringBuilder();
        sb.append("           Bienvenido al gimnasio Pokemon, que desea hacer? \n" );
        sb.append("Ver los datos de los Pokemones que se encuentran en el gimansio.......1 \n");
        sb.append("Ver una batalla pokemon...............................................2 \n");
        sb.append("Cuidar a mi propio pokemon............................................3 \n");
        sb.append("Salir del gimnasio....................................................4 \n");
        return sb.toString();
    }
    
    
    public String colocaMenuCuidadoPokemon(){
        StringBuilder sb;
        sb=new StringBuilder();
        sb.append("Pelear.........1 \n");
        sb.append("Entrenar.........2 \n");
        sb.append("Descansar.........3 \n");
        return sb.toString();
    }

    public String colocaSiNo(){
        StringBuilder sb;
        sb=new StringBuilder();
        sb.append("Si.........1 \n");
        sb.append("No.........2 \n");
        return sb.toString();
    }
    

    public String realizaBatallaPokemon(LiderGimnasio un, int clave1, int clave2){
        int pos1, pos2;
        StringBuilder sb;
        String resultadobatalla;
        sb=new StringBuilder();

        resultadobatalla=un.atacaPokemon(clave1,clave2);
        sb.append("   Batalla Pokemon \n");
        sb.append(un.getNombrePokemon(clave1)+"  VS  "+un.getNombrePokemon(clave2)+"\n");
        sb.append("El ganador es: \n");
        sb.append(resultadobatalla+"\n");
        sb.append(resultadobatalla+" subió sus puntos de ataque \n");
        
        return sb.toString();
    }
    
   
}
