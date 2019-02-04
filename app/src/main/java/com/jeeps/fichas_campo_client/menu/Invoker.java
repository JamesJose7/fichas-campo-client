package com.jeeps.fichas_campo_client.menu;

public class Invoker {
    public void executeCommand(Command command) {
        command.execute();
    }
}
