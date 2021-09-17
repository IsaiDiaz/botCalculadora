package bo.edu.ucb.est;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
                TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
                SendMessage mensaje= new SendMessage();
                mensaje.setText("");
                telegramBotsApi.registerBot(new HelloWorldBot(mensaje));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
    }
}
