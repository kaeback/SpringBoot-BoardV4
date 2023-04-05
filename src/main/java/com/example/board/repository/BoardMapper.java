package com.example.board.repository;

import com.example.board.model.board.AttachedFile;
import com.example.board.model.board.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void saveBoard(Board board);
    List<Board> findAllBoards();
    Board findBoard(Long board_id);
    void updateBoard(Board updateBoard);
    void removeBoard(Long board_id);
    void saveFile(AttachedFile attachedFile);
    AttachedFile findFileByBoardId(Long board_id);
    AttachedFile findFileByAttachedFileId(Long attachedFile_id);
}
