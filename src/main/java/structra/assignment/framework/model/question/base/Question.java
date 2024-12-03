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

import java.io.Serializable;

import structra.assignment.framework.model.Data;
import structra.assignment.framework.model.answer.base.Answer;
import structra.assignment.framework.model.question.QuestionType;

/**
 * The Question interface provides functionality to access necessary information a Question should
 * have. Each Question consist of a Set of answers. Since some for some questions the order of the
 * Answers matters and the amount of possible answers is fix the Answers are provided as an Array.
 * All Answers of a Question must store the same Answer Type specified by the generic <code>T</code>
 * .
 *
 * @param <T> The specified Answer Type for this Question
 * @author Lennart Köhler
 * @author Riko Torun
 * @author Artur Rausch
 * @see Answer
 */
public interface Question<T extends Serializable> extends Data {
    String NAME = "Question";

    Serializable getKey();

    void setKey(Serializable key);

    /**
     * Returns the type for this Question
     *
     * @return the type for this Question
     */
    QuestionType getType();

    /**
     * Returns the actual Question text.<br>
     * For example: "What is the definition of clean coding?"
     *
     * @return a non null Title
     */
    String getText();

    /**
     * Gets additional text providing explanation on why an answer is right.
     *
     * @return explanation the question text
     */
    String getExplanation();

    /**
     * Returns the answers for this Question
     *
     * @return the answers for this Question
     */
    Answer<T>[] getAnswers();

    /**
     * Returns a URI that refer to the image to display in this question
     *
     * @return a URI (String) that refers to image to display in this question
     */
    String getImageURI();

    /**
     * Returns the Difficulty for this Question
     *
     * @return the Difficulty for this Question
     */
    float getDifficulty();

    /**
     * Returns the points possible for this Question
     *
     * @return the points possible for this Question
     */
    long getPointsPossible();

    boolean isShuffled();
}
