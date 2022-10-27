import java.lang.annotation.Repeatable;
import java.util.List;

import org.junit.Test;

public class ForcaBrutaTeste {
    private static final int LIMITE_MAXIMO_TEMPO_MEDIO_EM_MILISEGUNDOS = 4 * 1000; // 4 SEGUNDOS

    @Test
    public void forcaBrutaComSucesso() {
        for(int i = 2; i < 100; i++) {
            List<Integer> conjunto = ForcaBruta.geradorDeConjuntos(i);
            
            int somaDeTodosOsElementos = conjunto.stream().mapToInt(numero -> numero).sum();
            int valorSoma = somaDeTodosOsElementos / conjunto.size();

            long mediaDeTempoEmMilissegundos = 0;
            for(int j = 1; j <= 150 || mediaDeTempoEmMilissegundos / j <= LIMITE_MAXIMO_TEMPO_MEDIO_EM_MILISEGUNDOS ; j ++) {
                long inicioTeste = System.currentTimeMillis();    

                boolean existeValorDaSoma = ForcaBruta.existeValorEmSomaDeSubconjuntos(conjunto, valorSoma);

                long fimTeste = System.currentTimeMillis();

                long diferencaDeTempoEmMilisegundos = fimTeste - inicioTeste;
                mediaDeTempoEmMilissegundos += diferencaDeTempoEmMilisegundos;
            }
        }
    }
}
