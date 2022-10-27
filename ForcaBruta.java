import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ForcaBruta {
    private static final int LIMITE_MAXIMO_TEMPO_MEDIO_EM_MILISEGUNDOS = 4 * 1000; // 4 SEGUNDOS

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // System.out.println("Digite o tamanho do conjunto:");
        // int tamanhoConjunto = sc.nextInt();

        // List<Integer> conjunto = geradorDeConjuntos(tamanhoConjunto);
        // System.out.println(conjunto);
        
        // boolean existeValor = existeValorEmSomaDeSubconjuntos(conjunto,12);
        // System.out.println(existeValor);

        // sc.close();

        testeAutomatizado();
    }

    public static void testeAutomatizado() {
        long tempoEmMilisegundos = 0;
        int tamanhoDoConjunto = 5000000;
        
        while(tempoEmMilisegundos / 150 <= LIMITE_MAXIMO_TEMPO_MEDIO_EM_MILISEGUNDOS) {

            for(int  j = 1 ; j <= 150 ; j++) {

                List<Integer> conjunto = ForcaBruta.geradorDeConjuntos(tamanhoDoConjunto);
                int somaDeTodosOsElementos = conjunto.stream().mapToInt(numero -> numero).sum();
                int valorMedia = somaDeTodosOsElementos / conjunto.size();

                long inicioTeste = System.currentTimeMillis();    

                ForcaBruta.existeValorEmSomaDeSubconjuntos(conjunto, valorMedia);

                long fimTeste = System.currentTimeMillis();

                long diferencaDeTempoEmMilisegundos = fimTeste - inicioTeste;
                tempoEmMilisegundos += diferencaDeTempoEmMilisegundos;

            }
           
            System.out.println("Tempo médio gasto em um conjunto de tamanho " + tamanhoDoConjunto + ": " + tempoEmMilisegundos / 150 + " milisegundos");
            
            tamanhoDoConjunto++;
        }
    }

    public static boolean existeValorEmSomaDeSubconjuntos(List<Integer> conjunto, int valor) {
        for(int i = 0; i < conjunto.size(); i++) {
            List<Integer> subconjunto = new ArrayList<Integer>();
            subconjunto.add(conjunto.get(i));

            if (conjunto.get(i) == valor) {
                return true;
            }
            
            int soma = conjunto.get(i);

            for(int j = i + 1; j < conjunto.size(); j++) {
                soma += conjunto.get(j);
                subconjunto.add(conjunto.get(j));

                if (soma == valor) {
                    return true;
                }
            }
        }

        return false;
    }

    public static List<Integer> geradorDeConjuntos(int tamanho) {
        Random gerador = new Random();
        List<Integer> conjunto = new ArrayList<Integer>();
        
        for (int i = 0; i < tamanho; i++) {
            conjunto.add(gerador.nextInt(9) + 1);
        }

        return conjunto;
    }
}