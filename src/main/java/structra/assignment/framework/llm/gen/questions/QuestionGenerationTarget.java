/*
 * MIT License
 *
 * Copyright (c) 2024 Riko Torun, Artur Rausch, Lennart Köhler, Moritz Wiedemann, Tim Stöcker,
 * Souren Ishkhanian
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

package structra.assignment.framework.llm.gen.questions;

import lombok.NonNull;
import structra.assignment.framework.llm.MachineLearningModel;
import structra.assignment.framework.model.question.base.Question;
import structra.assignment.framework.provide.ModelQuestionProvider;

/**
 * Defines a specific question generation configuration and behaviour for the {@link MachineLearningModel}.
 * This class is used if a {@link Question} needs to be constructed from a raw string.
 * Each implementation of this interface targets a specific question type for construction.
 *
 * @author Lennart Köhler
 * @author Riko Torun
 * @see ModelQuestionProvider
 */
public interface QuestionGenerationTarget<T extends Question<?>> {

    String DEFAULT_PROMPT = "Generate new question. It should not be seen before!";

    /**
     * Returns the base prompt for generating the next question this target relates to.
     *
     * @return the base prompt
     * @implNote returns {@code "Generate new question. It should not be seen before!"} by default
     */
    String getBasePrompt();

    /**
     * Parses the question
     *
     * @param input the input string to parse
     * @return the parsed question
     */
    T parse(String input);

    @NonNull
    String getTargetContext();
}
