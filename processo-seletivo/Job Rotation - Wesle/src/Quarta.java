public class Quarta {
    public static void main(String[] args) {
        double velCaminhao = 80.0;
        double velCarro = 110.0;
        int distanciaCidades = 100;
        double tempoPedagio = 0.083333; 

        
        double tempoCarro = distanciaCidades / velCarro; // pega o tempo que o carro ira demorar para percorrer o percurso
        double distanciaCarro = velCarro * tempoCarro; // Calculando a distância percorrida pelo carro até o encontro

        
        double tempoCaminhao = distanciaCidades / velCaminhao; // pega o tempo que o carro ira demorar para percorrer o percurso
        double distanciaCaminhao = velCaminhao * tempoCaminhao; // Calculando a distância percorrida pelo caminhão até o encontro

        
        distanciaCaminhao -= tempoPedagio * 2 * velCaminhao; // Subtraindo o tempo gasto pelo caminhão nos pedágios

        if (distanciaCarro < distanciaCaminhao) {
            System.out.println("O carro está mais próximo de Ribeirão Preto.");
        } else {
            System.out.println("O caminhão está mais próximo de Ribeirão Preto.");
        }
    }
}
