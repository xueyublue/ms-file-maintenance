package sg.darren.ms.file.rename.model.validate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidateReqDto {

    @NotBlank
    private String path;

    @NotBlank
    private String contains;

    @NotBlank
    private String extension;

    @NotBlank
    private String toBeReplaced;

    int expectedSize = 0;

}
