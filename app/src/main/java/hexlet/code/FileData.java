package hexlet.code;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class FileData {
    private String fileContent;
    private String fileExtension;
}
