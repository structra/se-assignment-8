## Using CompletableFuture
```java
// Create a new CompletableFuture object 
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello from future1!");

// Use join() to block and get the result once it is available
String result = future.join();
System.out.println("Result from join(): " + result1);

// Handle the result without blocking
future.thenAccept(futureResult -> {
    System.out.println("Result from future1 (non-blocking): " + result);
});

// Handle an error without blocking
future.exceptionally(throwable -> {
    System.out.println("Task from future1 failed (non-blocking) failed with: " + throwable.getMessage());
    return null;
});

try {
// Use get() to block and get the result (throws exceptions that must be handled)
String result2 = future.get();
    System.out.println("Result from get(): " + result2);
} catch (Exception e) {
        // Handle the exception
        System.err.println("Error occurred: " + e.getMessage());
}
```

## Using Gradle to run this project
### 1. Locate Gradle Icon
- Go to the top right of IntelliJ IDEA.
- Click on the Gradle Icon.
<div style="text-align: center;">
  <img src="/src/main/resources/gradle_icon.png" alt="Gradle Icon Showcase" style="width: 50%;">
</div>

### 2. Initiate Gradle Sync & Open the Settings
- Click on the sync icon.
<div style="text-align: center;">
  <img src="/src/main/resources/sync_icon.png" alt="Gradle Sync Button" style="width: 50%;">
</div>

- If the initial sync fails, open the Gradle settings.
<div style="text-align: center;">
  <img src="/src/main/resources/sync_failure_settings.png" alt="Gradle Sync Failure" style="width: 50%;">
</div>

### 3. Configure Gradle JVM
- Click the dropdown for Gradle JVM (currently showing `<No Project SDK>`).
<div style="text-align: center;">
  <img src="/src/main/resources/jdk_selection_dropdown.png" alt="JDK Selection Dropdown" style="width: 50%;">
</div>

### 4. Select JDK
- Choose a local JDK installed on your system.
- Alternatively, download a new JDK if needed.
<div style="text-align: center;">
  <img src="/src/main/resources/jdk_selection.png" alt="JDK Selection" style="width: 50%;">
</div>

### 5. Finalize Setup
- Run Gradle sync again.
- The sync should now complete successfully.

### 6. Run the project
- You can run either of these:
  - Execute the main method in `src/main/java/structra/assignment/task/impl/Example.java`
  - Run a **Gradle build**
<div style="text-align: center;">
  <img src="/src/main/resources/run_gradle_build.png" alt="Gradle Build" style="width: 50%;">
</div>

## Using some of the framework's classes
```java
// Create a new KeyProvider to provide the API key
KeyProvider keyProvider = new YourKeyProvider(); // TODO this should be implemented by you (task 1)

// Pass your Plugin to the Model you want to use
MachineLearningModel mimic = new Mimic(keyProvider);

// Create a new RandomTargetProvider with the given QuestionTargets.
// In this case Mimic will always return multiple choice questions, since setting the prompt to Mimic.MULTIPLE_CHOICE
// will let Mimic always return multiple choice questions.
TargetProvider provider = new RandomTargetProvider(new OpenQuestionTarget(Mimic.MULTIPLE_CHOICE));

// If you wish to use a real model, just set the prompt to the default prompt for generating new questions (or provide your own)
TargetProvider provider2 = new RandomTargetProvider(new OpenQuestionTarget(QuestionGenerationTarget.DEFAULT_PROMPT));

// Creates a new QuestionProvider with the model, provider and an empty list of questions, since 
// we do not want to pass any additional questions as context to the model.
QuestionProvider questionProvider = new ModelQuestionProvider(mimic, provider, new ArrayList<>());

// Create a new CompletableFuture object, holding the question, once generation has finished
CompletableFuture<Question<?>> future = questionProvider.next();
```