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

package structra.assignment.framework.model;

import structra.assignment.framework.model.answer.base.Answer;
import structra.assignment.framework.model.question.base.Question;

/**
 * This class is used to simplify and unify the use of Firebase field names in other classes. This
 * helper class stores data such as variable names to use when accessing the database. It should be
 * looked at whenever non-user-input Strings are used.
 */
public interface StringConstants {

    /** Overall constants used across multiple collections. */
    interface Overall {

        /** Points possible in a quiz or activity. */
        String POINTS_POSSIBLE = "PointsPossible";

        /** Points achieved in a quiz or activity. */
        String POINTS_ACHIEVED = "PointsAchieved";
    }

    /**
     * Constants related to a {@link Question}. Questions are stored within a given deck and contain
     * a collection of answers.
     */
    interface Questions {

        /** Collection name for questions. */
        String QUESTIONS_NAME = "Questions";

        /** Type of the question (e.g., multiple choice, true/false). */
        String QUESTION_TYPE = "Type";

        /** Text of the question. */
        String QUESTION_TEXT = "Text";

        /** Link to an image related to the question. */
        String QUESTION_IMG_LINK = "ImgLink";

        /** Difficulty level of the question. */
        String QUESTION_DIFFICULTY = "Difficulty";

        /** Explanation for the question. */
        String QUESTION_EXPLANATION = "Explanation";

        /** Sets if the answer for the question. */
        String SHUFFLED = "Shuffled";
    }

    /** Constants related to an {@link Answer}. Answers are stored within a given question. */
    interface Answers {
        /** Collection name for answers. */
        String ANSWERS_NAME = "Answers";

        /** Text of the answer. */
        String ANSWER_TEXT = "Text";

        /** Expected answer value. */
        String EXPECTED_ANSWER = "Expected";

        /** Type of the answer (e.g., text, numeric). */
        String ANSWER_TYPE = "Type";

        /** Index of the answer (useful for ordered answers). */
        String ANSWER_INDEX = "Index";
    }
}
