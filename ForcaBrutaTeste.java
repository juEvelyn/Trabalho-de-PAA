import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ForcaBrutaTeste {

    @Test
    public void forcaBrutaComSucesso() {
        List<Integer> testeExiste = Arrays.asList(10, 20, 30);
        assertTrue(ForcaBruta.existeValor(testeExiste, 40));
    }
    @Test
    public void forcaBrutaComFalha() {
        List<Integer> testeExiste = Arrays.asList(10, 20, 30);
        assertFalse(ForcaBruta.existeValor(testeExiste, 43));
    }

}
