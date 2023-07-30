package Wanted.Restful_API.service;

import Wanted.Restful_API.dto.BoardDTO;
import Wanted.Restful_API.entity.BoardEntity;
import Wanted.Restful_API.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    // Entity -> DB
    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }
}
