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

package structra.assignment.framework.llm.context.specification;

import java.util.Locale;
import java.util.UUID;

/**
 * Enum for generic context specifications.
 *
 * @author Riko Torun
 */
public enum GenericContext implements SystemContext {
    UNIQUENESS(
            "NEVER generate a seen question. Generate UNIQUE questions using "
                    + "this seed: %s. Avoid common topics. Be creative and unconventional. "),
    DIFFICULTY(
            "Include easy, medium, and hard questions using this seed: %s. "
                    + "Harder questions should require deeper knowledge or complex reasoning. "),
    TOPIC_VARIETY(
            "Cover diverse topics (science, history, arts, geography, "
                    + "literature, sports, tech) using this seed: %s. Aim for balance. "),
    ENGAGEMENT(
            "Create engaging questions with this seed: %s. Use interesting "
                    + "facts, surprising info, or intriguing scenarios. "),
    RELEVANCE("Ensure global/topic relevance with this seed: %s. "),
    EDUCATIONAL_VALUE(
            "Prioritize educational value using this seed: %s. Each "
                    + "question should teach or reinforce knowledge. "),
    LANGUAGE("Language of your response MUST BE: %s. "),
    RANDOM_SEED("Use this random seed in randomizing your response: %s. ");

    private final String contextMessage;

    GenericContext(String contextMessage) {
        this.contextMessage = contextMessage;
    }

    /**
     * Gets the default system language in a capitalized format.
     *
     * @return The capitalized name of the default system language.
     */
    private static String getLanguage() {
        Locale locale = new Locale(Locale.getDefault().getLanguage());
        String languageName = locale.getDisplayLanguage(Locale.ENGLISH);
        return languageName.substring(0, 1).toUpperCase() + languageName.substring(1);
    }

    private String generateSeed() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getContext() {
        if (this == LANGUAGE) return String.format(contextMessage, getLanguage());
        return String.format(contextMessage, generateSeed());
    }
}
