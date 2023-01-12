
/**
 * Пользователь
 */
class User {

    String name;
    private Chatroom chatroom;

    public User(String name, Chatroom chatroom) {
        this.name = name;
        this.chatroom = chatroom;
    }
    String strMessage(String msg) {
        return "Чат " +name +":" + msg +" \n";
    }
    String strMessage(String msg, Double f) {
        return "Чат " +  name + ":" +  msg + f;
    }
    void printMessage(String msg) {
        System.out.printf("Чат %s: %s\n", name, msg);
    }

    void printMessage(String msg, Double f) {
        System.out.printf("Чат %s: %s \n", name, msg, f);
    }

    void sendMsg(String text) {
        chatroom.sendMessage(text, this);
    }

    void sendMsg(String fileName, Double fileSize) {
        chatroom.sendMessage(fileName, fileSize, this);
    }
}