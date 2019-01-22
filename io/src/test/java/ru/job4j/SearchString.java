package ru.job4j;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchString {
    @Test
    public void whenSerch() {
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        exts.add("xml");
        List<File> result = search.files("C:\\Projects\\rukejam\\.idea", exts);
        List<String> expect = Arrays.asList("compiler.xml","encodings.xml","misc.xml","modules.xml","vcs.xml","workspace.xml");
        assertThat(result.toString(), is(expect.toString()));
    }
}
