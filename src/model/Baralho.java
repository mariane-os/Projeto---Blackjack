
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho(){
        cartas = new ArrayList<>();
        for(Naipe naipe : Naipe.values()){
            for(Valor valor : Valor.values()){
                cartas.add(new Carta(valor, naipe));
            }
        }
        Collections.shuffle(cartas);
    }

    //o que é?
    public Carta distribuirCarta() {
        return cartas.remove(cartas.size() - 1);
    }
}
