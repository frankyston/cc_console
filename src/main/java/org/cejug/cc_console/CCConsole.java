package org.cejug.cc_console;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

public class CCConsole {

    public static void main(String[] args) {

        Terminal terminal = TerminalFacade.createTerminal();
        terminal.applyForegroundColor(Terminal.Color.GREEN);
        terminal.applyBackgroundColor(Terminal.Color.BLACK);
        
        terminal.enterPrivateMode();
        terminal.moveCursor(10, 5);
        
        terminal.putCharacter('W');
        pausa(200);
        terminal.putCharacter('a');
        pausa(200);
        terminal.putCharacter('k');
        pausa(200);
        terminal.putCharacter('e');
        pausa(200);
        terminal.putCharacter(' ');
        pausa(200);
        terminal.putCharacter('u');
        pausa(200);
        terminal.putCharacter('p');
        pausa(200);
        terminal.putCharacter(',');
        pausa(200);
        terminal.putCharacter(' ');
        pausa(200);
        terminal.putCharacter('N');
        pausa(200);
        terminal.putCharacter('e');
        pausa(200);
        terminal.putCharacter('o');
        pausa(200);
        terminal.putCharacter('.');
        pausa(200);
        terminal.putCharacter('.');
        pausa(200);
        terminal.putCharacter('.');
        pausa(200);
        
        terminal.clearScreen();
        terminal.moveCursor(10, 5);
        
        terminal.putCharacter('T');
        pausa(200);
        terminal.putCharacter('h');
        pausa(200);
        terminal.putCharacter('e');
        pausa(200);
        terminal.putCharacter(' ');
        pausa(200);
        terminal.putCharacter('M');
        pausa(200);
        terminal.putCharacter('a');
        pausa(200);
        terminal.putCharacter('t');
        pausa(200);
        terminal.putCharacter('r');
        pausa(200);
        terminal.putCharacter('i');
        pausa(200);
        terminal.putCharacter('x');
        pausa(200);
        terminal.putCharacter(' ');
        pausa(200);
        terminal.putCharacter('h');
        pausa(200);
        terminal.putCharacter('a');
        pausa(200);
        terminal.putCharacter('s');
        pausa(200);
        terminal.putCharacter(' ');
        pausa(200);
        terminal.putCharacter('y');
        pausa(200);
        terminal.putCharacter('o');
        pausa(200);
        terminal.putCharacter('u');
        pausa(200);
        terminal.putCharacter('.');
        pausa(200);
        terminal.putCharacter('.');
        pausa(200);
        terminal.putCharacter('.');
        pausa(200);
        
        pausa(1000);
        
        terminal.clearScreen();
        

    }
    
    private static void pausa(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
