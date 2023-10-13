package ru.animal.akinator;

import ru.animal.akinator.service.AnimalAkinatorService;

public class AnimalAkinator {
    public static void main(String[] args) {
        AnimalAkinatorService akinatorService = new AnimalAkinatorService();
        akinatorService.startGame();
    }
}
