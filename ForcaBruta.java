import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ForcaBruta {
    private static final int LIMITE_MAXIMO_TEMPO_MEDIO_EM_MILISEGUNDOS = 4 * 1000; // 4 SEGUNDOS

    public static void main(String[] args) {

        testeAutomatizado();
    }

    public static void testeAutomatizado() {
        long tempoMedioSolucoes = 0;
        int tamanhoDoConjunto = 5400;
        
        while(tempoMedioSolucoes <= LIMITE_MAXIMO_TEMPO_MEDIO_EM_MILISEGUNDOS) {

            for(int  j = 1 ; j <= 150 ; j++) {

                List<Integer> conjunto = ForcaBruta.geradorDeConjuntos(tamanhoDoConjunto);
                int somaDeTodosOsElementos = conjunto.stream().mapToInt(numero -> numero).sum();
                int valorMedia = somaDeTodosOsElementos / conjunto.size();

                long inicioTeste = System.currentTimeMillis();    

                ForcaBruta.existeValor(conjunto, valorMedia);

                long fimTeste = System.currentTimeMillis();

                long diferencaDeTempoEmMilisegundos = fimTeste - inicioTeste;
                tempoMedioSolucoes += diferencaDeTempoEmMilisegundos;

            }
           tempoMedioSolucoes /= 150;
           if(tamanhoDoConjunto%10==0){
            System.out.println("Tempo médio gasto em um conjunto de tamanho " + tamanhoDoConjunto + ": " + tempoMedioSolucoes + " milisegundos");
           }
            
            tamanhoDoConjunto+=100;
        }
    }
    public static boolean existeValor(List<Integer> conjunto, int valor){
        if(conjunto.size()==0){
            if(valor == 0){
                return true;
            }
            return false;
        }
        List<Integer> subconjunto = new ArrayList<Integer>();
        for(int i=0;i<conjunto.size()-1;i++){
            subconjunto.add(conjunto.get(i));
        }
        boolean existe = existeValor(subconjunto, valor);
        if(!existe && conjunto.get(conjunto.size()-1)<= valor){
            existe = existeValor(subconjunto, (valor-conjunto.get(conjunto.size()-1)));
        }
        return existe;
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