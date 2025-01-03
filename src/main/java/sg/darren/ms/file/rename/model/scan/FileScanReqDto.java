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
public class FileScanReqDto {

    @NotBlank
    private String path;
    
    private boolean deleteDuplicate = false;

}
