package es.neesis.annotations.services;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AhorcadoService implements IAhorcadoService{

    private IPalabras generador;
    private String palabraSecreta;
    private StringBuilder palabraAdivinada;
    private int intentos;

    public AhorcadoService(IPalabras generador){
        this.generador = generador;
    }


    public void jugar(){
        iniciarJuego();

        Scanner sc = new Scanner(System.in);
        char letra;

        while(intentos > 0 && palabraAdivinada.indexOf("_") != -1){
            mostrarPartida();

            String entrada = sc.nextLine();

            if(entrada.isEmpty()){
                break;
            }

            if(entrada.length() == 1){
                letra = entrada.charAt(0);
                comprovarLetra(letra);
            }else{
                if(entrada.equals(palabraSecreta)){
                    palabraAdivinada = new StringBuilder(palabraSecreta);
                    break;
                }else{
                    intentos --;
                    System.out.println("Palabra incorrecta");
                }
            }
        }

        comprovarPartida();

        System.out.println("Presione enter para continuar...");
        sc.nextLine();

        sc.close();
    }

    public void iniciarJuego(){
        palabraSecreta = generador.generarPalabra();
        palabraAdivinada = new StringBuilder("_".repeat(palabraSecreta.length()));
        intentos = 8;
    }

    private void comprovarLetra(char letra){
        boolean acierto = false;
        for(int i=0; i<palabraSecreta.length(); i++){
            if(palabraSecreta.charAt(i) == letra){
                acierto = true;
                palabraAdivinada.setCharAt(i, letra);
            }
        }

        if(!acierto){
            System.out.println("Letra incorrecta");
            intentos--;
        }
    }

    private void mostrarPartida(){
        System.out.println("Palabra a adivinar: " + palabraAdivinada);
        System.out.println("Te quedan " + intentos + " intentos");
        System.out.println("Introduce una letra: ");
    }

    private void comprovarPartida(){
        if (palabraAdivinada.indexOf("_") == -1) {
            System.out.println("¡Felicidades, has ganado! La palabra era: " + palabraSecreta);
        } else {
            System.out.println("¡Has perdido! La palabra correcta era: " + palabraSecreta);
        }
    }

}
