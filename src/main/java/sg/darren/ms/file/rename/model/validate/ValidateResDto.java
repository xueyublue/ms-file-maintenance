package sg.darren.ms.file.rename.model.validate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidateResDto {

    private boolean result;
    private int expectedSize;
    private int resultSize;

}
