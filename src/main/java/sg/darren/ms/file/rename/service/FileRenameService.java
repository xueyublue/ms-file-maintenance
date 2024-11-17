package sg.darren.ms.file.rename.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import sg.darren.ms.file.rename.model.FileTypeEnum;
import sg.darren.ms.file.rename.model.list.FileItem;
import sg.darren.ms.file.rename.model.list.FileListReqDto;
import sg.darren.ms.file.rename.model.list.FileListResDto;
import sg.darren.ms.file.rename.model.rename.FileRenameReqDto;
import sg.darren.ms.file.rename.model.rename.FileRenameResDto;
import sg.darren.ms.file.rename.model.validate.ValidateReqDto;
import sg.darren.ms.file.rename.model.validate.ValidateResDto;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class FileRenameService {

    public FileListResDto list(FileListReqDto reqDto) {
        File path = new File(reqDto.getPath());
        File[] files = path.listFiles();
        List<FileItem> list = Arrays.stream(Objects.requireNonNull(files))
                // filter
                .filter(file -> {
                    if (reqDto.getExtension() != null && !reqDto.getExtension().trim().isEmpty()) {
                        return file.getName().endsWith(reqDto.getExtension());
                    }
                    if (reqDto.getType() != null && !reqDto.getType().trim().isEmpty()) {
                        if (reqDto.getType().equalsIgnoreCase("folder")) {
                            return file.isDirectory();
                        }
                        if (reqDto.getType().equalsIgnoreCase("file")) {
                            return file.isFile();
                        }
                    }
                    return true;
                })
                // build response dto
                .map(file -> FileItem.builder()
                        .name(file.getName())
                        .type(file.isDirectory() ? FileTypeEnum.FOLDER : FileTypeEnum.FILE)
                        .size(BigDecimal.valueOf(file.length())
                                .divide(BigDecimal.valueOf(1024), RoundingMode.DOWN)
                                .divide(BigDecimal.valueOf(1024), RoundingMode.DOWN))   // in MB
                        .build()).toList();
        return FileListResDto.builder()
                .path(reqDto.getPath())
                .type(reqDto.getType())
                .extension(reqDto.getExtension())
                .list(list)
                .count(list.size()).build();
    }

    public ValidateResDto validate(ValidateReqDto reqDto) {
        File path = new File(reqDto.getPath());
        File[] files = path.listFiles();
        int resultSize = 0;
        if (Objects.requireNonNull(files).length > 0) {
            // filter contains and extension
            List<File> filteredList = Arrays.stream(files)
                    .filter(file -> file.getName().contains(reqDto.getContains()) && file.getName().endsWith(reqDto.getExtension()))
                    .toList();
            // filter toBeReplaced
            filteredList = filteredList.stream().filter(file -> file.getName().contains(reqDto.getToBeReplaced())).toList();
            // set result size
            resultSize = filteredList.size();
        }
        return ValidateResDto.builder()
                .result(reqDto.getExpectedSize() == resultSize)
                .expectedSize(reqDto.getExpectedSize())
                .resultSize(resultSize)
                .build();
    }

    public FileRenameResDto rename(FileRenameReqDto reqDto) {
        File path = new File(reqDto.getPath());
        File[] files = path.listFiles();
        int resultSize = 0;
        if (Objects.requireNonNull(files).length > 0) {
            // filter first
            List<File> filteredList = Arrays.stream(files)
                    .filter(file -> file.getName().contains(reqDto.getContains()) && file.getName().endsWith(reqDto.getExtension()))
                    .toList();
            // rename
            filteredList.forEach(oldFile -> {
                String oldFileName = oldFile.getName();
                String newFileName = oldFile.getName().replace(reqDto.getToBeReplaced(), reqDto.getReplaceWith());
                File newFile = new File(oldFile.getParent(), newFileName);
                try {
                    Files.move(oldFile.toPath(), newFile.toPath());
                    log.info("renamed file from {} to {}", oldFileName, newFileName);
                } catch (IOException e) {
                    log.error(e.getMessage());
                    throw new RuntimeException(e);
                }
            });
            // set result size
            resultSize = filteredList.size();
        }

        return FileRenameResDto.builder()
                .size(resultSize)
                .build();
    }

}
