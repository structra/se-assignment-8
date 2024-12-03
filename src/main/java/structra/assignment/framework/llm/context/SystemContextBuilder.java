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

package structra.assignment.framework.llm.context;

import lombok.NonNull;
import structra.assignment.framework.llm.MachineLearningModel;
import structra.assignment.framework.llm.context.specification.SystemContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Defines a common class for prompting {@link MachineLearningModel} instances using {@link
 * SystemContext}. It is used to construct system level prompts to enable more well-defined
 * responses.
 *
 * @author Riko Torun
 */
public class SystemContextBuilder {

    private final List<String> rawPrompts = new ArrayList<>();

    private final List<SystemContext> specifications = new ArrayList<>();

    public SystemContextBuilder addRawContext(@NonNull String rawPrompt) {
        Objects.requireNonNull(rawPrompt);
        rawPrompts.add(rawPrompt);
        return this;
    }

    public SystemContextBuilder addContext(@NonNull SystemContext specification) {
        Objects.requireNonNull(specification);
        specifications.add(specification);
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append("Consider the following context: ");

        for (String raw : rawPrompts) {
            builder.append(raw);
        }

        if (!specifications.isEmpty()) {
            for (SystemContext _specifications : specifications) {
                builder.append(_specifications.getContext());
            }
        }
        return builder.toString();
    }
}
