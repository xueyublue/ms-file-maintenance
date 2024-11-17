package sg.darren.ms.file.rename.model.list;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileListReqDto {

    @NotBlank
    private String path;

    private String type;

    private String extension;

}
