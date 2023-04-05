package com.example.board.service;

import com.example.board.model.board.AttachedFile;
import com.example.board.model.board.Board;
import com.example.board.repository.BoardMapper;
import com.example.board.util.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardMapper boardMapper;
    private final FileService fileService;

    public void saveBoard(Board board, MultipartFile file) {

        boardMapper.saveBoard(board);
        // 파일을 저장한다.
        AttachedFile attachedFile = fileService.saveFile(file);
        attachedFile.setBoard_id(board.getBoard_id());
        boardMapper.saveFile(attachedFile);
    }

    public Board findBoard(long board_id) {
        return boardMapper.findBoard(board_id);
    }

    public AttachedFile findFile(long attachedFile_id) {
        return boardMapper.findFile(attachedFile_id);
    }
}
