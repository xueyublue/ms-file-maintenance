package sg.darren.ms.file.rename.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import sg.darren.ms.file.rename.model.rename.FileRenameReqDto;
import sg.darren.ms.file.rename.model.rename.FileRenameResDto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class FileRenameService {

    public FileRenameResDto rename(FileRenameReqDto reqDto) {
        log.info("reqDto", reqDto);
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
