package files;

import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFilesTests {
    private final ClassLoader cl = getClass().getClassLoader();
//    private ClassLoader cl = SelenideFilesTest.class.getClassLoader();


    @Test
    void downloadTest() throws Exception {
//        Configuration.proxyEnabled = true;
//        Configuration.fileDownload = FileDownloadMode.PROXY;
        open("https://github.com/junit-team/junit5/blob/main/LICENSE.md");
        File downloadedFile = $("#raw-url").download();
        try (InputStream is = new FileInputStream(downloadedFile)) {
            assertThat(new String(is.readAllBytes(), StandardCharsets.UTF_8))
                    .contains("Eclipse Public License - v 2.0");
        }
//        try {
//            File downloadedFile = $("#raw-url").download();
//        } catch (FileNotFoundException exception) {
//            exception.printStackTrace();
//        }
    }
    @Test
    void uploadFile() {
        Selenide.open("https://the-internet.herokuapp.com/upload");
        Selenide.$("input[type='file']").uploadFromClasspath("files/upload.txt");
        Selenide.$("#file-submit").click();
        Selenide.$("#uploaded-files").shouldHave(text("upload.txt"));
    }

    @Test
    void parseXlsTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("files/sample-xlsx-file.xlsx")) {
            assert stream != null;
            XLS parsed = new XLS(stream);
            assertThat(parsed.excel.getSheetAt(0).getRow(1).getCell(2).getStringCellValue())
                    .isEqualTo("Abril");
        }
    }
}
