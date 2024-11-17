package sg.darren.ms.file.rename.model.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.darren.ms.file.rename.model.FileTypeEnum;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileItem {

    private String name;
    private FileTypeEnum type;
    private BigDecimal size;

}
