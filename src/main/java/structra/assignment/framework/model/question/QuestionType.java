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

package structra.assignment.framework.model.question;

import java.io.Serializable;
import java.util.Collections;

import structra.assignment.framework.model.answer.AnswerData;
import structra.assignment.framework.model.answer.concrete.TextAnswer;

/**
 * An enumeration used for possible question types.
 *
 * @author Riko Torun
 * @author Artur Rausch
 * @author Lennart Köhler
 */
@SuppressWarnings("all")
public enum QuestionType implements Serializable {
    BOOLEAN(false, null, t -> null, "Boolean"),

    SINGLE_CHOICE(true, null, QuestionData::new, "Single Choice"),

    MULTIPLE_CHOICE(true, null, QuestionData::new, "Multiple Choice"),

    CLOZE(false, null, t -> null, "Cloze"),

    DRAG_AND_DROP(false, null, t -> null, "Drag and Drop"),

    OPEN_ANSWER(
            true,
            null,
            t -> {
                AnswerData answerData = new AnswerData(new TextAnswer("", "", ""));
                return new QuestionData(
                        t.toString(),
                        "",
                        0.5f,
                        5,
                        "",
                        "",
                        Collections.singletonList(answerData),
                        false);
            },
            "Open Answer");

    QuestionType(
            boolean stable,
            Integer previewResourceID,
            InitialQuestionProvider initialQuestionProvider,
            String displayName) {
        this.stable = stable;
        this.previewResourceID = previewResourceID;
        this.initialQuestionProvider = initialQuestionProvider;
        this.displayName = displayName;
    }

    private final boolean stable;
    public final Integer previewResourceID;
    private final InitialQuestionProvider initialQuestionProvider;
    private final String displayName;

    public QuestionData getInitials() {
        return initialQuestionProvider.getInitialData(this);
    }

    public boolean isStable() {
        return stable && initialQuestionProvider != null;
    }

    public String getDisplayName() {
        return displayName;
    }

    private interface InitialQuestionProvider {
        QuestionData getInitialData(QuestionType type);
    }
}
