package ru.animal.akinator.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Question {
    private String value;
    private Question positiveAnswer;
    private Question negativeAnswer;
}
