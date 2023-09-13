package ru.animal.akinator;

import ru.animal.akinator.service.AnimalAkinatorService;

import java.io.IOException;

public class AnimalAkinator {
    public static void main(String[] args) throws IOException {
        AnimalAkinatorService akinatorService = new AnimalAkinatorService();
        akinatorService.startGame();
    }
}
