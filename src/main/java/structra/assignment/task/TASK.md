# 🌟 **Quiz App Development Plan**

## ⚠️ Implementation details ⚠️

Your implementation should be placed in the package `src/main/java/structra/assignment/task/impl`. You may use Example.java
as a reference, but you dont have to.

## 1. **Plugin Creation**

- **Objective**: Create a class that implements the `KeyProvider.java` interface. Its purpose is to allow for simple
  retrieval of an API key via the `getApiKey` method. The API key can be the one required by `Mimic.java` or a genuine
  one used for the OpenAI chat completions endpoint.

- **Resources**: Use the following API key if you want to use `Mimic.java` (Our mock implementation of
  `ChatGPTModel.java`)
    - `structra-1343abnc-dGhpcyBpcyBub3Qgb3VyIGFwaSBrZXksIG5pY2UgdHJ5IHRobyA6KQ==`

## 2. **GUI Implementation**

- **Objective**: Develop an interactive Graphical User Interface (GUI) to display questions dynamically, powered by the
  `ModelQuestionProvider.java`.

- **Technologies**: **Swing** (Java GUI toolkit). Reference
  the [official documentation](https://docs.oracle.com/javase/tutorial/uiswing/) for guidance.

- **Components to Include**:
    - **Main Window**: The main container (e.g `JFrame`) of all other elements.
    - **Next Question Button**: A button that, when pressed, retrieves and displays the next question using
      `ModelQuestionProvider.next()`.
    - **Question Display Area**: A `TextArea` or `Label` that will display the question text. This should account for
      different question types (e.g. multiple-choice questions).

- **Non-blocking Design**:
    - Ensure the GUI remains responsive while tasks are being processed (Properly use `CompletableFuture`).

- **Handling Different Question Types**:
    - Display the question properly formatted in non JSON form
    - Example: <p>
      ![GUI Example](/src/main/resources/GUI_example.png) </p>

## 3. **Multiple Choice Formatter**

- **Objective**: Add your implementation to generate and format multiple-choice questions, using the model
  `ChatGPTModel.java` (or its mock, `Mimic.java`).

- **Steps**:
    - Create a concrete implementation for `QuestionGenerationTarget.java` and `SystemContext.java`.
    - Use the above classes to process inputs from the chosen model and generate instances of
      `MultiCheckboxQuestion.java` using `Quizzmaker.java`.
        - Refer to `OpenQuestionTarget.java` and `OpenQuestionContext.java` for guidance [^1].
    - Format the question and answer options to be displayed in the GUI.

## 4. **Refactoring - UML diagrams**

- **Objective**: Propose a refactor of the `QuestionTypes.java` enumeration, making it more modular, maintainable, and
  extensible.

- **Steps**:
    - Analyze the current `QuestionTypes.java`.
    - Create a UML [^2] diagram that outlines how to improve `QuestionTypes.java`.

## 5. **Documentation Improvements**

- **Objective**: Suggest improvements for any documentation inside `structra/assignment/framework`. This includes
  docstrings as well, as UML diagrams (if you feel like creating one).

- **Steps**:
    - Analyze the current documentation.
    - Suggest changes by adding documentation inside the respective files / packages.
    - Write a *short* text justifying your changes.

## 6. **Reflection**

- **Objective**: Reflect on what you have learned so far by discovering similarities between concepts used in the
  lecture and the actual implementation in `structra/assignment/framework`.

- **Steps**:
    - Familiarize yourself with the design patterns used and design choices made.
    - Have a look at the lecture material again.
    - Write a text detailing which similarities you have found.

[^1]: Additional documentation can be found in `structra/assignment/framework/docs`.
[^2]: PlantUML
renderer [PlantUML](https://www.plantuml.com/plantuml/duml/SoWkIImgAStDuNBAJrBGjLDmpCbCJbMmKiX8pSd9vt98pKi1IW80).
