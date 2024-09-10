public enum Valor {
    As(11),
    Dois(2),
    Tres(3),
    Quatro(4),
    Cinco(5),
    Seis(6),
    Sete(7), 
    Oito(8),
    Novo(9),
    Dez(10);

    private final int valor;

    Valor(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }

}
