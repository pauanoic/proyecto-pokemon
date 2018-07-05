/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorarreglos;
import java.util.Scanner;
/**
 *
 * @author hca
 */
public class ManejadorArreglos {
    

    public static void leeArreglo(int a[], int n){
        int i;
        Scanner lectura;
        lectura=new Scanner(System.in);
        for(i=0;i<n;i++){
            System.out.print("Dame el elemento "+i+": ");
            a[i]=lectura.nextInt();
        }
    }
    
     public static void leeArreglo(double a[], int n){
        int i;
        Scanner lectura;
        lectura=new Scanner(System.in);
        for(i=0;i<n;i++){
            System.out.print("Dame el elemento "+i+": ");
            a[i]=lectura.nextDouble();
        }
    }
    
    public static void imprimeArreglo(int a[], int n){
        int i;
        for(i=0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.println();   
    }
    
    public static void imprimeArreglo(double a[], int n){
        int i;
        for(i=0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.println();   
    }
    
    public static int sumaArreglo(int a[], int n){
        int suma, i;
        suma=0;
        for(i=0;i<n;i++){
            suma=suma+a[i];
        }
        return suma;
    }
    
     public static double sumaArreglo(double a[], int n){
        double suma; 
        int i;
        suma=0;
        for(i=0;i<n;i++)
            suma=suma+a[i];
        return suma;
    }
     
     public static double promedioArreglo(double a[], int n){
         double prom;
         prom=sumaArreglo(a,n);
         prom=prom/n;
         return prom;
     }
     
     
     public static int encuentraMayor(double a[], int n){
         int mayor, i;
         mayor=0;
         for(i=1;i<n;i++)
             if(a[i]>a[mayor])
                 mayor=i;
         return mayor;
     }
     
     public static int encuentraMenor(double a[], int n){
         int menor, i;
         menor=0;
         for(i=1;i<n;i++)
             if(a[i]<a[menor])
                 menor=i;
         return menor;
     }
     
     public static int encuentraMayores(double a[], int n, int p){
         int nm, i;
         nm=0;
         for(i=0;i<n;i++)
             if(a[i]>p)
                 nm=nm+1;
         return nm;
     }
     
     public static int encuentraMenores(double a[], int n, int p){
         int nm, i;
         nm=0;
         for(i=0;i<n;i++)
             if(a[i]<p)
                 nm=nm+1;
         return nm;
     }
     
      public static void recorreDerecha(double a[], int n){
         int i;
         for(i=n-1;i>0;i--)
             a[i]=a[i-1];
         a[i]=0;
     }
      
     public static void recorreIzquierda(double a[], int n){
         int i;
         for(i=0;i<n-1;i++)
             a[i]=a[i+1];
         a[n-1]=0;
     } 
     
     public static boolean esCapicua(double a[], int n){
         boolean resp;
         int i, fin;
         fin= n-1;
         i=0;
         while(i<n/2&& a[i]==a[fin]){
            fin=fin-1;
            i++;
        }
        if(i<(n/2))
            resp=false;
        else
            resp=true;
        return resp;
     }
     
    public static void main(String[] args) {
        int a[], indice;
        double b[], sum;
        
        b=new double[4];
        a=new int[5];
        leeArreglo(b,4);
        imprimeArreglo(b,4);
        sum=sumaArreglo(b,4);
        System.out.println("La suma del arreglo es "+sum);
        sum=promedioArreglo(b,4);
        System.out.println("El promedio del arreglo es "+sum);
        indice=encuentraMayor(b,4);
        System.out.println("El valor mas grande es "+ b[indice]+ " y esta en la posicion "+ indice);
        indice=encuentraMenor(b,4);
        System.out.println("El valor mas chico es "+ b[indice]+ " y esta en la posicion "+ indice);
        System.out.println(esCapicua(b,4));
        
    }
    
}
