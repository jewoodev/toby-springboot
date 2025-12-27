package tobyspring.helloboot;

import java.util.Objects;

public class ByeController {
    private final ByeService byeService;

    public ByeController(ByeService byeService) {
        this.byeService = byeService;
    }

    public void bye() {
        byeService.sayBye();
    }
}
