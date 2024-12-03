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

package structra.assignment.framework.utils;

import lombok.NonNull;
import structra.assignment.framework.model.answer.AnswerTypes;
import structra.assignment.framework.model.answer.concrete.BooleanAnswer;
import structra.assignment.framework.model.answer.concrete.TextAnswer;

import java.util.Objects;
import java.util.Optional;

/**
 * A utility class providing various string manipulation and sanitization methods.
 *
 * @author Riko Torun
 * @author Artur Rausch
 */
public abstract class StringUtils {

    /**
     * Attempts to map a class path name to an AnswerType String {@link AnswerTypes}
     *
     * @param type String, can't be null otherwise there is no use in this function and Optional
     *     creation would throw an exception as well
     * @return An Optional String that is at least always an uppercase version of the Input. If the
     *     String was Empty but not null it returns an empty Optional.
     */
    public static Optional<String> validateAnswerTypeString(@NonNull String type) {
        type = Objects.requireNonNull(lastPartInUpperCase(type));

        Optional<String> cleanType = Optional.of(type);

        // class names that are possibly used in the constructor
        // AnswerData(Answer<?> answer)
        final String part1 = lastPartInUpperCase(BooleanAnswer.class.getName());
        final String part2 = lastPartInUpperCase(TextAnswer.class.getName());

        // maps them to the equivalent type in the Enum
        if (type.equals(part1)) return Optional.of(AnswerTypes.BOOLEAN_ANSWER.toString());
        else if (type.equals(part2)) return Optional.of(AnswerTypes.TEXT_ANSWER.toString());
        else return cleanType;
    }

    /**
     * For now only used in {@link #validateAnswerTypeString(String)}
     *
     * @param s String that can have multiples parts e.g.
     *     <pre>{@code
     * final String str = "quiz.AnswerTypes.BooleanAnswer";
     *
     * }</pre>
     *
     * @return The last part of the input String in uppercase. If last part == first part it would
     *     just put it in uppercase.
     */
    @NonNull
    private static String lastPartInUpperCase(@NonNull String s) {
        String[] typeSplit = s.split("\\.");
        return typeSplit[typeSplit.length - 1].toUpperCase();
    }
}
