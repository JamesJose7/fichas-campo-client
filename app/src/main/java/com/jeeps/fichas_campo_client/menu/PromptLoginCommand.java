package com.jeeps.fichas_campo_client.menu;

public class PromptLoginCommand implements Command {
    private AppMenu mAppMenu;

    public PromptLoginCommand(AppMenu appMenu) {
        mAppMenu = appMenu;
    }


    @Override
    public void execute() {
        mAppMenu.promptLogin();
    }
}
