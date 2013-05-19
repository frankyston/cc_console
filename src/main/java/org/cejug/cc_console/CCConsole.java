package org.cejug.cc_console;

import org.cejug.cc_console.jdbc.CCConsoleJDBC;

/**
 * Classe principal para inciar o sistema.
 * @author helio frota https://www.heliofrota.com
 *
 */
public class CCConsole {

    /**
     * Método main.
     * @param String... args
     */
    public static void main(String... args) {

        System.out.println("=======");
        
        CCConsoleJDBC ccConsoleJDBC = new CCConsoleJDBC(); 
        
        System.out.println(ccConsoleJDBC.getConnection());

    }

   

}
