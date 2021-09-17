/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.ucb.est;

import java.util.List;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
/**
 *
 * @author ecampohermoso
 */
public class HelloWorldBot extends TelegramLongPollingBot {
    private SendMessage mensaje;
    private int a;
    private int b;
    private String inicial="Bienvenido al Bot calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números\n2. Calcular serie de fibonacci";

    public HelloWorldBot(SendMessage mensaje){
        this.mensaje=mensaje;
    }
    @Override
    public String getBotToken() {
        return "";
    }

    public void error(){
        try {
            mensaje.setText(inicial);
            execute(mensaje);
        }catch (TelegramApiException e) {
            mensaje.setText("");
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
            System.out.println("Llego mensaje: " + update.getMessage());
            if(mensaje.getText().equals("") || mensaje==null) {
                mensaje=new SendMessage();
                mensaje.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
                mensaje.setText(inicial);
                try {
                    execute(mensaje); // Envia el mensaje
                } catch (TelegramApiException e) {
                    mensaje.setText("");
                }

            }else if(mensaje.getText().equals(inicial) && update.getMessage().getText().equals("1")){
            mensaje.setText("Ingrese el primer número:");
                try {
                    execute(mensaje); // Envia el mensaje
                } catch (TelegramApiException e) {
                    mensaje.setText("");
                }
            }else if(mensaje.getText().equals("Ingrese el primer número:")){
                try {
                    a=Integer.parseInt(update.getMessage().getText());
                    mensaje.setText("Ingrese el segundo número:");
                    execute(mensaje); // Envia el mensaje
                } catch (TelegramApiException e) {
                    error();
                }catch (Exception e){
                    error();
                }
            }else if(mensaje.getText().equals("Ingrese el segundo número:")){
                try {
                    b=Integer.parseInt(update.getMessage().getText());
                    mensaje.setText("La suma es: "+ (a+b));
                    execute(mensaje); // Envia el mensaje
                    mensaje.setText(inicial);
                    execute(mensaje);
                } catch (TelegramApiException e) {
                    mensaje.setText("");
                }catch (Exception e){
                    error();
                }
            }else if(mensaje.getText().equals(inicial) && update.getMessage().getText().equals("2")){
                mensaje.setText("Funcionalidad no implementada, intente otro día");
                try {
                    execute(mensaje); // Envia el mensaje
                    mensaje.setText(inicial);
                    execute(mensaje);
                } catch (TelegramApiException e) {
                    mensaje.setText("");
                }
            }
    }

    @Override
    public String getBotUsername() {
        return "suma_ucb_bot";
    }
    
}
