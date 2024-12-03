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

package structra.assignment.framework.model.question.concrete;

import lombok.NonNull;
import structra.assignment.framework.model.answer.base.Answer;
import structra.assignment.framework.model.question.QuestionType;
import structra.assignment.framework.model.question.base.SingleAnswerQuestion;

/**
 * A Question for a single open answer.
 *
 * @see SingleAnswerQuestion
 * @author Lennart Köhler
 * @author Souren Ishkhanian
 */
public class OpenAnswerQuestion extends SingleAnswerQuestion<String> {

    /**
     * Constructs a new OpenAnswerQuestion with the provided level, title, and answers.
     *
     * @param difficulty The level of difficulty for this question.
     * @param title The title of the question.
     * @param answer The TextAnswer representing the possible answer.
     * @throws IllegalArgumentException if the answers array is empty.
     * @throws NullPointerException if any answer in the answers array is null.
     */
    public OpenAnswerQuestion(
            float difficulty,
            String title,
            long pointsPossible,
            String explanation,
            String image,
            @NonNull Answer<String> answer) {
        super(difficulty, title, pointsPossible, explanation, image, answer);
    }

    /** {@inheritDoc} */
    @Override
    public QuestionType getType() {
        return QuestionType.OPEN_ANSWER;
    }

    @Override
    public boolean isShuffled() {
        return false;
    }
}
