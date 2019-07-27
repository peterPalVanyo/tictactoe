package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Comic;
import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.tictactoegame.AiService;
import com.codecool.enterprise.overcomplicated.model.tictactoegame.TictactoeGame;
import com.codecool.enterprise.overcomplicated.service.ComicService;
import com.codecool.enterprise.overcomplicated.service.FunFactService;
import com.codecool.enterprise.overcomplicated.service.OutsourcedAiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"player", "game"})
public class GameController {

    AiService aiService = new OutsourcedAiService();

    private TictactoeGame game = new TictactoeGame(aiService);
    private FunFactService funFactService = new FunFactService();
    private ComicService comicService = new ComicService();


    @ModelAttribute("player")
    public Player getPlayer() {
        return new Player();
    }

    @ModelAttribute("game")
    public TictactoeGame getGame() {
        return new TictactoeGame(aiService);
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() {
        return "https://robohash.org/codecool";
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("player") Player player, Model model) {
        model.addAttribute("funfact", "&quot;"+ funFactService.getFunFact() +"&quot;");
        Comic comic = comicService.getComic();
        model.addAttribute("comic_uri", comic.getImg());
        model.addAttribute("comic_hover_text", comic.getHoverText());
        model.addAttribute("board", game.getBoard());
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) throws Exception {
        System.out.println("Player moved " + move);
        game.nextTurn(move);
        return "redirect:/game";
    }
}
