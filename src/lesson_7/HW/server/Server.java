package lesson_7.HW.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;


public class Server {
    private List<ClientHandler> clients;
    private AuthService authService;

    public Server() {
        clients = new Vector<>();
        authService = new SimpleAuthService();
        ServerSocket server = null;
        Socket socket;

        final int PORT = 8189;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился ");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(String msg){
        for (ClientHandler c : clients) {
            c.sendMsg(msg);
        }
    }

    public void privateMsg(String nick, String nick_recipient, String msg){
        for (ClientHandler c : clients) {
            if (c.getNick().equals(nick_recipient))
            c.sendMsg(nick + ": " + msg);
        }
    }

    public boolean isLoginFree(String login){
        for (ClientHandler c : clients) {
            if (c.getLogin().equals(login)) {
                return false;
            }
        }return true;
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }
}
