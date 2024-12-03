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

package structra.assignment.framework.model.answer.concrete;

import lombok.NonNull;
import structra.assignment.framework.model.answer.base.Answer;

/** A class used to store a text answer. */
public class TextAnswer extends Answer<String> {
    
    /**
     * Creates a new Answer wit the given initial input, expected input and Text this Answer should
     * have
     *
     * @param initialInput the initial input for this question or null if none is given
     * @param expected the non-null expected input
     * @param text the Text this Question should have or null if none is given.
     * @throws NullPointerException if the expected input is null
     */
    public TextAnswer(
            String initialInput, @NonNull String expected, String text) {
        super(initialInput, expected, text);
    }

    @Override
    public void setInput(String input) {
        if (input == null) this.input = "";
        else this.input = input;
    }
}
