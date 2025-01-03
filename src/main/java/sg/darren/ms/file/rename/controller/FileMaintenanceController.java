package sg.darren.ms.file.rename.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sg.darren.ms.file.rename.model.list.FileListReqDto;
import sg.darren.ms.file.rename.model.list.FileListResDto;
import sg.darren.ms.file.rename.model.rename.FileRenameReqDto;
import sg.darren.ms.file.rename.model.rename.FileRenameResDto;
import sg.darren.ms.file.rename.model.scan.FileScanReqDto;
import sg.darren.ms.file.rename.model.scan.FileScanResDto;
import sg.darren.ms.file.rename.model.validate.ValidateReqDto;
import sg.darren.ms.file.rename.model.validate.ValidateResDto;
import sg.darren.ms.file.rename.service.FileRenameService;
import sg.darren.ms.file.rename.service.FileScanService;

@RestController
@RequiredArgsConstructor
public class FileMaintenanceController {

    private final FileRenameService fileRenameService;
    private final FileScanService fileScanService;

    @GetMapping("/list")
    public FileListResDto list(@RequestBody @Valid FileListReqDto dto) {
        return fileRenameService.list(dto);
    }

    @PostMapping(path = "/validate")
    public ValidateResDto validate(@RequestBody @Valid ValidateReqDto dto) {
        return fileRenameService.validate(dto);
    }

    @PostMapping(path = "/rename")
    public FileRenameResDto rename(@RequestBody @Valid FileRenameReqDto dto) {
        return fileRenameService.rename(dto);
    }

    @PostMapping("/scan")
    public FileScanResDto scan(@RequestBody @Valid FileScanReqDto dto) {
        return fileScanService.scan(dto);
    }

}
