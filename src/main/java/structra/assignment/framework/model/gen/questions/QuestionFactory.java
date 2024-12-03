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
import structra.assignment.framework.model.question.QuestionData;
import structra.assignment.framework.model.question.QuestionType;
import structra.assignment.framework.model.question.base.Question;

/**
 * This Interface converts a {@link QuestionData} object into a {@link Question} instance. This
 * interface implements the Factory Design Pattern.
 *
 * @author Lennart Köhler
 * @author Riko Torun
 * @author Artur Rausch
 * @see Question
 */
public interface QuestionFactory {

    /**
     * Transforms the question data provided into a concrete question instance for details on which
     * ones are available have a look at {@link QuestionType}
     *
     * @param data the data provided
     * @return The concrete question instance
     */
    @NonNull
    Question<?> create(@NonNull QuestionData data);
}
