package github;


import org.noear.nami.Nami;
import org.noear.nami.channel.http.HttpChannel;
import org.noear.nami.coder.snack3.SnackDecoder;

import java.util.List;

/**
 * @author noear 2021/1/1 created
 */
public class MainTest {
    public static void main(String... args) {
        GitHub github = Nami.builder()
                .decoder(new SnackDecoder())
                .channel(new HttpChannel())
                .upstream(() -> "https://api.github.com")
                .create(GitHub.class);

        // Fetch and print a list of the contributors to this library.
        List<Contributor> contributors = github.contributors("OpenFeign", "feign");
        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }
    }
}
