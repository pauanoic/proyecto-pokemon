/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retopokemon;

import java.util.Scanner;


/**
 *
 * @author hca
 */
public class GimnasioPokemon {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables
        Pokemon poke1,poke2, poke3, poke4; 
        String resultadobatalla, nombre,especie, evolucion1, evolucion2;
        Scanner lectura;
        char tipo;
        int valorAtaq, valorDef, numAtaq, d, otronumAtaq, horasEntrenamiento, evolucion=0, i, clave1, clave2;
        Menu miMenu;
        LiderGimnasio unLider;
        
        //Instanciar poke 1, 2 y 4 
        miMenu=new Menu();
        unLider=new LiderGimnasio("Brock","ROCA");
        lectura= new Scanner(System.in);
        
        unLider.altaPokemon("Charmander",'F',"Lagartija", 3, 5, 6, "Charmeleon","Charizard");
        unLider.altaPokemon("Bulbasour",'H',"Semilla", 5, 6, 7, "Ivysaur","Venusaur" );
        unLider.altaPokemon("Squirtle",'A',"Tortuga", 4, 7, 5, "Wartortle", "Blastoise");
        unLider.altaPokemon("Alonso",'A',"Tortuga", 6, 8, 5, "AlosnoResponsable", "AlonsoNoTacanio");
        unLider.altaPokemon("Alonso",'A',"Tortuga", 6, 8, 5, "AlosnoResponsable", "AlonsoNoTacanio");
       
        //Bienvenida al menu principal
        System.out.println(miMenu.colocaMenuBienvenida());
        do{
            d=lectura.nextInt();
        }while(d<1 || d>4);
        
        
        while(d!=4){
            switch(d){
                case 1:{
                    //Caso para visualizar los datos de los ya pokemones instanciados
                    System.out.println("   Pokemones en el gimansio \n");
                    for(i=0;i<unLider.getOcupados();i++)
                        System.out.println(unLider.getDatos(i+1));
                }

                break;
                case 2:{
                    //Caso para activar el sistema de batallas
                    System.out.println("Cuál Pokemon es el atacante?");
                    for(i=0;i<unLider.getOcupados();i++)
                        System.out.println(unLider.getNombrePokemon(i+1)+"........."+(i+1));
                    do{
                        d=lectura.nextInt();
                        clave1=d;
                    }while(d<1 || d>unLider.getOcupados());
                    System.out.println("A que Pokemon desea atacar?");
                    for(i=0;i<d-1;i++)
                        System.out.println(unLider.getNombrePokemon(i+1)+"........."+(i+1));   
                    for(i=d;i<unLider.getOcupados();i++)
                        System.out.println(unLider.getNombrePokemon(i+1)+"........."+(i+1));
                        
                    do{
                        d=lectura.nextInt();
                        clave2=d;
                    }while(d<1 || d>unLider.getOcupados() || d==clave1);
                        
                    System.out.println(miMenu.realizaBatallaPokemon(unLider, clave1, clave2));
                }    
                break;
       /*         

                
                default:{
                    //Caso para crear tu propio Pokemon
                    System.out.println("     Cuida tu Pokemon");
                    //LLenar atributos de poke3
                    System.out.println("Nombre del pokemon:");
                    nombre=lectura.next();        
                    do{
                        System.out.println("Tipo: (F, H, A)");
                        tipo=lectura.next().charAt(0);
                        switch (tipo) {
                            case 'F':
                                d=1;
                            break;
                            case 'A':
                                d=1;
                            break;
                            case 'H':
                                d=1;
                            break;
                            default:
                                d=0;
                            break;
                        }
                    }while(d==0);
                    System.out.println("Especie:");
                    especie=lectura.next();
                    do{
                        System.out.println("Puntos de Ataque: (1-30)");
                        valorAtaq=lectura.nextInt();
                    }while(valorAtaq<1 || valorAtaq>30);
                    do{
                        System.out.println("Puntos de Defensa: (1-30)");
                        valorDef=lectura.nextInt();
                    }while(valorDef<1 || valorDef>30);
                    do{
                        System.out.println("Numero de Ataques: (1-15)");
                        numAtaq=lectura.nextInt();
                    }while(numAtaq<1 || numAtaq>15);
                    System.out.println("Nombre de la evolucion 1:");
                    evolucion1=lectura.next();
                    System.out.println("Nombre de la evolucion 2:");
                    evolucion2=lectura.next();
                    poke3= new Pokemon(nombre, tipo, especie, valorAtaq, valorDef, numAtaq, evolucion1, evolucion2); //SE ACABA DE INSTANCIAR poke3
                    //Presentacion al usuario de poke 3
                    System.out.println(poke3.toString());
                    System.out.println(miMenu.imagen(poke3));
                    
                    //Menu de cuidado poke3
                    System.out.println("Que desea que haga "+poke3.getNombre());
                    System.out.println(miMenu.colocaMenuCuidadoPokemon());
                    do{
                        d=lectura.nextInt();
                    }while(d<1 || d>3);
                    //Advertencia con respecto a salirse del menu de Cuidado. Esta se activa al colocar 3
                    if(d==3){
                        System.out.println("ADVERTENCIA: LOS DATOS DE TU POKEMON SERAN BORRADOS AL SALIR,\n SEGURO QUE DESEA HACERLO? \n");
                        do{
                            System.out.println(miMenu.colocaSiNo());
                            d=lectura.nextInt();
                        }while(d<0 || d>2);
                        if(d==1)
                            d=4;
                        else{
                            System.out.println("Que desea que haga "+poke3.getNombre());
                            System.out.println(miMenu.colocaMenuCuidadoPokemon());
                            d=lectura.nextInt();
                        }   
                    }
                    
                    //Loop del Menun de cuidado
                    while(d!=4){
                        //1ra evolucion de poke 3. Se activa al entrenar al 
                        //pokemon a Numero de Ataques mayores a 15
                        if(poke3.getNumeroDeAtaques()>15 && evolucion==0){
                            System.out.println("OH... OH... ");    
                            System.out.println("----------------- \n" + poke3.getNombre().toUpperCase() + " esta evolucionando!\n----------------------\n");
                            nombre=poke3.getEvolucion1();
                            System.out.println("De que especie es la evolución?");
                            especie=lectura.next();
                            System.out.println("----------------- \n" + poke3.getNombre().toUpperCase() + " evoluciono a"+nombre.toUpperCase()+"  !\n----------------------\n"); 
                            unLider.evoluciona(poke3,nombre, especie);
                            System.out.println(poke3.toString());
                            System.out.println(miMenu.imagen(poke3));
                            evolucion=evolucion+1;
                        }
                        //2da evolucion(y final) de poke 3. Se activa al entrenar al 
                        //pokemon a Numero de Ataques mayores a 20 (Y una vez que este paso por la primera evolucion"
                        if(poke3.getNumeroDeAtaques()>20 && evolucion==1){
                            System.out.println("OH... OH... ");    
                            System.out.println("----------------- \n" + poke3.getNombre().toUpperCase() + " esta evolucionando!\n----------------------\n"); 
                            nombre=poke3.getEvolucion2();
                            System.out.println("De que especie es la evolución?");
                            especie=lectura.next();
                            System.out.println("----------------- \n" + poke3.getNombre().toUpperCase() + " evoluciono a"+nombre.toUpperCase()+"  !\n----------------------\n"); 
                            unLider.evoluciona(poke3,nombre, especie);
                            System.out.println(poke3.toString());
                            System.out.println(miMenu.imagen(poke3));
                            evolucion=evolucion+1;
                        }
                        
                        //swicth a partir del valor d, de acuerdo al menu de Cuidados
                        switch(d){
                    
                            case 1:{
                                //Caso en que se desea que poke 3 ataque
                                do{
                                    System.out.println("A quien desea atacar?");
                                    System.out.println(poke1.getNombre()+".........1");
                                    System.out.println(poke2.getNombre()+".........2");
                                    System.out.println(poke4.getNombre()+".........3");
                                    d=lectura.nextInt();
                                }while(d<1 || d>3);
                                System.out.println("Iniciando batalla pokemon \n");
            
                                if(d==1)
                                    System.out.println(miMenu.realizaBatallaPokemon(unLider, poke3, poke1));
                                else
                                    if(d==2)
                                        System.out.println(miMenu.realizaBatallaPokemon(unLider, poke3, poke2));
                                    else
                                        System.out.println(miMenu.realizaBatallaPokemon(unLider, poke3, poke4));
                            }   
                            break;
                            case 2:{
                                //Caso en el que se desea entrenar a poke 3 (Subir su Numero de Ataques)
                                System.out.println("Cuantas horas desea entrenar?");
                                horasEntrenamiento=lectura.nextInt();
                                d=1;
                                while(d!=2){
                                    otronumAtaq=unLider.entrena(poke3, horasEntrenamiento);
                                    poke3.setNumeroDeAtaques(otronumAtaq);
                                    System.out.println(poke3.getNombre()+" subio su numero de Ataques a "+otronumAtaq+"\n");
                                    System.out.println(poke3.toString());
                        
                                    System.out.println("Desea volver a entrenar?");
                                    do{
                                        System.out.println(miMenu.colocaSiNo());;
                                        d=lectura.nextInt();
                                    }while(d<0 || d>2);
                                    if(d==1){
                                        System.out.println("Cuantas horas desea entrenar?");
                                        horasEntrenamiento=lectura.nextInt();
                                    }
                                }
                            }
                            break;
                            default:{
                            //Ultimo caso que se activa al presionar d=3. Este 
                            //vuelve a advertir al usuario de que el poke 3 que se instanció ya no será el mismo
                                System.out.println("ADVERTENCIA: LOS DATOS DE TU POKEMON SERAN BORRADOS AL SALIR, "
                                        + "SEGURO QUE DESEA HACERLO? \n");
                                do{
                                    System.out.println(miMenu.colocaSiNo());
                                    d=lectura.nextInt();
                                }while(d<0 || d>2);
                                if(d==1)
                                    d=4;
                                else
                                    d=5; 
                            }
                            break;
                            }    
                        //EN CASO DE QUE EL USUARIO NO HAYA DECIDIDO DEJAR 
                        //DESCANSAR A SU POKEMON, se vuelve a presentar menu cuidado    
                        if(d!=4){    
                        System.out.println("Que desea que haga "+poke3.getNombre());
                        System.out.println(miMenu.colocaMenuCuidadoPokemon());
                            do{
                                d=lectura.nextInt();
                            }while(d>3 || d<1);
                        }
                    }   
                    System.out.println(poke3.getNombre()+" Se fue a dormir");
                }//Default
                break;
                */
            }//switch
            
        System.out.println(miMenu.colocaMenuBienvenida());
        do{
            d=lectura.nextInt();
        }while(d<1 || d>4);
        
        }//While 
        System.out.println("Gracias por visitar el gimansio Pokemon");
        
    }//Main
    
}//Clase 
