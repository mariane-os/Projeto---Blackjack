
import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private List<Carta> mao;
    private String nome;

    public Jogador(String nome){
        this.nome = nome;
        this.mao = new ArrayList<>();
    }

    public void addCarta(Carta carta){
        mao.add(carta);
    }

    //repensar
    public int ValorMao(){
        int valor = 0;
        int ases = 0;
        for (Carta carta : mao){
            valor += carta.getValor().getValor();
            if(carta.getValor() == Valor.As){
               ases++;
            }             
        }
        while (valor > 21 && ases > 0) {
            valor -= 10;
            ases--;
        }
        return valor;
    }

    public boolean Estouro(){
        return ValorMao() > 21;
    }

    public String getNome(){
        return nome;
    }

    public List<Carta> getMao(){
        return mao;
    }

}
