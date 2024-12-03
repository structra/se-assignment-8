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

package structra.assignment.framework.provide;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

import structra.assignment.framework.model.question.base.Question;

/**
 * The Question Provider interface provides functionality for providing the next Question for a
 * certain Collection of Questions.
 *
 * @author Lennart Köhler
 * @see Question
 */
public interface QuestionProvider extends Serializable {

    int INFINITE_PROVISIONS = -1;

    /** {@inheritDoc} */
    CompletableFuture<Question<?>> next();

    /** {@inheritDoc} */
    boolean hasNext();

    /**
     * resets the QuestionProvider to its initial state.
     *
     * @implNote The initial state is implementation dependent and might change over time
     */
    void reset();

    /**
     * returns the maximum number of possible provisions that can be received via {@link #next()}.
     *
     * @return the maximum number of possible provisions and an integer < 0 if there are infinite
     *     provisions
     */
    int getMaxProvisions();
}
