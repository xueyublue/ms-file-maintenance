package sg.darren.ms.file.rename.model.scan;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileScanResDto {

    private int directoryCount;
    private int fileCount;
    private int deletedCount;

}
