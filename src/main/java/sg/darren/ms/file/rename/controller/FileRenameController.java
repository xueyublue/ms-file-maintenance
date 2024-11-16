package sg.darren.ms.file.rename.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sg.darren.ms.file.rename.model.list.FileListReqDto;
import sg.darren.ms.file.rename.model.list.FileListResDto;
import sg.darren.ms.file.rename.model.rename.FileRenameReqDto;
import sg.darren.ms.file.rename.model.rename.FileRenameResDto;
import sg.darren.ms.file.rename.service.FileRenameService;

@RestController
@RequestMapping("/rename")
@RequiredArgsConstructor
public class FileRenameController {

    private final FileRenameService fileRenameService;

    @GetMapping
    public FileListResDto list(@RequestBody @Valid FileListReqDto dto) {
        return FileListResDto.builder().build();
    }

    @PostMapping
    public FileRenameResDto rename(@RequestBody @Valid FileRenameReqDto dto) {
        return fileRenameService.rename(dto);
    }

}
