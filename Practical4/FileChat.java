import java.io.FileWriter;
import java.io.IOException;


/**
 * Класс для создания файла с чатом
 */

class FileChat {
    
    public void saveToFile() throws IOException {
        Chat chat = new Chat();
        try (FileWriter writer = new FileWriter("File_chat.txt", false)) {
            writer.append(chat.text);
        }
    }
}