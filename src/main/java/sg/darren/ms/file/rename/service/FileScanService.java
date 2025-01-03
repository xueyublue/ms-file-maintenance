package sg.darren.ms.file.rename.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import sg.darren.ms.file.rename.model.scan.FileScanReqDto;
import sg.darren.ms.file.rename.model.scan.FileScanResDto;

@Service
@Log4j2
public class FileScanService {

    public FileScanResDto scan(FileScanReqDto reqDto) {
        return FileScanResDto.builder()
                .build();
    }

}
