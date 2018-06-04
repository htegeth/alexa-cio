#Alexa Skill CIO Simulator
Zur Automatisierung der Entscheidungsprozesse der IT wird vorgeschlagen den CIO durch eine KI zu ersetzen

## Konzept
Der Entscheider soll letzlich die Entscheidung hinauszögern oder unnötig machen zu entscheiden. Das Kernprinzip baisert aus Gegenfragen die bei entscheidungsorientierte Ansprachen vom  CIO getätigt werden. Das sind wie folgt:

1. Beständigkeit:
    * Es ist gut so wie es ist
    * das lassen wir besser so
    * Dafür gibt es doch schon Vorgaben
    * Das ist nur der Wunsch eines Einzelnen 
2. Vergraben in Details
    * Erstelle dazu ein Konzept
    * Analysiere das Problem
    * Ich brauche mehr Details
    * Ich brauche noch mehr Details
4. Kapazitäten
    * Dafür haben wir nicht genug Resourcen
    * Hast du mit dem Team schon darüber geredet
7. Weg-Delegieren
    * Tanja erstellt dazu ein Konzept
    * Thorsten erstellt dazu ein Konzept
    * Nimm den Punkt auf wir sprechen beim nächsten mal darüber
8. Aufschieben
    * ich mache einen Termin mit allen Betroffenen
    * sprich erst mit allen Betroffenen
    * Schreib es auf, ich beschäftige mich später damit
    

### Aufruf und Reaktionen
Folgende Aufrufe sind möglich:

    "Was sollen wir mit {problem} machen",
          "Wie sieht es mit {problem} aus",
          "Wir sollten unbedingt {problem} tun",
          "Wir sollten unbedingt {problem} machen",
          "Wir sollten unbedingt {problem} angehen",
          "wenn wir nicht {problem} angehen haben wir ein Problem",
          "wir brauchen dringend {problem}",
          "was sind unsere vorgaben zu {problem}",
          "was sollen wir machen"
    
    




## Setup
To run this example skill you need to do two things. The first is to deploy the example code in lambda, and the second is to configure the Alexa skill to use Lambda.

### AWS Lambda Setup
1. Go to the AWS Console and click on the Lambda link. Note: ensure you are in us-east or you wont be able to use Alexa with Lambda.
2. Click on the Create Function button.
3. Click Author from scratch.
4. In Configure triggers, add Alexa Skill kit as trigger.
5. Name the Lambda Function "Hello-World-Example-Skill".
6. Select the runtime as Java 8.
7. Build a jar file to upload it into the lambda function. There are two ways:
- Using maven: go to the directory containing pom.xml, and run 'mvn assembly:assembly -DdescriptorId=jar-with-dependencies package'. This will generate a zip file named "helloworld-1.0-jar-with-dependencies.jar" in the target directory. 
- Using gradle: go to the directory containing build.gradle,  and run 'gradle fatJar'. This will generate a zip file named "helloworld-fat-1.0.jar" in the build/libs directory.
8. Select Code entry type as "Upload a .ZIP file" and then upload the jar file created in step 7 from the build directory to Lambda.
9. Set the Handler as com.amazon.asksdk.helloworld.HelloWorldSpeechletRequestStreamHandler (this refers to the Lambda RequestStreamHandler file in the zip).
10. Choose an existing role - lambda_basic_execution.
11. Leave the Advanced settings as the defaults.
12. Click "Next" and review the settings then click "Create Function".
13. Copy the ARN from the top right to be used later in the Alexa Skill Setup.

### Alexa Skill Setup
1. Go to the [Alexa Console](https://developer.amazon.com/edw/home.html) and click Add a New Skill.
2. Set "HelloWorld" as the skill name and "greeter" as the invocation name, this is what is used to activate your skill. For example you would say: "Alexa, tell Greeter to say hello."
3. Select the Lambda ARN for the skill Endpoint and paste the ARN copied from above. Click Next.
4. Copy the Intent Schema from the included IntentSchema.json.
5. Copy the Sample Utterances from the included SampleUtterances.txt. Click Next.
6. Go back to the skill Information tab and copy the appId. Paste the appId into the HelloWorldSpeechletRequestStreamHandler.java file for the variable supportedApplicationIds,
   then update the lambda source zip file with this change and upload to lambda again, this step makes sure the lambda function only serves request from authorized source.
7. You are now able to start testing your sample skill! You should be able to go to the [Echo webpage](http://echo.amazon.com/#skills) and see your skill enabled.
8. In order to test it, try to say some of the Sample Utterances from the Examples section below.
9. Your skill is now saved and once you are finished testing you can continue to publish your skill.

## Build Hinweise
Das Artefakt für den Lampda Service muss mit allen Abhänigkeiten gebaut werden:
  
     mvn assembly:assembly -DdescriptorId=jar-with-dependencies package



## Examples
### One-shot model:
    User: "Alexa, tell Greeter to say hello."
    Alexa: "Hello World!"
