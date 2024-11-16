package sg.darren.ms.file.rename.model.rename;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileRenameReqDto {

    @NotBlank
    private String path;

    @NotBlank
    private String contains;

    @NotBlank
    private String extension;

    @NotBlank
    private String toBeReplaced;

    private String replaceWith;

}
