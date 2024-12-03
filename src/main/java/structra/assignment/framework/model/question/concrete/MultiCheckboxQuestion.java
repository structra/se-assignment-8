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
import lombok.ToString;
import structra.assignment.framework.model.answer.base.Answer;
import structra.assignment.framework.model.question.QuestionType;
import structra.assignment.framework.model.question.base.MultiAnswerQuestion;

/**
 * A multiple choice question meaning it requires 1 or more boxes to be checked <br>
 * to be correct.
 *
 * @author Souren Ishkhanian
 * @author Artur Rausch
 */
@ToString
public class MultiCheckboxQuestion extends MultiAnswerQuestion<Boolean> {

    /**
     * Creates a new MultipleChoiceQuestion with the provided
     *
     * @param difficulty the level of this Question
     * @param title the title for this question
     * @param answers the answers for this question
     */
    @SafeVarargs
    public MultiCheckboxQuestion(
            float difficulty,
            String title,
            long pointsPossible,
            String explanation,
            String image,
            boolean shuffledAnswers,
            @NonNull Answer<Boolean>... answers) {
        super(difficulty, title, pointsPossible, explanation, image, shuffledAnswers, answers);
    }

    @Override
    public QuestionType getType() {
        return QuestionType.MULTIPLE_CHOICE;
    }
}
