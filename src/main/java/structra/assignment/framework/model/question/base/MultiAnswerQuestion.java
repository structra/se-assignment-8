/*
 * MIT License
 *
 * Copyright (c) 2024 Riko Torun, Artur Rausch, Lennart Köhler, Moritz Wiedemann, Tim Stöcker, Souren Ishkhanian
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package structra.assignment.framework.model.question.base;

import lombok.NonNull;
import lombok.ToString;
import structra.assignment.framework.model.answer.base.Answer;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * The MultipleChoice class is a raw implementation for a Question that can have multiple Answers.
 *
 * @param <T> The specified Answer Type for this Question
 * @author Lennart Köhler
 * @see Question
 * @see Answer
 */
@ToString
public abstract class MultiAnswerQuestion<T extends Serializable> implements Question<T> {

    private Serializable key;
    private final float difficulty;
    private final String title;
    private final Answer<T>[] answers;
    private final String imageURI;

    private final long pointsPossible;

    private final String explanation;
    private final boolean shuffled_answers;

    /**
     * Creates a new MultipleChoiceQuestion with the provided Leve, title, and answers.
     *
     * @param difficulty the level of this Question
     * @param title the title for this question
     * @param image a collection of image URIs to show or null if none is given
     * @param answers the answers for this question
     */
    @SafeVarargs
    public MultiAnswerQuestion(
            float difficulty,
            String title,
            long pointsPossible,
            String explanation,
            String image,
            boolean shuffled_answers,
            @NonNull Answer<T>... answers) {
        this.difficulty = difficulty;
        this.title = title;
        this.answers = Objects.requireNonNull(answers);
        this.imageURI = image;
        this.pointsPossible = pointsPossible;
        this.explanation = explanation;
        this.shuffled_answers = shuffled_answers;
    }

    @Override
    public Serializable getKey() {
        return key;
    }

    @Override
    public void setKey(Serializable key) {
        this.key = key;
    }

    /** {@inheritDoc} */
    @Override
    public String getText() {
        return title;
    }

    /** {@inheritDoc} */
    @Override
    public Answer<T>[] getAnswers() {
        return answers;
    }

    /** {@inheritDoc} */
    @Override
    public String getImageURI() {
        return imageURI;
    }

    /** {@inheritDoc} */
    @Override
    public float getDifficulty() {
        return difficulty;
    }

    public long getPointsPossible() {
        return pointsPossible;
    }

    public String getExplanation() {
        return explanation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAnswerQuestion<?> that = (MultiAnswerQuestion<?>) o;
        return difficulty == that.difficulty
                && Objects.equals(title, that.title)
                && Arrays.equals(answers, that.answers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(difficulty, title);
        result = 31 * result + Arrays.hashCode(answers);
        return result;
    }

    public boolean isShuffled() {
        return shuffled_answers;
    }
}
