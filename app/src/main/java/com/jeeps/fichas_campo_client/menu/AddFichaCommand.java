package com.jeeps.fichas_campo_client.menu;

public class AddFichaCommand implements Command {
    private AppMenu mAppMenu;

    public AddFichaCommand(AppMenu appMenu) {
        mAppMenu = appMenu;
    }

    @Override
    public void execute() {
        mAppMenu.addFicha();
    }
}
