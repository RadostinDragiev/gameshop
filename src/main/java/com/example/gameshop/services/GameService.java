package com.example.gameshop.services;

import com.example.gameshop.dtos.GameRegisterDto;

public interface GameService {
    void registerGame(GameRegisterDto gameRegisterDto);

    void deleteGame(Long id);
}
