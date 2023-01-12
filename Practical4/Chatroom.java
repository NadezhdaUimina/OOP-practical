interface Chatroom {

    void sendMessage(String msg, User user);

    void appendClient(User user);

    void sendMessage(String fileName, Double fileSize, User user);
}