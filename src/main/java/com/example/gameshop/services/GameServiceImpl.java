package com.example.gameshop.services;

import com.example.gameshop.dtos.GameRegisterDto;
import com.example.gameshop.entities.Game;
import com.example.gameshop.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, UserService userService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public void registerGame(GameRegisterDto gameRegisterDto) {
        if (this.userService.isLoggedUserAdmin()) {
            System.out.println("User is not allowed to add games");
            return;
        }

        Game game = this.modelMapper.map(gameRegisterDto, Game.class);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void deleteGame(Long id) {
        if (userService.isLoggedUserAdmin()) {
            System.out.println("User is not allowed to delete games");
            return;
        }

        Game game = this.gameRepository.findById(id).get();
        this.gameRepository.deleteById(id);
        System.out.printf("Deleted %s%n", game.getTitle());
    }
}
