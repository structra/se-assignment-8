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

package structra.assignment.framework.model.gen.answers;

import lombok.NonNull;
import structra.assignment.framework.model.answer.AnswerData;
import structra.assignment.framework.model.answer.concrete.BooleanAnswer;
import structra.assignment.framework.model.answer.concrete.TextAnswer;

import java.io.Serializable;

/**
 * Converts AnswerData to an instance of BooleanAnswer.<br>
 * For specifics about the DB schema have look <br>
 * at the Answer Table in the README.md
 *
 * @author Artur Rausch
 * @author Lennart Köhler
 * @author Riko Torun
 * @see TextAnswer
 */
public class BooleanAnswerFactory implements AnswerFactory {
    /**
     * @param data Information fetched from DB, for specifics have a look at the Schema in the
     *     Readme
     * @return a new instance of BooleanAnswer containing false (meaning it wasn't clicked yet.) and
     *     otherwise the generic AnswerData attributes needed
     */
    @Override
    @NonNull
    public BooleanAnswer create(@NonNull AnswerData data) {
        Serializable expected = data.getExpected();
        boolean bool =
                (expected instanceof String)
                        ? Boolean.parseBoolean((String) expected)
                        : (boolean) expected;
        BooleanAnswer answer = new BooleanAnswer(false, bool, data.getText());
        answer.setKey(data.getKey());
        return answer;
    }
}
