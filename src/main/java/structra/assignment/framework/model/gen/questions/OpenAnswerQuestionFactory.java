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

package structra.assignment.framework.model.gen.questions;

import lombok.NonNull;
import structra.assignment.framework.model.answer.AnswerData;
import structra.assignment.framework.model.answer.concrete.TextAnswer;
import structra.assignment.framework.model.gen.QuizzMaker;
import structra.assignment.framework.model.question.QuestionData;
import structra.assignment.framework.model.question.concrete.OpenAnswerQuestion;

import java.util.NoSuchElementException;

/**
 * Creates a new OpenAnswerQuestion instance from a given AnswerData instance.
 *
 * @author Artur Rausch
 * @author Lennart Köhler
 * @author Riko Torun
 * @see AnswerData
 */
public class OpenAnswerQuestionFactory implements QuestionFactory {
    /**
     * {@inheritDoc}
     *
     * @param data QuestionData
     * @return a new instance of OpenAnswerQuestion
     * @throws NoSuchElementException when there was a mistake in the creation of the question or
     *     previously during loading, which has resulted in the answer field now being empty.
     */
    @Override
    @NonNull
    public OpenAnswerQuestion create(@NonNull QuestionData data) {
        TextAnswer answer;

        if (data.getAnswers().stream().findFirst().isPresent()) {
            answer =
                    (TextAnswer)
                            QuizzMaker.createAnswer(data.getAnswers().stream().findFirst().get());
        } else {
            throw new NoSuchElementException(
                    "There was no answer provided for this Question."
                            + "However OpenAnswerQuestions require an expected TextAnswer to compare against.");
        }

        return new OpenAnswerQuestion(
                (float) data.getDifficulty(),
                data.getText(),
                data.getPointsPossible(),
                data.getExplanation(),
                data.getImageLink(),
                answer);
    }
}
