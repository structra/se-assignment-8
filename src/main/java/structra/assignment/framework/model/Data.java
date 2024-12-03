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

package structra.assignment.framework.model;

import java.io.Serializable;

/**
 * An interface representing an object that can be stored in an archive and retrieved from it. It
 * extends the Serializable interface, allowing objects implementing
 * se.assignment.given.model.answers.Data to be serialized and deserialized. This behaviour is
 * useful in encryption.
 *
 * @author Lennart Köhler
 * @author Riko Torun
 */
public interface Data extends Serializable {

    /**
     * Retrieves the key associated with this se.assignment.given.model.answers.Data object.
     *
     * @return The key associated with this se.assignment.given.model.answers.Data object.
     */
    Serializable getKey();

    /**
     * Sets the key associated with this se.assignment.given.model.answers.Data object.
     *
     * @param key The key to be associated with this se.assignment.given.model.answers.Data object.
     */
    void setKey(Serializable key);
}
