package lesson_7.HW.server;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);
}
