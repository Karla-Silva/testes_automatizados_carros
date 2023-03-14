package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceImplTest {

    //Cada teste será um método

    @Test
    public void deveAcelerarCorretamente() {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carroTeste01 = new Carro("Azul", "Fiat", "Uno", 2015, 150);
        carroService.ligar(carroTeste01);

        // When
        carroService.acelerar(carroTeste01, 10, 200);

        // Then
        // Assertivas
        // O Junit busca por Asserts no método para validar que o teste passou
        //Opcao com assertTrue
        //Assert.assertTrue(carroTeste01.getVelocidadeAtual() == 10);
        //Opcao com assertEquals
        int valorEsperado = 10;
        Assert.assertEquals(valorEsperado, carroTeste01.getVelocidadeAtual());
    }

    @Test
    public void deveLigarCorretamente() {
        CarroService carroService = new CarroServiceImpl();

        // Dado
        Carro carro =
                new Carro("vermelho", "marca", "modelo", 1990, 100);

        // Quando
        carroService.ligar(carro);

        // Então
        Assert.assertTrue(carro.getLigado());
    }

    @Test
    public void velocidadeNaoDeveSerMenorQueZero() {
        // O Junit busca por Assets no método para validar que o teste passou

        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 50);
        carroService.ligar(celtinha); // velocidade zero

        // Quando:
        carroService.frear(celtinha, 10);

        // Então:
        Assert.assertTrue(celtinha.getLigado());
        Assert.assertEquals(0, celtinha.getVelocidadeAtual());
    }

    @Test
    public void deveLigarCorretamenteEAcelerarCorretamente() {
        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 50);

        // Quando:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 10, 200);

        // Então:
        Assert.assertTrue(celtinha.getLigado());
        Assert.assertEquals(10, celtinha.getVelocidadeAtual());
    }


    //Nossos testes

    //Cenario 1
    CarroServiceImpl carroService = new CarroServiceImpl();
    @Test
    public void carroJaLigadoNaoDeveLigarDenovo(){
        //Given
        Carro carro1 = new Carro();
        carro1.setLigado(true);

        //When
        carroService.ligar(carro1);

        //Then
        Assert.assertTrue(carro1.getLigado());
    }

    //Cenario 2
    @Test
    public void desligarCarroJaDesligado(){
        //Given
        Carro carro2 = new Carro();
        carro2.setLigado(false);

        //When
        carroService.desligar(carro2);

        //Then
        Assert.assertFalse(carro2.getLigado());
    }

    //Cenario 3
    @Test
    public void desligarUmCarroLigado(){
        //Given
        Carro carro3 = new Carro();
        carro3.setLigado(true);

        //When
        carroService.desligar(carro3);

        //Then
        Assert.assertFalse(carro3.getLigado());
    }

    //Cenario 4
    @Test
    public void frearUmCarroParado(){
        //Given
        Carro carro4 = new Carro();
        carro4.setLigado(true);

        //When
        carroService.frear(carro4, 10);

        //Then
        int velocidadeEsperada = 0;
        Assert.assertEquals(velocidadeEsperada, carro4.getVelocidadeAtual());
    }

    //Cenario 5
    @Test
    public void naoPassarDaVelocidadeMaxima(){
        //Given
        Carro carro5 = new Carro();
        carro5.setLigado(true);

        //When
        int velocidadeMax = 10;
        carroService.acelerar(carro5, 15, velocidadeMax);

        //Then
        Assert.assertEquals(velocidadeMax, carro5.getVelocidadeAtual());
    }
}
