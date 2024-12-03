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

import java.util.Objects;
import java.util.Random;

/**
 * TargetProvider for providing QuestionGenerationTargets randomly from a set fo
 * QuestionGenerationTargets.
 *
 * @author Lennart Köhler
 */
public class RandomTargetProvider implements TargetProvider {

    private final QuestionGenerationTarget<?>[] targets;

    private final Random random;

    public RandomTargetProvider(QuestionGenerationTarget<?>... targets) {
        if (targets.length == 0)
            throw new IllegalArgumentException(
                    "needs at least one providable QuestionGenerationTarget");
        this.targets = targets;
        for (QuestionGenerationTarget<?> target : targets) Objects.requireNonNull(target);
        this.random = new Random();
    }

    public RandomTargetProvider(int seed, QuestionGenerationTarget<?>... targets) {
        this.targets = targets;
        for (QuestionGenerationTarget<?> target : targets) Objects.requireNonNull(target);
        this.random = new Random(seed);
    }

    @NonNull
    @Override
    public QuestionGenerationTarget<?> provide() {
        return targets[random.nextInt(targets.length)];
    }
}
