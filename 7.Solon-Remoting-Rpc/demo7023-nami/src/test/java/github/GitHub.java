package github;


import org.noear.nami.annotation.NamiClient;
import org.noear.nami.annotation.NamiMapping;

import java.util.List;

/**
 * @author noear 2021/1/1 created
 */

@NamiClient
public interface GitHub {
    @NamiMapping("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(String owner, String repo);

    @NamiMapping("POST /repos/{owner}/{repo}/issues")
    void createIssue(Issue issue, String owner, String repo);
}
