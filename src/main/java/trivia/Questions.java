package trivia;

import java.util.LinkedList;

public class Questions {

    public static final String POP = "Pop";
    public static final String ROCK = "Rock";
    public static final String SCIENCE = "Science";
    public static final String SPORTS = "Sports";
    private final LinkedList<String> popQuestions;
    private final LinkedList<String> scienceQuestions;
    private final LinkedList<String> sportsQuestions;
    private final LinkedList<String> rockQuestions;


    public Questions() {
        this.popQuestions = new LinkedList<>();
        this.scienceQuestions = new LinkedList<>();
        this.sportsQuestions = new LinkedList<>();
        this.rockQuestions = new LinkedList<>();

        // Create pool of questions
        createQuestions(50);
    }

    private void createQuestions(int numQuestions) {
        for (int i = 0; i < numQuestions; i++) {
            popQuestions.addLast(createQuestion(i, POP));
            scienceQuestions.addLast(createQuestion(i, SCIENCE));
            sportsQuestions.addLast(createQuestion(i, SPORTS));
            rockQuestions.addLast(createQuestion(i, ROCK));
        }
    }

    private String createQuestion(int index, String questionType) {
        return questionType + " Question " + index;
    }

    public void askQuestion(String category) {
        switch (category) {
            case Questions.POP -> System.out.println(popQuestions.removeFirst());
            case Questions.SCIENCE -> System.out.println(scienceQuestions.removeFirst());
            case Questions.SPORTS -> System.out.println(sportsQuestions.removeFirst());
            case Questions.ROCK -> System.out.println(rockQuestions.removeFirst());
            default -> throw new IllegalArgumentException("No such a category " + category);
        }
    }

    public String getQuestionCategoryByPlace(int place) {
        String category;
        switch (place) {
            case 0, 4, 8 -> category = Questions.POP;
            case 1, 5, 9 -> category = Questions.SCIENCE;
            case 2, 6, 10 -> category = Questions.SPORTS;
            default -> category = Questions.ROCK;
        }
        return category;
    }
}
