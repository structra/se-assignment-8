package structra.assignment.framework.llm;

import java.util.concurrent.CompletableFuture;

/**
 * A generic interface for machine learning models, designed to accommodate various types of ML
 * tasks, such as text generation, embeddings, classification, and more.
 *
 * @author Riko Torun
 * @author Lennart Köhler
 * @author Moritz Wiedemann
 */
public interface MachineLearningModel {

    char DEFAULT_DELIMITER = '$';

    /**
     * Configures the model with a specific system context or parameters.
     * It guides the model's behavior throughout a conversation.
     *
     * @param systemContext The context or configuration to apply.
     */
    void setContext(String systemContext);

    /**
     * Generates a response or performs a task based on the provided prompt.
     *
     * @param prompt The prompt(s) for the model.
     * @return A {@link CompletableFuture} containing the {@link String} result of the operation.
     */
    CompletableFuture<String> execute(String prompt);
}
