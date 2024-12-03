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
import java.util.Objects;

/**
 * The SingleChoice class is a raw implementation for a Question that contains exactly one Answer.
 *
 * @param <T> The specified Answer Type for this Question
 * @author Lennart Köhler
 * @see Question
 * @see Answer
 */
@ToString
public abstract class SingleAnswerQuestion<T extends Serializable> implements Question<T> {

    private Serializable key;
    private final String title;
    private final float difficulty;
    private final Answer<T> answer;
    private final String imageURI;
    private final long pointsPossible;
    private final String explanation;

    /**
     * Creates a new Answer with the given initial input, expected input and Text this Answer should
     * have
     *
     * @param title the Title this Question should have or null if none is given.
     * @throws NullPointerException if the expected input is null
     */
    public SingleAnswerQuestion(
            float difficulty,
            String title,
            long pointsPossible,
            String explanation,
            String image,
            @NonNull Answer<T> answer) {
        this.difficulty = difficulty;
        this.title = title;
        this.pointsPossible = pointsPossible;
        this.explanation = explanation;
        this.answer = Objects.requireNonNull(answer);
        this.imageURI = image;
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

    /**
     * {@inheritDoc} <br>
     * Since this is a Single choice Question only one Answer will be returned.
     */
    @Override
    @SuppressWarnings("unchecked")
    public Answer<T>[] getAnswers() {
        return new Answer[] {answer};
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

    /**
     * Returns the only Answer stored in this question. Since this is a single option question this
     * always succeed with the only one question.
     *
     * @return the only Answer stored in this question
     */
    protected Answer<T> getAnswer() {
        return getAnswers()[0];
    }

    /** {@inheritDoc} */
    @Override
    public long getPointsPossible() {
        return pointsPossible;
    }

    /** {@inheritDoc} */
    @Override
    public String getExplanation() {
        return explanation;
    }
}
