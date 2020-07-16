import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;



public class RandomFileContentGenerator {
    //variables
    private File root = new File("./data");
    private final String fileName;
    private final int lines;
    //constructor
    RandomFileContentGenerator(String fileName, int lineCount) {
        this.fileName = fileName;
        this.lines = lineCount;
    }
    //generates the random file.
    void generate() throws IOException {
        Path fullPath = new File(root, fileName).toPath();
        // make sure file exists
        Files.createDirectories(fullPath.getParent()); //creates the directory if it's not created.




        try (BufferedWriter writer = Files.newBufferedWriter(fullPath)) {
            for (int i = 0; i < lines; ++i) {

               String line = createRandom("1234567890`~!@#$%^&*()_-+=\\|]}[{':; <,>.?/ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm\"\n");
                writer.write(line); //appends to the large file.
            }
        }
    }

//random string generator based on the inputted id. Includes random String length aswell.
    public String createRandom(String id){
        Random rand = new Random(); //defines random number generator.
        int length = rand.nextInt(40); //gets a random number for the length
        char[] charArray = id.toCharArray(); //converts teh inputted String into a char array.
        char[] finalArray = new char[length]; //Makes a final char Array of a random length.
        //randomly picks a char from the charArray to put into the finalArray.
        for(int i = 0;i<finalArray.length;i++){
            int num = rand.nextInt(charArray.length);
            finalArray[i] = charArray[num];
        }
        return String.valueOf(finalArray); //converts to String.

    }




}