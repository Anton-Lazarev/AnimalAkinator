package ru.animal.akinator.service;

import lombok.Getter;
import lombok.Setter;
import ru.animal.akinator.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Getter
@Setter
public class AnimalAkinatorService {
    private final String prefix = "Это животное ";
    private final String postfix = "? (да/нет)";
    private final BufferedReader cmdReader;
    private final Question startQuestion;

    public AnimalAkinatorService() {
        startQuestion = Question.builder().value("живет на суше")
                .positiveAnswer(Question.builder().value("кот").build())
                .negativeAnswer(Question.builder().value("кит").build())
                .build();

        cmdReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startGame() {
        try {
            System.out.println("Хотите поиграем в угадайку про животных? (да/нет)");
            String answer = cmdReader.readLine();
            while (!answer.equals("нет")) {
                System.out.println("Загадай животное, а я попробую угадать...");
                ask(startQuestion);
                System.out.println("Хотите сыграть ещё? (да/нет)");
                answer = cmdReader.readLine();
            }
            System.out.println("Спасибо, что поиграли со мной! ;)");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void ask(Question question) throws IOException {
        System.out.println(prefix + question.getValue() + postfix);
        String answer = cmdReader.readLine();
        if (question.getPositiveAnswer() == null && question.getNegativeAnswer() == null) {
            if (answer.equals("да")) {
                System.out.println("Ваше животное - " + question.getValue());
            } else {
                System.out.println("Какое животное вы загадали?");
                String newAnimal = cmdReader.readLine();
                System.out.println("Чем оно отличается от " + question.getValue() + "?");
                String newQuestion = cmdReader.readLine();

                question.setNegativeAnswer(Question.builder().value(question.getValue()).build());
                question.setPositiveAnswer(Question.builder().value(newAnimal).build());
                question.setValue(newQuestion);
                System.out.println("Запись " + newAnimal + " добавлена");
            }
        } else {
            if (answer.equals("да")) {
                ask(question.getPositiveAnswer());
            } else {
                ask(question.getNegativeAnswer());
            }
        }
    }
}
