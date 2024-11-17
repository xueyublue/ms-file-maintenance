package sg.darren.ms.file.rename.model.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileListResDto {

    private int count;
    private String path;
    private String type;
    private String extension;
    private List<FileItem> list;
}
